package com.akash.aisecurity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class LiveCameraActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_camera);

        webView = findViewById(R.id.webView);

        WebSettings settings = webView.getSettings();

        settings.setJavaScriptEnabled(true);

        // Make the whole page fit on the phone
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);

        // Enable zoom
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);

        // Prevent opening browser
        webView.setWebViewClient(new WebViewClient());

        // Start zoomed out
        webView.setInitialScale(40);

        webView.loadUrl("http://192.168.1.7:5000/live");
    }
}