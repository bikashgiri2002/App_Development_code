package com.devbiku.basicviews;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button home,return_home;
    String str =", Load jagannath will help you grow in your life if you work hard and respect everyone and help the needy";
    static String enter;
    EditText name;
    String newStr;
    CheckBox success,hard_work,happiness,pain,discipline,peace;



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
        home=findViewById(R.id.btn_contact_us);
        name=findViewById(R.id.input_name);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enter = name.getText().toString();
               Log.v("entered message:",enter);
                Log.v("new string",enter+str);
                Intent newIntent;
                newIntent =new Intent(MainActivity.this , MessageActivity.class);
                startActivity(newIntent);
            }
        });
        success=findViewById(R.id.checkbox_success);
        hard_work=findViewById(R.id.checkbox_hard_work);
        happiness=findViewById(R.id.checkbox_happiness);
        pain=findViewById(R.id.checkbox_pain);
        discipline=findViewById(R.id.checkbox_discipline);
        peace=findViewById(R.id.checkbox_peace);
        success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (success.isChecked()){
                    pain.setChecked(true);
                    success.setChecked(false);
                }
            }
        });
        hard_work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hard_work.isChecked()){
                    success.setChecked(true);
                    happiness.setChecked(true);
                    pain.setChecked(false);
                }
            }
        });
        happiness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (happiness.isChecked()){
                    pain.setChecked(true);
                    happiness.setChecked(false);
                }
            }
        });
        pain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pain.isChecked()){
                    success.setChecked(false);
                    happiness.setChecked(false);
                    hard_work.setChecked(false);
                    discipline.setChecked(false);
                    peace.setChecked(false);
                }
            }
        });
        discipline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (discipline.isChecked()){
                    happiness.setChecked(true);
                    peace.setChecked(true);
                    pain.setChecked(false);
                }
            }
        });
    }
}