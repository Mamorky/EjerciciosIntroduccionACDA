package com.example.mamorky.ejerciciost1accesoadatos.Ejercicio2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mamorky.ejerciciost1accesoadatos.R;

public class URLActivity extends AppCompatActivity implements View.OnClickListener {

    EditText url;
    Button navegar;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url);

        url = (EditText)findViewById(R.id.edtURL);
        navegar = (Button)findViewById(R.id.btnNavegar);
        navegar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == navegar){
            intent = new Intent(this,WebViewActivity.class);
            intent = intent.putExtra("url",url.getText().toString());

            if(URLUtil.isValidUrl(url.getText().toString())){
                startActivity(intent);
            }
            else{
                Toast.makeText(this,"URL no válida",Toast.LENGTH_SHORT).show();
            }
        }
    }


}
