package com.developerfriendlypizzaexample;

import android.app.Application;

import com.developerfriendlypizzalibrary.PizzaSDK;

/**
 * Created by divyanshunegi on 04/10/18.
 * Project : DeloperFriendlyPizza
 */
public class PIzzaExampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        new PizzaSDK.Builder(this)
                .build();
    }
}
