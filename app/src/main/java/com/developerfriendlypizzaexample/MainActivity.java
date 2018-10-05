package com.developerfriendlypizzaexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.developerfriendlypizzalibrary.PizzaSDK;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pizzaTime(View view) {
        PizzaSDK.pizzaTime();
    }
}
