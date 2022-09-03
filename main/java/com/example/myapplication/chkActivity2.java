package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class chkActivity2 extends AppCompatActivity {
CheckBox chk1obj,chk2obj,chk3obj;
Button btnorderobj;
int bill;
TextView txtbillobj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chk2);
        chk1obj=findViewById(R.id.chk1);
        chk2obj=findViewById(R.id.chk2);
        chk3obj=findViewById(R.id.chk3);
        btnorderobj=findViewById(R.id.btnorder);
        txtbillobj=findViewById(R.id.txtbil);
        btnorderobj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bill=0;
                if(chk1obj.isChecked())
                {
                    bill+=100;
                    txtbillobj.setText("your bill is:"+bill);
                }
                if(chk2obj.isChecked())
                {
                    bill+=50;
                    txtbillobj.setText("your bill is:"+bill);

                }
                 if(chk3obj.isChecked())
                {
                    bill+=150;
                    txtbillobj.setText("your bill is:"+bill);
                }
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