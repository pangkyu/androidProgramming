# 파일처리 실습 3 

- SD카드에서 파일 읽기 
  - (1) Device File Explorer에서 /sdcard 폴더 또는 /storage/emulated/0 폴더에 텍스트 파일 올리기 
  
  ```xml
   <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
   <application
        android:requestLegacyExternalStorage="true"/>
  ```
    추가할것 !!


  ```xml
  
  <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/btnRead"
        android:text="sd카드에서 파일읽기"/>
    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/edtSD"
        android:lines="10"/>

    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/btnMkdir"
        android:text="SD카드에 디렉토리 생성"/>

    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/btnRmdir"
        android:text="SD카드에 디렉토리 삭제"/>
  ```

  ```java
  
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this, new String[]{
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);

        Button btnRead, btnMkdir, btnRmdir;
        final EditText edtSD;
        btnRead = (Button) findViewById(R.id.btnRead);
        edtSD = (EditText) findViewById(R.id.edtSD);
        btnMkdir = findViewById(R.id.btnMkdir);
        btnRmdir = findViewById(R.id.btnRmdir);

        final String strSDpath = Environment.getExternalStorageDirectory().getAbsolutePath(); // 절대경로를 얻을 수 있는 구문

        //mydir
        final File myDir = new File(strSDpath + "/mydir");
        btnMkdir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                myDir.mkdir();
            }
        });

        btnRmdir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDir.delete();
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try {
                    FileInputStream inFs = new FileInputStream("/storage/emulated/0/file.txt");
                    byte[] txt = new byte[inFs.available()]; // inFs를 담을수있는 만큼 배열공간 생성
                    inFs.read(txt);
                    edtSD.setText(new String(txt));
                    inFs.close();
                }catch (IOException e){

                }
            }
        });
    }
}
  ```
   - ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE); 선언할것
   - Environment.getExternalStorageDirectory().getAbsolutePath(); // 절대경로를 알수있다. 
   -  FileInputStream inFs = new FileInputStream("/storage/emulated/0/file.txt"); // 다음과 같은 경로에 저장이 됨 
   
 ---
 
  - 특정 폴더의 하위 폴더 및 파일 목록
    - 지정한 폴더의 하위 폴더 및 파일 목록에 접근하기 
      ==> 특정폴더의 하위 폴더 및 파일 목록은 File.listFiles() 메소드 사용하여 접근
          반환값 : File[] 형
          
