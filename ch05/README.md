# java 코드로 화면 만들기 

---

 - 일반적으로는 xml로 화면을 구성하고 java코드로 화면에 출력한다. 
   => setContentView(R.layout.activity_main);
   
   
 ex) 
 ```java
    //JAVA코드 작성
        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
        //(XML) android:layout_width = "match_parent", android:layout_height = "match_parent"

        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        //(XML) : android:orientation = "vertical"
        baseLayout.setBackgroundColor(Color.rgb(0,255,0));
        //(XML) : android:background = "#00ff00"
        setContentView(baseLayout, params);
 ```
 
