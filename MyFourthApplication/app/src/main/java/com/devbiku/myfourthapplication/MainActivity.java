package com.devbiku.myfourthapplication;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.MaterialToolbar;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String countries_name[];
    ArrayAdapter<String> adapter;
    TextView currentCountry;
    MaterialToolbar toolbar;
    EditText search;

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
        search=findViewById(R.id.search_country);
        toolbar =findViewById(R.id.tool_bar);
        toolbar.setOverflowIcon(AppCompatResources.getDrawable(this,R.drawable.baseline_more_vert_24));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.refresh_icon){
                    currentCountry.setText("");
                } else if (item.getItemId()== R.id.search_icon) {
                    search.setVisibility(View.VISIBLE);
                }else if (item.getItemId() == R.id.setting) {
                    Toast.makeText(getApplicationContext(), "setting  is clicked", Toast.LENGTH_SHORT).show();
                }else if (item.getItemId() == R.id.exit){
                    finish();
                }
                return true;
            }
        });

    }
}