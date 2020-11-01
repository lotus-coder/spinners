package com.example.spinners;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;

public class WebsFavoritas2 extends AppCompatActivity {

    private ImageView imagen;
    private TextView datosPais;
    private Spinner spnrPaises;
    private String [] websNombres = {"google","PC Componentes","PC Gamer",};
    private Webs [] datos = {new Webs("google","https://www.google.com",R.drawable.logo_google_background),
            new Webs("PC Componentes","https://www.pccomponentes.com",R.drawable.pc_componentes_background),
            new Webs("PC Gamer", "https://www.pcgamer.com",R.mipmap.pc_gamer)};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webs_favoritas2);

        spnrPaises = (Spinner) findViewById(R.id.websNombres);

        datosPais = (TextView) findViewById(R.id.textView);

        imagen = (ImageView) findViewById(R.id.imagenWeb2);

        ArrayAdapter<Webs> adaptador = new ArrayAdapter<Webs>(this,android.R.layout.simple_spinner_item, datos);

        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spnrPaises.setAdapter(adaptador);
        eventos();
    }


    private void eventos(){
        spnrPaises.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Webs pais = (Webs) spnrPaises.getItemAtPosition(position);
                datosPais.setText(pais.getNombre());
                imagen.setImageDrawable(getResources().getDrawable(pais.getImagen(), getApplicationContext().getTheme()));;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){
                datosPais.setText("No se ha realizado ninguna selección");
            }
        });

        datosPais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Webs w = (Webs) spnrPaises.getSelectedItem();
                Intent intent = new Intent (Intent.ACTION_VIEW, Uri.parse(w.getUrl()));
                startActivity(intent);
            }
        });
    }

}