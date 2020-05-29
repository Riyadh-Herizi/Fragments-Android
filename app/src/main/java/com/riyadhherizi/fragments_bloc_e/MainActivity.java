package com.riyadhherizi.fragments_bloc_e;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ArrayList<String> tweets = new ArrayList<>();
ListView listView;
    TweetsAdapter tweetsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         init_list();
         listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
                  Intent intent = new Intent(MainActivity.this,Content.class);
                  intent.putExtra("tweet",tweets.get(position));
                  startActivity(intent);
               }
               else {
                   ContentFragment contentFragment = (ContentFragment) getSupportFragmentManager().findFragmentByTag("content");
                   assert contentFragment != null;
                   contentFragment.updateContent(tweets.get(position));
               }
             }
         });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
      int selected = item.getItemId();
      if(selected == R.id.tweet) {
          final Dialog dialog = new Dialog(MainActivity.this);
          dialog.setContentView(R.layout.dialog);
          Button confirm = dialog.findViewById(R.id.confirm);
          Button annuler = dialog.findViewById(R.id.annuler);
          final EditText tweet = dialog.findViewById(R.id.text);
          annuler.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  dialog.dismiss();
              }
          });
          confirm.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
               String tweet_text = tweet.getText().toString().trim();
               if(TextUtils.isEmpty(tweet_text)) {
                 tweet.setError("this field is required");
               }
               else
               {
                tweets.add(tweet_text);
                tweetsAdapter.notifyDataSetChanged();
                dialog.dismiss();
               }
              }
          });
        dialog.show();

      }


        return super.onOptionsItemSelected(item);
    }

    void init_list(){

        listView = findViewById(R.id.list);
        tweetsAdapter = new TweetsAdapter(MainActivity.this,tweets);
        listView.setAdapter(tweetsAdapter);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("tweets",tweets);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        tweets = savedInstanceState.getStringArrayList("tweets");
        init_list();
    }
}
