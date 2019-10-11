package org.techtown.mymovie;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class CommentItemView extends LinearLayout {

    public CommentItemView(Context context) {
        super(context);

        init(context); // 초기화 하는 함수
    }

    public CommentItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context) //우리가 만든 xml 레이아웃과 이 자바 소스 파일을 인플레이션을 통해서 서로 연결해주어야함
    {
        // 메모리 객체화 후 연결

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.comment, this, true);

        // 이미지 뷰나 텍스트 뷰라던가 참조해서 데이터를 설정할 수 있음
    }
}
