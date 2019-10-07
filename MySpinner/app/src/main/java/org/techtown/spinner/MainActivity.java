package org.techtown.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    String[] items = {"트와이스", "아이즈원", "마마무", "베리굿"};
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);

        Spinner spinner = (Spinner)findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>( // ArrayAdapter는 직접 어댑터 클래스를 정의하지 않는 경우 자주 사용한다.
                //여러 개의 데이터를 가진 경우 직접 베이스 어댑터를 정의해주는 것이 좋다.
                this, android.R.layout.simple_spinner_item, items//두번째 파라미터는 스피너 처음에 보이는 화살표가 있는 창 레이아웃
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // 스피너를 선택했을 때 보이는 선택창
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) { // 하나의 아이템이 선택되면 호출
                textView.setText(items[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                textView.setText("선택 : ");
            }
        });
    }
}
