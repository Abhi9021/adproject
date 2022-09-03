package com.example.practical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class dbconnect extends AppCompatActivity  implements View.OnClickListener {
    EditText edtseachobj, edtsnameobj, edtmobobj, edtaddressobj;
    Button btnsaveobj, btnupdateonj, btndeleteobj, btnsearchobj, btnsearchaobj;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbconnect);
        db = openOrCreateDatabase("StudentDB1", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Studetail (Id INTEGER PRIMARY KEY AUTOINCREMENT,Sname VARCHAR,MobileNo NUMBER,Address VARCHAR);");

        edtseachobj = findViewById(R.id.edtsearch);
        edtsnameobj = findViewById(R.id.edtsname);
        edtmobobj= findViewById(R.id.edtmob);
        edtaddressobj = findViewById(R.id.edtaddress);
        btnsaveobj = findViewById(R.id.btnsave);
        btndeleteobj = findViewById(R.id.btndelete);
        btnupdateonj = findViewById(R.id.btnupdate);
        btnsearchobj = findViewById(R.id.btnsearch);
        btnsearchaobj = findViewById(R.id.btnsearcha);

        btnsaveobj.setOnClickListener(this);
        btnupdateonj.setOnClickListener(this);
        btndeleteobj.setOnClickListener(this);
        btnsearchaobj.setOnClickListener(this);
        btnsearchobj.setOnClickListener(this);
    }
    public void clear_all () {
        edtsnameobj.setText("");
        edtaddressobj.setText("");
        edtmobobj.setText("");
        edtseachobj.setText("");
    }
    @Override
    public void onClick(android.view.View view) {
        if (view.getId() == R.id.btnsave) {
           // Toast.makeText(getApplicationContext(),"save clicked",Toast.LENGTH_SHORT).show();
            if (edtsnameobj.getText().toString().trim().length() == 0 || edtmobobj.getText().toString().trim().length() == 0 || edtaddressobj.getText().toString().trim().length() == 0) {
                Toast.makeText(getApplicationContext(), "please enter all the details", Toast.LENGTH_LONG).show();

            }
            db.execSQL("insert into Studetail(Sname,MobileNo,Address) VALUES('"+edtsnameobj.getText()+"','"+edtmobobj.getText()+"','"+edtaddressobj.getText()+"')");

            Toast.makeText(getApplicationContext(), "record inserted succesfully", Toast.LENGTH_SHORT).show();
            clear_all();
        } else if (view.getId() == R.id.btnupdate) {
            if (edtseachobj.getText().toString().trim().length() == 0) {
                Toast.makeText(getApplicationContext(), "please enter emp name", Toast.LENGTH_SHORT).show();

            }
            Cursor c = db.rawQuery("select * from Studetail where Sname='" + edtseachobj.getText().toString() + "'", null);
          if (c.moveToNext()) {
                db.execSQL("update Studetail set Sname='" + edtsnameobj.getText() + "',MobileNo='" + edtmobobj.getText() + "',Address='" + edtaddressobj.getText() + "'where Sname='" + edtseachobj.getText().toString()+"'");

                Toast.makeText(getApplicationContext(), "record updated succesfully", Toast.LENGTH_SHORT).show();
          clear_all();
            }
        } else if (view.getId() == R.id.btndelete) {
            if (edtseachobj.getText().toString().trim().length() == 0) {
                Toast.makeText(getApplicationContext(), "please enter emp name", Toast.LENGTH_SHORT).show();
                return;
            }
            Cursor c = db.rawQuery("select * from Studetail where Sname='" + edtseachobj.getText().toString() + "'", null);
            if (c.moveToFirst()) {
                db.execSQL("delete from Studetail where Sname='" + edtseachobj.getText() + "'");
                clear_all();
                c.close();
            } else {
                Toast.makeText(getApplicationContext(), "invalid emp name", Toast.LENGTH_SHORT).show();
            }

       } else if (view.getId() == R.id.btnsearcha) {
            Cursor c = db.rawQuery("select * from Studetail", null);
            if (c.getCount() == 0) {
                Toast.makeText(getApplicationContext(), "Record not found", Toast.LENGTH_SHORT).show();
                return;
            }
            StringBuffer buffer = new StringBuffer();
            while (c.moveToNext()) {
                buffer.append("Id:"+c.getString(0)+"\n");
                buffer.append("student name:" + c.getString(1) + "\n");
                buffer.append("mobile no:" + c.getString(2) + "\n");
                buffer.append("Address:" + c.getString(3) + "\n");
            }
            Toast.makeText(getApplicationContext(), buffer, Toast.LENGTH_SHORT).show();
            c.close();
        } else if (view.getId() == R.id.btnsearch) {
            if (edtseachobj.getText().toString().trim().length() == 0) {
                Toast.makeText(getApplicationContext(), "Enter emp name", Toast.LENGTH_SHORT).show();
                return;
            }
            Cursor m = db.rawQuery("select * from Studetail where Sname='"+edtseachobj.getText()+"'",null);
            if (m.moveToFirst()) {
                edtsnameobj.setText(m.getString(1));
                edtmobobj.setText(m.getString(2));
                edtaddressobj.setText(m.getString(3));
            } else {
                Toast.makeText(getApplicationContext(), "Invalid studen name", Toast.LENGTH_SHORT).show();
            }
m.close();
        }
    }
}