# 프로젝트 5
---
 ### 새로 배운 것들 
 ```xml
  <Button
          android:gravity = "top|right"
          android:layout_gravity = "left"/>
 ```
 - line 6 : 버튼 안에 있는 글씨의 위치를 정한다. 
 - line 7 : 버튼의 위치를 정해준다. 상위 LinearLayout에서 android:orientation = "vertical"이 설정되어있어야 한다. 


 ```xml
  <LinearLayout ... 
                android:layout_width = "fill_parent"
                android:layout_height = "fill_parent"
 ```


---
 - baselineAligned 속성 
   - 크기가 다른 여러 위젯을 보기 좋게 정렬해준다. true와 false값을 가진다. (dafault : true)

---
 - 중복 LinearLayout
   - 형태 
   ```xml
     <LinearLayout>
         <LinearLayout>
                위젯..
         </LinearLayout>
      
         <LinearLayout>
              위젯...
         </LinearLayout>
     </LinearLayout>
   ```
    - layout_weight : 리니어 레이아웃을 여러 개 사용할 경우 각 레이아웃의 크기를 지정할 때 사용. 주로 전체 회면에 대한 비율(%)로 지정한다. 
