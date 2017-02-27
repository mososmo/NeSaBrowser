package com.example.osm.app;

import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends Activity {


    final Handler handler = new Handler();
    Runnable r;
    TextView txt;
    ImageView imgb;
    int life =2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent =getIntent();
        int num1=intent.getIntExtra("num1",0);
        int num2=intent.getIntExtra("num2",0);
        txt = (TextView)findViewById(R.id.textView7);
       /*  Chronometer chrono = (Chronometer) findViewById(R.id.chronometer);
        ((Chronometer)findViewById(R.id.chronometer2)).setBase(SystemClock.elapsedRealtime());
        ((Chronometer)findViewById(R.id.chronometer2)).start();

*/
        imgb =(ImageView) findViewById(R.id.imageView2);
        imgb.setTranslationY(life);
        imgb.setImageResource(R.drawable.nami2);

        ImageButton imgbutton=(ImageButton)findViewById(R.id.imageButton);
        imgbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl("https://www.google.com/");
        r = new Runnable() {

            Intent intent =getIntent();
            int num1=intent.getIntExtra("num1",0);
            int num2=intent.getIntExtra("num2",0);
            long count = num1+num2<=0?10:num1*3600+num2*60;
            long numm= count<100?life-(100-count)*30:life;

            @Override
            public void run() {
                // UIスレッド
                count--;

                if(count<100){numm-=30;imgb.setTranslationY(numm);}
                if (count < 0) { // 5回実行したら終了
                    return;
                }
                txt.setText(count/3600+":"+(count%3600/60)+":"+(count%3600%60));
                handler.postDelayed(this, 1000);
            }
        };
        handler.post(r);
    }

    // ストップ
    public void onStop( View v ) {
        handler.removeCallbacks(r);
        // ((Chronometer)findViewById(R.id.chronometer2)).stop();
    }
    public void onPause( View v ) {
        handler.removeCallbacks(r);
        // ((Chronometer)findViewById(R.id.chronometer2)).stop();
    }


    public void onDestroy(View v){
        handler.removeCallbacks(r);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}
