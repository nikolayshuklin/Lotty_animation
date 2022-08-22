package com.example.lotty_animation;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

public class QuestionFive extends Fragment{
    AppCompatButton button1;
    AppCompatButton button2;
    AppCompatButton button3;
    AppCompatButton button4;
    Button button5;
    boolean afteranswer;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.question_five, container, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        button1 = view.findViewById(R.id.Button1);
        button2 = view.findViewById(R.id.Button2);
        button3 = view.findViewById(R.id.Button3);
        button4 = view.findViewById(R.id.Button4);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noRightAnswer(button1);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noRightAnswer(button2);

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noRightAnswer(button3);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rightAnswer(button4);
            }
        });
    }

    public void rightAnswer(AppCompatButton button) { //правильный ответ
        button.setBackground(getResources().getDrawable(R.drawable.radius_button_green));
        afteranswer = true;
        MainActivity.score = 4500;
        if (MainActivity.score > MainActivity.score_record) MainActivity.score_record = MainActivity.score;
        MainActivity.mediaPlayer = MediaPlayer.create(getContext(), R.raw.likovanie);
        MainActivity.mediaPlayer.start();
        goNext();
    }
    public void noRightAnswer(AppCompatButton button) { //неправильный ответ
        button.setBackground(getResources().getDrawable(R.drawable.radius_button_red));
        afteranswer = false;
        MainActivity.mediaPlayer = MediaPlayer.create(getContext(), R.raw.jaloba);
        MainActivity.mediaPlayer.start();
        goNext();
    }

    @SuppressLint("ResourceType")
    public void goNext (){
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);
        LinearLayout ll = (LinearLayout) requireView().findViewById(R.id.ll);
        button5 = new Button(getContext());
        button5.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
        button5.setId(5);
        button5.setBackground(getResources().getDrawable(R.drawable.radius_button));
        button5.setText("ДАЛЕЕ");
        ll.addView(button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (afteranswer) {
                    getParentFragmentManager().beginTransaction().replace(R.id.container, new EndFragment()).commit();
                }
                else {
                    getParentFragmentManager().beginTransaction().replace(R.id.container, new LoserFragment()).commit();
                }
            }
        });
    }


}

