package com.example.mamorky.ejerciciost1accesoadatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnEj1;
    Button btnEj2;
    Button btnEj3;
    Button btnEj4;

    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnEj1 = (Button)findViewById(R.id.btnEj1);
        btnEj2 = (Button)findViewById(R.id.btnEj2);
        btnEj3 = (Button)findViewById(R.id.btnEj3);
        btnEj4 = (Button)findViewById(R.id.btnEj4);

        btnEj1.setOnClickListener(this);
        btnEj2.setOnClickListener(this);
        btnEj3.setOnClickListener(this);
        btnEj4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view==btnEj1){
            i = new Intent(this,com.example.mamorky.ejerciciost1accesoadatos.Ejercicio1.ConversorActivity.class);
            startActivity(i);
        }
        if(view==btnEj2){
            i = new Intent(this,com.example.mamorky.ejerciciost1accesoadatos.Ejercicio2.URLActivity.class);
            startActivity(i);
        }
        if(view==btnEj3){
            i = new Intent(this,com.example.mamorky.ejerciciost1accesoadatos.Ejercicio3.ContadorCafesActivity.class);
            startActivity(i);
        }
        if(view==btnEj4){
            i = new Intent(this,com.example.mamorky.ejerciciost1accesoadatos.Ejercicio4.ResuelveActivity.class);
            startActivity(i);
        }
    }
}
