package org.techtown.mymovie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button thumbUpButton, thumbDownButton;
    TextView thumbUpNum, thumbDownNum;

    int good = 0, bad = 0; // 좋아요 싫어요의 수
    boolean goodState = false;
    boolean badState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        thumbUpButton = (Button) findViewById(R.id.thumb_up_button);
        thumbDownButton= (Button) findViewById(R.id.thumb_down_button);

        thumbUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(goodState){
                    decrGood();
                } else {
                    incrGood();
                }
                thumbUpNum.setText(String.valueOf(good));

                goodState = !goodState;
            }
        });

        thumbDownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(badState){
                    decrBad();
                } else {
                    incrBad();
                }
                thumbDownNum.setText(String.valueOf(bad));

                badState = !badState;
            }
        });

        thumbUpNum = (TextView)(findViewById(R.id.thumb_up_num));
        thumbDownNum = (TextView)(findViewById(R.id.thumb_down_num));

        thumbUpNum.setText(String.valueOf(good));
        thumbUpNum.setText(String.valueOf(bad));

        ListView listView = (ListView)findViewById(R.id.listView);
        CommentAdapter adapter = new CommentAdapter();
        listView.setAdapter(adapter); // 리스트 뷰가 어댑터를 알기 때문에 서로 물어보면서 화면에 표시해줌

    }

    class CommentAdapter extends BaseAdapter{


    }

    public void incrGood()
    {
        good++;
        thumbUpNum.setText(String.valueOf(good));
        thumbUpButton.setBackgroundResource(R.drawable.ic_thumb_up_selected);
    }

    public void decrGood()
    {
        good--;
        thumbUpNum.setText(String.valueOf(good));
        thumbUpButton.setBackgroundResource(R.drawable.ic_thumb_up);
    }

    public void incrBad()
    {
        bad++;
        thumbDownNum.setText(String.valueOf(bad));
        thumbDownButton.setBackgroundResource(R.drawable.ic_thumb_down_selected);
    }

    public void decrBad()
    {
        bad--;
        thumbDownNum.setText(String.valueOf(bad));
        thumbDownButton.setBackgroundResource(R.drawable.ic_thumb_down);
    }
}
