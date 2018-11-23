package com.fryanramzkhar.stellarium;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclePlanet extends AppCompatActivity {

    @BindView(R.id.my_recycle_planet)
    RecyclerView myRecyclePlanet;

    String[] namaPlanet,detailPlanet;
    int[] gambarPlanet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_planet);
        ButterKnife.bind(this);

        namaPlanet = getResources().getStringArray(R.array.macam_planet);
        detailPlanet = getResources().getStringArray(R.array.detail_planet);
        gambarPlanet = new int[]{R.drawable.merkurius,R.drawable.venus,R.drawable.bumi,R.drawable.mars,R.drawable.jupiter,R.drawable.saturnus,R.drawable.uranus,R.drawable.neptunus,R.drawable.pluto};

        Adapter adapter = new Adapter(RecyclePlanet.this, gambarPlanet,namaPlanet,detailPlanet);
        myRecyclePlanet.setHasFixedSize(true);
        myRecyclePlanet.setLayoutManager(new LinearLayoutManager(RecyclePlanet.this));
        myRecyclePlanet.setAdapter(adapter);
    }
}
