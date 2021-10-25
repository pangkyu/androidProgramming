# P7_1 inflater 활용

  - inflater => main화면에서 sub화면을 열수있다. 
  
  <주요구문>
  
  ```xml
    <?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:id="@+id/itemRed"
        android:title = "배경색 (빨강)">
    </item>
    <item
    android:id="@+id/itemGreen"
    android:title = "배경색 (초록)">
    </item>
    <item
        android:id="@+id/itemBlue"
        android:title = "배경색 (파랑)">
    </item>
    <item android:title = "버튼 변경>>">
        <menu>
            <item android:id="@+id/subRotate"
                android:title="버튼 45도 회전">

            </item>
            <item android:id="@+id/subSize"
                android:title = "버튼 2배 확대">

            </item>
        </menu>
    </item>
</menu>
  ```
  
  ```java
  
public class MainActivity extends AppCompatActivity {

    LinearLayout baseLayout;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("배경색 바꾸기");
        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);
        button1 = (Button) findViewById(R.id.button1);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.itemRed:
                baseLayout.setBackgroundColor(Color.RED);
                return true;
            case R.id.itemGreen:
                baseLayout.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.itemBlue:
                baseLayout.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.subRotate:
                button1.setRotation(45);
                return true;
            case R.id.subSize:
                button1.setScaleX(2);
                return true;
        }
        return false;
    }
}
  ```


---
 - only java로도 구문작성가능 
 ```java
  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
//        MenuInflater mInflater = getMenuInflater();
//        mInflater.inflate(R.menu.menu1, menu);
        menu.add(0,1,0,"배경색 (발강)");
        menu.add(0,2,0,"배경색 (초록)");
        menu.add(0,3,0,"배경색 (파랑)");

        SubMenu sMenu = menu.addSubMenu("버튼변경 >>");
        sMenu.add(0,4,0,"버튼 45도 변경");
        sMenu.add(0,5,0,"버튼 2배확대 ");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case 1: //R.id.itemRed:
                baseLayout.setBackgroundColor(Color.RED);
                return true;
            case 2: //R.id.itemGreen:
                baseLayout.setBackgroundColor(Color.GREEN);
                return true;
            case 3: //R.id.itemBlue:
                baseLayout.setBackgroundColor(Color.BLUE);
                return true;
            case 4: //R.id.subRotate:
                button1.setRotation(45);
                return true;
            case 5: // R.id.subSize:
                button1.setScaleX(2);
                return true;
        }
        return false;
    }
 ```
