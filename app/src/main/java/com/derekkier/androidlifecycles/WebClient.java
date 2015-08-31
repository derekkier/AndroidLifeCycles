package com.derekkier.androidlifecycles;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Toshiba on 8/31/2015.
 */
public class WebClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }

    @Override
    public void onPageFinished(WebView view, String url)
    {
        // Obvious next step is: document.forms[0].submit()
        view.loadUrl("javascript:document.forms[0].q.value='[android]'");
    }
}
