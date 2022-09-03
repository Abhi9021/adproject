package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.LinearLayout;

public class backlActivity2 extends AppCompatActivity {

WebView webobj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backl2);
        webobj=findViewById(R.id.web);
        webobj.loadUrl("http://www.google.com");
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