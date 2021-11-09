# 파일처리 실습

```java
   btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    FileOutputStream outFs = openFileOutput("file.txt", Context.MODE_PRIVATE); // calling application
                    String str = "안드로이드a반 화이팅";
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(),"file.txt가 생성되었습니다.", Toast.LENGTH_SHORT).show();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        });
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    FileInputStream inFs = openFileInput("file.txt" );
                    byte[] txt = new byte[30];
                    inFs.read(txt);
                    String str = new String(txt);
                    Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                    inFs.close();
                }catch(IOException e){
                    Toast.makeText(getApplicationContext(),"파일이 없음", Toast.LENGTH_SHORT).show();
                }
            }
        });
```
 - FileOutputStream, FileInputStream을 사용! 
 - 저장된 데이터는 data/data/packageName/files/제목 으로 저장된다.
 -  try-catch문으로 예외처리 필수~!
