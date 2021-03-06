package com.example.think.citypass.activity.xzy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import com.example.think.citypass.R;

/**
 * Created by 宋家任 on 2016/4/29 16:41.
 * 扫一扫的扫描结果
 */

public class Sao1SaoResultActivity extends Activity {
    private EditText etSao1SaoResult;
    private Button btnBack;
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sao1sao_result);
        etSao1SaoResult = (EditText) findViewById(R.id.et_sao1sao_result);
        btnBack = (Button) findViewById(R.id.btn_back);
        webView = (WebView) findViewById(R.id.webview_erweima);
        String result = getIntent().getStringExtra("result");
        etSao1SaoResult.setText(result);
        String url = etSao1SaoResult.getText().toString();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sao1SaoResultActivity.this.finish();
            }
        });
    }

}
