# 자기소개 앱

  - 간단한 자기소개 앱을 만들어보자! 
  - 과제 목표 
     1. TextView를 이용하여 이름, 학번을 표시한다 
     2. 본인 학년을 체크된 상태로 표시, 1,2학년은 비활성화 시키기 
     3. 본인 사진 표시하여 순서대로 보여주기(반복)
---

 - 사용 xml
   - TextView, RadioGroup, RadioButton, ImageView, Button

 - 사용 이벤트 
    - setOnClickListener

---

 - 주요 코드 
 ```java
  // 버튼을 누르면 이미지가 반복하여 출력이 되는 메소드
  
  public class MainActivity extends AppCompatActivity{
    int [] ImageId = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3 }
    int i = 0;
    ImageView picture = null;
    // ... 
    protected void onCreate(Bundle savedInstanceState) {
    // ...
      picture = (ImageView) findViewById(R.id.picture);
      picture.setImageResource(R.drawable.pic1);
      
      clickBtn.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
          picture.setImageResource(ImageId[i]);
          i+=1;
          if(i == ImageId.length){
            i = 0;
          }
        }
      });
    }
  }
 ```
 
 ---
  - 막혔던 부분 
    - 처음에는 반복문으로 돌려서 length에 닿으면 다시 0으로 돌리려고 했으나, 구현해보니 무한루프가 발생하여 제대로 실행이 되지않았음.
    - 그래서 배열에 이미지들을 집어넣고 클릭하면 i에 1을 더해 length에 닿으면 i를 초기화하는 쪽으로 구현하였다.
