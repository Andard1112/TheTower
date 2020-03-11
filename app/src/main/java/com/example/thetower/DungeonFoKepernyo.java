package com.example.thetower;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class DungeonFoKepernyo extends AppCompatActivity {
    AdatbazisSegito as = new AdatbazisSegito(this);
    ImageButton ibLvL1, ibLvL2, ibLvL3,ibLvL4;
    int lvl = 0, level;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dungeon_fo_kepernyo);
        init();
        Cursor cursor = as.getRow(1);
        as.open();
        AdatLekeres(cursor);
        ibLvL1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lvl1 = new Intent(DungeonFoKepernyo.this, Dungeon.class);
                startActivity(lvl1);
                finish();
            }
        });
        ibLvL2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (level >= 2) {
                    lvl =2;
                Intent lvl2 = new Intent(DungeonFoKepernyo.this, Dungeon.class);
                lvl2.putExtra("LVL", lvl);
                startActivity(lvl2);
                finish();
                }else{
                    Toast.makeText(DungeonFoKepernyo.this, "Nincs elegendő szinted ehez a szinthez, térj vissza kettes szinten!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ibLvL3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (level >= 3){
                    lvl = 3;
                Intent lvl3 = new Intent(DungeonFoKepernyo.this,Dungeon.class);
                lvl3.putExtra("LVL",lvl);
                startActivity(lvl3);
                finish();
                }else{
                    Toast.makeText(DungeonFoKepernyo.this, "Nincs elegendő szinted ehez a szinthez, térj vissza hármas szinten!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ibLvL4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (level >= 4){
                    lvl = 4;
                Intent lvl4 = new Intent(DungeonFoKepernyo.this,Dungeon.class);
                lvl4.putExtra("LVL",lvl);
                startActivity(lvl4);
                finish();
            }else{
                Toast.makeText(DungeonFoKepernyo.this, "Nincs elegendő szinted ehez a szinthez, térj vissza négyes szinten!", Toast.LENGTH_SHORT).show();
            }
            }
        });

    }

    private void AdatLekeres(Cursor cursor) {
        if (cursor.moveToFirst()){
            level = cursor.getInt(14);
            cursor.close();
        }
    }

    private void init(){
        ibLvL1 = findViewById(R.id.ibLvL1);
        ibLvL2 = findViewById(R.id.ibLvL2);
        ibLvL3 = findViewById(R.id.ibLvL3);
        ibLvL4 = findViewById(R.id.ibLvL4);
    }
}
