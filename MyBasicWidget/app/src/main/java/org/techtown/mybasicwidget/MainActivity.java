package org.techtown.mybasicwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RadioButton radioButton = findViewById(R.id.radioButton3);
        boolean checked = radioButton.isChecked();
    }


}
