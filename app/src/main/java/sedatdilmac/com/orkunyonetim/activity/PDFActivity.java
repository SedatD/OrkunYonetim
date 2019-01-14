package sedatdilmac.com.orkunyonetim.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.widget.Toast;

import sedatdilmac.com.orkunyonetim.R;

public class PDFActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        WebView webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String url = bundle.getString("url");
            //webView.loadUrl(url);
            //webView.loadUrl("docs.google.com/viewer?" + url);
            webView.loadUrl("https://docs.google.com/gview?embedded=true&url=" + url);
            Log.wtf("TAG", "loaded");
        } else {
            Toast.makeText(PDFActivity.this, "Bir hata oluştu", Toast.LENGTH_LONG).show();
            finish();
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}
