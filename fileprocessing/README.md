# 파일 처리 실습 2 

### 파일에 내용을 입력하면 해당 날짜에 저장이 되는 txt파일을 생성시키는 실습 

```java

DatePicker dp;
    EditText edtDiary;
    Button btnWrite;
    String fileName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("간단 일기장");
        dp = findViewById(R.id.datePicker1);
        edtDiary = findViewById(R.id.edtDiary);
        btnWrite = findViewById(R.id.btnWrite);
        Calendar cal = Calendar.getInstance();
        int cYear = cal.get(Calendar.YEAR);
        int cMonth = cal.get(Calendar.MONTH);
        int cDay = cal.get(Calendar.DAY_OF_MONTH);

        dp.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                fileName = Integer.toString(year) + "_"
                        + Integer.toString(monthOfYear + 1) + "_"
                        + Integer.toString(dayOfMonth) + ".txt";
                String str = readDiary(fileName);
                edtDiary.setText(str);
                btnWrite.setEnabled(true);
            }
        });
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    FileOutputStream outFs = openFileOutput(fileName, MODE_PRIVATE);
                    String str = edtDiary.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(), fileName + "이 저장 생성됨", Toast.LENGTH_SHORT).show();
                }catch (IOException e){

                }
            }
        });
    }



    //file명의 파일을 읽어와서 그 내용을 반환하는 메소드
   String readDiary(String fileName){
       FileInputStream inFs;
       String diaryStr = null;
       try{
           inFs = openFileInput(fileName);
           byte[] txt = new byte[500];
           inFs.read(txt);
           inFs.close();
           diaryStr = (new String(txt)).trim(); // trim ==> 빈 여백을 다 제거할 수 있다
           btnWrite.setText("수정 하기");
       }catch (IOException e ){
            edtDiary.setHint("일기가 없다");
            btnWrite.setText("새로 저장");
       }
       return diaryStr; // 파일이 없는 경우 catch로 빠지고 파일이 있으면 얻은 스트링을 diaryStr로 리턴
    }
```
 - Calendar 메소드를 이용하여 현재시간을 받아올 수 있다. 
 - fileName을 readDiary() 함수를 통해 받아와서 inFs에 저장. inFs.read로 byte[500]만큼 공간 확보. 
 - try ==> 파일이 있으므로 수정하기를 버튼에 세트
 - catch ==> 파일이 없으므로 일기가 없다는 내용띄우고 버튼에 새로저장을 세트 
 
 
 ```xml
 <!--spinner를 하고 캘린더뷰를 false로 처리해야 스피너형태가 나온다 -->
    <DatePicker
        android:calendarViewShown="false"
        android:datePickerMode="spinner"
        android:id="@+id/datePicker1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />
    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/edtDiary"
        android:layout_weight="1"
        android:background="#00ff00"
        android:lines="8"/>
    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Button"
        android:enabled="false"
        android:id="@+id/btnWrite"/>
 ```
