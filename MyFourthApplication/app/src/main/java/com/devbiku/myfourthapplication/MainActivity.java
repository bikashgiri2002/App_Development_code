package com.devbiku.myfourthapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String countries_name[];
    ArrayAdapter<String> adapter;
    TextView currentCountry;

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
        listView=findViewById(R.id.list_country_name);
        countries_name=getResources().getStringArray(R.array.countries);
        currentCountry=findViewById(R.id.txt_country_name);
        adapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,countries_name);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String current_country_name=parent.getItemAtPosition(position).toString();
                currentCountry.setText("You Clicked "+current_country_name);
//                Toast.makeText(getApplicationContext(), "You select "+current_country_name, Toast.LENGTH_SHORT).show();
            }
        });
    }
}