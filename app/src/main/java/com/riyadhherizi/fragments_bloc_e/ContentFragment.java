package com.riyadhherizi.fragments_bloc_e;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ContentFragment extends Fragment {
TextView textView ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.content,container,false);
        textView =  view.findViewById(R.id.text_);
        return view;
    }


    void updateContent(String tweet) {
        textView.setText(tweet);
    }
}