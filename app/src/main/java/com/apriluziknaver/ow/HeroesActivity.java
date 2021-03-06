package com.apriluziknaver.ow;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class HeroesActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<HeroItem> heroItems=new ArrayList<>();
    ArrayList<AbilityItem> abilityItems=new ArrayList<>();
    HeroesAdapter hAdapter ;
    ReadJson readJson;
    ImageView bg ;

    String name;
    String img;
    String bgURL= "https://blzgdapipro-a.akamaihd.net/media/wallpaper/logo-burst-mobile.jpg";

    Typeface typeface;
    TextView infoText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes);

        typeface = Typeface.createFromAsset(getAssets(),"fonts/koverwatch.ttf");
        infoText = (TextView)findViewById(R.id.info_tv);
        infoText.setTypeface(typeface);

        bg = (ImageView)findViewById(R.id.heroes_bg);
        Picasso.with(this).load(bgURL).into(bg);

        Log.d("히어로액티비티","1");
        recyclerView = (RecyclerView) findViewById(R.id.rccHero);
        hAdapter = new HeroesAdapter(this,heroItems);
        recyclerView.setLayoutManager(new GridLayoutManager(this,4));
        recyclerView.scrollToPosition(0);
        recyclerView.setAdapter(hAdapter);
        Log.d("히어로액티비티1","2");

        readJson = new ReadJson();
        readJson.start();

        hAdapter.notifyDataSetChanged();



    }

    class ReadJson extends Thread{

        HeroItem heroItem;

        String page = getIntent().getStringExtra("Page");

        JSONObject object;
        JSONObject object2;

        Iterator<String> keys;


        @Override
        public void run() {
            super.run();


            try{

                object = new JSONObject(page);
                keys = object.keys();


                while (keys.hasNext()){

                    heroItem = new HeroItem();
                    String key = keys.next();
                    object2 = new JSONObject(object.getString(key));

                    Iterator<String> objkeys = object2.keys();
                    while (objkeys.hasNext()){
                        String objkey = objkeys.next();
                        Log.d("오비제이",objkey);
                    }

                    heroItem.title= object2.getString("about1");
                    heroItem.name= object2.getString("name");
                    name = heroItem.name;
                    heroItem.imgURL= object2.getString("imgURL");
                    img = heroItem.imgURL;

                    Log.d("히어로액티비티","7");
                    heroItem.about = object2.getString("about2");
                    Log.d("히어로액티비티","8");
                    heroItem.part = object2.getString("part");
                    Log.d("히어로액티비티","9");
                    heroItem.diff = object2.getString("diff");

                    if(object2.has("0-imgURL")) {
                        heroItem.hIcon = object2.getString("0-imgURL");

                    }
                    if(object2.has("0-video")) {

                        heroItem.hVideo = object2.getString("0-video");
                    }

                    
                    heroItem.icon01= object2.getString("1-imgURL");
                    heroItem.skill01= object2.getString("1-skill");
                    heroItem.icon02= object2.getString("2-imgURL");
                    heroItem.skill02= object2.getString("2-skill");

                    heroItem.icon03= object2.getString("3-imgURL");
                    heroItem.skill03= object2.getString("3-skill");
                    heroItem.icon04= object2.getString("4-imgURL");
                    heroItem.skill04= object2.getString("4-skill");


                    Log.d("히어로액티비티","10");
                    if(object2.has("5-imgURL")){



                        heroItem.icon05= object2.getString("5-imgURL");
                        heroItem.skill05= object2.getString("5-skill");



                    }

                    Log.d("히어로액티비티","11");
                    if(object2.has("6-imgURL")) {


                        heroItem.icon06 = object2.getString("6-imgURL");
                        heroItem.skill06 = object2.getString("6-skill");
                    }

                    heroItem.ownName = object2.getString("ownname");
                    heroItem.age = object2.getString("age");
                    heroItem.occ = object2.getString("occ");
                    heroItem.bound = object2.getString("area");
                    heroItem.aff = object2.getString("aff");
                    heroItem.comment = object2.getString("comment");
                    heroItem.story = object2.getString("story");

                    heroItems.add(heroItem);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            hAdapter.notifyDataSetChanged();
                        }
                    });
                }



                Log.d("히어로액티비티","12");

            }catch(Exception e){
                Log.d("히어로액티비티", "E");
                e.printStackTrace();
            }
        }
    }






}
