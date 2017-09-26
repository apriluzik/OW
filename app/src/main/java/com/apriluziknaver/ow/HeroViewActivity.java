package com.apriluziknaver.ow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class HeroViewActivity extends AppCompatActivity {
    String heroName="";
    String backURL="https://blzgdapipro-a.akamaihd.net/hero/"+heroName+"/background-story.jpg";

    TextView name;
    TextView about1;
    TextView about2;
    TextView part;
    TextView diff;
    TextView ownname;
    TextView age;
    TextView occ;
    TextView area;
    TextView aff;
    TextView comment;
    TextView story;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_view);
    }
}
