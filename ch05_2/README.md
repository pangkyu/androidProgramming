# ch05 실습 
  - RelativeLayout 실습

---
 - 주요 사용코드
   - xml : RelativeLayout

---
 - 주요 내용 

  - RelativeLayout 
    - 다른 위젯의 상대 위치에 배치
    - 각 속성의 값은 다른 위젯의 id를 지정 ( "@+id/기준 위젯의 아이디"와 같은 형식으로 사용한다. ) 
    
  ※ above : alignLeft, alignRight
     below : alignLeft, alignRight
     toLeftOf : alignTop, alignBaseline, alignBottom
     toRightOf : alignTop, alignBaseline, alignBottom
     
  - TableLayout
    - 주로 위젯을 표 형태로 배치할 때 사용한다. 
    - <TableRow>와 함께 사용되는데, <TableRow>의 개수가 바로 행의 개수.
    - 열의 개수는 <TableRow>안에 포함된 위젯의 수로 결정
      - 테이블레이아웃의 속성
         - layout_column : 지정된 열에 현재 위젯을 표시
         - layout_span : 지정된 크기만큼 열을 합쳐서 표시
         - stretchColumns : 지정된 열의폭을 늘림
         - stretchColumns = "*" : 각 셀을 같은 크기로 확장. 전체 화면이 꽉 차는 효과 
  
  - GridLayout ( 안드로이드 4.0 , 아이스크림 샌드위치 api 부터 지원 ) 
    - 테이블 레이아웃처럼 위젯을 표 형태로 배치할 때 사용. 좀더 직관적이다. 인덱스 0부터 시작  
    - 레이아웃의 속성
       - rowCount, columnCount : 행/열개수
       - orientation : 그리드를 수평/수직방향을 우선할 것인지 
       - layout_gravity : 주로 fill, fill_vertical, fill_horizontal로 지정 행 또는 열 확장시, 위젯을 확장된 셀에 꽉 채우는 효과를 낸다. 
      
  - FrameLayout 
    - 단순히 레이아웃 내의 위젯을 왼쪽 상단부터 겹쳐서 출력
    - 프레임레이아웃 자체로 사용하기보다는 탭 위젯 등과 혼용하여 사용할 때 유용
    - 레이아웃의 속성
       - foreground : 프레임레이아웃의 전경 이미지를 지정 ex) @drawable/dog
       - foregroundGravity : 전경 이미지의 위치를 지정 ex ) "center|fill_horizontal" 
  
