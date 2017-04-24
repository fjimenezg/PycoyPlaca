package com.example.frank.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ConfigActivity extends AppCompatActivity {

    private Spinner spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        spinner1 = (Spinner) findViewById(R.id.spinner);
        String []opciones={"0 - 1","2 - 3","4 - 5","6 - 7","8 - 9"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.spinner_item, opciones);
        spinner1.setAdapter(adapter);

        SharedPreferences prefe=getSharedPreferences("datos", Context.MODE_PRIVATE);
        int i=prefe.getInt("placa_pos",0);


       spinner1.setSelection(i);

       spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View selectedItemView, int pos, long id) {
                SharedPreferences preferencias=getSharedPreferences("datos", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=preferencias.edit();
                editor.putString("placa", parent.getItemAtPosition(pos).toString());
                editor.putInt("placa_pos", pos);
                editor.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }

    public void reg(View v) {
        finish();
    }
}
