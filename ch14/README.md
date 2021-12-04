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
      - 프로젝트 실행 및 결과확인 
        ==> 명령 프롬포트에서 "telnet localhost 5554"입력한후 'auth 인증번호'를 입력 
      - 텔넷 명령어 
        1. power display : 배터리 상태 출력
        2. power ac [on/off] : 전원 연결/해제 설정
        3. power status [charging/discharging/full 등] : 배터리 상태변경설정
        4. power present [true/false] : 배터리 장착/탈착 설정
        5. power health [good/overhead/dead 등] : 배터리 성능 상태 설정
 
 ---
  - 안드로이드 제공 콘텐트 프로바이더 
    - 콘텐트 프로바이더 
      => 안드로이드 보안상 앱에서 사용하는 데이터를 외부에서 접근 x 
         파일이나 db를 외부 앱에서 사용하도록 하려면 콘텐트 프로바이더를 만들어서 외부로 제공 
    - URI(Uniform Resource Identifier)
      => URI는 콘텐트 프로바이더에서 제공하는 데이터에 접근하기 위한 주소 
         URI는 "content://패키지명/경로/아이디"형식으로 지정 
