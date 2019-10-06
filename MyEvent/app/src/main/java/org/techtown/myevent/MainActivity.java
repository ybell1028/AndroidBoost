package org.techtown.myevent;

import androidx.appcompat.app.AppCompatActivity;

import android.gesture.GestureOverlayView;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    GestureDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);

        View view = findViewById(R.id.view);

        view.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){ // 손가락으로 터치하면 메서드 호출
                int action = event.getAction();//각각의 상태를 구분할 수 있는 구분자

                float curX = event.getX();
                float curY = event.getY();

                if(action == MotionEvent.ACTION_DOWN) // 손가락을 눌렀을때
                {
                    println("손가락 눌렸음 : " + curX + ", " + curY);
                }
                else if(action == MotionEvent.ACTION_MOVE) // 손가락을 누른 상태에서 움직일때
                {
                    println("손가락 움직임 : " + curX + ", " + curY);
                }
                else if(action == MotionEvent.ACTION_UP) // 손가락을 땠을때
                {
                    println("손가락 떼졌음 : " + curX + ", " + curY);
                }

                return true;//이벤트가 정상적으로 처리됨
            }
        });

        detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent motionEvent) {
                println("onDown() 호출됨");
                return true;
            }

            @Override
            public void onShowPress(MotionEvent motionEvent) {
                //화면을 터치하고 떼지 않았을 때, 즉 터치다운하고 이동과
                // 업 이벤트가 발생하지 않았을 때 호출됩니다.
                println("onShowPress() 호출됨");
            }

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                println("onSingleTapUp() 호출됨");
                return true;
            }

            @Override
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                println("onScroll() 호출됨 : " + v + ", " + v1);
                return true;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {
                println("onLongPress() 호출됨");
            }

            @Override
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                //v, v1(velocity) 속도를 자동으로 계산해서 파라미터로 넘겨준다
                // 화면을 살짝 팅길 때, 즉 터치다운하고 터치업할때 호출됩니다.

                println("onFling() 호출됨 : " + v + ", " + v1);
                return true;
            }
        });

        View view2 = findViewById(R.id.view2);
        view2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                detector.onTouchEvent(motionEvent);
                return true;
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //키가 눌렸을때 지금 이 이벤트가 처리됨
        if(keyCode == KeyEvent.KEYCODE_BACK)//시스템 BACK 버튼이 눌렸을때 초출됨
        {
            Toast.makeText(this, "시스템 BACK 버튼 눌림.", Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }

    public void println(String data)
    {
        textView.append(data + "\n");
    }
}
