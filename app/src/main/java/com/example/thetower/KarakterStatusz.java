package com.example.thetower;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class KarakterStatusz extends AppCompatActivity {
    AdatbazisSegito as = new AdatbazisSegito(this);
    private int stamina,strength,agility,armor, enableStatusPoints,deffense, atackPower, cash, level, exp, kardlvl, pajzslvl, fejeslvl, chestlvl, gatyalvl, cipolvl;
    private String name,szakma, clas;
    private double crit,lifepoint;
    ImageView ivKSCharacterPortre,ivKSSisak,ivKSChest,ivKSNadrag,ivKSCsizma,ivKSKard,ivKSPajzs;
    Button btnKSStaminaDown,btnKSStaminaUp,btnKSStrengthDown, btnKSStrengthUp, btnKSDeffenseDown, btnKSDeffenseUp, btnKSAgilityDown, btnKSAgilityUp;
    EditText etKSStamina, etKSStrength, etKSDeffense, etKSAgility;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_karakter_statusz);
        init();
        Cursor cursor = as.getRow(1);
        as.open();
        AdatLekeres(cursor);
        if (clas.equals("Knight")){
            ivKSCharacterPortre.setImageResource(R.drawable.knight);
        }else
        if (clas.equals("Warrior")){
            ivKSCharacterPortre.setImageResource(R.drawable.warrior);
        }else
        if (clas.equals("Hunter")){
            ivKSCharacterPortre.setImageResource(R.drawable.hunter);
        }else
        if (clas.equals("Rouge")){
            ivKSCharacterPortre.setImageResource(R.drawable.rouge);
        }
        if (exp>=20) {
            as.updateLvL(level + 1);
            as.updateEXP(0);
            as.updateEnableStatuszPoint(enableStatusPoints+1);
        }

        if (enableStatusPoints>0){
            btnKSStaminaDown.setEnabled(true);
            btnKSStaminaDown.setVisibility(View.VISIBLE);
            btnKSStaminaUp.setEnabled(true);
            btnKSStaminaUp.setVisibility(View.VISIBLE);
            btnKSStrengthDown.setEnabled(true);
            btnKSStrengthDown.setVisibility(View.VISIBLE);
            btnKSStrengthUp.setEnabled(true);
            btnKSStrengthUp.setVisibility(View.VISIBLE);
            btnKSDeffenseDown.setEnabled(true);
            btnKSDeffenseDown.setVisibility(View.VISIBLE);
            btnKSDeffenseUp.setEnabled(true);
            btnKSDeffenseUp.setVisibility(View.VISIBLE);
            btnKSAgilityDown.setEnabled(true);
            btnKSAgilityDown.setVisibility(View.VISIBLE);
            btnKSAgilityUp.setEnabled(true);
            btnKSAgilityUp.setVisibility(View.VISIBLE);
        }else{
            btnKSStaminaDown.setEnabled(false);
            btnKSStaminaDown.setVisibility(View.INVISIBLE);
            btnKSStaminaUp.setEnabled(false);
            btnKSStaminaUp.setVisibility(View.INVISIBLE);
            btnKSStrengthDown.setEnabled(false);
            btnKSStrengthDown.setVisibility(View.INVISIBLE);
            btnKSStrengthUp.setEnabled(false);
            btnKSStrengthUp.setVisibility(View.INVISIBLE);
            btnKSDeffenseDown.setEnabled(false);
            btnKSDeffenseDown.setVisibility(View.INVISIBLE);
            btnKSDeffenseUp.setEnabled(false);
            btnKSDeffenseUp.setVisibility(View.INVISIBLE);
            btnKSAgilityDown.setEnabled(false);
            btnKSAgilityDown.setVisibility(View.INVISIBLE);
            btnKSAgilityUp.setEnabled(false);
            btnKSAgilityUp.setVisibility(View.INVISIBLE);
        }
        etKSStamina.setText("Stamina: "+stamina);
        etKSStrength.setText("Strenght: "+strength);
        etKSDeffense.setText("Deffence: "+deffense);
        etKSAgility.setText("Agility: "+agility);
        btnKSStaminaDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stamina--;
                as.updateStamina(stamina);
                etKSStamina.setText("Stamina: "+stamina);
                as.updateEnableStatuszPoint(enableStatusPoints+1);
            }
        });
        btnKSStaminaUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stamina++;
                as.updateStamina(stamina);
                etKSStamina.setText("Stamina: "+stamina);
                as.updateEnableStatuszPoint(enableStatusPoints-1);
            }
        });
        btnKSStrengthDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strength--;
                as.updateStrength(strength);
                etKSStrength.setText("Strenght: "+strength);
                as.updateEnableStatuszPoint(enableStatusPoints+1);
            }
        });
        btnKSStrengthUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strength++;
                as.updateStrength(strength);
                etKSStrength.setText("Strenght: "+strength);
                as.updateEnableStatuszPoint(enableStatusPoints-1);
            }
        });
        btnKSDeffenseDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deffense--;
                as.updateDeffense(deffense);
                etKSDeffense.setText("Deffence: "+deffense);
                as.updateEnableStatuszPoint(enableStatusPoints+1);
            }
        });
        btnKSDeffenseUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deffense++;
                as.updateDeffense(deffense);
                etKSDeffense.setText("Deffence: "+deffense);
                as.updateEnableStatuszPoint(enableStatusPoints-1);
            }
        });
        btnKSAgilityDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agility--;
                as.updateAgility(agility);
                etKSAgility.setText("Agility: "+agility);
                as.updateEnableStatuszPoint(enableStatusPoints+1);
            }
        });
        btnKSAgilityUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agility++;
                as.updateAgility(agility);
                etKSAgility.setText("Agility: "+agility);
                as.updateEnableStatuszPoint(enableStatusPoints-1);
            }
        });

    }

    private void init() {
        ivKSCharacterPortre = findViewById(R.id.ivKSCharacterPortre);
        ivKSSisak = findViewById(R.id.ivKSSisak);
        ivKSChest = findViewById(R.id.ivKSChest);
        ivKSNadrag = findViewById(R.id.ivKSNadrag);
        ivKSCsizma = findViewById(R.id.ivKSCsizma);
        ivKSKard = findViewById(R.id.ivKSKard);
        ivKSPajzs = findViewById(R.id.ivKSPajzs);
        btnKSStrengthDown = findViewById(R.id.btnKSStrengthDown);
        btnKSStrengthUp = findViewById(R.id.btnKSStrengthUp);
        btnKSStaminaDown = findViewById(R.id.btnKSStaminaDown);
        btnKSStaminaUp = findViewById(R.id.btnKSStaminaUp);
        btnKSAgilityDown = findViewById(R.id.btnKSAgilityDown);
        btnKSAgilityUp = findViewById(R.id.btnKSAgilityUp);
        btnKSDeffenseDown = findViewById(R.id.btnKSDeffenseDown);
        btnKSDeffenseUp = findViewById(R.id.btnKSDeffenseUp);
        etKSStamina = findViewById(R.id.etKSStamina);
        etKSStrength = findViewById(R.id.etKSStrength);
        etKSDeffense = findViewById(R.id.etKSDeffense);
        etKSAgility = findViewById(R.id.etKSAgility);



    }

    public void AdatLekeres(Cursor cursor){
        if (cursor.moveToFirst()){
            name =  cursor.getString(1);
            szakma = cursor.getString(2);
            stamina = cursor.getInt(3);
            strength = cursor.getInt(4);
            deffense = cursor.getInt(5);
            agility = cursor.getInt(6);
            armor = cursor.getInt(7);
            lifepoint = cursor.getDouble(8);
            enableStatusPoints = cursor.getInt(9);
            atackPower = cursor.getInt(10);
            exp = cursor.getInt(11);
            clas = cursor.getString(12);
            cash = cursor.getInt(13);
            level = cursor.getInt(14);
            kardlvl = cursor.getInt(15);
            pajzslvl = cursor.getInt(16);
            fejeslvl = cursor.getInt(17);
            chestlvl = cursor.getInt(18);
            gatyalvl = cursor.getInt(19);
            cipolvl = cursor.getInt(20);

            cursor.close();
        }
    }
}
