package com.apriluziknaver.ow;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by mapri on 2017-09-23.
 */

public class HeroesAdapter extends RecyclerView.Adapter {
    Context ctx;
    ArrayList<HeroItem> items;
    HeroItem heroItem;

    public HeroesAdapter(Context ctx, ArrayList<HeroItem> items) {
        this.ctx = ctx;
        this.items = items;

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(ctx).inflate(R.layout.heroes_item,parent,false);
        RecyclerView.ViewHolder holder = new HeroHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        HeroHolder mholder = (HeroHolder)holder;


        Picasso.with(ctx).load(items.get(position).imgURL).into(mholder.img);
        mholder.name.setText(items.get(position).name);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class HeroHolder extends RecyclerView.ViewHolder{

        TextView name;
        ImageView img;
        Typeface typeface;
        public HeroHolder(View itemView) {
            super(itemView);
            typeface = Typeface.createFromAsset(ctx.getAssets(),"fonts/koverwatch.ttf");
            name = itemView.findViewById(R.id.hero_name);
            name.setTypeface(typeface);
            img = itemView.findViewById(R.id.hero_img);



            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int index = getLayoutPosition();
                    String selectHero = items.get(index).name;
                    Intent intent = new Intent(ctx,HeroViewActivity.class);
                    intent.putExtra("Index",index);
                    intent.putExtra("SelectHero",selectHero.toString());
                    ctx.startActivity(intent);

                    Log.d("어댑터","index: "+index+" HeroKey: "+selectHero);
                }
            });



        }
    }

}
