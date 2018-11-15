package com.example.brian.fyp115494258;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

//Referred to the following youtube video:https://www.youtube.com/watch?v=6qo_Opqjhew to allow me to gain an understanding on how to switch between different activities


public class MainActivity extends AppCompatActivity {

   // public Button btnFirebase;

    public DatabaseReference mdatabase;

   // public TextView txtName;

    private EditText txtEmail;
    private ListView muserList;

    private ArrayList<String> mUsernames=new ArrayList<>();
    private ArrayList<String> mKeys=new ArrayList<>();

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

      //  btnFirebase = (Button) findViewById(R.id.btnFirebase);


        //pointing to the root of the database
        mdatabase = FirebaseDatabase.getInstance().getReference();
        muserList= (ListView) findViewById(R.id.user_list);

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mUsernames);

        muserList.setAdapter(arrayAdapter);

        mdatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                String value =dataSnapshot.getValue(String.class);


                mUsernames.add(value);

                String key =dataSnapshot.getKey();
                mKeys.add(key);



                arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                String value =dataSnapshot.getValue(String.class);
                String key =dataSnapshot.getKey();


                int index = mKeys.indexOf(key);

                mUsernames.set(index,value);

                arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


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
