package com.example.mamorky.ejerciciost1accesoadatos.Ejercicio3;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mamorky.ejerciciost1accesoadatos.R;

public class ContadorCafesActivity extends AppCompatActivity implements View.OnClickListener{

    static final long SEGCAMBIA = 1000;

    //Inicializamos el contador a 5 min
    long milsegundosTotal = 5*60*1000;
    long segundos = 0;
    long minutos = 0;
    int numCafes = 0;

    //Unidad de segundo en expresión de milisegundos
    static final int segMil = 1000;

    Button btnComenzar;
    Button btnRestablecer;
    Button btnMas;
    Button btnMenos;
    TextView txvTiempo;
    TextView txvNumCafes;

    String texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador_cafes);

        btnComenzar = (Button)findViewById(R.id.btnComenzar);
        btnRestablecer = (Button)findViewById(R.id.btnRestablecer);
        btnMas = (Button)findViewById(R.id.btnMas);
        btnMenos = (Button)findViewById(R.id.btnMenos);
        txvTiempo = (TextView)findViewById(R.id.txvTiempo);
        txvNumCafes = (TextView)findViewById(R.id.txvNumCafes);

        //Habilitar o deshabilitar botones de inicio
        btnComenzar.setEnabled(true);
        btnMas.setEnabled(true);
        btnMenos.setEnabled(true);
        btnRestablecer.setEnabled(false);

        //Apuntarse a el evento on click
        btnComenzar.setOnClickListener(this);
        btnMas.setOnClickListener(this);
        btnMenos.setOnClickListener(this);
        btnRestablecer.setOnClickListener(this);
        txvNumCafes.setText(String.valueOf(numCafes));

        pasaDeMilAMinAndSeg(milsegundosTotal);
        escribeSegundos();
        txvTiempo.setText(texto);
    }

    public void pasaDeMilAMinAndSeg(long milisegundosRestante){
        segundos =((milisegundosRestante/segMil)%60);
        minutos =((milisegundosRestante/segMil)/60);
    }

    public void escribeSegundos(){
        if(minutos < 10 && segundos < 10)
            texto = "0"+String.valueOf(minutos)+":0"+String.valueOf(segundos);
        else if(segundos < 10)
            texto = String.valueOf(minutos)+":0"+String.valueOf(segundos);
        else if(minutos < 10)
            texto = "0"+String.valueOf(minutos)+":"+String.valueOf(segundos);
        else
            texto = String.valueOf(minutos)+":"+String.valueOf(segundos);
    }

    public void cambiaEstadoBtn(){
        btnComenzar.setEnabled(!btnComenzar.isEnabled());
        btnMas.setEnabled(!btnMas.isEnabled());
        btnMenos.setEnabled(!btnMenos.isEnabled());
    }

    @Override
    public void onClick(View view) {
        if(view==btnComenzar){
            cambiaEstadoBtn();
            MyCountDownTimer contador = new MyCountDownTimer(milsegundosTotal,10);
            contador.start();
        }
        if(view==btnRestablecer){
            pasaDeMilAMinAndSeg(milsegundosTotal);
            escribeSegundos();
            txvTiempo.setText(texto);
            cambiaEstadoBtn();
            btnRestablecer.setEnabled(!btnRestablecer.isEnabled());
            if(numCafes == 10){
                numCafes = 0;
                txvNumCafes.setText(String.valueOf(numCafes));
            }
        }
        if(view == btnMenos){
            if(segundos == 0 && minutos == 0)
                return;
            milsegundosTotal = milsegundosTotal - SEGCAMBIA;
            pasaDeMilAMinAndSeg(milsegundosTotal);
            escribeSegundos();
            txvTiempo.setText(texto);
        }
        if(view==btnMas){
            if(minutos == 60)
                return;
            milsegundosTotal = milsegundosTotal + SEGCAMBIA;
            pasaDeMilAMinAndSeg(milsegundosTotal);
            escribeSegundos();
            txvTiempo.setText(texto);
        }

    }

    public void notificacionCafe(){
        MediaPlayer mp = MediaPlayer.create(this, R.raw.mesuenas);
        mp.start();
    }


    public class MyCountDownTimer extends CountDownTimer
    {
        public MyCountDownTimer(long startTime, long interval) {
            super(startTime, interval);
        }
        @Override
        public void onTick (long millisUntilFinished) {
            pasaDeMilAMinAndSeg(millisUntilFinished+segMil);
            escribeSegundos();
            txvTiempo.setText(texto);
        }
        @Override
        public void onFinish() {
            txvTiempo.setText("00:00");
            btnRestablecer.setEnabled(!btnRestablecer.isEnabled());
            numCafes++;
            if(numCafes < 10){
                txvNumCafes.setText(String.valueOf(numCafes));
                Toast.makeText(getApplicationContext(),"Café servido",Toast.LENGTH_SHORT).show();
                notificacionCafe();
            }
            else{
                txvNumCafes.setText(String.valueOf(numCafes));
                AlertDialog.Builder popup=new AlertDialog.Builder(ContadorCafesActivity.this);
                notificacionCafe();
                popup.setTitle("Estado de alteración!!!!!");
                popup.setMessage("Ya te has tomado diez cafés y se te ve alterado. El contador se pondrá a cero al resetear");
                popup.setPositiveButton("Ok", null);
                popup.show();
            }
        }
    }
}
