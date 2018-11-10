package com.example.brian.fyp115494258;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.Arrays;
import java.util.List;

//Created the following class by following the steps in this youtube video: youtube video:https://www.youtube.com/watch?v=9ZCK5BOU6wk&index=29&list=PLshdtb5UWjSrOJfpFOE-u55s3SnY2EO9v


public class MenuList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<String> list;
    private RecyclerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);
        recyclerView = findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        list = Arrays.asList(getResources().getStringArray(R.array.menu_items));
        adapter = new RecyclerAdapter(list);


        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(adapter);

        init();


    }

    public Button btnReturn;

    public void init() {
        btnReturn = (Button) findViewById(R.id.btnReturn);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent2 = new Intent(MenuList.this,MainActivity.class);

                startActivity(intent2);
            }
        });

    }
}

