package com.mapriluzikgmail.heroes;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by mapri on 2017-09-27.
 */

public class AbliltyAdapter extends RecyclerView.Adapter {
    Context ctx;
    ArrayList<AbilityItem> items;
    HeroItem hero;

    public AbliltyAdapter(Context ctx, ArrayList<AbilityItem> items) {
        this.ctx = ctx;
        this.items = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.ability_item,parent,false);
        AbilHolder holder = new AbilHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AbilHolder mholder = (AbilHolder)holder;

            mholder.name.setText(items.get(position).skill);
            Picasso.with(ctx).load(items.get(position).icon).into(mholder.img);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class AbilHolder extends RecyclerView.ViewHolder{
        Typeface typeface;
        ImageView img;
        TextView name;
        public AbilHolder(View itemView) {
            super(itemView);
            int i = getLayoutPosition();
            typeface = Typeface.createFromAsset(ctx.getAssets(),"fonts/koverwatch.ttf");
            img = itemView.findViewById(R.id.ab_img);
            name = itemView.findViewById(R.id.ab_name);
            name.setTypeface(typeface);

            Log.d("어빌리티",name.getText().toString());
        }
    }
}
