package com.derekkier.androidlifecycles;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout layout = (RelativeLayout)findViewById(R.id.layout);
        final RelativeLayout.LayoutParams params =
        new RelativeLayout.LayoutParams
        (
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        WebView webView = new WebView(this);
        //params.addRule(RelativeLayout.BELOW, 10);
        layout.addView(webView);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                //Show the actual html in this section, I'm not sure if it is generated or not.
                view.loadUrl("javascript:(function() { document.getElementsByTagName('body')[0].innerHTML='test'; }();");
                /*
                view.loadUrl("javascript:(function() { " +
                        "document.getElementsByClassName('z-navbar-wrapper')[0].style.backgroundColor='red';" +
                        "document.getElementsByTagName('body')[0].style.color = 'red'; " +
                        "})()");
                */
            }
        });
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //webView.loadUrl("http://php.vectorflash.biz");
        webView.loadUrl("http://globalapp.zuppler.com/show.html?channel=skinnyfats&permalink=skinnyfats2");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
