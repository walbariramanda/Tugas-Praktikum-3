package com.example.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private RecyclerView rvHeroes;
    private ArrayList<ModelHero> modelHeroes = new ArrayList<>();
    private Button btnDetail, btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHeroes = findViewById(R.id.recycle_hero);
        rvHeroes.setHasFixedSize(true);

        modelHeroes.addAll(DataHero.getHeroList());

        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        AdapterHero adapterHero = new AdapterHero(this);
        adapterHero.setHero(modelHeroes);
        rvHeroes.setAdapter(adapterHero);

        btnDetail = findViewById(R.id.btn_detail);
        btnDetail.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_detail:{
                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                intent.putExtra(DetailActivity.DATA,modelHeroes);
                startActivity(intent);
            }
            break;
        }

    }
}
