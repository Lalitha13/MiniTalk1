package com.example.lalithanjali.minitalk;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Politics1 extends AppCompatActivity {
    private DatabaseReference dref;
    private ListView listview;
    private ArrayList<String> list;
    private FirebaseDatabase database;
    //ArrayAdapter<Info> adapter;
    //Info info2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.politics1);
        Button register = (Button) findViewById(R.id.REGISTER);
        Button login = (Button) findViewById(R.id.LOGIN);

        //info2 = new Info();
        listview = findViewById(R.id.politics1);
        database = FirebaseDatabase.getInstance();
        dref = database.getReference("Politics");
        list = new ArrayList<>();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        listview.setAdapter(adapter);
        dref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String value = dataSnapshot.getValue(String.class);
                list.add(value);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                list.remove(value);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Intent intent = new Intent(Politics1.this,recordpage.class);
                    startActivity(intent);
                }
                if(position == 1){
                    Intent intent = new Intent(Politics1.this,recordpage.class);
                    startActivity(intent);
                }
                if(position == 2){
                    Intent intent = new Intent(Politics1.this,recordpage.class);
                    startActivity(intent);
                }
                if(position == 3){
                    Intent intent = new Intent(Politics1.this,recordpage.class);
                    startActivity(intent);
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //Intent myIntent = new Intent(view.getContext(), Categories.class);
                //startActivity(myIntent);
                Intent myIntent = new Intent(view.getContext(), Register.class);
                startActivity(myIntent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //Intent myIntent = new Intent(view.getContext(), Categories.class);
                //startActivity(myIntent);
                Intent myIntent = new Intent(view.getContext(), Login.class);
                startActivity(myIntent);
            }
        });
    }
}





