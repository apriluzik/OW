package com.apriluziknaver.ow;
//http://kghy234.dothome.co.kr/overwatch/heroes_fix2.json

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HeroViewActivity extends AppCompatActivity {
    String[] names = new String[]
            {"doomfist","genji", "mccree", "pharah","reaper", "soldier-76", "sombra", "tracer",
                    "bastion", "hanzo", "junkrat", "mei", "torbjorn", "widowmaker",
                    "dva", "orisa", "reinhardt", "roadhog", "winston", "zarya",
                    "ana", "lucio", "mercy", "symmetra", "zenyatta"};
    //    parsingThread parsingThread;
    int index;



    TextView name;
    TextView title;
    TextView about2;
    TextView part;
    RatingBar diff;
    ImageView bgHero;
    TextView ownname;
    TextView age;
    TextView occ;
    TextView area;
    TextView aff;
    TextView comment;
    TextView story;

    ArrayList<AbilityItem> abilityItems = new ArrayList<>();
    RecyclerView recyclerView;
    AbliltyAdapter abliltyAdapter;
    HeroItem heroItem;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_view);
        Intent intent =getIntent();
        index = intent.getIntExtra("Index",0);
        heroItem=intent.getParcelableExtra("Hero");

        setAbilityItems();

        name=(TextView)findViewById(R.id.view_name);
        title=(TextView)findViewById(R.id.view_title);
        part = (TextView)findViewById(R.id.view_part);
        diff = (RatingBar)findViewById(R.id.view_diff);
        bgHero = (ImageView)findViewById(R.id.view_bgHero);

        name.setText(heroItem.name);
        title.setText(heroItem.title);
        part.setText(heroItem.part);
        diff.setRating(Integer.parseInt(heroItem.diff));

        String backURL="https://blzgdapipro-a.akamaihd.net/hero/"+names[index]+"/background-story.jpg";
        Picasso.with(this).load(backURL).into(bgHero);


        recyclerView = (RecyclerView) findViewById(R.id.rccability);
        recyclerView.setLayoutManager(new GridLayoutManager(this,4));
        abliltyAdapter = new AbliltyAdapter(this,abilityItems);
        recyclerView.setAdapter(abliltyAdapter);
        abliltyAdapter.notifyDataSetChanged();

    }

    public void setAbilityItems(){

        abilityItems.add(new AbilityItem(heroItem.skill01,heroItem.icon01));
        abilityItems.add(new AbilityItem(heroItem.skill02,heroItem.icon02));
        abilityItems.add(new AbilityItem(heroItem.skill03,heroItem.icon03));
        abilityItems.add(new AbilityItem(heroItem.skill04,heroItem.icon04));
        if(heroItem.skill05!=null){
        abilityItems.add(new AbilityItem(heroItem.skill05,heroItem.icon05));
        }
        if(heroItem.skill06!=null) {
            abilityItems.add(new AbilityItem(heroItem.skill06, heroItem.icon06));
        }

    }
}
