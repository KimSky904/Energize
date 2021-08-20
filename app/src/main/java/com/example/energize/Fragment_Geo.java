package com.example.energize;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Fragment_Geo extends Fragment {

    ImageView next_q2;
    RelativeLayout question1;
    RelativeLayout question2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_theme_solar, container, false);

        //bottom page animation
        final Animation translateup = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.translate_up);
        question1 = view.findViewById(R.id.question1);
        question1.setVisibility(View.VISIBLE);
        question1.startAnimation(translateup);

//        next_q2 = view.findViewById(R.id.next_q2);
//        question2 = view.findViewById(R.id.question2);
//        next_q2.setOnClickListener(v -> {
//            question1.setVisibility(View.INVISIBLE);
//            question2.setVisibility(View.VISIBLE);
//            //starting activity animation
//            getActivity().overridePendingTransition(R.anim.translate_none,R.anim.translate_right);
//            getActivity().finish();
//        });

        return view;
    }
}