package com.mapriluzikgmail.heroes;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class StoryActivity extends AppCompatActivity {
    TextView main_txt;
    TextView ownName;
    TextView age;
    TextView occ;
    TextView area;
    TextView aff;
    TextView comment;
    TextView story;
    ImageView img;
    Intent intent;

    Typeface typeface;

    HeroItem heroItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        typeface = Typeface.createFromAsset(getAssets(),"fonts/koverwatch.ttf");

        main_txt = (TextView)findViewById(R.id.main_txt);
        main_txt.setTypeface(typeface);

        ownName = (TextView)findViewById(R.id.ownname);
        ownName.setTypeface(typeface);

        age = (TextView)findViewById(R.id.age);
        age.setTypeface(typeface);

        occ = (TextView)findViewById(R.id.occ);
        occ.setTypeface(typeface);

        area = (TextView)findViewById(R.id.area);
        area.setTypeface(typeface);

        aff = (TextView)findViewById(R.id.aff);
        aff.setTypeface(typeface);

        comment = (TextView)findViewById(R.id.comment);
        comment.setTypeface(typeface);

        story = (TextView)findViewById(R.id.story);
        story.setTypeface(typeface);

        img = (ImageView)findViewById(R.id.st_img);

        intent = getIntent();
        heroItem = intent.getParcelableExtra("Hero");

        main_txt.setLetterSpacing(0.5f);

        ownName.setText("본명 : "+heroItem.ownName);
        age.setText("나이 : "+heroItem.age);
        occ.setText("직업 : "+heroItem.occ);
        area.setText("활동근거지 : "+heroItem.bound);
        aff.setText("소속 : "+heroItem.aff);
        comment.setText(heroItem.comment);

        String s = heroItem.story;

        s=s.replace(".",".\n");
        story.setText(s);



        Picasso.with(this).load(heroItem.imgURL).into(img);



    }
}
