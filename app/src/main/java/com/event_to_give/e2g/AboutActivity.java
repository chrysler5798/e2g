package com.event_to_give.e2g;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by Chrysler on 11/20/2016.
 * <p>
 * e2g
 */

public class AboutActivity extends AppCompatActivity {

    Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        myToolbar = (Toolbar) findViewById(R.id.my_toolbar_about);

        myToolbar.setTitle(R.string.e2g_about);
    }
}
