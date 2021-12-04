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

 --- 
  - 브로드캐스트 리시버(Broadcast Receiver, BR)
      - 안드로이드는 문자메시지 도착, 배터리 방전, SD카드 탈부착, 네트워크 환경변화 등이 발생하면 방송(Braodcast)신호를 보냄 
      - 이런 신호(이벤트)를 받아서 처리하는 컴포넌트 = 브로드캐스트 리시버
      
