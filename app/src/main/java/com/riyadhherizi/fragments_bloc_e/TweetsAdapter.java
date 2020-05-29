package com.riyadhherizi.fragments_bloc_e;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class TweetsAdapter extends ArrayAdapter<String> {

    private Activity context ;
    private ArrayList<String> tweets ;

    TweetsAdapter(Activity context , ArrayList<String> tweets){
        super(context,R.layout.tweet,tweets);
        this.context = context;
        this.tweets = tweets;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        @SuppressLint("ViewHolder")
        View view = inflater.inflate(R.layout.tweet,null,false);
        TextView tweet = view.findViewById(R.id.text);
        tweet.setText(tweets.get(position));
        return view;
    }
}
