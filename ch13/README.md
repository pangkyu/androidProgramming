# CH13 오디오 
 - 오디오 
   - MediaPlayer 클래스 : 음악 및 동영상을 재생해주는 기능 
   - MediaPlayer의 메소드 
   ```java
    play() // 음악시작 메소드 
    pause() // 일시정지 메소드 
    stop() // 정지 메소드 
   ```
 - 간단한 음악 재생 
   - res 폴더에서 raw폴더를 만든 후, 적당한 mp3파일을 복사 

 MediaPlayer.create(Context context, int resid)
 
 MediaPlayer 
  - 음원뿐 아니라 영상 재생에도 사용되는 클래스다. 
  - 영상 재생에는 화면 출력을 위한 SurfaceView 준비해야함 
  - 음원 재생은 뷰 필요없이 MediaPlayer만으로 재생 (컨트롤을 위한 별도 뷰를 구현할거면 만들어야함) 
```java
  mediaPlayer = MediaPlayer.create(this, R.raw.sound);
  mediaPlayer.start();
```

 음원파일이 외장 메모리/서버에 있는 경우. 
 
 ```java
  mediaPlayer = new MediaPlayer();
  mediaPlayer.setDataSource(this, Uri.parse(url)); // setDataSource()로 음원 지정
  
  mediaPlayer.setDataSource(filePath); // 파일일때, String타입으로 파일 경로를 지정
 ```
  - 간단한 효과음같은 경우는 리소스파일이 작기 때문에 리소스파일을 바로 지정한후 재생해도 문제 없다. 
  - 외장 메모리/서버의 음원은 로딩~재생의 시간이 걸린다. 
    - 음원로딩 명령 따로, 재생이 가능한 상태가 되면 재생 명령을 수행 
    - prepare() : 재생 준비동안 다른 작업 수행 x , 재생 가능한 상태가 되면 OnPreparedListener 이벤트가 발생 
    - prepareAsync() : 다른 작업 수행 가능 
    ```java
      mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener(){
        @Override
        public void onPrepared(MediaPlayer mp){
          mediaPlayer.start();
        }
      });
    ```
    
  MediaPlayer에 등록하는 이벤트 
  
   - OnCompletionListener : 미디어 재생 완료 시 이벤트 
   - OnErrorListener : 재생 에러 발생 
   - OnPreparedListener : 재생 가능한 상태로 로딩된 상태 
   - OnBufferingUpdateListener : 버퍼링 이벤트 
   - OnVideoSizeChangedListener : 비디오 크기 변경 이벤트 

  MediaPlayer 제공 제어 및 정보 추출 함수 
  
   - start() : 재생 시작   
   - stop() : 정지 
   - prepare() : 준비
   - pause() : 일시 정지 
   - release() : 메모리 해제
   - seekTo() : 재생 위치 지정
   - getCurrentPosition() : 재생 위치 
   - getDuration() : 재생 시간 
   - getVideoHeight() : 영상 높이값
   - getVideoWidth() : 영상 너비값
   - setLooping() : 반복 설정
   - setVolume() : 볼륨 설정 
---
  리소스 파일과 저장 폴더 
  
  |--|
   -- 