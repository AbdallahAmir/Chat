package com.example.amir.chat;

import com.firebase.client.Firebase;


public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}