package com.devbiku.bmicalculater;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.MaterialToolbar;

public class MainActivity extends AppCompatActivity {
    RadioGroup gender;
    RadioButton male,female;
    EditText weight,feet,inch;
    TextView resultOutput;
    Button calculate;
    MaterialToolbar toolbar;

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
        gender=findViewById(R.id.gender);
        male=findViewById(R.id.radio_btn_male);
        female=findViewById(R.id.radio_btn_female);
        male.setChecked(true);
        weight=findViewById(R.id.input_weight);
        feet=findViewById(R.id.input_feet);
        inch=findViewById(R.id.input_inch);
        calculate=findViewById(R.id.btn_calculate);
        resultOutput=findViewById(R.id.result);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String finalWeight=weight.getText().toString();
                String height_feet=feet.getText().toString();
                String height_inch=inch.getText().toString();
                // check for valid entry
                if(finalWeight.isEmpty() || (height_feet.isEmpty() || height_inch.isEmpty())) {
                   resultOutput.setText("enter valid data");
                   return;
                }
                double weight = Double.parseDouble(finalWeight);
                int feet = Integer.parseInt(height_feet);
                int inch = Integer.parseInt(height_inch);
                double height=(feet*0.3048)+(inch*0.0254);
                double bmi=weight/(height*height);
               if (bmi <18.5){
                   resultOutput.setText("Bmi is "+bmi+"\n Under weight");
                   resultOutput.setBackgroundResource(R.color.yellow);
//                   resultOutput.setVisibility(View.VISIBLE);
               }else if (bmi >=18.5 && bmi<25.0){
                   resultOutput.setText("Bmi is "+bmi+"\n Healthy weight");
//                   resultOutput.setVisibility(View.VISIBLE);
                   resultOutput.setBackgroundResource(R.color.green);
               }else if (bmi >=25.0 && bmi<30){
                   resultOutput.setText("Bmi is "+bmi+"\n Over weight");
                   resultOutput.setBackgroundResource(R.color.red);

//                   resultOutput.setVisibility(View.VISIBLE);
               }
               else {
                   resultOutput.setText("Bmi is "+bmi+"\nObese\nDANGER");
//                 resultOutput.setVisibility(View.VISIBLE);
                   resultOutput.setBackgroundResource(R.color.deepRed);
               }
            }
        });
        toolbar=findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}