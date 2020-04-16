package com.example.a312;


import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView screen;

    private Float num1;
    private Float num2;
    private Float result;
    private String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        screen = findViewById(R.id.textViewInputNumbers);
        TextView buttonC = findViewById(R.id.textViewButtonC);
        TextView buttonPlusOrMinus = findViewById(R.id.textViewButtonPlusMinus);
        TextView buttonPercent = findViewById(R.id.textViewButtonPercent);
        TextView buttonDivision = findViewById(R.id.textViewButtonDivision);
        TextView buttonSeven = findViewById(R.id.textViewButton7);
        TextView buttonEight = findViewById(R.id.textViewButton8);
        TextView buttonNine = findViewById(R.id.textViewButton9);
        TextView buttonMultiplication = findViewById(R.id.textViewButtonMulti);
        TextView buttonFour = findViewById(R.id.textViewButton4);
        TextView buttonFive = findViewById(R.id.textViewButton5);
        TextView buttonSix = findViewById(R.id.textViewButton6);
        TextView buttonSubtraction = findViewById(R.id.textViewButtonMinus);
        TextView buttonOne = findViewById(R.id.textViewButton1);
        TextView buttonTwo = findViewById(R.id.textViewButton2);
        TextView buttonThree = findViewById(R.id.textViewButton3);
        TextView buttonAddition = findViewById(R.id.textViewButtonPlus);
        TextView buttonZero = findViewById(R.id.textViewButton0);
        TextView buttonDot = findViewById(R.id.textViewButtonDot);
        TextView buttonEqually = findViewById(R.id.textViewButtonEqual);

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText("0");
                num1 = 0F;
                num2 = 0F;
            }
        });

        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String notDoubleNull = screen.getText().toString();
                if (notDoubleNull.contains(getString(R.string.textViewButtonDot))) {
                    screen.append(getString(R.string.textViewButton0));
                } else {
                    if (notDoubleNull.startsWith(getString(R.string.textViewButton0))) {
                        screen.append(getString(R.string.textViewButtonDot));
                    } else {
                        screen.append(getString(R.string.textViewButton0));
                    }
                }
            }
        });

        buttonOne.setOnClickListener(getCalcButtonClickListener(R.string.textViewButton1));
        buttonTwo.setOnClickListener(getCalcButtonClickListener(R.string.textViewButton2));
        buttonThree.setOnClickListener(getCalcButtonClickListener(R.string.textViewButton3));
        buttonFour.setOnClickListener(getCalcButtonClickListener(R.string.textViewButton4));
        buttonFive.setOnClickListener(getCalcButtonClickListener(R.string.textViewButton5));
        buttonSix.setOnClickListener(getCalcButtonClickListener(R.string.textViewButton6));
        buttonSeven.setOnClickListener(getCalcButtonClickListener(R.string.textViewButton7));
        buttonEight.setOnClickListener(getCalcButtonClickListener(R.string.textViewButton8));
        buttonNine.setOnClickListener(getCalcButtonClickListener(R.string.textViewButton9));

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String notDoubleDot = screen.getText().toString();
                if (notDoubleDot.contains(getString(R.string.textViewButtonDot))) {
                    v.setClickable(false);
                } else {
                    screen.append(getString(R.string.textViewButtonDot));
                }
            }
        });

        buttonPlusOrMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String plusOrMinus = screen.getText().toString();
                String minus = getString(R.string.textViewButtonMinus) + plusOrMinus;
                String plus = getString(R.string.textViewButtonPlus) + plusOrMinus;
                if (Float.valueOf(screen.getText().toString()) > 0) {
                    screen.setText(minus);
                } else {
                    screen.setText(plus.substring(1));
                }
            }
        });

        buttonPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Float.valueOf(screen.getText().toString()) / 100;
            }
        });

        buttonAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (screen.getText().length() != 0) {
                    operator = "+";
                    num1 = Float.valueOf(screen.getText().toString());
                    screen.setText("");
                } else {
                    operator = "+";
                }
            }
        });

        buttonSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (screen.getText().length() != 0) {
                    operator = "-";
                    num1 = Float.valueOf(screen.getText().toString());
                    screen.setText("");
                } else {
                    operator = "-";
                }
            }
        });

        buttonMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (screen.getText().length() != 0) {
                    operator = "×";
                    num1 = Float.valueOf(screen.getText().toString());
                    screen.setText("");
                } else {
                    operator = "×";
                }
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (screen.getText().length() != 0) {
                    operator = "÷";
                    num1 = Float.valueOf(screen.getText().toString());
                    screen.setText("");
                } else {
                    operator = "÷";
                }
            }
        });

        buttonEqually.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (operator != null && screen.getText().length() != 0) {
                    num2 = Float.valueOf(screen.getText().toString());
                    switch (operator) {
                        case "+":
                            result = num1 + num2;
                            screen.setText(result.toString());
                            break;
                        case "-":
                            result = num1 - num2;
                            screen.setText(result.toString());
                            break;
                        case "×":
                            result = num1 * num2;
                            screen.setText(result.toString());
                            break;
                        case "÷":
                            if (num2 != 0F) {
                                result = num1 / num2;
                                screen.setText(result.toString());
                            } else {
                                screen.setText(getString(R.string.app_error));
                            }
                            break;
                    }
                    num1 = result;
                } else {
                    //   num1 = Float.valueOf(screen.getText().toString());
                    screen.setText(num1.toString());
                    num1 = result;
                }
            }
        });
    }

    private View.OnClickListener getCalcButtonClickListener(@StringRes final int numberResource) {
        final String number = getString(numberResource);

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.append(number);
            }
        };
    }
}