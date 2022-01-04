package com.example.evaluacincontinua3.application;

import android.app.Application;
import android.content.Context;

import androidx.appcompat.app.AppCompatDelegate;

public class AplicationEv3 extends Application {
    private static AplicationEv3 instance;
    private static Context appContext;

    public static AplicationEv3 getInstance(){return instance;}
    public static Context getAppContext(){return appContext;}
    public void setAppContext(Context mAppContext){this.appContext=mAppContext;}

    @Override
    public void onCreate(){
        super.onCreate();
        instance=this;

        this.setAppContext(getApplicationContext());
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
}
