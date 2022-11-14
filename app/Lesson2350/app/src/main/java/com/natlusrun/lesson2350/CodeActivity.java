package com.natlusrun.lesson2350;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class CodeActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;
    Button button;
    String generatedCode = "";
    String number = "";
    Button checkButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);

        textView = findViewById(R.id.number_from_et);
        editText = findViewById(R.id.code_et);
        button = findViewById(R.id.generate_btn);
        checkButton = findViewById(R.id.check_btn);

        Intent intent = getIntent();

        number = intent.getStringExtra("phone_number");



        textView.setText(textView.getText().toString() + number);


        System.out.println(generatedCode);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Random random = new Random();
//                random.nextInt(999999);
                generateCode();


                //Toast.makeText(getApplicationContext(), generatedCode, Toast.LENGTH_LONG).show();

            }
        });

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText.getText().toString().equals(generatedCode)) {
                    //Toast.makeText(getApplicationContext(), "success!", Toast.LENGTH_SHORT).show();
                    System.out.println("success!");

                    Intent intent1 = new Intent(CodeActivity.this, UserActivity.class);
                    intent1.putExtra("user_phone", number);
                    startActivity(intent1);

                } else  {
                    System.out.println("wrong code!");
                    //Toast.makeText(getApplicationContext(), "wrong code!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    void generateCode() {
        for (int i = 0; i < 6; i++) {
            Random random = new Random();
            int number = random.nextInt(9);
            String character = String.valueOf(number);

            //generatedCode += character;
            System.out.println(character);

            generatedCode = generatedCode + character;
            System.out.println(generatedCode);
        }
    }
}