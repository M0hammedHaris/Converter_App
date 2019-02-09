package com.mohammedharis2032.converter_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton img,img1,img2,img3,img4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=(ImageButton)findViewById(R.id.imageButton5);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(MainActivity.this,BMI.class);
                startActivity(i);
            }
        });
        img1=(ImageButton)findViewById(R.id.imageButton4);
        img1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent j =new Intent(MainActivity.this,Temperature.class);
                startActivity(j);
            }
        });

        img2=(ImageButton)findViewById(R.id.imageButton3);
        img2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent k =new Intent(MainActivity.this,Weight.class);
                startActivity(k);
            }
        });
        img3=(ImageButton)findViewById(R.id.imageButton2);
        img3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent l =new Intent(MainActivity.this,Volume.class);
                startActivity(l);
            }
        });
        img4=(ImageButton)findViewById(R.id.imageButton);
        img4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent m =new Intent(MainActivity.this,Unit.class);
                startActivity(m);
            }
        });
    }
}
