package com.example.lotty_animation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import android.media.MediaPlayer;

import org.json.*;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static int score_record;
    public static int score = 0;
    SharedPreferences setting;
    SharedPreferences.Editor editor;
    private static final String FILE_NAME = "FILE_NAME";
    private static final String TOP_SCORE = "TOP_SCORE";
    public static MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setting = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
        score_record = setting.getInt(TOP_SCORE, score_record);
    }

    @Override
    protected void onPause () {
        super.onPause();
        editor = setting.edit();
        editor.putInt(TOP_SCORE, score_record);
        editor.apply();
    }


}