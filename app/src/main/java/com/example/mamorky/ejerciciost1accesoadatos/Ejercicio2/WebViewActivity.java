package com.example.mamorky.ejerciciost1accesoadatos.Ejercicio2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.mamorky.ejerciciost1accesoadatos.R;

public class WebViewActivity extends AppCompatActivity {

    Intent intent;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        intent = this.getIntent();
        String direccion = intent.getStringExtra("url");
        WebView webView = (WebView)findViewById(R.id.webView);

        //Habilita javascript
        webView.getSettings().setJavaScriptEnabled(true);

        //Para añadir el ZOOM
        webView.getSettings().setBuiltInZoomControls(true);

        webView.loadUrl(direccion);

            //Método necesario para que no se habra con el navegador externo
            webView.setWebViewClient(new WebViewClient()
            {
                // evita que los enlaces se abran fuera nuestra app en el navegador de android
                @Override
                public boolean shouldOverrideUrlLoading(WebView view,String url)
                {
                    return false;
                }
            });
        }
}


