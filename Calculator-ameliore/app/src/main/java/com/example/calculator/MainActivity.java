package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    private enum Operator {none,add,minus,multiply,divide};
    private double data1=0, data2=0;
    private Operator optr= Operator.none;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickNumericalButton(View view) {
        int pressID = view.getId();
        TextView curText = (TextView) findViewById(R.id.resultEdit);

        if (pressID  == R.id.btn00) {
            curText.setText(curText.getText() + "0");
        } else if (pressID == R.id.btn01) {
            curText.setText(curText.getText() + "1");
        } else if (pressID == R.id.btn02) {
            curText.setText(curText.getText() + "2");
        } else if (pressID == R.id.btn03) {
            curText.setText(curText.getText() + "3");
        } else if (pressID == R.id.btn04) {
            curText.setText(curText.getText() + "4");
        } else if (pressID == R.id.btn05) {
            curText.setText(curText.getText() + "5");
        } else if (pressID == R.id.btn06) {
            curText.setText(curText.getText() + "6");
        } else if (pressID == R.id.btn07) {
            curText.setText(curText.getText() + "7");
        } else if (pressID == R.id.btn08) {
            curText.setText(curText.getText() + "8");
        } else if (pressID == R.id.btn09) {
            curText.setText(curText.getText() + "9");
        } else if (pressID == R.id.btnDot) {
            curText.setText(curText.getText() + ".");

        } else if (pressID == R.id.btnResult) {

            if(optr!= Operator.none){
                TextView eText= (TextView) findViewById(R.id.resultEdit);
                data2=Double.parseDouble(eText.getText().toString());
                double result=0;
                if (optr==Operator.add){
                    result=data1+data2;
                }
                else if(optr==Operator.minus){
                    result=data1-data2;
                }
                else if(optr==Operator.multiply){
                    result=data1*data2;
                }
                else if(optr==Operator.divide){
                    result=data1/data2;
                }
                optr=Operator.none;
                data1=result;
                if((result-(int)result)!=0){
                    eText.setText(String.valueOf(result));
                }
                else{
                    eText.setText(String.valueOf((int)result));
                }

            }
        }else if (pressID == R.id.btnAdd) {
            optr = Operator.add;
            TextView eText = (TextView) findViewById(R.id.resultEdit);
            data1 = Double.parseDouble(eText.getText().toString());
            eText.setText("");
        }else if (pressID == R.id.btnMinus){
            optr= Operator.minus;
            TextView eText= (TextView) findViewById(R.id.resultEdit);
            data1= Double.parseDouble(eText.getText().toString());
            eText.setText("");
        }else if (pressID == R.id.btnMultiply){
            optr= Operator.multiply;
            TextView eText= (TextView) findViewById(R.id.resultEdit);
            data1= Double.parseDouble(eText.getText().toString());
            eText.setText("");
        }else if (pressID == R.id.btnDivide) {
            optr = Operator.divide;
            TextView eText = (TextView) findViewById(R.id.resultEdit);
            data1 = Double.parseDouble(eText.getText().toString());
            eText.setText("");
        }else if (pressID == R.id.btnClear) {
            TextView eText = (TextView) findViewById(R.id.resultEdit);
            eText.setText("");
        }else{
            curText.setText("ERROR");
            Log.d("Error", "Unknown Button pressed!");
        }
    }
}