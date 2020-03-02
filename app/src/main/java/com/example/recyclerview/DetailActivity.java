package com.example.recyclerview;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    public static String DATA = "data";
    private ImageView ivFoto;
    private TextView tvNama,tvDesk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivFoto = findViewById(R.id.adiv_hero_image);
        tvNama = findViewById(R.id.adtv_hero_name);
        tvDesk = findViewById(R.id.adtv_hero_desc);

        ModelHero hero = getIntent().getParcelableExtra(DATA);
        if (hero!=null){
            Glide.with(this).load(hero.getHeroImage()).into(ivFoto);
            tvNama.setText(hero.getHeroName());
            tvDesk.setText(hero.getHeroDesc());
        }

    }
}
