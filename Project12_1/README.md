# Project 12_1

SQLite 사용하기 

안드로이드를 설치할때 기본적으로 함께 설치가 된다.

avd manager 실행한 상태에서 명령프롬포트 경로 C:\Users\82010\AppData\Local\Android\Sdk\platform-tools 로 이동 
 
  그후 adb devices 를 입력하면 에뮬레이터가 하나 실행되고 있는 것을 확인할 수 있음. adb root 입력.
  
   adb shell 입력 (내부 커널 리눅스기반으로 동작)(리눅스 명령어 사용가능)
   
   그 후 cd /data/data/kr.ac.hs.and2021.myapplication (안드로이드 파일 위치 경로)
   
   ```java
   generic_x86_arm:/ # ls
acct      bugreports  data           dev              linkerconfig  odm      res      system
adb_keys  cache       data_mirror    etc              lost+found    oem      sdcard   system_ext
apex      config      debug_ramdisk  init             metadata      proc     storage  vendor
bin       d           default.prop   init.environ.rc  mnt           product  sys
generic_x86_arm:/ # cd /data/data/
generic_x86_arm:/data/data # cd kr.ac.hs.and2021.myapplication
generic_x86_arm:/data/data/kr.ac.hs.and2021.myapplication # ls -l
total 16
drwxrws--x 2 u0_a153 u0_a153_cache 4096 2021-11-16 11:53 cache
drwxrws--x 2 u0_a153 u0_a153_cache 4096 2021-11-16 11:53 code_cache
generic_x86_arm:/data/data/kr.ac.hs.and2021.myapplication # mkdir databases
   ```
   <실행결과>
   
   mkdir databases로 데이터베이스 폴더를 생성하고 데이터베이스 폴더로 이동 
   
   
