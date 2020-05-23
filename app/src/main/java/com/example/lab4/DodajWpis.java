package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class DodajWpis extends AppCompatActivity {
    private ArrayAdapter gatunki;
    private int modyfi_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_wpis);
        gatunki = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, new String[] {"SSak", "Gad", "Ptak"});
        Spinner spinner = findViewById(R.id.gatunekSpinner);
        spinner.setAdapter(gatunki);

        Bundle extras = getIntent().getExtras();
        try {
            if (extras.getSerializable("element") != null) {
                Animal animal = (Animal) extras.getSerializable("element");

                ((EditText) findViewById(R.id.kolorText)).setText(animal.getKolor());
                ((EditText) findViewById(R.id.opisText)).setText(animal.getOpis());
                ((EditText) findViewById(R.id.wielkoscText)).setText(Float.toString(animal.getWielkosc()));
                this.modyfi_id = animal.get_id();
            }
        } catch (Exception ex) {
            this.modyfi_id = 0;}


    }

    public void wyslij(View view) {
        Animal zwierze = new Animal(
                ((Spinner) findViewById(R.id.gatunekSpinner)).getSelectedItem().toString(),
                ((EditText) findViewById(R.id.kolorText)).getText().toString(),
                Float.parseFloat(((EditText) findViewById(R.id.wielkoscText)).getText().toString()),
                ((EditText) findViewById(R.id.opisText)).getText().toString()
        );
        zwierze.set_id(this.modyfi_id);

        Intent intention = new Intent();
        intention.putExtra("nowy", zwierze);
        setResult(RESULT_OK, intention);
        finish();
    }


}
