package com.example.spinners;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;

public class WebsFavoritas2 extends AppCompatActivity {
    private TextView datosPais;
    private Spinner spnrPaises;
    private String [] websNombres = {"google","PC Componentes","PC Gamer",};
    private Webs [] datos = {new Webs("google","https://www.google.com",R.mipmap.logo_google),
            new Webs("PC Componentes","https://www.pccomponentes.com",R.mipmap.pc_componentes),
            new Webs("PC Gamer", "https://www.pcgamer.com",R.mipmap.pc_gamer)};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webs_favoritas2);

        spnrPaises = (Spinner) findViewById(R.id.websNombres);

        datosPais = (TextView) findViewById(R.id.datoPais);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, websNombres);

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
                datosPais.setText(pais+" tiene  habitantes");
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){
                datosPais.setText("No se ha realizado ninguna selección");
            }
        });
    }
    private void llenarMapa(){

    }
}