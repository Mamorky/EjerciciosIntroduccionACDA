package com.example.mamorky.ejerciciost1accesoadatos.Ejercicio4;

import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mamorky.ejerciciost1accesoadatos.R;

public class ResuelveActivity extends AppCompatActivity implements View.OnClickListener{

    EditText edtA;
    EditText edtB;
    EditText edtC;
    Button btnResuelve;
    TextView txvResultado;

    double resultado1;
    double resultado2;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resuelve);

        edtA = (EditText)findViewById(R.id.edtA);
        edtB = (EditText)findViewById(R.id.edtB);
        edtC = (EditText)findViewById(R.id.edtC);
        btnResuelve = (Button)findViewById(R.id.btnResuelve);
        txvResultado = (TextView)findViewById(R.id.txvResultado);

        btnResuelve.setOnClickListener(this);
    }

    public void ResuelveEcuacion(double a,double b,double c){
        resultado1 = (-b+Math.sqrt(Math.pow(b,2)-4*a*c))/(2*a);
        resultado2 = (-b-Math.sqrt(Math.pow(b,2)-4*a*c))/(2*a);
    }

    @Override
    public void onClick(View view) {
        try{
            if(view==btnResuelve){
                ResuelveEcuacion(Double.parseDouble(edtA.getText().toString()),
                        Double.parseDouble(edtB.getText().toString()),
                        Double.parseDouble(edtC.getText().toString()));

                txvResultado.setText("X1 = "+String.format("%.2f",resultado1)+"\r\nX2 = "+String.format("%.2f",resultado2));
            }
        }
        catch (Exception e){
            Toast.makeText(this,"Introduce valores correctos", Toast.LENGTH_SHORT).show();
        }
    }
}
