package com.event_to_give.e2g;

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
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;



public class MainActivity extends AppCompatActivity
{

    WebView firstWeb;

    SwipeRefreshLayout swipeLayout;

    final String FACEBOOK_URL = "https://www.facebook.com/assoc.eventtogive";
    final String TWITTER_URL = "https://twitter.com/Event2Give";

    private String[] mMenuTitles;
    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        myToolbar.setTitle("Event To Give");
        myToolbar.setNavigationIcon(R.drawable.ic_list_black_24dp);
        setSupportActionBar(myToolbar);

        mMenuTitles = getResources().getStringArray(R.array.menu_arrays);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        mDrawerList.setAdapter(new ArrayAdapter<>(this, R.layout.drawer_list_item, mMenuTitles));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        firstWeb = (WebView) findViewById(R.id.webView1);

        firstWeb.getSettings().setJavaScriptEnabled(true);

        firstWeb.setWebViewClient(new WebViewClient()
        {
            @Override
            public void onPageCommitVisible(WebView view, String url) {
                findViewById(R.id.loadingPanel).setVisibility(View.GONE);
                swipeLayout.setNestedScrollingEnabled(true);
                firstWeb.loadUrl("javascript:(function() { " + "document.getElementsByClassName('container clearfix')[0].style.display = 'none'; " + "})()");
                //firstWeb.loadUrl("javascript:(function() { " + "document.getElementsByClassName('mainnav-toggle')[0].style.display = 'none'; " + "})()");
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                findViewById(R.id.loadingPanel).setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                firstWeb.loadUrl("javascript:(function() { " + "document.getElementsByClassName('mainnav-toggle')[0].style.display = 'none'; " + "})()");
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
        });

        firstWeb.loadUrl("http://www.event-to-give.com/");

        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipeToRefresh);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Insert your code here
                firstWeb.reload(); // refreshes the WebView
            }
        });
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
                default:
                    return super.onOptionsItemSelected(item);
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
                        loadUrlandClose("http://www.event-to-give.com/");
                        break;
                    case 1:
                        loadUrlandClose("http://www.event-to-give.com/?page_id=8");
                        break;
                    case 2:
                        loadUrlandClose("http://www.event-to-give.com/?page_id=80");
                        break;
                    case 3:
                        loadUrlandClose("http://www.event-to-give.com/?page_id=86");
                        break;
                    case 4:
                        loadUrlandClose("http://www.event-to-give.com/?page_id=2192");
                        break;
                    case 5:
                        loadUrlandClose("http://www.event-to-give.com/?page_id=76");
                        break;
                    case 6:
                        loadUrlandClose("http://www.event-to-give.com/?page_id=364");
                        break;
                    case 7:
                        loadUrlandClose("http://www.event-to-give.com/?page_id=2356");
                        break;
                    case 8:
                        loadUrlandClose("http://www.event-to-give.com/?page_id=88");
                        break;
                    case 9:
                        loadUrlandClose("http://www.event-to-give.com/?page_id=114");
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