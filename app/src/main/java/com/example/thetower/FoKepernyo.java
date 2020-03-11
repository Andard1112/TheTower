package com.example.thetower;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FoKepernyo extends AppCompatActivity {
    private Button btnContinue, btnNewGame, btnSettings;
    AdatbazisSegito as = new AdatbazisSegito(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fokepernyo);
        init();
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent game = new Intent(FoKepernyo.this,GameFoKepernyo.class);
                startActivity(game);
                finish();
            }

        });
        btnNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Build an AlertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(FoKepernyo.this);
                // Set a title for alert dialog
                builder.setTitle("Új játék");
                // Ask the final question
                builder.setMessage("Ha új játékot kezd akkor törlődik az eddigi mentés.\\nBiztos új játékot szeretne kezdeni?");
                // Set the alert dialog yes button click listener
                builder.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Yes buton click
                        as.open();
                        as.deleteRow(1);
                        Intent newGame = new Intent(FoKepernyo.this,characterCreation.class);
                        startActivity(newGame);
                        finish();
                    }
                });
                // Set the alert dialog no button click listener
                builder.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //No buton click
                    }
                });
                AlertDialog dialog = builder.create();
                // Display the alert dialog on interface
                dialog.show();

            }
        });
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    private void init(){
        btnContinue = findViewById(R.id.btnContinue);
        btnNewGame = findViewById(R.id.btnNewGame);
        btnSettings = findViewById(R.id.btnSettings);
    }
}
