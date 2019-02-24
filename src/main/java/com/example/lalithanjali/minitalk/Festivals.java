package com.example.lalithanjali.minitalk;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Festivals extends AppCompatActivity {
    ListView listView;
    String[] listValue = new String[]
            {
                    "Pongal",
                    "Ugadi",
                    "Diwali",
                    "Dussehra"
            };
    List<String> LISTSTRING;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.festivals);
        listView = (ListView) findViewById(R.id.festivals);
        LISTSTRING = new ArrayList<String>(Arrays.asList(listValue));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_2, android.R.id.text1, LISTSTRING){

            @Override
            public View getView(int position, View convertView, ViewGroup parent){

                View view = super.getView(position, convertView, parent);

                TextView ListItemShow = (TextView) view.findViewById(android.R.id.text1);

                ListItemShow.setTextColor(Color.parseColor("#FFF7FAF1"));

                return view;
            }

        };

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //String cities = String.valueOf(parent.getItemAtPosition(position));
                        //Toast.makeText(Cities.this, cities, Toast.LENGTH_LONG).show();
                        if ( position >= 0 ) {
                            Intent myIntent = new Intent(view.getContext(),mainPage.class);
                            startActivityForResult(myIntent,0);
                        }
                    }


                });

    }
}
