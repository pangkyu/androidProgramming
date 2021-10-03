package kr.ac.hs.and2021.introducemyself;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    int [] ImageId = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3};
    int i = 0;
    RadioButton grade3, grade4;
    Button clickBtn;
    ImageView picture = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //라디오 버튼 설정
        grade3 = (RadioButton) findViewById(R.id.grade3);
        grade4 = (RadioButton) findViewById(R.id.grade4);
        grade3.setChecked(true);
        //변경 버튼 설정
        clickBtn = (Button) findViewById(R.id.clickBtn);

        //이미지 설정
        picture = (ImageView) findViewById(R.id.picture);
        picture.setImageResource(R.drawable.pic1);

        int length = ImageId.length;

        clickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                picture.setImageResource(ImageId[i]);
                i+=1;
                if(i == ImageId.length){
                    i = 0;
                }
//                i = 1 - i;
//                if ( i == 0){
//                    picture.setImageResource(R.drawable.pic1);
//                }else if ( i == 1){
//                    picture.setImageResource(R.drawable.pic2);
//                }else{
//                    picture.setImageResource(R.drawable.pic3);
//                }
            }
        });

    }
}