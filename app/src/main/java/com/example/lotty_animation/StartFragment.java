package com.example.lotty_animation;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

public class StartFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
    View view = inflater.inflate(R.layout.start_fragment, container, false);
        TextView textTopScore = view.findViewById(R.id.top_score);
        String stringScore = "РЕКОРД : " + MainActivity.score_record +  " руб.";
        textTopScore.setText(stringScore);
        MainActivity.mediaPlayer = MediaPlayer.create(getContext(), R.raw.start);
        MainActivity.mediaPlayer.start();
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
    super.onViewCreated(view, savedInstanceState);
        AppCompatButton button1 = view.findViewById(R.id.Button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            getParentFragmentManager().beginTransaction().replace(R.id.container, new QuestionOne()).commit();
            }
        });
    }
}
