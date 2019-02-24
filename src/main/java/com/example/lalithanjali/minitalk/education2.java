package com.example.lalithanjali.minitalk;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class education2 extends AppCompatActivity {

    DatabaseReference dref;
    ListView listview;
    ArrayList<String> list;
    FirebaseDatabase database;
    ArrayAdapter<String> adapter;
    Edu edu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education2);
        edu = new Edu();
        listview=(ListView)findViewById(R.id.layout);
        database= FirebaseDatabase.getInstance();
        dref = database.getReference("Categories");
        list = new ArrayList<>();
        adapter=new ArrayAdapter<String>(this,R.layout.info,R.id.info1,list);
        listview.setAdapter(adapter);
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    edu = ds.getValue(Edu.class);
                    list.add(edu.getS1().toString());
                    list.add(edu.getS2().toString());
                    list.add(edu.getS3().toString());
                    list.add(edu.getS4().toString());
                }
                listview.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
