package com.example.thetower;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class Dungeon extends AppCompatActivity {
    Button btnUp, btnRight, btnDown, btnLeft, btnEnemy;
    int x = 0, y = 0, enemy, dungeonSzint;
    Random random = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dungeon);
        init();

        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (x>5){
                    //ilyenkor elért a map tetejére nem lehet tovább menni
                    btnUp.setVisibility(View.INVISIBLE);
                    btnUp.setEnabled(false);
                    szornyek();
                }else{
                    x++;
                    btnDown.setVisibility(View.VISIBLE);
                    btnDown.setEnabled(true);
                    enemy = random.nextInt(10)+1;
                    szornyek();

                }
            }
        });
        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (y > 5){
                    //elérte a jobb szélét
                    btnRight.setVisibility(View.INVISIBLE);
                    btnRight.setEnabled(false);
                    szornyek();
                }else{
                    y++;
                    btnLeft.setVisibility(View.VISIBLE);
                    btnLeft.setEnabled(true);
                    szornyek();
                }
            }
        });
        btnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (x<-5){
                    //elérte az alját a mappnak
                    btnDown.setVisibility(View.INVISIBLE);
                    btnDown.setEnabled(false);
                    szornyek();
                }else{
                    x--;
                    btnUp.setVisibility(View.VISIBLE);
                    btnUp.setEnabled(true);
                    szornyek();
                }
            }
        });
        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (y < -5){
                    //elértee a bal szélét mappnakx
                    btnLeft.setVisibility(View.INVISIBLE);
                    btnLeft.setEnabled(false);
                    szornyek();
                }else{
                    y--;
                    btnRight.setVisibility(View.VISIBLE);
                    btnRight.setEnabled(true);
                    szornyek();
                }
            }
        });
    }
    private void init(){
        btnUp = findViewById(R.id.btnUp);
        btnRight = findViewById(R.id.btnRight);
        btnDown = findViewById(R.id.btnDown);
        btnLeft = findViewById(R.id.btnLeft);
        btnEnemy = findViewById(R.id.btnEnemy);
    }
    private void szornyek(){
        enemy = random.nextInt(10)+1;

        if (enemy < 7 ){
            final int szorny = random.nextInt(4)+1;
            switch (szorny){
                case 1:
                    btnEnemy.setBackgroundResource(R.drawable.zombie);
                    break;
                case 2:
                    btnEnemy.setBackgroundResource(R.drawable.skeleton_archer);
                    break;
                case 3:
                    btnEnemy.setBackgroundResource(R.drawable.imp);
                    break;
                case 4:
                    btnEnemy.setBackgroundResource(R.drawable.minotaurus);
                    break;
            }
            btnEnemy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent fight = new Intent(Dungeon.this,Fight.class);
                    fight.putExtra("fajta",szorny);
                    startActivity(fight);
                    finish();
                }
            });
        }
    }
}
