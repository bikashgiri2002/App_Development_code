package com.devbiku.myfirstapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button b;
    RelativeLayout r;
    Button white;
    TextView t;

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
        b=findViewById(R.id.b1);
        b.setText("black");
        r=findViewById(R.id.main);
        t=findViewById(R.id.jay);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r.setBackgroundColor(Color.BLACK);
                t.setBackgroundColor(Color.WHITE);
                t.setTextColor(Color.BLACK);
            }
        });
        white=findViewById(R.id.b2);
        white.setText("white");
        white.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r.setBackgroundColor(Color.WHITE);
                t.setBackgroundColor(Color.BLACK);
                t.setTextColor(Color.WHITE);
            }
        });
    }
}