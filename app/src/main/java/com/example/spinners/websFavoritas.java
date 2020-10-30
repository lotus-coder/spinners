package com.example.spinners;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.net.URI;

public class websFavoritas extends AppCompatActivity {

    private ListView listaWebs;
    private Webs [] datos = {new Webs("google","https://www.google.com",R.mipmap.logo_google),
            new Webs("PC Componentes","https://www.pccomponentes.com",R.mipmap.pc_componentes),
            new Webs("PC Gamer", "https://www.pcgamer.com",R.mipmap.pc_gamer)};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webs_favoritas);
        listaWebs = (ListView) findViewById(R.id.lvLista);

        AdaptadorTitulares adaptadorListView = new AdaptadorTitulares(this, datos);
        listaWebs.setAdapter(adaptadorListView);
        eventos();
    }

    class AdaptadorTitulares extends ArrayAdapter <Webs>{
        public AdaptadorTitulares(@NonNull websFavoritas context, Webs [] dat ) {
            super(context, R.layout.listawebs, dat);
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView,@NonNull ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listawebs, null);

            TextView tvURL = (TextView)item.findViewById(R.id.urlWeb);
            tvURL.setText(datos[position].getUrl());

            TextView tvNombre = (TextView)item.findViewById(R.id.nombreWeb);
            tvNombre.setText(datos[position].getNombre());

            ImageView ivRuta = (ImageView) item.findViewById(R.id.imagenWeb);
            ivRuta.setImageResource(datos[position].getImagen());
            return (item);
        }
    }
    private void  eventos(){
        listaWebs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Webs w = (Webs) listaWebs.getItemAtPosition(position);
                Intent intent = new Intent (Intent.ACTION_VIEW, Uri.parse(w.getUrl()));
                startActivity(intent);
            }
        });
    }
}