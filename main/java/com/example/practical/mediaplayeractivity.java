package com.example.practical;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mediaplayeractivity extends AppCompatActivity {
MediaPlayer mp;
Button start,pause,stop;
int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mediaplayeractivity);
        start=findViewById(R.id.btnstart);
        pause=findViewById(R.id.btnpause);
        stop=findViewById(R.id.btnstop);
        mp=MediaPlayer.create(getApplicationContext(),R.raw.song);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.pause();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.stop();
if(counter%2==1)
{
    mp=MediaPlayer.create(getApplicationContext(),R.raw.song);
}
else
{
    mp=MediaPlayer.create(getApplicationContext(),R.raw.song2);
}
            }
        });
    }
}