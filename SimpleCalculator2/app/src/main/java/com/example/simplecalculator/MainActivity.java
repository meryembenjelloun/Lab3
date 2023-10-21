package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private enum Operator {none, add, sub, mul, div, eq}
    private double data01=0, data02 = 0;
    private Operator opp = Operator.none;
    private boolean hasDot = false;
    private boolean requiresCleaning = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Function called every time a number button is pressed
    public void onClickNumericalButton(View view) {
        //Getting ID of pressed Button
        int pressID = view.getId();

        //Getting Text object where we display the current number value
        TextView curText = (TextView)findViewById(R.id.resultTextView);

        //If we had an equal sign pressed last, standard operation is to clean
        if (opp == Operator.eq) {
            opp = Operator.none;
            curText.setText("");
        }

        if (requiresCleaning) {
            requiresCleaning = false;
            curText.setText("");
        }

        //Figuring out which button was pressed and updating the represented text field object
        switch (pressID) {
            case R.id.btn0:
                curText.setText(curText.getText() + "0");
                break;
            case R.id.btn1:
                curText.setText(curText.getText() + "1");
                break;
            case R.id.btn2:
                curText.setText(curText.getText() + "2");
                break;
            case R.id.btn3:
                curText.setText(curText.getText() + "3");
                break;
            case R.id.button4:
                curText.setText(curText.getText() + "4");
                break;
            case R.id.button5:
                curText.setText(curText.getText() + "5");
                break;
            case R.id.btn6:
                curText.setText(curText.getText() + "6");
                break;
            case R.id.btn7:
                curText.setText(curText.getText() + "7");
                break;
            case R.id.btn8:
                curText.setText(curText.getText() + "8");
                break;
            case R.id.btn9:
                curText.setText(curText.getText() + "9");
                break;
            case R.id.btnvirgule:
                if (!hasDot) {
                    curText.setText(curText.getText() + ".");
                    hasDot = true;
                } else {
                    //TODO Decide if we will implement a special case for when we already have a decimal point.
                    //For now we follow android guidelines and ignore
                }
                break;
            default:
                curText.setText("ERROR");
                Log.d("Error","Error: Unknown Button pressed!");
                break;
        }
    }

    public void onClickFunctionButton(View view) {
        //Getting ID of pressed Button
        int pressID = view.getId();

        //Getting Text object where we display the current number value
        TextView curText = (TextView)findViewById(R.id.resultTextView);

        //CE clears all regardless of context
        if (pressID == R.id.btnCE) {
            opp = Operator.none;
            curText.setText("");
            data01 = 0;
            data02 = 0;
            requiresCleaning = false;
            return;
        }

        String dataText = curText.getText().toString();
        double numberVal = dataText.length() > 0 ? Double.parseDouble(dataText) : 0;

        //Checking if we have "prior data" aka something stored in data1 that we should use
        //Having data1 !≃ 0 is not enough, we need to know of a previous operator, hence this
        if (opp == Operator.none) {
            data01 = numberVal;
            requiresCleaning = true;
            switch (pressID) {
                case R.id.btnegale:
                    //TODO Decide if we will implement a special function for the no data equal operation
                    opp = Operator.eq;
                    data01 = 0;
                    break;

                case R.id.btnplus:
                    opp = Operator.add;
                    break;

                case R.id.btnmoins:
                    opp = Operator.sub;
                    break;

                case R.id.btndivise:
                    opp = Operator.div;
                    break;

                case R.id.btnfois:
                    opp = Operator.mul;
                    break;

                case R.id.btnCE:
                    opp = Operator.none;
                    break;
            }
        } else {
            double result = 0;
            data02 = numberVal;

            switch (opp) {
                case eq:
                    //TODO: Technically this doesn't do anything and shouldn't accur
                    break;

                case none:
                    //TODO: Technically this can't do anything and will never occur
                    break;

                case add:
                    result = data01 + data02;
                    break;

                case sub:
                    result = data01 - data02;
                    break;

                case div:
                    result = data01 / data02;
                    break;

                case mul:
                    result = data01 * data02;
                    break;
            }
            data01 = result;
            opp = Operator.none;
            if ( (result - (int)result) != 0) {
                curText.setText(String.valueOf(result));
            } else {
                curText.setText(String.valueOf((int)result));
            }
        }
    }


}
