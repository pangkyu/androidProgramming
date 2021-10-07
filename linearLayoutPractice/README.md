# 중복리니어레이아웃 실습 

---
-CODE

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:orientation="vertical">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_weight="1"
        android:orientation="horizontal">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:background="#ff0000"
            android:orientation="vertical">
        </LinearLayout>
        <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:layout_weight="1"
                android:background = "#00ff00"
                android:orientation="vertical">
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:layout_weight="1"
                android:background = "#ffff00"
                android:orientation="vertical">
            </LinearLayout>
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:layout_weight="1"
                android:background = "#000000"
                android:orientation="vertical">
            </LinearLayout>
        </LinearLayout>



    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_weight="1"
        android:background="#0000ff"
        android:orientation="vertical">
        
    </LinearLayout>
</LinearLayout>
```

  - 1 대 1 비율로 나눠지게 했기때문에 상단에서도 리니어 레이아웃을 하나 더 적용시켜야함(실제결과에서는 덮어써져서 보인다. ) 
