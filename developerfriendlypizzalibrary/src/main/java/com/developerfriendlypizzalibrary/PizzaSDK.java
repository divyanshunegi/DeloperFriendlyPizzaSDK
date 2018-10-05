package com.developerfriendlypizzalibrary;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.developerfriendlypizzalibrary.ui.PizzaActivity;
import com.developerfriendlypizzalibrary.utils.Constants;

/**
 * Created by divyanshunegi on 04/10/18.
 * Project : DeloperFriendlyPizza
 */

public class PizzaSDK {

    private static PizzaSDK _instance;
    private Context context;

    private PizzaSDK() {
        //it is private to not access it from outside this scope
    }

    private PizzaSDK(Builder builder) {
        _instance = this;
        context = builder.context;
    }


    public static final class Builder {
        public Context context;

        public Builder(Context val) {
            context = val;
        }

        public PizzaSDK build() {
            Toast.makeText(context, R.string.pizza, Toast.LENGTH_SHORT).show();
            return new PizzaSDK(this);
        }
    }

    public static void pizzaTime() {
        if (_instance == null) {
            throw new RuntimeException(Constants.initializationError);
        }
        _instance.showPizzaMenu();
    }

    private void showPizzaMenu() {
        Intent in = new Intent(context,PizzaActivity.class);
        in.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(in);
    }

}
