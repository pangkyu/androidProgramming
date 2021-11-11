# 뷰 실습

 1. 리스트와 그리드 뷰 

  - XML을 이용한 리스트뷰 만들기 

    1. 리스트뷰에 나열할 내용을 String 배열로 미리 만든다. 
    2. 리스트뷰 변수를 생성하고 XML의 <ListView>에 대응시킴
    3. ArrayAdapter<String> 형의 변수를 선언하고, 리스트뷰의 모양과 내용을 1번 배열로 채움
    4. 3번에서 생성한 ArrayAdapter를 2번의 리스트 뷰 변수에 적용
    5. 리스트뷰의 항목을 클릭했을 때 동작하는 리스너 정의 
  
    ```xml
      <LinearLayout>
        <ListView
                  android:id = "@+id/listView1"
                  android:layout_width = "match_parent"
                  android:layout_height = "wrap_content"/>
      </LinearLayout>
    ```
