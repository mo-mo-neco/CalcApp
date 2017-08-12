package jp.techacademy.kawai.momoko.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText mEditText1;
    EditText mEditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

        mEditText1 = (EditText) findViewById(R.id.EditText1);
        mEditText2 = (EditText) findViewById(R.id.EditText2);
    }

    @Override
    public void onClick(View v) {

        double value1 =0;
        double value2 =0;

        //入力値読み取り
        if (readValue(mEditText1)){
            value1 = Double.parseDouble(mEditText1.getText().toString());
        }
        else{
            Toast.makeText(this, "数値を入力してください", Toast.LENGTH_LONG).show();
            return;
        }
        if (readValue(mEditText2)) {
            value2 = Double.parseDouble(mEditText2.getText().toString());
        }
        else{
            Toast.makeText(this, "数値を入力してください", Toast.LENGTH_LONG).show();
            return;
        }

        //ボタン分岐
        int valOpr = 0;
        if (v.getId() == R.id.button1) {
            valOpr = 1;
        } else if (v.getId() == R.id.button2) {
            valOpr = 2;
        } else if (v.getId() == R.id.button3) {
            valOpr = 3;
        } else if (v.getId() == R.id.button4) {
            valOpr = 4;
        }

        //遷移
        if (valOpr == 4 && value2 == 0){
            Toast.makeText(this, "０で割り算できません", Toast.LENGTH_LONG).show();
        }
        else{
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("VALUE1", value1);
            intent.putExtra("VALUE2", value2);
            intent.putExtra("Operator", valOpr);
            startActivity(intent);
        }
    }

    //数値かどうか判定
    private boolean readValue(EditText iEditText){
        try
        {
            double val = Double.parseDouble(iEditText.getText().toString());
            return true;
        } catch (NumberFormatException e)
        {
            return false;
        }
    }
}
