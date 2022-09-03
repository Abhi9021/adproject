package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    LinearLayout lrt1obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lrt1obj=findViewById(R.id.lrt1);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
    switch (menuItem.getItemId()) {
        case R.id.mired:
            lrt1obj.setBackgroundColor(Color.RED);
            return true;
        case R.id.migreen:
            lrt1obj.setBackgroundColor(Color.GREEN);
            return true;
        case  R.id.miyellow:
            lrt1obj.setBackgroundColor(Color.YELLOW);
            return  true;
        case R.id.miblue:
            lrt1obj.setBackgroundColor(Color.BLUE);
            return true;
        default:
            return true;
    }
    }
    }
