package com.example.practical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
Button btnobj;
EditText edtobj;
Context cn=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnobj=findViewById(R.id.btnprompt);
        edtobj=findViewById(R.id.edtprompt);
        LayoutInflater li=LayoutInflater.from(cn);
        View view1=li.inflate(R.layout.prompt,null);
        AlertDialog.Builder alb=new AlertDialog.Builder(cn);
        alb.setView(view1);
        EditText input=(EditText) view1.findViewById(R.id.edtp);
alb.setPositiveButton("yes", new DialogInterface.OnClickListener() {
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
al.setTitle("Prompt");
al.show();


    }
}