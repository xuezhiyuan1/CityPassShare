package com.example.think.citypass.activity.xzy;

        import android.graphics.Color;
        import android.graphics.drawable.ColorDrawable;
        import android.view.Gravity;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.webkit.WebChromeClient;
        import android.webkit.WebView;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.PopupWindow;
        import android.widget.ProgressBar;
        import android.widget.TextView;

        import com.example.think.citypass.R;
        import com.example.think.citypass.common.base.BaseActivity;

/**
 * Created by think on 2017/5/27.
 */

public class FindShopWebView extends BaseActivity implements View.OnClickListener {

    private LinearLayout linearLayout_btn;
    private TextView textViewTitle;
    private ImageView imageView;
    private WebView webView;
    private ProgressBar progressBar;
    private ImageView imageViewPop;
    private PopupWindow popupWindow;
    private View view;

    @Override
    protected int layoutId() {
        return R.layout.shequwebview;
    }

    @Override
    protected void initView() {
        view = LayoutInflater.from(this).inflate(R.layout.popuwindows, null);
        imageViewPop = (ImageView) findViewById(R.id.findhouse_more);
        linearLayout_btn = (LinearLayout) findViewById(R.id.findhouse_close);
        textViewTitle = (TextView) findViewById(R.id.text_fount);
        webView = (WebView) findViewById(R.id.webview);
        imageView = (ImageView) findViewById(R.id.findhouse_more);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar_parent);
        loadProgressBar();

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        linearLayout_btn.setOnClickListener(this);
        imageView.setOnClickListener(this);
        imageViewPop.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

        String url = getIntent().getStringExtra("url");
        String title = getIntent().getStringExtra("title");
        webView.getSettings().setJavaScriptEnabled(true);//#andriod_redirect
        webView.loadUrl(url);
        textViewTitle.setText(title);

    }

    private void loadProgressBar() {
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100) {
                    progressBar.setProgress(newProgress);
                    progressBar.setVisibility(View.INVISIBLE);
                } else {
                    progressBar.setProgress(newProgress);
                    progressBar.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.findhouse_close:
                onBackPressed();
                break;

            case R.id.findhouse_more:
                showSelectPhotoPopup();
                break;
        }
    }

    private void showSelectPhotoPopup() {
        popupWindow = new PopupWindow(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setContentView(view);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAtLocation(view, Gravity.RIGHT, 0, 0);
    }

    private void dismiss() {
        if (popupWindow != null && popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
    }

}
