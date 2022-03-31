package com.example.emoji;

import android.app.Application;

import com.vanniktech.emoji.EmojiManager;
import com.vanniktech.emoji.google.GoogleEmojiProvider;

public class EmojiApplicatioon extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //install emoji manager
        EmojiManager.install(new GoogleEmojiProvider());
    }
}
