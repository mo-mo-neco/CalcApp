package jp.techacademy.kawai.momoko.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        double value1 = intent.getDoubleExtra("VALUE1", 0);
        double value2 = intent.getDoubleExtra("VALUE2", 0);
        int value3 = intent.getIntExtra("Operator", 0);

        TextView textView = (TextView) findViewById(R.id.textView);
        switch (value3) {
        case 1:
            textView.setText(String.valueOf(value1 + value2));
            break;
        case 2:
            textView.setText(String.valueOf(value1 - value2));
            break;
        case 3:
            textView.setText(String.valueOf(value1 * value2));
            break;
        case 4:
            textView.setText(String.valueOf(value1 / value2));
            break;
        default:
            textView.setText("エラー");
            break;
        }
    }
}
