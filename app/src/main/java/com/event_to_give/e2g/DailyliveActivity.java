package com.event_to_give.e2g;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Louis on 19/11/2016.
 * <p>
 * e2g
 */

public class DailyliveActivity extends Activity
{

    private DMWebVideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_daily);

        WebView mChatView;
        final String STREAM_ID = "x4q5kra_fr-programmation-culturelle-hebdomadaire-streamteame2g_videogames";
        final String CHAT_URL = "http://live-chat.dmcdn.net/#event2give/x4q5kra";

        mVideoView = (DMWebVideoView) findViewById(R.id.dmWebVideoView);
        mChatView = (WebView) findViewById(R.id.chatView);
        mVideoView.setVideoId(STREAM_ID);
        mVideoView.setAutoPlay(true);
        mVideoView.load();

        mVideoView.setEventListener(new DMWebVideoView.Listener()
        {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onEvent(String event)
            {
                switch (event)
                {
                    case "fullscreenchange":
                        if(mVideoView.fullscreen)
                        {
                            hideNavigationBar();
                        }
                        break;
                }
            }
        });

        mChatView.getSettings().setJavaScriptEnabled(true);
        mChatView.loadUrl(CHAT_URL);

        mChatView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        mVideoView.handleBackPress(this);
    }

    @Override
    protected void onPause()
    {
        super.onPause();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
        {
            mVideoView.onPause();
        }
    }


    @Override
    protected void onResume()
    {
        super.onResume();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
        {
            mVideoView.onResume();
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void hideNavigationBar()
    {
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

}
