package com.example.thetower;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class characterCreation extends AppCompatActivity{
    private Button btnCreate,btnClassDown,btnClassUp;
    private EditText etName,etClass;
    private ImageView ivcharacter;
    private int clas = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_creation);
        init();
        ivcharacter.setImageResource(R.drawable.knight);

        btnClassDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clas == 1){
                    clas = 4;
                    Classes classes = new Classes(clas);
                    etClass.setText(classes.getName());
                    ivcharacter.setImageResource(R.drawable.hunter);

                }else{
                    clas--;
                    Classes classes = new Classes(clas);
                    etClass.setText(classes.getName());
                    switch (clas){
                        case 2:
                            ivcharacter.setImageResource(R.drawable.warrior);
                            break;
                        case 3:
                            ivcharacter.setImageResource(R.drawable.rouge);
                            break;
                        case 1:
                            ivcharacter.setImageResource(R.drawable.knight);
                            break;
                    }
                }
            }
        });

        btnClassUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clas == 4){
                    clas = 1;
                    Classes classes = new Classes(clas);
                    etClass.setText(classes.getName());
                    ivcharacter.setImageResource(R.drawable.knight);
                }else{
                    clas++;
                    Classes classes = new Classes(clas);
                    etClass.setText(classes.getName());
                    switch (clas){
                        case 2:
                            ivcharacter.setImageResource(R.drawable.warrior);
                            break;
                        case 3:
                            ivcharacter.setImageResource(R.drawable.rouge);
                            break;
                        case 4:
                            ivcharacter.setImageResource(R.drawable.hunter);
                            break;
                    }
                }
            }
        });

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                if (!name.isEmpty()) {

                    Classes classes = new Classes(clas);
                    CharacterInformation character = new CharacterInformation();
                    character.name = name;
                    character.setStamina(classes.getStamina());
                    character.setStrength(classes.getStrength());
                    character.setDeffense(classes.getDeffense());
                    character.setAgility(classes.getAgility());
                    character.setAtackPower(classes.getAtackPower());
                    Intent guildInfo = new Intent(characterCreation.this, SetSzakmak.class);
                    startActivity(guildInfo);
                   // finish();
                }else{
                    Toast.makeText(characterCreation.this, "Karakter neve nem lehet üres!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void init(){
        btnClassDown = findViewById(R.id.btnClassDown);
        btnClassUp = findViewById(R.id.btnClassUp);
        btnCreate = findViewById(R.id.btnCreate);
        ivcharacter = findViewById(R.id.ivcharacter);
        etName = findViewById(R.id.etName);
        etClass = findViewById(R.id.etClass);

    }






}
