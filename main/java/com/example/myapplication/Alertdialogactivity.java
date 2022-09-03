package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Alertdialogactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alertdialogactivity);
        AlertDialog.Builder alb=new AlertDialog.Builder(this);
        alb.setMessage("Do you want close this application").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog al=alb.create();
        al.setTitle("Exit");
        al.show();
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }
    public boolean onOptionsItemSelected(MenuItem i)
    {
        switch (i.getItemId())
        {
            case android.R.id.home:
                finish();
                return  true;
        }
        return super.onOptionsItemSelected(i);
    }
    public  boolean onCreateOptionMenu(Menu menu)
    {
        return true;
    }
}