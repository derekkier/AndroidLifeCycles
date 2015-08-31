package com.derekkier.androidlifecycles;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
//import android.widget.ScrollView;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout RL = (RelativeLayout)findViewById(R.id.RL);
//        TextView tvOut = new TextView(this);
//        tvOut.setText("TV Out Text.");
//        RL.addView(tvOut);
        Random rnd = new Random();
        int prevTextViewId = 0;
        for(int i = 0; i < 10; i++)
        {
            final TextView textView = new TextView(this);
            textView.setTextColor(rnd.nextInt() | 0xff000000);

            int curTextViewId = prevTextViewId + 1;
            textView.setId(curTextViewId);
            textView.setText("Text " + curTextViewId);
            final RelativeLayout.LayoutParams params =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                                                RelativeLayout.LayoutParams.WRAP_CONTENT);

            params.addRule(RelativeLayout.BELOW, prevTextViewId);
            textView.setLayoutParams(params);

            prevTextViewId = curTextViewId;
            RL.addView(textView, params);
        }
        final RelativeLayout.LayoutParams params =
        new RelativeLayout.LayoutParams
        (
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        WebView webView = new WebView(this);
        webView.setId(11);
        params.addRule(RelativeLayout.BELOW, 10);
        webView.loadUrl("http://google.com");
        RL.addView(webView, params);
        /*
            final RelativeLayout.LayoutParams params =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT,
                                                RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.BELOW, prevTextViewId);
        TextView.setLayoutParams(params);
        TextView tvOut = new TextView(this);
        tvOut.setText("TV Out Text.");
        RL.addView(tvOut);
        //public RelativeLayout = (R.layout.activity_main.RL);
        //TextView tvOut = new TextView();
        appendTextView("\nAppend the text.");
        */
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

    @Override
    protected void onStart()
    {
        super.onStart();
        displayLifeCycleChange("onStart");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        displayLifeCycleChange("onPause");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        displayLifeCycleChange("onResume");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        displayLifeCycleChange("onStop");
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        displayLifeCycleChange("onRestart");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        displayLifeCycleChange("onDestroy");
    }

    private void displayLifeCycleChange(String cycle)
    {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat  = new SimpleDateFormat("MM/dd/y h:mm:ss a");
        String dateToStr = dateFormat.format(currentDate);

        appendTextView("\n"+cycle+" called at: "+dateToStr+".","10");
    }

    public void appendTextView(String str, String passedID)
    {
        //final TextView TextView
        int resID = getResources().getIdentifier(passedID, "id", getPackageName());
        //TextView thisTextView = (TextView)findViewById( R.id.passedID);
        TextView thisTextView = (TextView)findViewById(resID);
        //thisTextView.setText(str);
        thisTextView.append(str);
    }
}
