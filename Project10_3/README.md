# 로그캣을 이용하여 액티비티 생명주기 확인하기 

암시적 인텐트(Implicit Intent, 묵시적 인텐트)
 - 약속된 액션을 지정하여 안드로이드에서 제공하는 기존 응용 프로그램을 실행
 - ex ) 전화 걸기 
   ```java
   // 119에 응급전화를 거는 형식
   Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:/119"));
   startActivity(intent);
   ```
   - 전화걸기 및 구글 맵 사용을 위해 AndroidManifest.xml의 <application 위에 다음과 같이 권한을 주어야한다.
   ```xml
    <uses:permission android:name = "android.permission.CALL_PHONE"/>
    <uses:permission android:name = "android.permission.ACCESS_COARSE_LOCATION"/>
    <uses:permission android:name = "android.permission.ACCESS_FINE_LOCATION"/>
   ```
   
   ---
    - 액티비티 생명주기 
    
      - 액티비티 생성 ~ 소멸까지의 주기 
      - 안드로이드 응용프로그램은 화면이 작아서 동시에 여러 개의 액티비티가 나올 수 없음
      - 앞에 나오는 화면 하나만 활성화된 상태이고, 나머지는 모두 비활성화된 상태로 남게됨
   ---
     - 로그캣
       - 작성 중인 프로그램에 예기치 못한 오류가 발생했을 때 원인을 파악하는 방법 중 하나가 로그를 남기는 것. 안드로이드는 android.util.Log 클래스를 제공하여 로그를 남기고, 
         로그캣이라는 화면을 제공하여 로그를 확인힌다. 프로그래머가 로그를 남기기 위해 사용하는 메소드는 다음과 같다. 절대적인 기준은 아니며 프로그래머가 적절한 메소드를 골라 사용해야한다. 
         
         android.util.Log.d("태그", "메시지") / Debugging , 디버깅 용도로 남기는 로그 
         android.util.Log.e("태그", "메시지") / Error, 가장 심각한 오류 발생 시 남기는 로그 
         android.util.Log.i("태그", "메시지") / information , 정보를 남기기위한 로그 
         android.util.Log.v("태그", "메시지") / Verbose , 상세한 기록을 남기기 위한 로그 
         android.util.Log.w("태그", "메시지") / Warning, 경고 수준을 남기기 위한 로그 
