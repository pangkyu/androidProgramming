# 액티비티 실습 1 

 - 액티비티(Activity)
   - 화면을 구성하는 가장 기본적인 컴포넌트 
   
 - 서비스(Service)
   - 액티비티와 상관없이 백그라운드에서 동작하는 컴포넌트 
     ==> 서비스 생성 -> 서비스 시작 -> 서비스 종료 
     
 - 브로드캐스트 리시버(Broadcast Receiver)
   - 문자 메시지 도착, 배터리 방전, SD 카드 탈부착, 네트워크 환경 변화 등이 발생하면 전체 응용프로그램이 들을 수 있도록 방송 신호를 보낸다. 


 - 콘텐트 프로바이더(Content Provider) 
   - 응용프로그램 사이에 데이터를 상호 공유하기 위한 컴포넌트
   - 콘텐트 프로바이더의 정보를 제공하는 방법으로는 URI(Uniform Resource Identifier)가 있음 


 2. 액티비티의 개요
   - 액티비티 추가 
     - 일반적으로 액티비티 하나당 XML 파일 하나를 만들어서 사용
     - MainActivity.java 코드는 Activity 클래스를 상속받으므로 MainActivity.java를 액티비티라고 부름 
           ```java
           public class MainActivity extends Activity { 
             @Override 
             public void onCreate(Bundle savedInstanceState) {
                .....
             }
       
           }
           ```
           
           
  ---
    - 인텐트
      ==> 액티비티끼리 서로 호출하기 위해서 필요한 통신장치가 intent이다. 
      
      액티비티를 호출하는 메소드는 아래 메소드이다. 
      
      void startActivity(Intent intent)
         첫번째 인수(intent) : 누구를 호출하여 무슨 작업을 시킬 것인가에 대한 정보가 담겨있다. 
         
      인텐트의 생성자 
      
      Intent() // 디폴트 생성자, 사용되는 경우가 드물다. 
      Intent(Intent o) // 복사 생성자, 사용되는 경우가 드물다. 
      Intent(String action [, Uri uri])
      Intent(Context packageContext, Class<?>cls) // 가장 많이 사용.  첫번째 인수 : 액티비티 클래스를 구현하는 컨텍스트, 보통 this 사용
                                                                     두번째 인수 : 호출할 액티비티의 클래스 
      Intent(String action, Uri uri, Context packageContext, Class<?> cls)
  
  
  ---
   - SecondActivity 만들기 
```java
package kr.ac.hs.and2021.myapplication;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second); // second.xml파일을 뷰 시켜주는 구문
    }
}
     
```

