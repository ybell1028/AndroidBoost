package org.techtown.mytoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(), "위치가 바뀐 토스트",Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP|Gravity.LEFT, 200, 200);
                toast.show();
            }
        });

        Button button2 = (Button)findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = getLayoutInflater();
                /*안드로이드에서 레이아웃 XML파일을 View 객체로 만들기 위해서는
                LayoutInflater를 이용해야 한다.
                 */
                View layout = inflater.inflate(R.layout.toastborder, (ViewGroup)findViewById(R.id.toast_layout_root));
                //인플레이션에서 한 toastborder라고 하는 xml 레이아웃을
                //그대로 그 안에 있는 최상위 레이아웃으로 인플레이션해 붙임


                TextView text = (TextView)layout.findViewById(R.id.text);//토스트 메시지로 사용할것
                text.setText("모양을 바꾼 토스트입니다.");

                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER, 0, -100); //토스트의 위치 설정
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);//인플레이션 해서 만든 레이아웃을 설정

                toast.show();
            }
        });

        Button button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "스낵바입니다.", Snackbar.LENGTH_LONG).show();
            }
        });
    }
}
