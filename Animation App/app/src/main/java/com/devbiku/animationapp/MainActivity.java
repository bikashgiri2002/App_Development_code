package com.devbiku.animationapp;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView hello;
    Button translate,rotation,alpha,scale;

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
        Animation move = AnimationUtils.loadAnimation(this,R.anim.move_animation);
        Animation rotate = AnimationUtils.loadAnimation(this,R.anim.rotate_animation);
        hello = findViewById(R.id.textView);
        translate = findViewById(R.id.translate);
        rotation = findViewById(R.id.rotation);
        translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hello.startAnimation(move);
            }
        });
        rotation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                hello.startAnimation(rotate);
            }
        });
    }
}