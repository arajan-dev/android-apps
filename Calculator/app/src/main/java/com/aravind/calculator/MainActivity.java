package com.aravind.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity{

    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button decimal;
    private Button plus;
    private Button sub;
    private Button mul;
    private Button divide;
    private Button equalTo;
    private Button del;
    private TextView result;
    private TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //map buttons
        one = findViewById(R.id.button40);
        two = findViewById(R.id.button43);
        three = findViewById(R.id.button46);
        four = findViewById(R.id.button36);
        five = findViewById(R.id.button42);
        six = findViewById(R.id.button45);
        seven = findViewById(R.id.button35);
        eight = findViewById(R.id.button37);
        nine = findViewById(R.id.button38);
        zero = findViewById(R.id.button44);
        divide = findViewById(R.id.button48);
        plus = findViewById(R.id.button51);
        sub = findViewById(R.id.button50);
        mul = findViewById(R.id.button49);
        decimal = findViewById(R.id.button41);
        del = findViewById(R.id.button39);
        equalTo = findViewById(R.id.button47);

        textView = findViewById(R.id.textView);
        textView1 = findViewById(R.id.textView1);
    }


    EditText textView, textView1;
    String equation = "";

    public void b1(View view){
        equation = equation + "1";
        textView.setText(equation);
    }

    public void b2(View view){
        equation = equation + "2";
        textView.setText(equation);
    }

    public void b3(View view){
        equation = equation + "3";
        textView.setText(equation);
    }

    public void b4(View view){
        equation = equation + "4";
        textView.setText(equation);
    }

    public void b5(View view){
        equation = equation + "5";
        textView.setText(equation);
    }

    public void b6(View view){
        equation = equation + "6";
        textView.setText(equation);
    }

    public void b7(View view){
        equation = equation + "7";
        textView.setText(equation);
    }

    public void b8(View view){
        equation = equation + "8";
        textView.setText(equation);
    }

    public void b9(View view){
        equation = equation + "9";
        textView.setText(equation);
    }

    public void b0(View view){
        equation = equation + "0";
        textView.setText(equation);
    }

    public void bDot(View view){
        equation = equation + ".";
        textView.setText(equation);
    }

    public void bMul(View view){
        equation = equation + "*";
        textView.setText(equation);
    }

    public void bPlus(View view){
        equation = equation + "+";
        textView.setText(equation);
    }

    public void bMinus(View view){
        equation = equation + "-";
        textView.setText(equation);
    }

    public void bDiv(View view){
        equation = equation + "/";
        textView.setText(equation);
    }

    public void bClear(View view){
        equation = "";
        textView.setText(equation);
        textView1.setText(equation);
    }

    public void bCal(View view){
        double answer;
        answer = eval(equation);
        String answerStr= Double.toString(answer);
        String[] answerSp = answerStr.split(Pattern.quote("."));
        if(answerSp[1].equals("0")) {
            textView1.setText(answerSp[0]);
            //textView.setText(answerSp[0]);
            equation =  answerSp[0];
        }else {
            textView1.setText(Double.toString(answer));
            //textView.setText(Double.toString(answer));
            equation =  Double.toString(answer);
        }
        //textView.setText(Double.toString(answer))
    }



    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation
                return x;
            }
        }.parse();
    }

}
