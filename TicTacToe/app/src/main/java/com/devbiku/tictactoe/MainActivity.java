package com.devbiku.tictactoe;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.MaterialToolbar;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,refresh;
    String b1,b2,b3,b4,b5,b6,b7,b8,b9;
    MaterialToolbar toolbar;
    AlertDialog.Builder resultDialog;
    int count=0;
    int choose=0;

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
        toolbar=findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        init();
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGame();
            }
        });
    }
    void init(){
        btn1=findViewById(R.id.btn_1);
        btn2=findViewById(R.id.btn_2);
        btn3=findViewById(R.id.btn_3);
        btn4=findViewById(R.id.btn_4);
        btn5=findViewById(R.id.btn_5);
        btn6=findViewById(R.id.btn_6);
        btn7=findViewById(R.id.btn_7);
        btn8=findViewById(R.id.btn_8);
        btn9=findViewById(R.id.btn_9);
        refresh=findViewById(R.id.btn_refresh);
    }
    void newGame(){
        count=0;
        choose=0;
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
    }
    void getBtnText(){
        b1=btn1.getText().toString();
        b2=btn2.getText().toString();
        b3=btn3.getText().toString();
        b4=btn4.getText().toString();
        b5=btn5.getText().toString();
        b6=btn6.getText().toString();
        b7=btn7.getText().toString();
        b8=btn8.getText().toString();
        b9=btn9.getText().toString();
    }
    public void click(View v){
        Button currentButton = (Button) v;
        if (currentButton.getText().toString().equals("")) {
            if (choose == 0) {
                currentButton.setText("X");
                choose = 1;
                count++;
            } else {
                currentButton.setText("O");
                choose = 0;
                count++;
            }
            if (count > 4){
                getBtnText();
                if (!b1.equals("") && b1.equals(b2) && b1.equals(b3)){
                    showDialogMessage(b1+" is winner");

                }
                else if (!b4.equals("") && b4.equals(b5) && b4.equals(b6)){
                    showDialogMessage(b4+" is winner");

                }
                else if (!b7.equals("") && b7.equals(b8) && b8.equals(b9)){
                    showDialogMessage(b7+" is winner");

                }
                else if (!b1.equals("") && b1.equals(b4) && b1.equals(b7)){
                    showDialogMessage(b4+" is winner");

                }
                else if (!b2.equals("") && b2.equals(b5) && b2.equals(b8)){
                    showDialogMessage(b2+" is winner");

                }
                else if (!b3.equals("") && b3.equals(b6) && b3.equals(b9)){
                    showDialogMessage(b3+" is winner");

                }
                else if (!b1.equals("") && b1.equals(b5) && b1.equals(b9)){
                    showDialogMessage(b1+" is winner");

                }
                else if (!b3.equals("") && b3.equals(b5) && b3.equals(b7)){
                    showDialogMessage(b3+" is winner");

                }
                else if (!b1.equals("") && !b2.equals("") && !b3.equals("") && !b4.equals("") && !b5.equals("") && !b6.equals("") && !b7.equals("") && !b8.equals("") && !b9.equals("")){
                    showDialogMessage("draw!");

                }
            }
        }
    }
    private void showDialogMessage(String result) {
        resultDialog=new AlertDialog.Builder(this);
        resultDialog.setTitle("Result").setMessage(result).setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setPositiveButton("New Game", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                newGame();
            }
        }).show();
        resultDialog.create();
    }

}