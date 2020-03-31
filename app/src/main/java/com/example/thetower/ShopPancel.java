package com.example.thetower;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ShopPancel extends AppCompatActivity {
    ImageView ivASPSisak, ivASPVert, ivASPGatya, ivASPCipo;
    TextView tvASPSisakLeiras,tvASPVertLeiras, tvASPGatyaLeiras, tvASPCipoLeiras;
    Button btnASPSisak, btnASPVert, btnASPGatya, btnASPCipo;
    AdatbazisSegito as = new AdatbazisSegito(this);
    int cash,armor,fejesArmor,vertArmor,gatyaArmor,cipoArmor, fejesLvl,chestLvl,gatyaLvl,cipoLvl, upgradeCostSisak, upgradeCostVert, upgradeCostGatya, upgradeCostCipo;
    private String szakma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_pancel);
        init();
        Cursor cursor = as.getRow(1);
        as.open();
        AdatLekeres(cursor);

            fejesArmor = fejesLvl;
            vertArmor = chestLvl;
            gatyaArmor = gatyaLvl;
            cipoArmor = cipoLvl;


        tvASPSisakLeiras.setText("Arany: "+cash+"\nArmor: "+fejesArmor+" --> "+(fejesArmor+1)+"\nSzint: "+fejesLvl+" --> "+(fejesLvl+1)+"\n Fejlesztés ára: "+ upgradeCostSisak);
        tvASPVertLeiras.setText("Arany: "+cash+"\nArmor: "+vertArmor+" --> "+(vertArmor+1)+"\nSzint: "+chestLvl+" --> "+(chestLvl+1)+"\n Fejlesztés ára: "+ upgradeCostVert);
        tvASPGatyaLeiras.setText("Arany: "+cash+"\nArmor: "+gatyaArmor+" --> "+(gatyaArmor+1)+"\nSzint: "+gatyaLvl+" --> "+(gatyaLvl+1)+"\n Fejlesztés ára: "+ upgradeCostGatya);
        tvASPCipoLeiras.setText("Arany: "+cash+"\nArmor: "+cipoArmor+" --> "+(cipoArmor+1)+"\nSzint: "+cipoLvl+" --> "+(cipoLvl+1)+"\n Fejlesztés ára: "+ upgradeCostCipo);

        btnASPSisak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpgradeSisak();
            }
        });
        btnASPVert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpgradeVert();
            }
        });
        btnASPGatya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpgradeGatya();
            }
        });
        btnASPCipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpgradeCipo();
            }
        });
    }
    public void init(){
        ivASPSisak = findViewById(R.id.ivASPSisak);
        ivASPVert = findViewById(R.id.ivASPVert);
        ivASPGatya = findViewById(R.id.ivASPGatya);
        ivASPCipo = findViewById(R.id.ivASPCipo);
        tvASPSisakLeiras = findViewById(R.id.tvASPSisakLeiras);
        tvASPVertLeiras = findViewById(R.id.tvASPVertLeiras);
        tvASPGatyaLeiras = findViewById(R.id.tvASPGatyaLeiras);
        tvASPCipoLeiras = findViewById(R.id.tvASPCipoLeiras);
        btnASPSisak = findViewById(R.id.btnASPSisak);
        btnASPVert = findViewById(R.id.btnASPVert);
        btnASPGatya = findViewById(R.id.btnASPGatya);
        btnASPCipo = findViewById(R.id.btnASPCipo);
    }
    public void AdatLekeres(Cursor cursor) {
        if (cursor.moveToFirst()) {
            szakma = cursor.getString(2);
            armor = cursor.getInt(7);
            cash = cursor.getInt(13);
            fejesLvl = cursor.getInt(17);
            chestLvl = cursor.getInt(18);
            gatyaLvl = cursor.getInt(19);
            cipoLvl = cursor.getInt(20);
            upgradeCostSisak = cursor.getInt(22);
            upgradeCostVert = cursor.getInt(23);
            upgradeCostGatya = cursor.getInt(24);
            upgradeCostCipo = cursor.getInt(25);
            cursor.close();
        }
    }
    public void UpgradeSisak(){
        fejesArmor = fejesLvl;
        if (cash >= upgradeCostSisak){
            if (szakma.equals("Páncél kovács")){
                if (upgradeCostSisak > 10){
                    cash -= upgradeCostSisak;
                    as.updateCash(cash);
                    upgradeCostSisak += (upgradeCostSisak-1);
                    as.updateRowUpgradeCostSisak(upgradeCostSisak);
                }else{
                    cash -= upgradeCostSisak;
                    as.updateCash(cash);
                    upgradeCostSisak += upgradeCostSisak;
                    as.updateRowUpgradeCostSisak(upgradeCostSisak);
                }
                armor +=1;
                as.updateRowArmor(armor);
                fejesLvl += 1;
                as.updateRowFejes(fejesLvl);
                tvASPSisakLeiras.setText("Arany: "+cash+"\nArmor: "+fejesArmor+" --> "+(fejesArmor+1)+"\nSzint: "+fejesLvl+" --> "+(fejesLvl+1)+"\n Fejlesztés ára: "+ upgradeCostSisak);
            }else if (szakma.equals("Páncél szakértő")){
                cash -= upgradeCostSisak;
                as.updateCash(cash);
                upgradeCostSisak += upgradeCostSisak;
                as.updateRowUpgradeCostSisak(upgradeCostSisak);
                armor +=2;
                as.updateRowArmor(armor);
                fejesLvl += 1;
                as.updateRowFejes(fejesLvl);
                tvASPSisakLeiras.setText("Arany: "+cash+"\nArmor: "+fejesArmor+" --> "+(fejesArmor+1)+"\nSzint: "+fejesLvl+" --> "+(fejesLvl+1)+"\n Fejlesztés ára: "+ upgradeCostSisak);
        }else{
                cash -= upgradeCostSisak;
                as.updateCash(cash);
                upgradeCostSisak += upgradeCostSisak;
                as.updateRowUpgradeCostSisak(upgradeCostSisak);
                armor +=1;
                as.updateRowArmor(armor);
                fejesLvl += 1;
                as.updateRowFejes(fejesLvl);
                tvASPSisakLeiras.setText("Arany: "+cash+"\nArmor: "+fejesArmor+" --> "+(fejesArmor+1)+"\nSzint: "+fejesLvl+" --> "+(fejesLvl+1)+"\n Fejlesztés ára: "+ upgradeCostSisak);
            }
        }else{
            Toast.makeText(ShopPancel.this, "Nem lehet fejleszteni, nincs hozzá elég pénzed!", Toast.LENGTH_SHORT).show();
        }
    }
    public void UpgradeVert(){
        vertArmor = chestLvl;
        if (cash >= upgradeCostVert){
            if (szakma.equals("Páncél kovács")){
                if (upgradeCostVert > 10){
                    cash -= upgradeCostVert;
                    as.updateCash(cash);
                    upgradeCostVert += (upgradeCostVert-1);
                    as.updateRowUpgradeCostVert(upgradeCostVert);
                }else{
                    cash -= upgradeCostVert;
                    as.updateCash(cash);
                    upgradeCostVert += upgradeCostVert;
                    as.updateRowUpgradeCostVert(upgradeCostVert);
                }
                armor +=1;
                as.updateRowArmor(armor);
                fejesLvl += 1;
                as.updateRowFejes(fejesLvl);
                tvASPSisakLeiras.setText("Arany: "+cash+"\nArmor: "+vertArmor+" --> "+(vertArmor+1)+"\nSzint: "+chestLvl+" --> "+(chestLvl+1)+"\n Fejlesztés ára: "+ upgradeCostVert);
            }else if (szakma.equals("Páncél szakértő")){
                cash -= upgradeCostVert;
                as.updateCash(cash);
                upgradeCostVert += upgradeCostVert;
                as.updateRowUpgradeCostVert(upgradeCostVert);
                armor +=2;
                as.updateRowArmor(armor);
                fejesLvl += 1;
                as.updateRowFejes(fejesLvl);
                tvASPSisakLeiras.setText("Arany: "+cash+"\nArmor: "+vertArmor+" --> "+(vertArmor+1)+"\nSzint: "+chestLvl+" --> "+(chestLvl+1)+"\n Fejlesztés ára: "+ upgradeCostVert);
            }else{
                cash -= upgradeCostVert;
                as.updateCash(cash);
                upgradeCostVert += upgradeCostVert;
                as.updateRowUpgradeCostVert(upgradeCostVert);
                armor +=1;
                as.updateRowArmor(armor);
                fejesLvl += 1;
                as.updateRowFejes(fejesLvl);
                tvASPSisakLeiras.setText("Arany: "+cash+"\nArmor: "+vertArmor+" --> "+(vertArmor+1)+"\nSzint: "+chestLvl+" --> "+(chestLvl+1)+"\n Fejlesztés ára: "+ upgradeCostVert);
            }
        }else{
            Toast.makeText(ShopPancel.this, "Nem lehet fejleszteni, nincs hozzá elég pénzed!", Toast.LENGTH_SHORT).show();
        }
    }
    public void UpgradeGatya(){
        gatyaArmor = gatyaLvl;
        if (cash >= upgradeCostGatya){
            if (szakma.equals("Páncél kovács")){
                if (upgradeCostGatya > 10){
                    cash -= upgradeCostGatya;
                    as.updateCash(cash);
                    upgradeCostGatya += (upgradeCostGatya-1);
                    as.updateRowUpgradeCostGatya(upgradeCostGatya);
                }else{
                    cash -= upgradeCostGatya;
                    as.updateCash(cash);
                    upgradeCostGatya += upgradeCostGatya;
                    as.updateRowUpgradeCostGatya(upgradeCostGatya);
                }
                armor +=1;
                as.updateRowArmor(armor);
                gatyaLvl += 1;
                as.updateRowFejes(gatyaLvl);
                tvASPSisakLeiras.setText("Arany: "+cash+"\nArmor: "+gatyaArmor+" --> "+(gatyaArmor+1)+"\nSzint: "+gatyaLvl+" --> "+(gatyaLvl+1)+"\n Fejlesztés ára: "+ upgradeCostGatya);
            }else if (szakma.equals("Páncél szakértő")){
                cash -= upgradeCostGatya;
                as.updateCash(cash);
                upgradeCostGatya += upgradeCostGatya;
                as.updateRowUpgradeCostGatya(upgradeCostGatya);
                armor +=2;
                as.updateRowArmor(armor);
                gatyaLvl += 1;
                as.updateRowFejes(gatyaLvl);
                tvASPSisakLeiras.setText("Arany: "+cash+"\nArmor: "+gatyaArmor+" --> "+(gatyaArmor+1)+"\nSzint: "+gatyaLvl+" --> "+(gatyaLvl+1)+"\n Fejlesztés ára: "+ upgradeCostGatya);
            }else{
                cash -= upgradeCostGatya;
                as.updateCash(cash);
                upgradeCostGatya += upgradeCostGatya;
                as.updateRowUpgradeCostGatya(upgradeCostGatya);
                armor +=1;
                as.updateRowArmor(armor);
                gatyaLvl += 1;
                as.updateRowFejes(gatyaLvl);
                tvASPSisakLeiras.setText("Arany: "+cash+"\nArmor: "+gatyaArmor+" --> "+(gatyaArmor+1)+"\nSzint: "+gatyaLvl+" --> "+(gatyaLvl+1)+"\n Fejlesztés ára: "+ upgradeCostGatya);
            }
        }else{
            Toast.makeText(ShopPancel.this, "Nem lehet fejleszteni, nincs hozzá elég pénzed!", Toast.LENGTH_SHORT).show();
        }
    }
    public void UpgradeCipo(){
        cipoArmor = cipoLvl;
        if (cash >= upgradeCostCipo){
            if (szakma.equals("Páncél kovács")){
                if (upgradeCostCipo > 10){
                    cash -= upgradeCostCipo;
                    as.updateCash(cash);
                    upgradeCostCipo += (upgradeCostCipo-1);
                    as.updateRowUpgradeCostCipo(upgradeCostCipo);
                }else{
                    cash -= upgradeCostCipo;
                    as.updateCash(cash);
                    upgradeCostCipo += upgradeCostCipo;
                    as.updateRowUpgradeCostCipo(upgradeCostCipo);
                }
                armor +=1;
                as.updateRowArmor(armor);
                cipoLvl += 1;
                as.updateRowCipo(cipoLvl);
                tvASPGatyaLeiras.setText("Arany: "+cash+"\nArmor: "+cipoArmor+" --> "+(cipoArmor+1)+"\nSzint: "+cipoLvl+" --> "+(cipoLvl+1)+"\n Fejlesztés ára: "+ upgradeCostCipo);
            }else if (szakma.equals("Páncél szakértő")){
                cash -= upgradeCostCipo;
                as.updateCash(cash);
                upgradeCostCipo += upgradeCostCipo;
                as.updateRowUpgradeCostCipo(upgradeCostCipo);
                armor +=2;
                as.updateRowArmor(armor);
                cipoLvl += 1;
                as.updateRowCipo(cipoLvl);
                tvASPGatyaLeiras.setText("Arany: "+cash+"\nArmor: "+cipoArmor+" --> "+(cipoArmor+1)+"\nSzint: "+cipoLvl+" --> "+(cipoLvl+1)+"\n Fejlesztés ára: "+ upgradeCostCipo);
            }else{
                cash -= upgradeCostCipo;
                as.updateCash(cash);
                upgradeCostCipo += upgradeCostCipo;
                as.updateRowUpgradeCostCipo(upgradeCostCipo);
                armor +=1;
                as.updateRowArmor(armor);
                cipoLvl += 1;
                as.updateRowCipo(cipoLvl);
                tvASPGatyaLeiras.setText("Arany: "+cash+"\nArmor: "+cipoArmor+" --> "+(cipoArmor+1)+"\nSzint: "+cipoLvl+" --> "+(cipoLvl+1)+"\n Fejlesztés ára: "+ upgradeCostCipo);
            }
        }else{
            Toast.makeText(ShopPancel.this, "Nem lehet fejleszteni, nincs hozzá elég pénzed!", Toast.LENGTH_SHORT).show();
        }
    }
}
