package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ListView lstobj;
LinearLayout lrtobj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       lstobj=findViewById(R.id.lst);
       lrtobj=findViewById(R.id.lrt);
       lstobj.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               if(i==0)
               {
                   Intent m=new Intent(MainActivity.this,chkActivity2.class);
                   startActivity(m);
                   Toast.makeText(getApplicationContext(),"Checkbox selected",Toast.LENGTH_SHORT);
               }
               if(i==1)
               {
                   Intent m=new Intent(MainActivity.this,imgActivity2.class);
                   startActivity(m);
                   Toast.makeText(getApplicationContext(),"Image View selected",Toast.LENGTH_SHORT);
               }
               else if(i==2)
               {
                   Intent m=new Intent(MainActivity.this,backlActivity2.class);
                   startActivity(m);
                   Toast.makeText(getApplicationContext(),"Web View selected",Toast.LENGTH_SHORT);
               }
               else if(i==3)
               {
                   Intent m=new Intent(MainActivity.this,Alertdialogactivity.class);
                   startActivity(m);
                   Toast.makeText(getApplicationContext(),"Alert dialog selected",Toast.LENGTH_SHORT);
               }
           }
       });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mired:
                lrtobj.setBackgroundColor(Color.RED);
                return  true;
            case  R.id.migreen:
                lrtobj.setBackgroundColor(Color.GREEN);
                return  true;
            case R.id.miyellow:
                lrtobj.setBackgroundColor(Color.YELLOW);
                return true;
            default:
                return true;
        }
    }
}