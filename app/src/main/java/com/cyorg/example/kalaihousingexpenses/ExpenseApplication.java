package com.cyorg.example.kalaihousingexpenses;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by HCL on 11/27/2016.
 */
public class ExpenseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
