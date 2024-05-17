package com.devbiku.stonepaperscissor;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
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

    int userScore=0,computerScore=0,userChoose,computerChoose;
    TextView displayUserScore,displayComputerScore,result;
    Random random = new Random();
    Button refresh ;


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
        displayUserScore =findViewById(R.id.txt_user_score);
        displayComputerScore =findViewById(R.id.txt_computer_score);
        result = findViewById(R.id.result_txt);
        refresh = findViewById(R.id.refresh_btn);
    }

    public void check(int userChoose,int computerChoose ){
        switch (userChoose){
            case 0:
                user.setImageResource(R.drawable.stone_final);
                if (computerChoose==1){
                    computer.setImageResource(R.drawable.paper_final);
                    computerScore++;
                    result.setText("Opps! You Lost");
                } else if (computerChoose==2) {
                    computer.setImageResource(R.drawable.sciccors_final);
                    userScore++;
                    result.setText("Yups ! You Won");
                }
                else{
                    computer.setImageResource(R.drawable.stone_final);
                    result.setText("It's a Tie !");
                }
                break;
            case 1:
                user.setImageResource(R.drawable.paper_final);
                if (computerChoose==2) {
                    computer.setImageResource(R.drawable.sciccors_final);
                    computerScore++;
                    result.setText("Opps! you lost");
                } else if (computerChoose==0) {
                    computer.setImageResource(R.drawable.stone_final);
                    userScore++;
                    result.setText("Yups ! You Won");
                }
                else{
                    computer.setImageResource(R.drawable.paper_final);
                    result.setText("It's a Tie !");
                }
                break;
            case 2:
                user.setImageResource(R.drawable.sciccors_final);
                if (computerChoose == 0){
                    computer.setImageResource(R.drawable.stone_final);
                    computerScore++;
                    result.setText("Opps! you lost");
                } else if (computerChoose == 1) {
                    computer.setImageResource(R.drawable.paper_final);
                    userScore++;
                    result.setText("Yups ! You Won");
                }
                else{
                    computer.setImageResource(R.drawable.sciccors_final);
                    result.setText("It's a Tie !");
                }
                break;
        }
    }
    private void changeScoreBoard(int userScore,int computerScore){
        displayUserScore.setText(String.valueOf(userScore));
        displayComputerScore.setText(String.valueOf(computerScore));
    }
    public void onClickOfImage(View v){
        userChoose=Integer.parseInt(v.getTag().toString());
        computerChoose=random.nextInt(3);
        check(userChoose,computerChoose);
        changeScoreBoard(userScore,computerScore);
    }
    public void onClickRefresh(View v){
        userScore=0;
        computerScore=0;
        displayUserScore.setText(String.valueOf(userScore));
        displayComputerScore.setText(String.valueOf(computerScore));
        user.setImageResource(R.drawable.stone_final);
        computer.setImageResource(R.drawable.stone_final);
        result.setText("Result");
    }


}