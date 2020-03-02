package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterHero extends RecyclerView.Adapter<AdapterHero.HeroViewHolder>{

    private Context context;
    private ArrayList<ModelHero> hero;

    public AdapterHero(Context context) {
        this.context = context;
    }

    public ArrayList<ModelHero> getHero() {
        return hero;
    }

    public void setHero(ArrayList<ModelHero> hero) {
        this.hero = hero;
    }

    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.heroes_item,parent,false);
        return new HeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder holder, int position) {
        Glide.with(context).load(hero.get(position).getHeroImage()).into(holder.ivFoto);
        holder.tvNama.setText(hero.get(position).getHeroName());
    }

    @Override
    public int getItemCount() {
        return getHero().size();
    }

    public class HeroViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivFoto;
        private TextView tvNama;
        public HeroViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFoto = itemView.findViewById(R.id.hero_image);
            tvNama = itemView.findViewById(R.id.hero_name);
        }
    }
}
