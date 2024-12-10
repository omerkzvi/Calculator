package com.example.myfirstapplicationhit;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView result;
    double firstNumber, secondNumber;
    char ch;
    boolean Decimal = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        result = findViewById(R.id.textViewResult);
        result.setText("");

    }

    public void numFunc(View view) {
        Button button = (Button) view;
        result.append(button.getText().toString());
    }

    public void funcCh(View view) {
        ch =((Button) view).getText().toString().charAt(0);
        firstNumber = Double.parseDouble(result.getText().toString());
        result.setText("");
    }

    public void funcEqual(View view) {
        secondNumber = Double.parseDouble(result.getText().toString());
        double res = 0;
        switch (ch) {
            case '+':
                res = firstNumber + secondNumber;
                break;
            case '-':
                res = firstNumber - secondNumber;
                break;
            case 'X':
                res = firstNumber * secondNumber;
                break;
            case '/':
                if (secondNumber == 0) {
                    result.setText("Division by zero!");
                    return;
                } else
                    res = firstNumber / secondNumber;
                break;
        }
        result.setText(res+"");
        Decimal = false;
        }

    public void resetCalculator(View view) {
        result.setText("");
        firstNumber = 0;
        secondNumber = 0;
        ch = '\0';
        Decimal = false;
    }

    public void decimalPoint(View view){
        if (!Decimal) {
            result.append(".");
            Decimal = true;
        }

    }
}
