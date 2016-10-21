package com.pdm.p_17_intent_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        WebView webView=(WebView)findViewById(R.id.webView);
        Bundle bundle = getIntent().getExtras();
        webView.loadUrl("http://" + bundle.getString("url"));
    }
}
