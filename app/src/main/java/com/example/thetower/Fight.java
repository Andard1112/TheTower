package com.example.thetower;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Fight extends AppCompatActivity {
    AdatbazisSegito as = new AdatbazisSegito(this);
    private int stamina,strength,agility,armor,dungeonSzint, enableStatusPoints, atackPower, cash, level, exp, kardlvl, pajzslvl, fejeslvl, chestlvl, gatyalvl, cipolvl;
    private String name,szakma, clas;
    private double deffense,crit;
    int[] enemy1 = new int[4],enemy2= new int[4],enemy3= new int[4],enemy4= new int[4];
    TextView tvFName,tvFStamina,tvFStrength,tvFAgility,tvFAtackPower,tvFArmor,tvFCrit,tvFMiss,tvFEnemyName,tvFEnemyStamina,tvFEnemyStrength,tvFLoot;
    ImageView ivFHero,ivFEnemy;
    Button btnFOK;
    // int atackPower, String clas, int cash, int level, int x, int y
    //String name, String guild, String clas
    // int stamina, int strength,  int agility,  int armor,  int enableStatusPoints, int atackPower,  int cash, int level, int x, int y
    //double deffense,double crit,double lifepoint
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);
        init();
        Cursor cursor = as.getRow(1);
        as.open();
        AdatLekeres(cursor);
        if (clas.equals("Knight")){
            ivFHero.setImageResource(R.drawable.knight);
        }else
        if (clas.equals("Warior")){
            ivFHero.setImageResource(R.drawable.warrior);
        }else
        if (clas.equals("Hunter")){
            ivFHero.setImageResource(R.drawable.hunter);
        }else
        if (clas.equals("Rouge")){
            ivFHero.setImageResource(R.drawable.rouge);
        }
        if (exp>=20) {
            as.updateLvL(level + 1);
            as.updateEXP(0);
            as.updateEnableStatuszPoint(enableStatusPoints+1);
        }
        int szornyFajta = getIntent().getIntExtra("fajta",0);
        switch (dungeonSzint){
            case 0:
                enemy1[0] = 20;
                enemy1[1] = 1;
                enemy1[2] = 1;
                enemy1[3] = 1;
                enemy2[0] = 15;
                enemy2[1] = 2;
                enemy2[2] = 1;
                enemy2[3] = 1;
                enemy3[0] = 17;
                enemy3[1] = 1;
                enemy3[2] = 1;
                enemy3[3] = 1;
                enemy4[0] = 13;
                enemy4[1] = 2;
                enemy4[2] = 1;
                enemy4[3] = 1;
                break;
            case 1:
                enemy1[0] = 30;
                enemy1[1] = 2;
                enemy1[2] = 2;
                enemy1[3] = 2;
                enemy2[0] = 20;
                enemy2[1] = 3;
                enemy2[2] = 2;
                enemy2[3] = 2;
                enemy3[0] = 22;
                enemy3[1] = 2;
                enemy3[2] = 2;
                enemy3[3] = 2;
                enemy4[0] = 18;
                enemy4[1] = 3;
                enemy4[2] = 2;
                enemy4[3] = 2;
                break;
            case 2:
                enemy1[0] = 40;
                enemy1[1] = 3;
                enemy1[2] = 3;
                enemy1[3] = 3;
                enemy2[0] = 25;
                enemy2[1] = 4;
                enemy2[2] = 3;
                enemy2[3] = 3;
                enemy3[0] = 27;
                enemy3[1] = 3;
                enemy3[2] = 3;
                enemy3[3] = 3;
                enemy4[0] = 23;
                enemy4[1] = 4;
                enemy4[2] = 3;
                enemy4[3] = 3;
                break;
            case 3:
                enemy1[0] = 50;
                enemy1[1] = 4;
                enemy1[2] = 4;
                enemy1[3] = 4;
                enemy2[0] = 30;
                enemy2[1] = 5;
                enemy2[2] = 4;
                enemy2[3] = 4;
                enemy3[0] = 32;
                enemy3[1] = 4;
                enemy3[2] = 4;
                enemy3[3] = 4;
                enemy4[0] = 28;
                enemy4[1] = 5;
                enemy4[2] = 4;
                enemy4[3] = 4;
                break;
        }
        tvFAtackPower.setText(""+szornyFajta+";"+dungeonSzint);
        switch (szornyFajta){
            case 1:
                ivFEnemy.setImageResource(R.drawable.zombie);
                tvFEnemyName.setText("Élőhalott");
                tvFEnemyStamina.setText("Életerő: "+enemy1[0]);
                tvFEnemyStrength.setText("Sebzés: "+enemy1[1]);
                if (sebzes((atackPower+strength),(stamina+20),armor,enemy1[0],enemy1[1])){
                    tvFLoot.setVisibility(View.VISIBLE);
                    tvFLoot.setText("Arany: "+enemy1[2]+"\nTapasztalat: "+enemy1[3]);
                    btnFOK.setVisibility(View.VISIBLE);
                    btnFOK.setEnabled(true);
                }else{
                    // Build an AlertDialog
                    AlertDialog.Builder builder = new AlertDialog.Builder(Fight.this);
                    // Set a title for alert dialog
                    builder.setTitle("Vereség");
                    // Ask the final question
                    builder.setMessage("Önt megölte a szörny, és véget ért a játék.");
                    // Set the alert dialog yes button click listener
                    builder.setPositiveButton("Rendben", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //Yes buton click
                            as.open();
                            as.deleteRow(1);
                            Intent newGame = new Intent(Fight.this,FoKepernyo.class);
                            startActivity(newGame);
                            finish();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    // Display the alert dialog on interface
                    dialog.show();
                }
                break;
            case 2:
                ivFEnemy.setImageResource(R.drawable.skeleton_archer);
                tvFEnemyName.setText("Élőhalott ijjász");
                tvFEnemyStamina.setText("Életerő: "+enemy2[0]);
                tvFEnemyStrength.setText("Sebzés: "+enemy2[1]);
                if (sebzes((atackPower+strength),(stamina+20),armor,enemy2[0],enemy2[1])){
                    tvFLoot.setVisibility(View.VISIBLE);
                    tvFLoot.setText("Arany: "+enemy2[2]+"\nTapasztalat: "+enemy2[3]);
                    btnFOK.setVisibility(View.VISIBLE);
                    btnFOK.setEnabled(true);
                }else{
                    // Build an AlertDialog
                    AlertDialog.Builder builder = new AlertDialog.Builder(Fight.this);
                    // Set a title for alert dialog
                    builder.setTitle("Vereség");
                    // Ask the final question
                    builder.setMessage("Önt megölte a szörny, és véget ért a játék.?");
                    // Set the alert dialog yes button click listener
                    builder.setPositiveButton("Rendben", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //Yes buton click
                            as.open();
                            as.deleteRow(1);
                            Intent newGame = new Intent(Fight.this,FoKepernyo.class);
                            startActivity(newGame);
                            finish();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    // Display the alert dialog on interface
                    dialog.show();
                }
                break;
            case 3:
                ivFEnemy.setImageResource(R.drawable.imp);
                tvFEnemyName.setText("Imp");
                tvFEnemyStamina.setText("Életerő: "+enemy3[0]);
                tvFEnemyStrength.setText("Sebzés: "+enemy3[1]);
                if (sebzes((atackPower+strength),(stamina+20),armor,enemy3[0],enemy3[1])){
                    tvFLoot.setVisibility(View.VISIBLE);
                    tvFLoot.setText("Arany: "+enemy3[2]+"\nTapasztalat: "+enemy3[3]);
                    btnFOK.setVisibility(View.VISIBLE);
                    btnFOK.setEnabled(true);
                }else{
                    // Build an AlertDialog
                    AlertDialog.Builder builder = new AlertDialog.Builder(Fight.this);
                    // Set a title for alert dialog
                    builder.setTitle("Vereség");
                    // Ask the final question
                    builder.setMessage("Önt megölte a szörny, és véget ért a játék.?");
                    // Set the alert dialog yes button click listener
                    builder.setPositiveButton("Rendben", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //Yes buton click
                            as.open();
                            as.deleteRow(1);
                            Intent newGame = new Intent(Fight.this,FoKepernyo.class);
                            startActivity(newGame);
                            finish();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    // Display the alert dialog on interface
                    dialog.show();
                }
                break;
            case 4:
                ivFEnemy.setImageResource(R.drawable.minotaurus);
                tvFEnemyName.setText("Minotaurusz");
                tvFEnemyStamina.setText("Életerő: "+enemy4[0]);
                tvFEnemyStrength.setText("Sebzés: "+enemy4[1]);
                if (sebzes((atackPower+strength),(stamina+20),armor,enemy4[0],enemy4[1])){
                    tvFLoot.setVisibility(View.VISIBLE);
                    tvFLoot.setText("Arany: "+enemy4[2]+"\nTapasztalat: "+enemy4[3]);
                    btnFOK.setVisibility(View.VISIBLE);
                    btnFOK.setEnabled(true);
                }else{
                    // Build an AlertDialog
                    AlertDialog.Builder builder = new AlertDialog.Builder(Fight.this);
                    // Set a title for alert dialog
                    builder.setTitle("Vereség");
                    // Ask the final question
                    builder.setMessage("Önt megölte a szörny, és véget ért a játék.?");
                    // Set the alert dialog yes button click listener
                    builder.setPositiveButton("Rendben", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //Yes buton click
                            as.open();
                            as.deleteRow(1);
                            Intent newGame = new Intent(Fight.this,FoKepernyo.class);
                            startActivity(newGame);
                            finish();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    // Display the alert dialog on interface
                    dialog.show();
                }
                break;
        }
        btnFOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int szornyFajta = getIntent().getIntExtra("fajta",0);
                Intent visszaDungeon = new Intent(Fight.this,Dungeon.class);
                switch (szornyFajta){
                    case 1:
                        as.updateCash(cash+enemy1[2]);
                        as.updateEXP(exp+enemy1[3]);
                        break;
                    case 2:
                        as.updateCash(cash+enemy2[2]);
                        as.updateEXP(exp+enemy2[3]);
                        break;
                    case 3:
                        as.updateCash(cash+enemy3[2]);
                        as.updateEXP(exp+enemy3[3]);
                        break;
                        case 4:
                        as.updateCash(cash+enemy4[2]);
                        as.updateEXP(exp+enemy4[3]);
                        break;
                }
                if (exp>=20) {
                    as.updateLvL(level + 1);
                    exp -= 20;
                    as.updateEXP(exp);
                    as.updateEnableStatuszPoint(enableStatusPoints+1);
                }
                startActivity(visszaDungeon);
                finish();
            }
        });



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
            dungeonSzint = cursor.getInt(8);
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
            tvFName.setText(name);
            tvFStamina.setText("Stamina: "+stamina);
            tvFStrength.setText("Strength: "+strength);
            tvFAgility.setText("Agility: "+agility);
            tvFArmor.setText("Armor: "+armor);
            //tvFAtackPower.setText("Sebzés:: "+atackPower);
            cursor.close();
        }
    }
    private void init(){
        tvFName = findViewById(R.id.tvFName);
        ivFEnemy = findViewById(R.id.ivFEnemy);
        tvFEnemyName = findViewById(R.id.tvFEnemyName);
        tvFEnemyStamina = findViewById(R.id.tvFEnemyStamina);
        tvFEnemyStrength = findViewById(R.id.tvFEnemyStrength);
        tvFLoot = findViewById(R.id.tvFLoot);
        btnFOK = findViewById(R.id.btnFOK);
        tvFStamina = findViewById(R.id.tvFStamina);
        tvFStrength = findViewById(R.id.tvFStrength);
        tvFAgility = findViewById(R.id.tvFAgility);
        tvFArmor = findViewById(R.id.tvFArmor);
        tvFEnemyName = findViewById(R.id.tvFEnemyName);
        tvFEnemyStamina = findViewById(R.id.tvFEnemyStamina);
        tvFEnemyStrength = findViewById(R.id.tvFEnemyStrength);
        ivFHero = findViewById(R.id.ivFHero);
        tvFAtackPower = findViewById(R.id.tvFAtackPower);
    }
    private boolean sebzes(int hosSebzes,int hosHp,int hosArmor, int szornyHp, int szornySebzes ){
        int hos=0;
        int szorny=0;
        szornySebzes -= hosArmor;
        if (szornySebzes <0){
            szornySebzes = 0;
        }
        do {
            szornyHp = szornyHp-hosSebzes;
            hos++;
        }while(szornyHp >= 0 );
        do {
            hosHp = hosHp-szornySebzes;
            szorny++;
        }while(hosHp >= 0);
        if (hos > szorny){
            return false;
        }else if (hos < szorny){
            return true;
        }else{
            return false;
        }
    }
}
