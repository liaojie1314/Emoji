package com.example.emoji;

import static android.view.LayoutInflater.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.vanniktech.emoji.EmojiPopup;
import com.vanniktech.emoji.EmojiTextView;

public class MainActivity extends AppCompatActivity {


    private ImageView mBtEmoji;
    private ImageView mBtSend;
    private EditText mEtEmoji;
    private LinearLayout mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        EmojiPopup popup= EmojiPopup.Builder.fromRootView(
                findViewById(R.id.root_view)
        ).build(mEtEmoji);

        mBtEmoji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //toggle between text and emoji
                popup.toggle();
            }
        });
        mBtSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //inflate emoji text view
                EmojiTextView emojiTextView= (EmojiTextView) LayoutInflater
                        .from(v.getContext())
                        .inflate(R.layout.emoji_text_view,mLinearLayout,false);
                //set text on emoji text view
                emojiTextView.setText(mEtEmoji.getText().toString());
                //add view to linear layout
                mLinearLayout.addView(emojiTextView);
                //clear text value
                mEtEmoji.getText().clear();
            }
        });
    }

    private void initView() {
        mBtEmoji = findViewById(R.id.bt_emoji);
        mBtSend = findViewById(R.id.bt_send);
        mEtEmoji = findViewById(R.id.et_emoji);
        mLinearLayout = findViewById(R.id.linear_layout);
    }
}