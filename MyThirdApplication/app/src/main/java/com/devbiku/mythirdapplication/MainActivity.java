package com.devbiku.mythirdapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    MaterialToolbar toolbar;

    ConstraintLayout mainLayout;
    Button snack_bar;
    TextView main_text;
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
        toolbar.setOverflowIcon(AppCompatResources.getDrawable(this,R.drawable.baseline_more_vert_24));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),"Navigation icon is clicked",Toast.LENGTH_SHORT).show();
                showDialogMessage();
            }
        });
        main_text=findViewById(R.id.text_in_main);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId()== R.id.edit){
                    Toast.makeText(getApplicationContext(),"Edit icon is clicked",Toast.LENGTH_SHORT).show();
                }
                else if (item.getItemId() == R.id.archive){
                    Toast.makeText(getApplicationContext(),"archive icon is clicked",Toast.LENGTH_SHORT).show();
                } else if (item.getItemId() == R.id.setting) {
                    Toast.makeText(getApplicationContext(),"setting  is clicked",Toast.LENGTH_SHORT).show();
                }else if (item.getItemId() == R.id.sign_out) {
//                    Toast.makeText(getApplicationContext(),"Sign Out is clicked",Toast.LENGTH_SHORT).show();
                    Snackbar.make(mainLayout,"You want to sign out",Snackbar.LENGTH_INDEFINITE)
                            .setAction("Sign out message", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    main_text.setText("Sign out successfully");
                                }
                            }).show();
                }
                return true;
            }
        });
        mainLayout=findViewById(R.id.main);
        snack_bar= findViewById(R.id.btn_snack_bar);
        snack_bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(mainLayout,"Snack bar message", Snackbar.LENGTH_INDEFINITE)
                        .setAction("close", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        }).show();
            }
        });

    }

    private void showDialogMessage() {
        AlertDialog.Builder exitDialog=new AlertDialog.Builder(this);
        exitDialog.setTitle("Exit").setMessage("do you want to exit ?").setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

            }
        }).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        }).show();
        exitDialog.create();
    }
}