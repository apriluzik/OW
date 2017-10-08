package com.mapriluzikgmail.heroes;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.squareup.picasso.Picasso;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    AdView adView;

    String server="http://kghy234.dothome.co.kr/overwatch/heroes_fix2.json";

    String oasis="https://d1u1mce87gyfbn.cloudfront.net/media/screenshot/oasis-1-screenshot.jpg";
    String volskaya="https://d1u1mce87gyfbn.cloudfront.net/media/screenshot/volskaya-screenshot-001.jpg";
    String hanamura="https://d1u1mce87gyfbn.cloudfront.net/media/screenshot/hanamura-screenshot-004.jpg";
    String kings="https://d1u1mce87gyfbn.cloudfront.net/media/screenshot/kings-row-screenshot-009.jpg";
    String numbani="https://d1u1mce87gyfbn.cloudfront.net/media/screenshot/numbani-screenshot-001.jpg";

//    String[] bgUrls={"https://d1u1mce87gyfbn.cloudfront.net/media/screenshot/oasis-1-screenshot.jpg",
//            "https://d1u1mce87gyfbn.cloudfront.net/media/screenshot/volskaya-screenshot-001.jpg",
//            "https://d1u1mce87gyfbn.cloudfront.net/media/screenshot/hanamura-screenshot-004.jpg",
//            "https://d1u1mce87gyfbn.cloudfront.net/media/screenshot/kings-row-screenshot-009.jpg",
//            "https://d1u1mce87gyfbn.cloudfront.net/media/screenshot/numbani-screenshot-001.jpg"};

    Button button;
    ArrayList<HeroItem> heroItems = new ArrayList<>();
    String page;
    ReadJson readJson;
    Intent intent;

    TextView intro;
    TextView title;
    Typeface typeface;
    ImageView bg;

    String bgURL= "https://blzgdapipro-a.akamaihd.net/media/wallpaper/logo-burst-mobile.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        typeface = Typeface.createFromAsset(getAssets(),"fonts/koverwatch.ttf");

        MobileAds.initialize(this,"ca-app-pub-9476856001766966~2857819325");
        adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
//        광고
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
        button.setTypeface(typeface);

        bg = (ImageView)findViewById(R.id.main_bg);

        Picasso.with(this).load(bgURL).into(bg);
//        Picasso.with(this).load(kings).into(bg);



        title=(TextView)findViewById(R.id.title_tv);
        title.setTypeface(typeface);
        intro=(TextView)findViewById(R.id.intro_tv);
        intro.setTypeface(typeface);

        readJson = new ReadJson();
        readJson.start();
        intent = new Intent(this,HeroesActivity.class);





        title.setText(" 미래를 위한 전투 ");
        intro.setText("군인, 과학자, 탐험가, 전문가.\n" +
                "\n" +
                "국제 분쟁의 시대에 상처로 찢긴 세계를 구원하기 위해 영웅들로 구성된 다국적 특수 부대, 오버워치가 결성되었습니다. \n" +
                "\n" +
                "그들은 사태를 종식시켰고, 그 후 수십 년 동안 평화가 지속되며 탐험과 혁신, 발견의 시대가 이어졌습니다. 그러나 시간이 흐르며 오버워치는 그 영향력을 서서히 잃었고, 마침내는 해체되기에 이르렀습니다.\n" +
                "\n" +
                "\n" +
                "그리고, 다시 분쟁으로 얼룩지기 시작한 세상을 구하기 위해, 예전 그리고 새로운 영웅들이 부름을 받기 시작했습니다.\n" +
                "\n" +
                "함께 하시겠습니까?");

    }

    public void clickBtn(View v){

        startActivity(intent);
    }

    class ReadJson extends Thread{



        BufferedReader reader;
        String line;


        @Override
        public void run() {
            super.run();



            try{

                URL url = new URL(server);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setDoInput(true);
                conn.setDoOutput(true);
                conn.setDefaultUseCaches(false);

                reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));


                line= null;
                page="";

                while((line=reader.readLine())!=null){

                    Log.d("라인:",line);
                    page+=line;
                }

                Log.d("페이지:",page);


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

