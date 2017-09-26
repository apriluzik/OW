package com.apriluziknaver.ow;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
    AdView adView;

    Button button;
    ArrayList<HeroItem> heroItems = new ArrayList<>();
    String page;
    ReadJson readJson;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this,"ca-app-pub-9476856001766966~2857819325");
        adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        adView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Log.i("Ads", "onAdLoaded");

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                Log.i("Ads", "onAdFailedToLoad");
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
                Log.i("Ads", "onAdOpened");
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
                Log.i("Ads", "onAdLeftApplication");
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the user is about to return
                // to the app after tapping on an ad.
                Log.i("Ads", "onAdClosed");
            }
        });
        button = (Button)findViewById(R.id.startBtn);
        readJson = new ReadJson();
        readJson.start();
        intent = new Intent(this,HeroesActivity.class);

    }

    public void clickBtn(View v){

        startActivity(intent);
    }

    class ReadJson extends Thread{


        HeroItem heroItem;

        AssetManager assetManager;
        AssetManager.AssetInputStream ais;
        BufferedReader reader;
        String line;

        JSONObject object;
        JSONObject object2;
        Iterator<String> keys;

        @Override
        public void run() {
            super.run();

            assetManager = getResources().getAssets();
            ais=null;

            try{

                ais = (AssetManager.AssetInputStream)assetManager.open("json/heroes.json");
                reader = new BufferedReader(new InputStreamReader(ais,"UTF-8"));

                line= null;
                page="";

                while((line=reader.readLine())!=null){

                    Log.d("라인:",line);
                    page+=line;
                }

                ais.close();

//                object = new JSONObject(page);
//                keys = object.keys();
//
//                while (keys.hasNext()){
//
//                    heroItem = new HeroItem();
//                    String key = keys.next();
//
//                    object2 = new JSONObject(object.getString(key));
//
//                    heroItem.title= object2.getString("설명1");
//                    heroItem.name= object2.getString("이름");
//                    heroItem.imgURL= object2.getString("이미지");
//
//                    heroItem.about = object2.getString("설명2");
//                    heroItem.part = object2.getString("역할");
//                    heroItem.diff = object2.getString("난이도");
//
//                    heroItem.hIcon= object2.getString("0-이미지");
//                    heroItem.hVideo= object2.getString("0-동영상");
//
//                    heroItem.skill01= object2.getString("1-이미지");
//                    heroItem.icon01= object2.getString("1-기술");
//
//                    heroItem.skill02= object2.getString("2-이미지");
//                    heroItem.icon02= object2.getString("2-기술");
//
//                    heroItem.skill03= object2.getString("3-이미지");
//                    heroItem.icon03= object2.getString("3-기술");
//
//                    heroItem.skill04= object2.getString("4-이미지");
//                    heroItem.icon04= object2.getString("4-기술");
//
//                    if(object2.has("5-이미지")){
//                    heroItem.skill05= object2.getString("5-이미지");
//                    heroItem.icon05= object2.getString("5-기술");
//                    }
//                    if(object2.has("6-이미지")) {
//                        heroItem.skill06 = object2.getString("6-이미지");
//                        heroItem.skill06 = object2.getString("6-기술");
//                    }
//                    heroItem.ownName = object2.getString("본명");
//                    heroItem.age = object2.getString("연령");
//                    heroItem.occ = object2.getString("직업");
//                    heroItem.bound = object2.getString("활동근거지");
//                    heroItem.aff = object2.getString("소속");
//                    heroItem.comment = object2.getString("대사");
//                    heroItem.story = object2.getString("스토리");
//
//                }
//                heroItems.add(heroItem);


            }catch(Exception e){
                e.getStackTrace();
            }finally {
                intent.putExtra("Page",page);
               runOnUiThread(new Runnable() {
                   @Override
                   public void run() {
                       button.setVisibility(View.VISIBLE);
                   }
               });
            }

        }
    }

}

