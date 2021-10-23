# TabHost 실습 

※ 레이아웃 width height 잘 확인할것!

 - TabWidget 클래스 단독으로는 탭 기능을 할 수 없다. 
   ==> 탭 위젯 내부의 탭이 눌러질 때 표시되는 내용을 위한 페이지 화면 때문에!

```xml
    <TabHost
        ...>

        <LinearLayout
            ...
            android:orientation="vertical">

            <TabWidget
                ...
                android:id="@android:id/tabs" />

            <FrameLayout
                ...
                android:id="@android:id/tabcontent">

                <!-- TAB CONTENT 1 -->
                    ...

                <!-- TAB CONTENT 2 -->
                    ...

                <!-- TAB CONTENT 2 -->
                    ...

            </FrameLayout>
        </LinearLayout>
    </TabHost>
```
  - 위의 레이아웃 리소스 코드 중 TabHost에 TabWidget과 FrameLayout을 추가할 때, LinearLayoutㅇ르 사용하는 것을 주의!
  - TabHost는 FrameLayout에서 상속된, 뷰 그룹으로서의 역할을 수행하는 위젯
    ==> 그래서 TabHost의 자식으로 뷰그룹(LinearLayout같은.. )을 사용하지 않고, TabWidget과 FrameLayout을 배치하게 되면, 일반적인 상황에서
        FrameLayout을 사용할 때 처럼, 추가된 자식들이 중첩되버리는 문제가 발생. 이를 해결하기 위해 LinearLayout을 사용.
---

 - 레이아웃 타입 => TabHost 
    - 탭 버튼을 표시하는 TabWidget과, 각 탭의 선택에 따라 표시될 페이지 화면을 관리하는 클래스이다. 
    - 탭 기능과 관련된 모든 내용을 포함하고 있는 컨테이너 역할.
    - TabHost는 FrameLayout을 상속했으므로, 뷰그룹을 사용해서 자식들을 배치해야한다. 
    - 내부 아이디는 android:id = "@android:id/tabHost" 로 줄것
    
 - 하위 리니어레이아웃 
    - 내부에 orientation = vertical을 해줘야 위에서 아래로 화면이 설정된다.
    
 - TabWidget  => 탭 위젯을 담당
    - android:id = "@android:id/tabs" 해줄것
    
 - FrameLayout => 탭을 누르면 컨텐츠들이 출력될 공간이다.
    - android:id = "@android:id/tabcontent" 해줄것


---

```java
 // .setIndicator ==> 탭에 보여질 문자열을 지정
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = getTabHost();

        TabHost.TabSpec tabSpecSong = tabHost.newTabSpec("SONG").setIndicator("음악별"); // "SONG"태그를 가진 TabSpec객체 생성
        tabSpecSong.setContent(R.id.tabSong); // 탭이 눌러졌을 때 FrameLayout에 표시될 content 뷰에 대한 리소스 id를 지정
        tabHost.addTab(tabSpecSong); // TabHost에 탭 추가

        TabHost.TabSpec tabSpecArtist = tabHost.newTabSpec("ARTIST").setIndicator("가수별");
        tabSpecArtist.setContent(R.id.tabArtist);
        tabHost.addTab(tabSpecArtist);

        TabHost.TabSpec tabSpecAlbum = tabHost.newTabSpec("ALBUM").setIndicator("앨범별");
        tabSpecAlbum.setContent(R.id.tabAlbum);
        tabHost.addTab(tabSpecAlbum);

        tabHost.setCurrentTab(0);
    }
```
  
