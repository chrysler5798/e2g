package com.event_to_give.e2g;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity
{

    WebView firstWeb;
    LiveClass LiveC;
    TextView textWebTV;
    RelativeLayout liveLayout;
    SwipeRefreshLayout mySwipeRefresh;
    Intent intentLive;

    final String WEBSITE_URL = "http://www.event-to-give.com/";
    final String FACEBOOK_URL = "https://www.facebook.com/assoc.eventtogive";
    final String TWITTER_URL = "https://twitter.com/Event2Give";

    final String ASSOC_URL = "http://www.event-to-give.com/?page_id=8";
    final String EVENT_URL = "http://www.event-to-give.com/?page_id=80";
    final String PART_URL = "http://www.event-to-give.com/?page_id=86";
    final String CLUB_URL = "http://www.event-to-give.com/?page_id=2192";
    final String SERVICE_URL = "http://www.event-to-give.com/?page_id=76";
    final String EQUIPE_URL = "http://www.event-to-give.com/?page_id=364";
    final String PROG_URL = "http://www.event-to-give.com/?page_id=2356";
    final String GALERIE_URL = "http://www.event-to-give.com/?page_id=88";
    final String CONTACT_URL = "http://www.event-to-give.com/?page_id=114";

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView mDrawerList;
        String[] mMenuTitles;
        ImageView logoLive;
        ImageView logoClique;
        Toolbar myToolbar;

        LiveC = new LiveClass();

        textWebTV = (TextView) findViewById(R.id.textViewWebTV);
        liveLayout = (RelativeLayout) findViewById(R.id.LiveLayout);
        logoLive = (ImageView) findViewById(R.id.logoLive);
        logoClique = (ImageView) findViewById(R.id.logoDailymotion);
        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        firstWeb = (WebView) findViewById(R.id.webView1);
        mySwipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);

        setSupportActionBar(myToolbar);

        myToolbar.setTitle(R.string.e2g_fullname);
        myToolbar.setNavigationIcon(R.drawable.ic_list_black_24dp);
        setSupportActionBar(myToolbar);

        mMenuTitles = getResources().getStringArray(R.array.menu_arrays);
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        mDrawerList.setAdapter(new ArrayAdapter<>(this, R.layout.drawer_list_item, mMenuTitles));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        firstWeb.getSettings().setJavaScriptEnabled(true);

        firstWeb.setWebViewClient(new WebViewClient()
        {
            @Override
            public void onPageCommitVisible(WebView view, String url) {
                firstWeb.setVisibility(View.VISIBLE);
                removeElementsJS(firstWeb);
                mySwipeRefresh.setRefreshing(false);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                firstWeb.setVisibility(View.GONE);
                findViewById(R.id.loadingPanel).setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                removeElementsJS(firstWeb);
                findViewById(R.id.loadingPanel).setVisibility(View.GONE);
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl)
            {
                if (errorCode == -2)
                {
                    //String summary = "<html><body style='background: black;'><p style='color: red;'>Unable to load information. Please check if your network connection is working properly or try again later.</p></body></html>";
                    //view.loadData(summary, "text/html", null);
                    //Todo: Add an errorPage when no connection
                    return;
                }
                super.onReceivedError(view, errorCode, description, failingUrl);
            }

            private void removeElementsJS (WebView wv)
            {
                wv.loadUrl("javascript:(function() { " + "document.getElementsByClassName('container clearfix')[0].style.display = 'none'; " + "})()");
                wv.loadUrl("javascript:(function() { " + "document.getElementsByClassName('mainnav-toggle')[0].style.display = 'none'; " + "})()");
            }
        });

        firstWeb.loadUrl(WEBSITE_URL);

        mySwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                firstWeb.reload();
                LiveC.showPlanning(textWebTV, liveLayout, mySwipeRefresh);
                //A noter : firstWeb.loadUrl( "javascript:window.location.reload( true )" );
            }
        });

        final Animation animation = new AlphaAnimation(1, 0);
        animation.setDuration(500);
        animation.setInterpolator(new LinearInterpolator());
        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatMode(Animation.REVERSE);

        logoLive.startAnimation(animation);

        logoLive.setOnClickListener(new LiveClickListener());
        logoClique.setOnClickListener(new LiveClickListener());
        textWebTV.setOnClickListener(new LiveClickListener());

        LiveC.showPlanning(textWebTV, liveLayout, mySwipeRefresh);

        intentLive = new Intent(this, DailyliveActivity.class);
    }


        @Override
        public boolean onKeyDown ( int keyCode, KeyEvent event){
            if (event.getAction() == KeyEvent.ACTION_DOWN) {
                switch (keyCode) {
                    case KeyEvent.KEYCODE_BACK:
                        if (firstWeb.canGoBack()) {
                            firstWeb.goBack();
                        } else {
                            finish();
                        }
                        return true;
                }

            }
            return super.onKeyDown(keyCode, event);
        }

        @Override
        public boolean onCreateOptionsMenu (Menu menu)
        {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main_menu, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item)
        {
            switch (item.getItemId())
            {
                case android.R.id.home:
                    mDrawerLayout.openDrawer(GravityCompat.START);
                    return true;
                case R.id.action_facebook:
                    firstWeb.loadUrl(FACEBOOK_URL);
                    return true;
                case R.id.action_twitter:
                    firstWeb.loadUrl(TWITTER_URL);
                    return true;
                case R.id.action_about:
                    Intent intentAbout = new Intent(MainActivity.this,AboutActivity.class);
                    startActivity(intentAbout);
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
        }

        class LiveClickListener implements View.OnClickListener {

            @Override
            public void onClick(View view) {
                startActivity(intentLive);
            }
        }
        class DrawerItemClickListener implements ListView.OnItemClickListener {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItem(position);
            }

            private void selectItem(int position) {
                switch (position) {
                    case 0:
                        loadUrlandClose(WEBSITE_URL);
                        break;
                    case 1:
                        loadUrlandClose(ASSOC_URL);
                        break;
                    case 2:
                        loadUrlandClose(EVENT_URL);
                        break;
                    case 3:
                        loadUrlandClose(PART_URL);
                        break;
                    case 4:
                        loadUrlandClose(CLUB_URL);
                        break;
                    case 5:
                        loadUrlandClose(SERVICE_URL);
                        break;
                    case 6:
                        loadUrlandClose(EQUIPE_URL);
                        break;
                    case 7:
                        loadUrlandClose(PROG_URL);
                        break;
                    case 8:
                        loadUrlandClose(GALERIE_URL);
                        break;
                    case 9:
                        loadUrlandClose(CONTACT_URL);
                        break;
                    default:
                }
            }

            private void loadUrlandClose(String url) {
                firstWeb.loadUrl(url);
                mDrawerLayout.closeDrawers();
            }
        }
}