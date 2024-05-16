package com.devbiku.stonepaperscissor;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView user,computer;
    RadioGroup userClick;
    RadioButton stone, paper,scissor;
    int userScore=0,computerScore=0,userChoose,computerChoose;
    TextView displayUserScore,displayComputerScore;
    Random random = new Random();


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
        user = findViewById(R.id.user_choose_img);
        computer = findViewById(R.id.computer_choose_img);
        userClick = findViewById(R.id.userclicked);
        stone = findViewById(R.id.stone_radio);
        paper = findViewById(R.id.paper_radio);
        scissor = findViewById(R.id.scissor_radio);
        displayUserScore =findViewById(R.id.txt_user_score);
        displayComputerScore =findViewById(R.id.txt_computer_score);
        userClick.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.stone_radio){
                    user.setImageResource(R.drawable.stone_final);
                }else if (checkedId == R.id.paper_radio){
                    user.setImageResource(R.drawable.paper_final);
                }else{
                    user.setImageResource(R.drawable.sciccors_final);
                }
            }
        });

    }

}