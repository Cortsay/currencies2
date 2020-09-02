package com.example.currencies;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    EditText EditText1;
    EditText EditText2;
    Boolean modif = false;
    double EH = 32.3761;
    double HE = 0.0309006;
    double ER = 87.5685;
    double RE = 0.01142;
    double ED = 1.19295;
    double DE = 0.838261;
    double EuroMonnaieLocale=0;
    double MonnaieLocaleEuro=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText1 = findViewById(R.id.EditText1);
        EditText2 = findViewById(R.id.EditText2);
        EditText1.addTextChangedListener(TW1);
        EditText2.addTextChangedListener(TW2);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        List exempleList = new ArrayList();
        exempleList.add("Hryvnia");
        exempleList.add("Rouble ");
        exempleList.add("Dollar");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, exempleList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        EuroMonnaieLocale=EH;
                        MonnaieLocaleEuro=HE;
                        break;
                    case 1:
                        EuroMonnaieLocale=ER;
                        MonnaieLocaleEuro=RE;
                        break;
                    case 2:
                        EuroMonnaieLocale=ED;
                        MonnaieLocaleEuro=DE;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    private TextWatcher TW1 = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (modif == false) {
                String v = EditText1.getText().toString();
                double value;
                if (v.equals("")) {
                    value = 0;
                } else {
                    value = Double.parseDouble(v);
                }
                value *= EuroMonnaieLocale;

                String valeur = String.valueOf(value);
                modif = true;
                EditText2.setText(valeur);
                modif = false;
            }
        }
        @Override
        public void afterTextChanged(Editable s) {
        }
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
    };

    private TextWatcher TW2 = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (modif == false) {
                String v = EditText2.getText().toString();
                double value;
                if (v.equals("")) {
                    value = 0;
                } else {
                    value = Double.parseDouble(v);
                }
                value *= MonnaieLocaleEuro;
                String valeur = String.valueOf(value);
                modif = true;
                EditText1.setText(valeur);
                modif = false;
            }
        }
        @Override
        public void afterTextChanged(Editable s) {
        }
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
    };



}