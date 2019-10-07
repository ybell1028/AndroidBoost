package org.techtown.mymovie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button thumbUpButton, thumbDownButton;
    TextView thumbUpNum, thumbDownNum;

    int good = 0, bad = 0; // 좋아요 싫어요의 수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        thumbUpButton = (Button) findViewById(R.id.thumb_up_button);
        thumbDownButton= (Button) findViewById(R.id.thumb_down_button);

        thumbUpNum = (TextView)(findViewById(R.id.thumb_up_num));
        thumbDownNum = (TextView)(findViewById(R.id.thumb_down_num));

        thumbUpNum.setText(String.valueOf(good));
        thumbUpNum.setText(String.valueOf(bad));

        thumbUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                good++;
                thumbUpNum.setText(String.valueOf(good));
            }
        });

        thumbDownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bad++;
                thumbDownNum.setText(String.valueOf(bad));
            }
        });
    }

}
