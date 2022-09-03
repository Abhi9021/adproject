package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class imgActivity2 extends AppCompatActivity {
ImageView imgvobj;
TextView txtimgobj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img2);
        imgvobj=findViewById(R.id.imgv);
        txtimgobj=findViewById(R.id.txtimg);
        imgvobj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtimgobj.setText("1234567890\tabhishekbodhwad@gmail.com");
            }
        });
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