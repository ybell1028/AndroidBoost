package org.techtown.mylayoutinflater;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {


    FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = (FrameLayout)findViewById(R.id.container);

        Button button = (Button)(findViewById(R.id.button));
        button.setOnClickListener(new View.OnClickListener() // 버튼을 클랙했을때 sub1.xml이라고 하는 xml 레이아웃의 내용을
            // 메모리에 객체화하는 인플레이션 과정을 거치면 우리가 공간을 확보한 container에다가 붙여줄 수 있다
        {
            @Override
            public void onClick(View v)
            {
                LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE); // LayoutInflater가 왼쪽으로 반환
                inflater.inflate(R.layout.sub1, container, true); // inflate() 메소드를 실행하면 xml레이아웃을 메모리에 객체화 할 수 있다.
                //파라미터는 우리가 만든 xml 레이아웃 파일과, 어느 뷰에다 붙혀줄건지 지정
            }
        });
    }
}
