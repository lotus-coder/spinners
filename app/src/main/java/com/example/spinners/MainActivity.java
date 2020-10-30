package com.example.spinners;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button Ejer1,Ejer2,Ejer3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Ejer1 = (Button) findViewById(R.id.button);
        Ejer2 = (Button) findViewById(R.id.button2);
        Ejer3 = (Button) findViewById(R.id.button3);
        eventos();
    }




    private void eventos(){
        Ejer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Paises.class);
                startActivity(i);
            }
        });
        Ejer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,websFavoritas.class);
                startActivity(i);
            }
        });
        Ejer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,WebsFavoritas2.class);
                startActivity(i);
            }
        });
    }
}