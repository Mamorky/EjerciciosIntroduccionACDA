package com.example.mamorky.ejerciciost1accesoadatos.Ejercicio1;

import android.icu.text.DecimalFormat;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mamorky.ejerciciost1accesoadatos.R;

/**
 * @author mamorky
 * @version 1.0
 * */

public class ConversorActivity extends AppCompatActivity implements View.OnClickListener{
    Button convertirBtn;
    RadioButton dolarEuroRd;
    RadioButton euroDolarRd;
    EditText dolarTexto;
    EditText euroTexto;
    EditText cambioEdit;

    double cambio;
    static final double cambioOficial = 0.852784;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor);
        convertirBtn = (Button) findViewById(R.id.convertirBtn);
        dolarEuroRd = (RadioButton) findViewById(R.id.dolarEuroRd);
        euroDolarRd = (RadioButton) findViewById(R.id.eurodolarRd);
        dolarTexto = (EditText) findViewById(R.id.DolaresEdit);
        euroTexto = (EditText) findViewById(R.id.EurosEdit);
        cambioEdit = (EditText)findViewById(R.id.CambioEdit);

        convertirBtn.setOnClickListener(this);
        cambio = cambioOficial;
        cambioEdit.setText(String.valueOf(cambio));
    }

    @Override
    public void onClick(View view) {
        Conversor.TipoCambio tipoCambio;

        if(view == convertirBtn)
        {
            try{
                try{
                    cambio = Double.parseDouble(cambioEdit.getText().toString());
                }catch (Exception e){
                    Toast.makeText(this, "El cambio introducido no es válido.Se establecerá el cambio oficial", Toast.LENGTH_SHORT).show();
                    cambio = cambioOficial;
                    cambioEdit.setText(String.valueOf(cambio));
                }

                if(dolarEuroRd.isChecked())
                {
                    tipoCambio = Conversor.TipoCambio.dolarEuro;
                    Conversor conver = new Conversor(Double.parseDouble(dolarTexto.getText().toString()),tipoCambio,cambio);
                    euroTexto.setText(String.valueOf(conver.getEuros()));
                }

                if(euroDolarRd.isChecked())
                {
                    tipoCambio = Conversor.TipoCambio.euroDolar;
                    Conversor conver = new Conversor(Double.parseDouble(euroTexto.getText().toString()),tipoCambio,cambio);
                    dolarTexto.setText(String.valueOf(conver.getDolares()));
                }}catch (Exception e){};
        }
    }
}