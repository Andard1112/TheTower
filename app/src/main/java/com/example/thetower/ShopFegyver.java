package com.example.thetower;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ShopFegyver extends AppCompatActivity {
    ImageView ivFegyver;
    TextView tvFegyverLeiras;
    Button btnUppgrade,btnBack;
    AdatbazisSegito as = new AdatbazisSegito(this);
    int cash,upgradeCost = 1,ap, fegyverlvl, pajzsLvl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_fegyver);
        init();
        Cursor cursor = as.getRow(1);
        as.open();
        AdatLekeres(cursor);
        if (cash>= upgradeCost){
            btnUppgrade.setEnabled(true);
        }else{
            btnUppgrade.setEnabled(false);
        }
        btnUppgrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (upgradeCost > 10){
                    upgradeCost += (upgradeCost-1);
                }else{
                    upgradeCost += upgradeCost;
                }
                    ap +=1;
                as.updateRowAtackPowerh(ap);
                    fegyverlvl += 1;
                as.updateRowFegyverLvl(fegyverlvl);

            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kilep = new Intent(ShopFegyver.this,GameFoKepernyo.class);
                startActivity(kilep);
                finish();
            }
        });
    }
    private void init(){
        ivFegyver = findViewById(R.id.ivFegyver);
        tvFegyverLeiras = findViewById(R.id.tvFegyverLeiras);
        btnUppgrade = findViewById(R.id.btnUppgrade);
        btnBack = findViewById(R.id.btnBack);
    }
    public void AdatLekeres(Cursor cursor) {
        if (cursor.moveToFirst()) {
            ap = cursor.getInt(11);
            cash = cursor.getInt(13);
            fegyverlvl = cursor.getInt(17);
            pajzsLvl = cursor.getInt(18);
            cursor.close();
        }
    }
}
