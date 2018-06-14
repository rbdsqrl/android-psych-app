package com.rbdsqrl.mindsafe.view;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public abstract class BaseActivity extends AppCompatActivity {
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
    Context context;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(getLayout());
        Log.i("baseActivity", "view set");
        context = this;
        onLayoutReady();
    }

    abstract public int getLayout();

    abstract public void onLayoutReady();

}
