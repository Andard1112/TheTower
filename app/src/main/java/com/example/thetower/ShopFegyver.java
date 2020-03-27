package com.example.thetower;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ShopFegyver extends AppCompatActivity {
    ImageView ivFegyver, ivFegyverEgykezes1, ivFegyverEgykezes2;
    TextView tvFegyverLeiras, tvFegyverLeirasEgykezes1, tvFegyverLeirasEgykezes2;
    Button btnUppgrade,btnBack;
    AdatbazisSegito as = new AdatbazisSegito(this);
    int cash,ap,armor, fegyverlvl, pajzsLvl, upgradeCostFegyver;
    private String szakma, clas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_fegyver);
        init();
        Cursor cursor = as.getRow(1);
        as.open();
        AdatLekeres(cursor);
        if (clas.equals("Knight")){
            ivFegyver.setVisibility(View.INVISIBLE);
            ivFegyver.setEnabled(false);
            ivFegyverEgykezes1.setVisibility(View.VISIBLE);
            ivFegyverEgykezes1.setEnabled(true);
            ivFegyverEgykezes2.setVisibility(View.VISIBLE);
            ivFegyverEgykezes2.setEnabled(true);
            ivFegyverEgykezes2.setImageResource(R.drawable.pajzs_hatter);
            tvFegyverLeiras.setVisibility(View.INVISIBLE);
            tvFegyverLeirasEgykezes1.setVisibility(View.VISIBLE);
            tvFegyverLeirasEgykezes2.setVisibility(View.VISIBLE);
            tvFegyverLeirasEgykezes1.setText("Arany: "+cash+"\nSebzés: "+ap+" --> "+(ap+1)+"\nSzint: "+fegyverlvl+" --> "+(fegyverlvl+1));
            tvFegyverLeirasEgykezes2.setText("Armor: "+armor+" --> "+(armor+1)+"\n Fejlesztés ára: "+ upgradeCostFegyver+"\nSzint: "+pajzsLvl+" --> "+(pajzsLvl+1));
        }else if (clas.equals("Warior")){
            ivFegyver.setVisibility(View.VISIBLE);
            ivFegyver.setEnabled(true);
            ivFegyverEgykezes1.setVisibility(View.INVISIBLE);
            ivFegyverEgykezes1.setEnabled(false);
            ivFegyverEgykezes2.setVisibility(View.INVISIBLE);
            ivFegyverEgykezes2.setEnabled(false);
            tvFegyverLeiras.setVisibility(View.VISIBLE);
            tvFegyverLeirasEgykezes1.setVisibility(View.INVISIBLE);
            tvFegyverLeirasEgykezes2.setVisibility(View.INVISIBLE);
            tvFegyverLeiras.setText("Arany: "+cash+"\nSebzés: "+ap+" --> "+(ap+1)+"\n Fejlesztés ára: "+ upgradeCostFegyver+"\nSzint: "+fegyverlvl+" --> "+(fegyverlvl+1));
        }else if (clas.equals("Hunter")){
            ivFegyver.setVisibility(View.VISIBLE);
            ivFegyver.setEnabled(true);
            ivFegyver.setImageResource(R.drawable.bow);
            ivFegyverEgykezes1.setVisibility(View.INVISIBLE);
            ivFegyverEgykezes1.setEnabled(false);
            ivFegyverEgykezes2.setVisibility(View.INVISIBLE);
            ivFegyverEgykezes2.setEnabled(false);
            tvFegyverLeiras.setVisibility(View.VISIBLE);
            tvFegyverLeirasEgykezes1.setVisibility(View.INVISIBLE);
            tvFegyverLeirasEgykezes2.setVisibility(View.INVISIBLE);
            tvFegyverLeiras.setText("Arany: "+cash+"\nSebzés: "+ap+" --> "+(ap+1)+"\n Fejlesztés ára: "+ upgradeCostFegyver+"\nSzint: "+fegyverlvl+" --> "+(fegyverlvl+1));
        }else if (clas.equals("Rouge")) {
            ivFegyver.setVisibility(View.INVISIBLE);
            ivFegyver.setEnabled(false);
            ivFegyverEgykezes1.setVisibility(View.VISIBLE);
            ivFegyverEgykezes1.setEnabled(true);
            ivFegyverEgykezes2.setVisibility(View.VISIBLE);
            ivFegyverEgykezes2.setEnabled(true);
            tvFegyverLeiras.setVisibility(View.INVISIBLE);
            tvFegyverLeirasEgykezes1.setVisibility(View.VISIBLE);
            tvFegyverLeirasEgykezes2.setVisibility(View.VISIBLE);
            tvFegyverLeirasEgykezes1.setText("Arany: " + cash + "\nSebzés: " + ap + " --> " + (ap + 1)+"\nSzint: "+fegyverlvl+" --> "+(fegyverlvl+1));
            tvFegyverLeirasEgykezes2.setText("Sebzés: " + ap + " --> " + (ap + 1) + "\n Fejlesztés ára: " + upgradeCostFegyver+"\nSzint: "+fegyverlvl+" --> "+(fegyverlvl+1));
        }
        btnUppgrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fejlesztes();
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
        ivFegyverEgykezes1 = findViewById(R.id.ivFegyverEgykezes1);
        ivFegyverEgykezes2 = findViewById(R.id.ivFegyverEgykezes2);
        tvFegyverLeirasEgykezes1 = findViewById(R.id.tvFegyverLeirasEgykezes1);
        tvFegyverLeirasEgykezes2 = findViewById(R.id.tvFegyverLeirasEgykezes2);
    }
    public void fejlesztes(){
        if (cash>= upgradeCostFegyver){
            if (szakma.equals("Fegyverkovács")){
                if (clas.equals("Knight")){
                    ivFegyver.setVisibility(View.INVISIBLE);
                    ivFegyver.setEnabled(false);
                    ivFegyverEgykezes1.setVisibility(View.VISIBLE);
                    ivFegyverEgykezes1.setEnabled(true);
                    ivFegyverEgykezes2.setVisibility(View.VISIBLE);
                    ivFegyverEgykezes2.setEnabled(true);
                    ivFegyverEgykezes2.setImageResource(R.drawable.pajzs_hatter);
                    tvFegyverLeiras.setVisibility(View.INVISIBLE);
                    tvFegyverLeirasEgykezes1.setVisibility(View.VISIBLE);
                    tvFegyverLeirasEgykezes2.setVisibility(View.VISIBLE);
                    tvFegyverLeirasEgykezes1.setText("Arany: "+cash+"\nSebzés: "+ap+" --> "+(ap+1+"\nSzint: "+fegyverlvl+" --> "+(fegyverlvl+1)));
                    tvFegyverLeirasEgykezes2.setText("Armor: "+armor+" --> "+(armor+1)+"\n Fejlesztés ára: "+ upgradeCostFegyver+"\nSzint: "+pajzsLvl+" --> "+(pajzsLvl+1));

                    if (upgradeCostFegyver > 10){
                        cash -= upgradeCostFegyver;
                        as.updateCash(cash);
                        upgradeCostFegyver += (upgradeCostFegyver-1);
                        as.updateRowUpgradeCostFegyver(upgradeCostFegyver);
                    }else{
                        cash -= upgradeCostFegyver;
                        as.updateCash(cash);
                        upgradeCostFegyver += upgradeCostFegyver;
                        as.updateRowUpgradeCostFegyver(upgradeCostFegyver);
                    }
                            ap +=1;
                            as.updateRowAtackPowerh(ap);
                            fegyverlvl += 1;
                            pajzsLvl += 1;
                            as.updateRowFegyverLvl(fegyverlvl);
                            as.updateRowPajzsLvl(pajzsLvl);
                            as.updateRowArmor(armor);
                            tvFegyverLeirasEgykezes1.setText("Arany: "+cash+"\nSebzés: "+ap+" --> "+(ap+1)+"\nSzint: "+fegyverlvl+" --> "+(fegyverlvl+1));
                            tvFegyverLeirasEgykezes2.setText("Armor: "+armor+" --> "+(armor+1)+"\n Fejlesztés ára: "+ upgradeCostFegyver+"\nSzint: "+pajzsLvl+" --> "+(pajzsLvl+1));


                }else if (clas.equals("Warior")){
                    ivFegyver.setVisibility(View.VISIBLE);
                    ivFegyver.setEnabled(true);
                    ivFegyverEgykezes1.setVisibility(View.INVISIBLE);
                    ivFegyverEgykezes1.setEnabled(false);
                    ivFegyverEgykezes2.setVisibility(View.INVISIBLE);
                    ivFegyverEgykezes2.setEnabled(false);
                    tvFegyverLeiras.setVisibility(View.VISIBLE);
                    tvFegyverLeirasEgykezes1.setVisibility(View.INVISIBLE);
                    tvFegyverLeirasEgykezes2.setVisibility(View.INVISIBLE);
                    tvFegyverLeiras.setText("Arany: "+cash+"\nSebzés: "+ap+" --> "+(ap+1)+"\n Fejlesztés ára: "+ upgradeCostFegyver+"\nSzint: "+fegyverlvl+" --> "+(fegyverlvl+1));

                    if (upgradeCostFegyver > 10){
                        cash -= upgradeCostFegyver;
                        upgradeCostFegyver += (upgradeCostFegyver-1);
                        as.updateRowUpgradeCostFegyver(upgradeCostFegyver);
                    }else{
                        cash -= upgradeCostFegyver;
                        as.updateCash(cash);
                        upgradeCostFegyver += upgradeCostFegyver;
                        as.updateRowUpgradeCostFegyver(upgradeCostFegyver);
                    }
                            ap +=1;
                            as.updateRowAtackPowerh(ap);
                            fegyverlvl += 1;
                            as.updateRowFegyverLvl(fegyverlvl);
                            tvFegyverLeiras.setText("Arany: "+cash+"\nSebzés: "+ap+" --> "+(ap+1)+"\n Fejlesztés ára: "+ upgradeCostFegyver+"\nSzint: "+fegyverlvl+" --> "+(fegyverlvl+1));


                }else if (clas.equals("Hunter")){
                    ivFegyver.setVisibility(View.VISIBLE);
                    ivFegyver.setEnabled(true);
                    ivFegyver.setImageResource(R.drawable.bow);
                    ivFegyverEgykezes1.setVisibility(View.INVISIBLE);
                    ivFegyverEgykezes1.setEnabled(false);
                    ivFegyverEgykezes2.setVisibility(View.INVISIBLE);
                    ivFegyverEgykezes2.setEnabled(false);
                    tvFegyverLeiras.setVisibility(View.VISIBLE);
                    tvFegyverLeirasEgykezes1.setVisibility(View.INVISIBLE);
                    tvFegyverLeirasEgykezes2.setVisibility(View.INVISIBLE);
                    tvFegyverLeiras.setText("Arany: "+cash+"\nSebzés: "+ap+" --> "+(ap+1)+"\n Fejlesztés ára: "+ upgradeCostFegyver+"\nSzint: "+fegyverlvl+" --> "+(fegyverlvl+1));

                    if (upgradeCostFegyver > 10){
                        cash -= upgradeCostFegyver;
                        as.updateCash(cash);
                        upgradeCostFegyver += (upgradeCostFegyver-1);
                        as.updateRowUpgradeCostFegyver(upgradeCostFegyver);
                    }else{
                        cash -= upgradeCostFegyver;
                        as.updateCash(cash);
                        upgradeCostFegyver += upgradeCostFegyver;
                        as.updateRowUpgradeCostFegyver(upgradeCostFegyver);
                    }
                            ap +=1;
                            as.updateRowAtackPowerh(ap);
                            fegyverlvl += 1;
                            as.updateRowFegyverLvl(fegyverlvl);
                            tvFegyverLeiras.setText("Arany: "+cash+"\nSebzés: "+ap+" --> "+(ap+1)+"\n Fejlesztés ára: "+ upgradeCostFegyver+"\nSzint: "+fegyverlvl+" --> "+(fegyverlvl+1));


                }else if (clas.equals("Rouge")){
                    ivFegyver.setVisibility(View.INVISIBLE);
                    ivFegyver.setEnabled(false);
                    ivFegyverEgykezes1.setVisibility(View.VISIBLE);
                    ivFegyverEgykezes1.setEnabled(true);
                    ivFegyverEgykezes2.setVisibility(View.VISIBLE);
                    ivFegyverEgykezes2.setEnabled(true);
                    tvFegyverLeiras.setVisibility(View.INVISIBLE);
                    tvFegyverLeirasEgykezes1.setVisibility(View.VISIBLE);
                    tvFegyverLeirasEgykezes2.setVisibility(View.VISIBLE);
                    tvFegyverLeirasEgykezes1.setText("Arany: "+cash+"\nSebzés: "+ap+" --> "+(ap+1)+"\nSzint: "+fegyverlvl+" --> "+(fegyverlvl+1));
                    tvFegyverLeirasEgykezes2.setText("Sebzés: "+ap+" --> "+(ap+1)+"\n Fejlesztés ára: "+ upgradeCostFegyver+"\nSzint: "+fegyverlvl+" --> "+(fegyverlvl+1));

                    if (upgradeCostFegyver > 10){
                        cash -= upgradeCostFegyver;
                        as.updateCash(cash);
                        upgradeCostFegyver += (upgradeCostFegyver-1);
                        as.updateRowUpgradeCostFegyver(upgradeCostFegyver);
                    }else{
                        cash -= upgradeCostFegyver;
                        as.updateCash(cash);
                        upgradeCostFegyver += upgradeCostFegyver;
                        as.updateRowUpgradeCostFegyver(upgradeCostFegyver);
                    }
                            ap +=2;
                            as.updateRowAtackPowerh(ap);
                            fegyverlvl += 1;
                            as.updateRowFegyverLvl(fegyverlvl);
                            tvFegyverLeirasEgykezes1.setText("Arany: "+cash+"\nSebzés: "+ap+" --> "+(ap+1)+"\nSzint: "+fegyverlvl+" --> "+(fegyverlvl+1));
                            tvFegyverLeirasEgykezes2.setText("Sebzés: "+ap+" --> "+(ap+1)+"\n Fejlesztés ára: "+ upgradeCostFegyver+"\nSzint: "+fegyverlvl+" --> "+(fegyverlvl+1));

                }
            }else if (szakma.equals("Fegyver szakértő")){
                if (clas.equals("Knight")){
                    ivFegyver.setVisibility(View.INVISIBLE);
                    ivFegyver.setEnabled(false);
                    ivFegyverEgykezes1.setVisibility(View.VISIBLE);
                    ivFegyverEgykezes1.setEnabled(true);
                    ivFegyverEgykezes2.setVisibility(View.VISIBLE);
                    ivFegyverEgykezes2.setEnabled(true);
                    ivFegyverEgykezes2.setImageResource(R.drawable.pajzs_hatter);
                    tvFegyverLeiras.setVisibility(View.INVISIBLE);
                    tvFegyverLeirasEgykezes1.setVisibility(View.VISIBLE);
                    tvFegyverLeirasEgykezes2.setVisibility(View.VISIBLE);
                    tvFegyverLeirasEgykezes1.setText("Arany: "+cash+"\nSebzés: "+ap+" --> "+(ap+1)+"\nSzint: "+fegyverlvl+" --> "+(fegyverlvl+1));
                    tvFegyverLeirasEgykezes2.setText("Armor: "+armor+" --> "+(armor+1)+"\n Fejlesztés ára: "+ upgradeCostFegyver+"\nSzint: "+pajzsLvl+" --> "+(pajzsLvl+1));
                    cash -= upgradeCostFegyver;
                    as.updateCash(cash);
                    upgradeCostFegyver += upgradeCostFegyver;
                    as.updateRowUpgradeCostFegyver(upgradeCostFegyver);
                            ap +=2;
                            as.updateRowAtackPowerh(ap);
                            fegyverlvl += 1;
                            pajzsLvl += 1;
                            as.updateRowFegyverLvl(fegyverlvl);
                            as.updateRowPajzsLvl(pajzsLvl);
                    as.updateRowArmor(armor);
                            tvFegyverLeirasEgykezes1.setText("Arany: "+cash+"\nSebzés: "+ap+" --> "+(ap+1)+"\nSzint: "+fegyverlvl+" --> "+(fegyverlvl+1));
                            tvFegyverLeirasEgykezes2.setText("Armor: "+armor+" --> "+(armor+1)+"\n Fejlesztés ára: "+ upgradeCostFegyver+"\nSzint: "+pajzsLvl+" --> "+(pajzsLvl+1));

                }else if (clas.equals("Warior")){
                    ivFegyver.setVisibility(View.VISIBLE);
                    ivFegyver.setEnabled(true);
                    ivFegyverEgykezes1.setVisibility(View.INVISIBLE);
                    ivFegyverEgykezes1.setEnabled(false);
                    ivFegyverEgykezes2.setVisibility(View.INVISIBLE);
                    ivFegyverEgykezes2.setEnabled(false);
                    tvFegyverLeiras.setVisibility(View.VISIBLE);
                    tvFegyverLeirasEgykezes1.setVisibility(View.INVISIBLE);
                    tvFegyverLeirasEgykezes2.setVisibility(View.INVISIBLE);
                    tvFegyverLeiras.setText("Arany: "+cash+"\nSebzés: "+ap+" --> "+(ap+1)+"\n Fejlesztés ára: "+ upgradeCostFegyver+"\nSzint: "+fegyverlvl+" --> "+(fegyverlvl+1));
                    cash -= upgradeCostFegyver;
                    as.updateCash(cash);
                    upgradeCostFegyver += upgradeCostFegyver;
                    as.updateRowUpgradeCostFegyver(upgradeCostFegyver);
                            ap +=2;
                            as.updateRowAtackPowerh(ap);
                            fegyverlvl += 1;
                            as.updateRowFegyverLvl(fegyverlvl);

                            tvFegyverLeiras.setText("Arany: "+cash+"\nSebzés: "+ap+" --> "+(ap+1)+"\n Fejlesztés ára: "+ upgradeCostFegyver+"\nSzint: "+fegyverlvl+" --> "+(fegyverlvl+1));

                }else if (clas.equals("Hunter")){
                    ivFegyver.setVisibility(View.VISIBLE);
                    ivFegyver.setEnabled(true);
                    ivFegyver.setImageResource(R.drawable.bow);
                    ivFegyverEgykezes1.setVisibility(View.INVISIBLE);
                    ivFegyverEgykezes1.setEnabled(false);
                    ivFegyverEgykezes2.setVisibility(View.INVISIBLE);
                    ivFegyverEgykezes2.setEnabled(false);
                    tvFegyverLeiras.setVisibility(View.VISIBLE);
                    tvFegyverLeirasEgykezes1.setVisibility(View.INVISIBLE);
                    tvFegyverLeirasEgykezes2.setVisibility(View.INVISIBLE);
                    tvFegyverLeiras.setText("Arany: "+cash+"\nSebzés: "+ap+" --> "+(ap+1)+"\n Fejlesztés ára: "+ upgradeCostFegyver+"\nSzint: "+fegyverlvl+" --> "+(fegyverlvl+1));
                    cash -= upgradeCostFegyver;
                    as.updateCash(cash);
                    upgradeCostFegyver += upgradeCostFegyver;
                    as.updateRowUpgradeCostFegyver(upgradeCostFegyver);
                            ap +=2;
                            as.updateRowAtackPowerh(ap);
                            fegyverlvl += 1;
                            as.updateRowFegyverLvl(fegyverlvl);

                            tvFegyverLeiras.setText("Arany: "+cash+"\nSebzés: "+ap+" --> "+(ap+1)+"\n Fejlesztés ára: "+ upgradeCostFegyver+"\nSzint: "+fegyverlvl+" --> "+(fegyverlvl+1));

                }else if (clas.equals("Rouge")){
                    ivFegyver.setVisibility(View.INVISIBLE);
                    ivFegyver.setEnabled(false);
                    ivFegyverEgykezes1.setVisibility(View.VISIBLE);
                    ivFegyverEgykezes1.setEnabled(true);
                    ivFegyverEgykezes2.setVisibility(View.VISIBLE);
                    ivFegyverEgykezes2.setEnabled(true);
                    tvFegyverLeiras.setVisibility(View.INVISIBLE);
                    tvFegyverLeirasEgykezes1.setVisibility(View.VISIBLE);
                    tvFegyverLeirasEgykezes2.setVisibility(View.VISIBLE);
                    tvFegyverLeirasEgykezes1.setText("Arany: "+cash+"\nSebzés: "+ap+" --> "+(ap+1)+"\nSzint: "+fegyverlvl+" --> "+(fegyverlvl+1));
                    tvFegyverLeirasEgykezes2.setText("Sebzés: "+ap+" --> "+(ap+1)+"\n Fejlesztés ára: "+ upgradeCostFegyver+"\nSzint: "+fegyverlvl+" --> "+(fegyverlvl+1));
                    cash -= upgradeCostFegyver;
                    as.updateCash(cash);
                    upgradeCostFegyver += upgradeCostFegyver;
                    as.updateRowUpgradeCostFegyver(upgradeCostFegyver);
                            ap +=4;
                            as.updateRowAtackPowerh(ap);
                            fegyverlvl += 1;
                            as.updateRowFegyverLvl(fegyverlvl);

                            tvFegyverLeirasEgykezes1.setText("Arany: "+cash+"\nSebzés: "+ap+" --> "+(ap+1)+"\nSzint: "+fegyverlvl+" --> "+(fegyverlvl+1));
                            tvFegyverLeirasEgykezes2.setText("Sebzés: "+ap+" --> "+(ap+1)+"\n Fejlesztés ára: "+ upgradeCostFegyver+"\nSzint: "+fegyverlvl+" --> "+(fegyverlvl+1));

                }
            }else{
                if (clas.equals("Knight")){
                    ivFegyver.setVisibility(View.INVISIBLE);
                    ivFegyver.setEnabled(false);
                    ivFegyverEgykezes1.setVisibility(View.VISIBLE);
                    ivFegyverEgykezes1.setEnabled(true);
                    ivFegyverEgykezes2.setVisibility(View.VISIBLE);
                    ivFegyverEgykezes2.setEnabled(true);
                    ivFegyverEgykezes2.setImageResource(R.drawable.pajzs_hatter);
                    tvFegyverLeiras.setVisibility(View.INVISIBLE);
                    tvFegyverLeirasEgykezes1.setVisibility(View.VISIBLE);
                    tvFegyverLeirasEgykezes2.setVisibility(View.VISIBLE);
                    tvFegyverLeirasEgykezes1.setText("Arany: "+cash+"\nSebzés: "+ap+" --> "+(ap+1)+"\nSzint: "+fegyverlvl+" --> "+(fegyverlvl+1));
                    tvFegyverLeirasEgykezes2.setText("Armor: "+armor+" --> "+(armor+1)+"\n Fejlesztés ára: "+ upgradeCostFegyver+"\nSzint: "+pajzsLvl+" --> "+(pajzsLvl+1));
                    cash -= upgradeCostFegyver;
                    as.updateCash(cash);
                    upgradeCostFegyver += upgradeCostFegyver;
                    as.updateRowUpgradeCostFegyver(upgradeCostFegyver);
                            ap +=1;
                            as.updateRowAtackPowerh(ap);
                            fegyverlvl += 1;
                            pajzsLvl += 1;
                            as.updateRowFegyverLvl(fegyverlvl);
                            as.updateRowPajzsLvl(pajzsLvl);
                    as.updateRowArmor(armor);
                            tvFegyverLeirasEgykezes1.setText("Arany: "+cash+"\nSebzés: "+ap+" --> "+(ap+1)+"\nSzint: "+fegyverlvl+" --> "+(fegyverlvl+1));
                            tvFegyverLeirasEgykezes2.setText("Armor: "+armor+" --> "+(armor+1)+"\n Fejlesztés ára: "+ upgradeCostFegyver+"\nSzint: "+pajzsLvl+" --> "+(pajzsLvl+1));

                }else if (clas.equals("Warior")){
                    ivFegyver.setVisibility(View.VISIBLE);
                    ivFegyver.setEnabled(true);
                    ivFegyverEgykezes1.setVisibility(View.INVISIBLE);
                    ivFegyverEgykezes1.setEnabled(false);
                    ivFegyverEgykezes2.setVisibility(View.INVISIBLE);
                    ivFegyverEgykezes2.setEnabled(false);
                    tvFegyverLeiras.setVisibility(View.VISIBLE);
                    tvFegyverLeirasEgykezes1.setVisibility(View.INVISIBLE);
                    tvFegyverLeirasEgykezes2.setVisibility(View.INVISIBLE);
                    tvFegyverLeiras.setText("Arany: "+cash+"\nSebzés: "+ap+" --> "+(ap+1)+"\n Fejlesztés ára: "+ upgradeCostFegyver+"\nSzint: "+fegyverlvl+" --> "+(fegyverlvl+1));
                    cash -= upgradeCostFegyver;
                    as.updateCash(cash);
                    upgradeCostFegyver += upgradeCostFegyver;
                    as.updateRowUpgradeCostFegyver(upgradeCostFegyver);
                            ap +=1;
                            as.updateRowAtackPowerh(ap);
                            fegyverlvl += 1;
                            as.updateRowFegyverLvl(fegyverlvl);

                            tvFegyverLeiras.setText("Arany: "+cash+"\nSebzés: "+ap+" --> "+(ap+1)+"\n Fejlesztés ára: "+ upgradeCostFegyver+"\nSzint: "+fegyverlvl+" --> "+(fegyverlvl+1));

                }else if (clas.equals("Hunter")){
                    ivFegyver.setVisibility(View.VISIBLE);
                    ivFegyver.setEnabled(true);
                    ivFegyver.setImageResource(R.drawable.bow);
                    ivFegyverEgykezes1.setVisibility(View.INVISIBLE);
                    ivFegyverEgykezes1.setEnabled(false);
                    ivFegyverEgykezes2.setVisibility(View.INVISIBLE);
                    ivFegyverEgykezes2.setEnabled(false);
                    tvFegyverLeiras.setVisibility(View.VISIBLE);
                    tvFegyverLeirasEgykezes1.setVisibility(View.INVISIBLE);
                    tvFegyverLeirasEgykezes2.setVisibility(View.INVISIBLE);
                    tvFegyverLeiras.setText("Arany: "+cash+"\nSebzés: "+ap+" --> "+(ap+1)+"\n Fejlesztés ára: "+ upgradeCostFegyver+"\nSzint: "+fegyverlvl+" --> "+(fegyverlvl+1));
                    cash -= upgradeCostFegyver;
                    as.updateCash(cash);
                    upgradeCostFegyver += upgradeCostFegyver;
                    as.updateRowUpgradeCostFegyver(upgradeCostFegyver);
                            ap +=1;
                            as.updateRowAtackPowerh(ap);
                            fegyverlvl += 1;
                            as.updateRowFegyverLvl(fegyverlvl);

                            tvFegyverLeiras.setText("Arany: "+cash+"\nSebzés: "+ap+" --> "+(ap+1)+"\n Fejlesztés ára: "+ upgradeCostFegyver+"\nSzint: "+fegyverlvl+" --> "+(fegyverlvl+1));

                }else if (clas.equals("Rouge")){
                    ivFegyver.setVisibility(View.INVISIBLE);
                    ivFegyver.setEnabled(false);
                    ivFegyverEgykezes1.setVisibility(View.VISIBLE);
                    ivFegyverEgykezes1.setEnabled(true);
                    ivFegyverEgykezes2.setVisibility(View.VISIBLE);
                    ivFegyverEgykezes2.setEnabled(true);
                    tvFegyverLeiras.setVisibility(View.INVISIBLE);
                    tvFegyverLeirasEgykezes1.setVisibility(View.VISIBLE);
                    tvFegyverLeirasEgykezes2.setVisibility(View.VISIBLE);
                    tvFegyverLeirasEgykezes1.setText("Arany: "+cash+"\nSebzés: "+ap+" --> "+(ap+1)+"\nSzint: "+fegyverlvl+" --> "+(fegyverlvl+1));
                    tvFegyverLeirasEgykezes2.setText("Sebzés: "+ap+" --> "+(ap+1)+"\n Fejlesztés ára: "+ upgradeCostFegyver+"\nSzint: "+fegyverlvl+" --> "+(fegyverlvl+1));
                    cash -= upgradeCostFegyver;
                    as.updateCash(cash);
                    upgradeCostFegyver += upgradeCostFegyver;
                    as.updateRowUpgradeCostFegyver(upgradeCostFegyver);
                            ap +=2;
                            as.updateRowAtackPowerh(ap);
                            fegyverlvl += 1;
                            as.updateRowFegyverLvl(fegyverlvl);
                            tvFegyverLeirasEgykezes1.setText("Arany: "+cash+"\nSebzés: "+ap+" --> "+(ap+1)+"\nSzint: "+fegyverlvl+" --> "+(fegyverlvl+1));
                            tvFegyverLeirasEgykezes2.setText("Sebzés: "+ap+" --> "+(ap+1)+"\n Fejlesztés ára: "+ upgradeCostFegyver+"\nSzint: "+fegyverlvl+" --> "+(fegyverlvl+1));

                }
            }

        }else{
            if (clas.equals("Knight")){
                ivFegyver.setVisibility(View.INVISIBLE);
                ivFegyver.setEnabled(false);
                ivFegyverEgykezes1.setVisibility(View.VISIBLE);
                ivFegyverEgykezes1.setEnabled(true);
                ivFegyverEgykezes2.setVisibility(View.VISIBLE);
                ivFegyverEgykezes2.setEnabled(true);
                ivFegyverEgykezes2.setImageResource(R.drawable.pajzs_hatter);
                tvFegyverLeiras.setVisibility(View.INVISIBLE);
                tvFegyverLeirasEgykezes1.setVisibility(View.VISIBLE);
                tvFegyverLeirasEgykezes2.setVisibility(View.VISIBLE);
                tvFegyverLeirasEgykezes1.setText("Arany: "+cash+"\nSebzés: "+ap+" --> "+(ap+1)+"\nSzint: "+fegyverlvl+" --> "+(fegyverlvl+1));
                tvFegyverLeirasEgykezes2.setText("Armor: "+armor+" --> "+(armor+1)+"\n Fejlesztés ára: "+ upgradeCostFegyver+"\nSzint: "+pajzsLvl+" --> "+(pajzsLvl+1));
            }else if (clas.equals("Warior")){
                ivFegyver.setVisibility(View.VISIBLE);
                ivFegyver.setEnabled(true);
                ivFegyverEgykezes1.setVisibility(View.INVISIBLE);
                ivFegyverEgykezes1.setEnabled(false);
                ivFegyverEgykezes2.setVisibility(View.INVISIBLE);
                ivFegyverEgykezes2.setEnabled(false);
                tvFegyverLeiras.setVisibility(View.VISIBLE);
                tvFegyverLeirasEgykezes1.setVisibility(View.INVISIBLE);
                tvFegyverLeirasEgykezes2.setVisibility(View.INVISIBLE);
                tvFegyverLeiras.setText("Arany: "+cash+"\nSebzés: "+ap+" --> "+(ap+1)+"\n Fejlesztés ára: "+ upgradeCostFegyver+"\nSzint: "+fegyverlvl+" --> "+(fegyverlvl+1));
            }else if (clas.equals("Hunter")){
                ivFegyver.setVisibility(View.VISIBLE);
                ivFegyver.setEnabled(true);
                ivFegyver.setImageResource(R.drawable.bow);
                ivFegyverEgykezes1.setVisibility(View.INVISIBLE);
                ivFegyverEgykezes1.setEnabled(false);
                ivFegyverEgykezes2.setVisibility(View.INVISIBLE);
                ivFegyverEgykezes2.setEnabled(false);
                tvFegyverLeiras.setVisibility(View.VISIBLE);
                tvFegyverLeirasEgykezes1.setVisibility(View.INVISIBLE);
                tvFegyverLeirasEgykezes2.setVisibility(View.INVISIBLE);
                tvFegyverLeiras.setText("Arany: "+cash+"\nSebzés: "+ap+" --> "+(ap+1)+"\n Fejlesztés ára: "+ upgradeCostFegyver+"\nSzint: "+fegyverlvl+" --> "+(fegyverlvl+1));
            }else if (clas.equals("Rouge")) {
                ivFegyver.setVisibility(View.INVISIBLE);
                ivFegyver.setEnabled(false);
                ivFegyverEgykezes1.setVisibility(View.VISIBLE);
                ivFegyverEgykezes1.setEnabled(true);
                ivFegyverEgykezes2.setVisibility(View.VISIBLE);
                ivFegyverEgykezes2.setEnabled(true);
                tvFegyverLeiras.setVisibility(View.INVISIBLE);
                tvFegyverLeirasEgykezes1.setVisibility(View.VISIBLE);
                tvFegyverLeirasEgykezes2.setVisibility(View.VISIBLE);
                tvFegyverLeirasEgykezes1.setText("Arany: " + cash + "\nSebzés: " + ap + " --> " + (ap + 1)+"\nSzint: "+fegyverlvl+" --> "+(fegyverlvl+1));
                tvFegyverLeirasEgykezes2.setText("Sebzés: " + ap + " --> " + (ap + 1) + "\n Fejlesztés ára: " + upgradeCostFegyver+"\nSzint: "+fegyverlvl+" --> "+(fegyverlvl+1));
            }

                    Toast.makeText(ShopFegyver.this, "Nem lehet fejleszteni, nincs hozzá elég pénzed!", Toast.LENGTH_SHORT).show();


        }
    }
    public void AdatLekeres(Cursor cursor) {
        if (cursor.moveToFirst()) {
            szakma = cursor.getString(2);
            armor = cursor.getInt(7);
            ap = cursor.getInt(11);
            clas = cursor.getString(12);
            cash = cursor.getInt(13);
            fegyverlvl = cursor.getInt(17);
            pajzsLvl = cursor.getInt(18);
            upgradeCostFegyver = cursor.getInt(23);
            cursor.close();
        }
    }
}
