package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DodajWpis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_wpis);
    }

    public void wyslij(View view) {
        EditText editText = (EditText) findViewById(R.id.editText);
        Intent intention = new Intent();
        intention.putExtra("wpis", editText.getText().toString());
        setResult(RESULT_OK, intention);
        finish();
    }


}
