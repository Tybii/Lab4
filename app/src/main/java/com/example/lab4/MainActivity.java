package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.os.Bundle;
import android.widget.ArrayAdapter;


import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> target;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        target = new ArrayList<>();
        String[] values = new String[]{
                "Pies", "Kot", "Koń", "Gołąb", "Kruk", "Dzik", "Karp", "Osioł", "Chomik", "Mysz",
                "Jeż", "Karaluch"
        };

        target.addAll(Arrays.asList(values));
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, this.target);

        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(this.adapter);







    }
}
