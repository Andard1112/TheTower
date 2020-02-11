package com.example.thetower;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameFoKepernyo extends AppCompatActivity {
    private Button btnDuengeon,btnBag,btnKarakter,btnShopPoti,btnShopPancel,btnShopFegyver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_fo_kepernyo);
        init();
        btnDuengeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toDungeon = new Intent(GameFoKepernyo.this,DungeonFoKepernyo.class);
                startActivity(toDungeon);
                finish();
            }
        });
        btnBag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toBag = new Intent(GameFoKepernyo.this,KarakterBag.class);
                startActivity(toBag);
                finish();
            }
        });
        btnKarakter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toKarakter = new Intent(GameFoKepernyo.this,KarakterStatusz.class);
                startActivity(toKarakter);
                finish();
            }
        });
        btnShopPoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toShopPoti = new Intent(GameFoKepernyo.this,ShopPoti.class);
                startActivity(toShopPoti);
                finish();
            }
        });
        btnShopPancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toShopPancel = new Intent(GameFoKepernyo.this,ShopPancel.class);
                startActivity(toShopPancel);
                finish();
            }
        });
        btnShopFegyver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toShopFegyver = new Intent(GameFoKepernyo.this,ShopFegyver.class);
                startActivity(toShopFegyver);
                finish();
            }
        });

    }
    private void init(){
        btnDuengeon = findViewById(R.id.btnDuengeon);
        btnBag = findViewById(R.id.btnBag);
        btnKarakter = findViewById(R.id.btnKarakter);
        btnShopPoti = findViewById(R.id.btnShopPoti);
        btnShopFegyver = findViewById(R.id.btnShopFegyver);
        btnShopPancel = findViewById(R.id.btnShopPancel);
    }
}
