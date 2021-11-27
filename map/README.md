# map 

 - Google Play Service 설치 
   - 안드로이드 스튜디오 tools - android - sdk manager 
   - sdk tools탭 클릭 Google play services가 설치되어있는지 확인 
   - 구글지도를 사용할 프로젝트 생성 
   - 구글 api등록 ( 인증키까지 등록 ) 
   - 안드로이드 스튜디오 Gradle Scripts - build.gradle - dependencies - implementation 'com.google.android.gms:play-services-location:17.0.0'
                                                                       implementation 'com.google.android.gms:play-services-maps:17.0.0' 추가
 ```xml
  <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
    <uses-permission android:name="android.permission.INTERNET"/>
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>
    <uses-permission android:name="com.google.android.providers.gsf.permission.READ_GSERVICES"/>
    <uses-feature android:required="true" android:glEsVersion="0x00020000"/>
    <permission android:name="kr.ac.hs.and2021.myapplication.permission.MAPS_RECEIVE" android:label="signature" ></permission>
    <meta-data android:name = "com.google.android.gms.version" android:value = "12451000"/>
 ```
  위에 거 입력
 
