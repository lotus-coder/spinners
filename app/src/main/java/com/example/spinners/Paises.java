package com.example.spinners;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;

public class Paises extends AppCompatActivity {

    private TextView datosPais;
    private Spinner spnrPaises;
    private String [] listaPaises = {"Nicaragua","El Salvador","Chile","Urugay",
            "Bolivia","Argentina","Peru","Cuba","Venezuela","Colombia","Brasil"};
    private HashMap<String,String> datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paises);

        spnrPaises = (Spinner) findViewById(R.id.listaPaises);

        datosPais = (TextView) findViewById(R.id.datoPais);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, listaPaises);

        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spnrPaises.setAdapter(adaptador);
        llenarMapa();
        eventos();
    }


    private void eventos(){
        spnrPaises.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String pais = spnrPaises.getItemAtPosition(position).toString();
                datosPais.setText(pais+" tiene "+datos.get(pais)+" habitantes");
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){
                datosPais.setText("No se ha realizado ninguna selección");
            }
        });
    }
    private void llenarMapa(){
        datos = new HashMap<String, String>();
        datos.put("Nicaragua","6 494 000");
        datos.put("Bolivia","11 390 000");
        datos.put("Argentina","44 723 000");
        datos.put("Urugay","3 512 000");
        datos.put("Chile","18 880 000");
        datos.put("El Salvador","6 675 000");
        datos.put("Venezuela"," 32 030 000");
        datos.put("Colombia","49 737 000");
        datos.put("Brasil","210 461 000");
        datos.put("Peru","32 362 000");
        datos.put("Cuba","11 212 000");
    }
}