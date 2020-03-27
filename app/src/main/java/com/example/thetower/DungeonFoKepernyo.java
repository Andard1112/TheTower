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
    int lvlszint = 0, level;
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
                Intent lvl = new Intent(DungeonFoKepernyo.this, Dungeon.class);
                as.updateRowDungeonSzint(lvlszint);
                startActivity(lvl);
            }
        });
        ibLvL2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (level >= 2) {
                    lvlszint =1;
                Intent lvl = new Intent(DungeonFoKepernyo.this, Dungeon.class);
                as.updateRowDungeonSzint(lvlszint);
                startActivity(lvl);
                }else{
                    Toast.makeText(DungeonFoKepernyo.this, "Nincs elegendő szinted ehez a szinthez, térj vissza kettes szinten!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ibLvL3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (level >= 3){
                    lvlszint = 2;
                Intent lvl = new Intent(DungeonFoKepernyo.this,Dungeon.class);
                startActivity(lvl);
                as.updateRowDungeonSzint(lvlszint);
                }else{
                    Toast.makeText(DungeonFoKepernyo.this, "Nincs elegendő szinted ehez a szinthez, térj vissza hármas szinten!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ibLvL4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (level >= 4){
                    lvlszint = 3;
                Intent lvl = new Intent(DungeonFoKepernyo.this,Dungeon.class);
                    as.updateRowDungeonSzint(lvlszint);
                startActivity(lvl);
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
