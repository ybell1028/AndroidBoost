package org.techtown.mymovie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button thumbUpButton, thumbDownButton;
    TextView thumbUpNum, thumbDownNum;

    CommentAdapter adapter;

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


        //여기서부터 리스트 뷰 구현
        ListView listView = (ListView)findViewById(R.id.listView);

        adapter = new CommentAdapter();
        adapter.addItem(new CommentItem(R.drawable.ic_12, "ybell1028", 30, 2, "What were they Thinking?", 100));
        adapter.addItem(new CommentItem(R.drawable.ic_12, "ybell1028", 30, 2, "What were they Thinking?", 100));
        adapter.addItem(new CommentItem(R.drawable.ic_12, "ybell1028", 30, 2, "What were they Thinking?", 100));
        adapter.addItem(new CommentItem(R.drawable.ic_12, "ybell1028", 30, 2, "What were they Thinking?", 100));

        listView.setAdapter(adapter);
    }

    class CommentAdapter extends BaseAdapter
    {
        ArrayList<CommentItem> items = new ArrayList<CommentItem>();

        public void addItem(CommentItem item)
        {
            items.add(item);
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            CommentItemView civ = null;

            if(view == null)
            {
                civ =  new CommentItemView(getApplicationContext());
            }
            else
            {
                civ = (CommentItemView)view;
            }

            CommentItem item = items.get(i);
            civ.setImage(item.getResId());
            civ.setId(item.getId());
            civ.setTime(item.getTime());
            civ.setRating(item.getRating());
            civ.setComment(item.getComment());
            civ.setRecommend(item.getRecommend());

            return civ;
        }
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
