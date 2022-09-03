package com.example.practical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class flash1 extends AppCompatActivity {
Button btntorchobj;
CameraManager cm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash1);
        btntorchobj=findViewById(R.id.btntorch);
        cm=(CameraManager) getSystemService(Context.CAMERA_SERVICE);
        btntorchobj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String camid=null;
                boolean flag;
                flag=true;
              /*  camid=cm.getCameraIdList()[0];
                try {
                    if(flag==true)
                    {

                    }
                }
                catch (CameraAccessException e)
                {
                    e.printStackTrace();
                }*/
            }
        });
    }
}