package com.example.priya_000.calculator;


import java.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    private char CURRENT_ACTION;

    private double valueOne = Double.NaN;
    private double valuetwo;

    private DecimalFormat decimalFormat;
    private EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        decimalFormat = new DecimalFormat("#.##########");


        edit = (EditText) findViewById(R.id.edit);
        final TextView text = (TextView) findViewById(R.id.text);
        Button key7 = (Button) findViewById(R.id.key7);
        Button key8 = (Button) findViewById(R.id.key8);
        Button key9 = (Button) findViewById(R.id.key9);
        Button key4 = (Button) findViewById(R.id.key4);
        Button key5 = (Button) findViewById(R.id.key5);
        Button key6 = (Button) findViewById(R.id.key6);
        Button key1 = (Button) findViewById(R.id.key1);
        Button key2 = (Button) findViewById(R.id.key2);
        Button key3 = (Button) findViewById(R.id.key3);
        Button keydot = (Button) findViewById(R.id.keydot);
        Button keyzero = (Button) findViewById(R.id.keyzero);
        Button keyequal = (Button) findViewById(R.id.keyequal);
        Button keyadd = (Button) findViewById(R.id.keyadd);
        Button keysub = (Button) findViewById(R.id.keysub);
        Button keymul = (Button) findViewById(R.id.keymul);
        Button keydiv = (Button) findViewById(R.id.keydiv);
        Button keyback = (Button) findViewById(R.id.keyback);
        Button keyclear = (Button) findViewById(R.id.keyclear);

        keyzero.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {

                        edit.setText(edit.getText() + "0");
                    }
                });
        keydot.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {

                        edit.setText(edit.getText() + ".");
                    }
                });
        key7.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {

                        edit.setText(edit.getText() + "7");
                    }
                });
        key8.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {

                        edit.setText(edit.getText() + "8");
                    }
                });
        key9.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {

                        edit.setText(edit.getText() + "9");
                    }
                });
        key4.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {

                        edit.setText(edit.getText() + "4");
                    }
                });
        key5.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {

                        edit.setText(edit.getText() + "5");
                    }
                });
        key6.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {

                        edit.setText(edit.getText() + "6");
                    }
                });
        key1.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {

                        edit.setText(edit.getText() + "1");
                    }
                });
        key2.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {

                        edit.setText(edit.getText() + "2");
                    }
                });
        key3.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {

                        edit.setText(edit.getText() + "3");
                    }
                });

        keyadd.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        computeCalculation();
                        CURRENT_ACTION = ADDITION;
                        text.setText(decimalFormat.format(valueOne) + "+");
                        edit.setText(null);
                    }
                });

        keysub.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        computeCalculation();
                        CURRENT_ACTION = SUBTRACTION;
                        text.setText(decimalFormat.format(valueOne) + "-");
                        edit.setText(null);
                    }
                });

        keymul.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        computeCalculation();
                        CURRENT_ACTION = MULTIPLICATION;
                        text.setText(decimalFormat.format(valueOne) + "*");
                        edit.setText(null);
                    }
                });

        keydiv.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        computeCalculation();
                        CURRENT_ACTION = DIVISION;
                        text.setText(decimalFormat.format(valueOne) + "/");
                        edit.setText(null);
                    }
                });

        keyequal.setOnClickListener(
                new View.OnClickListener() {

                    public void onClick(View view) {
                        computeCalculation();
                        text.setText(text.getText().toString() +
                                decimalFormat.format(valuetwo) + " = " + decimalFormat.format(valueOne));
                        valueOne = Double.NaN;
                        CURRENT_ACTION = '0';
                    }
                });

        keyback.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edit.getText().length() > 0) {
                    CharSequence currentText = edit.getText();
                    edit.setText(currentText.subSequence(0, currentText.length()-1));
                }
                else {
                    valueOne = Double.NaN;
                    valuetwo = Double.NaN;
                    edit.setText("");
                    text.setText("");
                }
            }
        });
        keyclear.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(edit.getText().length() > 0) {
                            CharSequence currentText = edit.getText();
                            edit.setText(null);
                        }
                        else {
                            valueOne = Double.NaN;
                            valuetwo = Double.NaN;
                            edit.setText("");
                            text.setText("");
                        }
                    }
                });

    }



    private void computeCalculation() {
        if (!Double.isNaN(valueOne)) {
            valuetwo = Double.parseDouble(edit.getText().toString());
            edit.setText(null);

            if (CURRENT_ACTION == ADDITION)
                valueOne = this.valueOne + valuetwo;
            else if (CURRENT_ACTION == SUBTRACTION)
                valueOne = this.valueOne - valuetwo;
            else if (CURRENT_ACTION == MULTIPLICATION)
                valueOne = this.valueOne * valuetwo;
            else if (CURRENT_ACTION == DIVISION)
                valueOne = this.valueOne / valuetwo;
        } else {
            try {
                valueOne = Double.parseDouble(edit.getText().toString());
            } catch (Exception e) {
            }
        }
    }

}


