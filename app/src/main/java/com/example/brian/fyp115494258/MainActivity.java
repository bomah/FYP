package com.example.brian.fyp115494258;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

//Referred to the following youtube video:https://www.youtube.com/watch?v=6qo_Opqjhew to allow me to gain an understanding on how to switch between different activities


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public Button btnMenu;

    public void init() {
        btnMenu = (Button) findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent1 = new Intent(MainActivity.this, MenuList.class);

                startActivity(intent1);
            }
        });



    }
}
