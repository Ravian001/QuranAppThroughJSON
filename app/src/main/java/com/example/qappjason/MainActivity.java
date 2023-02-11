package com.example.qappjason;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnParah, btnSurah;
    Intent intt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnParah= findViewById(R.id.open_by_volume_name_button);
        btnSurah= findViewById(R.id.open_by_poem_name_button);

        btnParah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intt= new Intent(MainActivity.this, OpenByVolumeActivity.class);
                startActivity(intt);


            }
        });


        btnSurah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intt= new Intent(MainActivity.this, OpenByPoemActivity.class);
                startActivity(intt);

            }
        });



    }
}