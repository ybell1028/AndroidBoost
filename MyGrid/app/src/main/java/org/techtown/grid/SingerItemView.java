package org.techtown.grid;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SingerItemView extends LinearLayout {

    TextView textView, textView2; // 메소드 어디서든지 사용할수 있기위해
    ImageView imageView;

    public SingerItemView(Context context) {
        super(context);

        init(context);
    }

    public SingerItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) // 만든 xml 레이아웃 파일(singer_item.xml)을 인플레이션해서 붙혀주는 역할
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // 단말이 시작됐을 때 단말에서 기본적으로 실행시켜 놓는 서비스 = 시스템 서비스

        inflater.inflate(R.layout.singer_item, this, true); // 두번째 파라미터 this는 이 클래스가 리니어 레이아웃을 상속받았기 때문에 붙이기가 가능

        textView = (TextView)findViewById(R.id.textView);
        textView2 = (TextView)findViewById(R.id.textView2);
        imageView = (ImageView)findViewById(R.id.imageView);
    }

    //SingerItemView(이 파일)를 이용해서 만든 객체에다가 메서드를 호출하면 바로 데이터를 설정할 수 있게 메서드를 정의

    public void setName(String name)
    {
        textView.setText(name);
    }

    public void setMobile(String mobile)
    {
        textView2.setText(mobile);
    }

    public void setImage(int resId)
    {
        imageView.setImageResource(resId);
    }
}
