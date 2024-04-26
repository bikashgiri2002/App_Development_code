package com.devbiku.mysecondapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView text,text2;
    Button ok;
    RelativeLayout c;
    ImageView i;
    RadioGroup group;
    RadioButton green,blue,yellow;
    ToggleButton showText;
    ArrayAdapter spinnerAdapter;
    Spinner countrySpinner;

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
        text = findViewById(R.id.textExample);
        text.setText("Jay Jay Jagannath");
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setTextColor(Color.BLACK);
                text.setBackgroundColor(Color.WHITE);
            }
        });
        ok=findViewById(R.id.menu);
        text2=findViewById(R.id.textView2);
        c=findViewById(R.id.main);
        group=findViewById(R.id.radioGroupColour);
        green=findViewById(R.id.radioButtonGreen);
        blue=findViewById(R.id.radioButtonBlue);
        yellow=findViewById(R.id.radioButtonYellow);
        showText=findViewById(R.id.toggle_btn_text);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text2.setVisibility(View.VISIBLE);
                if (green.isChecked()){
                    c.setBackgroundColor(Color.GREEN);
                }
                else if (blue.isChecked()){
                    c.setBackgroundColor(Color.BLUE);
                }
                if (yellow.isChecked()){
                    c.setBackgroundColor(Color.YELLOW);
                }
            }
        });
        showText.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    text.setTextColor(Color.BLACK);
                    text.setBackgroundColor(Color.WHITE);
                    c.setBackgroundColor(Color.BLACK);
                }
                else{
                    text.setTextColor(Color.WHITE);
                    text.setBackgroundColor(Color.BLACK);
                    c.setBackgroundColor(Color.WHITE);
                }
            }
        });
        countrySpinner=findViewById(R.id.spinner_country);
        spinnerAdapter=ArrayAdapter.createFromResource(this,R.array.country,android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countrySpinner.setAdapter(spinnerAdapter);

    }
}