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

  ---
  - 리스트뷰의 동적 추가/삭제 
    - 리스트뷰의 항목을 동적으로 추가/삭제 하려면 ArrayList<T>를 정의한 후 add()와 remove() 메소드를 사용
 
 ---
 
  - 그리드 뷰 
     - 사진이나 그림을 격자 모야응로 배치 
     - XML 파일에는 간단히 <GridView>를 넣으면 되지만, JAVA코드에는 필요한 내용을 반드시 코딩해야 한다. 
     - 특히 <GridView>의 속성 중 열 개수를 지정하는 numColumns는 꼭 넣어야한다. 
 
