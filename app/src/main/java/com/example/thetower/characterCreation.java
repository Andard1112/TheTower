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
    private Button btnCreate,btnClassDown,btnClassUp,btnSzakmaDown,btnSzakmaUp;
    private EditText etName,etClass,etSzakmaInfo,etClassInfo,etSzakma;
    private ImageView ivcharacter;
    private int clas = 1;
    private int szakma = 1;
    CharacterInformation chi = new CharacterInformation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_creation);
        init();
        ivcharacter.setImageResource(R.drawable.knight);
        Szakmak szakmak = new Szakmak(szakma);
        etSzakmaInfo.setText(szakmak.getLeiras()+"");
        Classes classes = new Classes(clas);
        etClassInfo.setText("Agility:"+classes.getAgility()+"\nErő:"+classes.getStrength()+"\nKitartás:"+classes.getStamina()+"\nTámadási erő:"+classes.getAtackPower()+"\nVédekezés"+classes.getDeffense()+"\n"+classes.getLeiras());
        btnClassDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clas == 1){
                    clas = 4;
                    Classes classes = new Classes(clas);
                    etClass.setText(classes.getName());
                    ivcharacter.setImageResource(R.drawable.hunter);
                    etClassInfo.setText("Agility:"+classes.getAgility()+"\nErő:"+classes.getStrength()+"\nKitartás:"+classes.getStamina()+"\nTámadási erő:"+classes.getAtackPower()+"\nVédekezés"+classes.getDeffense()+"\n"+classes.getLeiras());
                }else{
                    clas--;
                    Classes classes = new Classes(clas);
                    etClass.setText(classes.getName());
                    etClassInfo.setText("Agility:"+classes.getAgility()+"\nErő:"+classes.getStrength()+"\nKitartás:"+classes.getStamina()+"\nTámadási erő:"+classes.getAtackPower()+"\nVédekezés"+classes.getDeffense()+"\n"+classes.getLeiras());
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
                    etClassInfo.setText("");
                    etClassInfo.setText("Agility:"+classes.getAgility()+"\nErő:"+classes.getStrength()+"\nKitartás:"+classes.getStamina()+"\nTámadási erő:"+classes.getAtackPower()+"\nVédekezés"+classes.getDeffense()+"\n"+classes.getLeiras());
                }else{
                    clas++;
                    Classes classes = new Classes(clas);
                    etClass.setText(classes.getName());
                    etClassInfo.setText("Agility:"+classes.getAgility()+"\nErő:"+classes.getStrength()+"\nKitartás:"+classes.getStamina()+"\nTámadási erő:"+classes.getAtackPower()+"\nVédekezés"+classes.getDeffense()+"\n"+classes.getLeiras());
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
        btnSzakmaDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (szakma==1){
                    szakma = 4;
                    Szakmak szakmak = new Szakmak(szakma);
                    etSzakma.setText(szakmak.getGuildName()+"");
                    etSzakmaInfo.setText(szakmak.getLeiras()+"");
                    chi.setGuild(szakma);
                }else{
                    szakma--;
                    Szakmak szakmak = new Szakmak(szakma);
                    etSzakma.setText(szakmak.getGuildName()+"");
                    etSzakmaInfo.setText(szakmak.getLeiras()+"");
                    chi.setGuild(szakma);
                }
            }
        });
        btnSzakmaUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (szakma == 4){
                    szakma = 1;
                    Szakmak szakmak = new Szakmak(szakma);
                    etSzakma.setText(szakmak.getGuildName()+"");
                    etSzakmaInfo.setText(szakmak.getLeiras()+"");
                    chi.setGuild(szakma);
                }else{
                    szakma++;
                    Szakmak szakmak = new Szakmak(szakma);
                    etSzakma.setText(szakmak.getGuildName()+"");
                    etSzakmaInfo.setText(szakmak.getLeiras()+"");
                    chi.setGuild(szakma);
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
                    Intent gameStart = new Intent(characterCreation.this,GameFoKepernyo.class);
                    startActivity(gameStart);
                    finish();
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
        btnSzakmaDown = findViewById(R.id.btnSzakmaDown);
        btnSzakmaUp = findViewById(R.id.btnSzakmaUp);
        etSzakmaInfo = findViewById(R.id.etSzakmaInfo);
        etClassInfo = findViewById(R.id.etClassInfo);
        etSzakma = findViewById(R.id.etSzakma);
    }






}
