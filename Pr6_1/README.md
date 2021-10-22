# Pr6_1

 날짜/시간 예약 앱 만들기 
 
 기능소개 
  1. 타이머 기능 : <예약 시작>과 <예약 완료>를 클릭하면 크로노미터가 타이머로 동작한다. 
  2. 날짜/시간 설정 : <날짜 설정>, <시간 설정>을 클릭하면 예약 날짜와 시간을 변경 가능
  3. <예약 완료>를 클릭하면 설정한 날짜와 시간이 결정된다. 
 
 주요 코드
 
 ```xml
   <CalendarView
                android:id = "@+id/calendarView1"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:showWeekNumber="false">

            </CalendarView>
 ```
   => showWeekNumber의 default는 true. 왼쪽에 주차를 보여줄지 말지를 알려주는 코드다.
   
 ```java
    //처음에는 2개를 안보이게 설정한다.
        tPicker.setVisibility(View.INVISIBLE);
        calView.setVisibility(View.INVISIBLE);

        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tPicker.setVisibility(View.INVISIBLE);
                calView.setVisibility(View.VISIBLE);
            }
        });
        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tPicker.setVisibility(View.VISIBLE);
                calView.setVisibility(View.INVISIBLE);
            }
        });
 ```
 
 ```java
     // 버튼을 클릭하면 날짜, 시간을 가져온다.
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.stop();
                chrono.setTextColor(Color.BLUE);

                tvYear.setText(Integer.toString(selectYear));
                tvMonth.setText(Integer.toString(selectMonth));
                tvDay.setText(Integer.toString(selectDay));
                tvHour.setText(Integer.toString(tPicker.getCurrentHour()));
                tvMinute.setText(Integer.toString(tPicker.getCurrentMinute()));
            }
        });

        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                selectYear = year;
                selectMonth = month + 1; // 0부터 시작하기 때문에 1을 추가했음음
                selectDay = dayOfMonth;
            }
        });
 ```
