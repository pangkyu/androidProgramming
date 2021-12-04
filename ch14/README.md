# ch14 

 서비스 : 화면없이 동작하는 프로그램 
   - 사용자 인터페이스 없이 백그라운드에서 실행되는 컴포넌트 
   - 데몬(daemon), 백그라운드 프로세스 

--- 
 - AndroidManifest.xml을 열고 <application>안에 
   ```xml
      <service android:name = "MusicService">
        <intent-filter>
           <action android:name = "{package name}.{className}"/>
        </intent-filter>
       </service> 
   ```
   를 등록 해준다. 
