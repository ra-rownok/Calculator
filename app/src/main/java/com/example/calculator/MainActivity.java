package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class MainActivity extends AppCompatActivity {

    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn00,btnPlus,btnMinus,btnPercentage,btnDivide,btnEqual,btnClear,btnMultiplication,btnDot,btnBracket;
    TextView Input,Output;
    String process;
    boolean checkBracket = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn00 = findViewById(R.id.btn00);

        btnPlus = findViewById(R.id.btnPlus);
        btnMinus =findViewById(R.id.btnMinus);
        btnMultiplication = findViewById(R.id.btnMultiplication);
        btnDivide = findViewById(R.id.btnDivide);
        btnPercentage = findViewById(R.id.btnPercentage);

        btnClear = findViewById(R.id.btnClear);
        btnDot = findViewById(R.id.btnDot);
        btnBracket = findViewById(R.id.btnBracket);
        btnEqual = findViewById(R.id.btnEqual);

        Input = findViewById(R.id.Input);
        Output = findViewById(R.id.Output);


        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Input.setText("");
                Output.setText("");
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = Input.getText().toString();
                Input.setText(process + "0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = Input.getText().toString();
                Input.setText(process + "1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = Input.getText().toString();
                Input.setText(process + "2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = Input.getText().toString();
                Input.setText(process + "3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = Input.getText().toString();
                Input.setText(process + "4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = Input.getText().toString();
                Input.setText(process + "5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = Input.getText().toString();
                Input.setText(process + "6");
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = Input.getText().toString();
                Input.setText(process + "0");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = Input.getText().toString();
                Input.setText(process + "7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = Input.getText().toString();
                Input.setText(process + "8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = Input.getText().toString();
                Input.setText(process + "9");
            }
        });

        btn00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = Input.getText().toString();
                Input.setText(process + "00");
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = Input.getText().toString();
                Input.setText(process + "+");
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = Input.getText().toString();
                Input.setText(process + "-");
            }
        });

        btnMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = Input.getText().toString();
                Input.setText(process + "×");
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = Input.getText().toString();
                Input.setText(process + "÷");
            }
        });

        btnPercentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = Input.getText().toString();
                Input.setText(process + "%");
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = Input.getText().toString();
                Input.setText(process + ".");
            }
        });


        btnBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBracket){
                    process = Input.getText().toString();
                    Input.setText(process + "(");
                    checkBracket = false;
                }
                else{
                    process = Input.getText().toString();
                    Input.setText(process + ")");
                    checkBracket = true;
                }

            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = Input.getText().toString();

                process = process.replaceAll("×", "*");
                process = process.replaceAll("%", "/100");
                process = process.replaceAll("÷", "/");

                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);

                String finalResult = "";

                try{
                    Scriptable scriptable = rhino.initStandardObjects();
                    finalResult = rhino.evaluateString(scriptable, process, "javascript", 1, null).toString();
                }
                catch(Exception e){
                    finalResult = "0";
                }

                Output.setText(finalResult);

            }
        });
    }

}