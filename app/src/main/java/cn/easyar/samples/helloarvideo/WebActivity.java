package cn.easyar.samples.helloarvideo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        webView=(WebView) findViewById(R.id.web_view);
        webView.getSettings().getJavaScriptEnabled();
        webView.setWebViewClient(new WebViewClient());
        Intent intent=getIntent();
        String url=intent.getStringExtra("url");
        webView.loadUrl(url);
    }
}
