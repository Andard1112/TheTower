package com.example.thetower;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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

        btnShopFegyver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Build an AlertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(GameFoKepernyo.this);
                // Set a title for alert dialog
                builder.setTitle("Kovács");
                // Ask the final question
                builder.setMessage("Páncél vagy fegyverkovácshoz szeretne lépni?");
                // Set the alert dialog yes button click listener
                builder.setPositiveButton("Fegyver kovács", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Positive buton click
                        Intent toShopFegyver = new Intent(GameFoKepernyo.this,ShopFegyver.class);
                        startActivity(toShopFegyver);
                        finish();
                    }
                });
                // Set the alert dialog no button click listener
                builder.setNegativeButton("Páncél kovács", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Negative buton click
                        Intent toShopPancel = new Intent(GameFoKepernyo.this,ShopPancel.class);
                        startActivity(toShopPancel);
                        finish();
                    }
                });
                AlertDialog dialog = builder.create();
                // Display the alert dialog on interface
                dialog.show();

            }
        });

    }
    private void init() {
        btnDuengeon = findViewById(R.id.btnDuengeon);
        btnBag = findViewById(R.id.btnBag);
        btnKarakter = findViewById(R.id.btnKarakter);

        btnShopFegyver = findViewById(R.id.btnShopFegyver);
    }
}
