package com.ademkayaaslan.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    Spinner spinner3;
    Spinner spinner4;
    int spinner3Position;
    int spinner4Position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText4);
        textView = findViewById(R.id.textView2);
        spinner3 = findViewById(R.id.spinner3);
        spinner4 = findViewById(R.id.spinner4);
        String[] items = new String[]{"Celsius", "Fahrenheit", "Kelvin"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinner3.setAdapter(adapter);
        spinner4.setAdapter(adapter);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinner3Position = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MainActivity.this, "nothing selected on first list", Toast.LENGTH_SHORT).show();
            }
        });
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinner4Position = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MainActivity.this, "nothing selected on second list", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void convert (View view) {
        if (editText.getText().toString().matches("")) {
            Toast.makeText(this, "Enter a number", Toast.LENGTH_SHORT).show();
        } else {

        if (spinner3Position == 0 && spinner4Position == 1) {
            int c = Integer.parseInt(editText.getText().toString());
            int f = c * (9 / 5) + 32;
            textView.setText("Result:" + f);

        } else if (spinner3Position == 0 && spinner4Position == 2) {
            int c = Integer.parseInt(editText.getText().toString());
            int k = c - 273;
            textView.setText("Result:" + k);

        } else if (spinner3Position == 1 && spinner4Position == 0) {
            int f = Integer.parseInt(editText.getText().toString());
            int c = (5 / 9) * (f - 32);
            textView.setText("Result:" + c);

        } else if (spinner3Position == 1 && spinner4Position == 2) {
            int f = Integer.parseInt(editText.getText().toString());
            int k = (5/9)*(f - 32) + 273;
            textView.setText("Result:" + k);

        } else if (spinner3Position == 2 && spinner4Position == 0) {
            int k = Integer.parseInt(editText.getText().toString());
            int c = k - 273;
            textView.setText("Result:" + c);
        } else if (spinner3Position == 2 && spinner4Position == 1) {
            int k = Integer.parseInt(editText.getText().toString());
            int f = (9 / 5) * (k - 273) + 32;
            textView.setText("Result:" + f);
        } else {
            Toast.makeText(this, "Selected units are same", Toast.LENGTH_SHORT).show();
        }
    }
        

    }
}
