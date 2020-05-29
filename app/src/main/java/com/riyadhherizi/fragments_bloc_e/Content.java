package com.riyadhherizi.fragments_bloc_e;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Content extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        Bundle extras = getIntent().getExtras();
        assert extras != null;
        String tweet = extras.getString("tweet");
        TextView textView = findViewById(R.id.text_);
        textView.setText(tweet);

    }
}
