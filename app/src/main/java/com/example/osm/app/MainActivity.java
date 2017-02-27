package com.example.osm.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final NumberPicker numberpicker =(NumberPicker)findViewById(R.id.numberPicker);
        final NumberPicker numberpicker2 =(NumberPicker)findViewById(R.id.numberPicker2);

        numberpicker.setMaxValue(24);
        numberpicker.setMinValue(0);
        numberpicker2.setMaxValue(59);
        numberpicker2.setMinValue(0);

        numberpicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        numberpicker2.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

        Button btn = (Button)findViewById(R.id.button);

        // クリックイベントを受け取れるようにする
        btn.setOnClickListener(new View.OnClickListener() {
            // このメソッドがクリック毎に呼び出される
            public void onClick(View v) {
                // ここにクリックされたときの処理を記述
                numberpicker.getValue();
                numberpicker2.getValue();
                Intent intent = new Intent(getApplication(),Main2Activity.class);
                intent.putExtra("num1",numberpicker.getValue());
                intent.putExtra("num2",numberpicker2.getValue());
                startActivity(intent);
            }
        });
    }
}
