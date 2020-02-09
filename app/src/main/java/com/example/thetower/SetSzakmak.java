package com.example.thetower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class SetSzakmak extends AppCompatActivity {
    private ImageButton btnGuildDown,btnGuildUp,btnCreate;
    private EditText etGuildName, etGuildInformation;
    private int guild = 1;
    CharacterInformation chi = new CharacterInformation();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_szakmak);
        init();
        CharacterInformation ch = new CharacterInformation();
        etGuildInformation.setText(ch.getName()+""+ch.getStamina());
        btnGuildDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (guild==1){
                    guild = 4;
                    Szakmak szakmak = new Szakmak(guild);
                    etGuildName.setText(szakmak.getGuildName()+"");
                    etGuildInformation.setText(szakmak.getLeiras()+"");
                    chi.setGuild(guild);
                }else{
                    guild--;
                    Szakmak szakmak = new Szakmak(guild);
                    etGuildName.setText(szakmak.getGuildName()+"");
                    etGuildInformation.setText(szakmak.getLeiras()+"");
                    chi.setGuild(guild);
                }
            }
        });
        btnGuildUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (guild == 4){
                    guild = 1;
                    Szakmak szakmak = new Szakmak(guild);
                    etGuildName.setText(szakmak.getGuildName()+"");
                    etGuildInformation.setText(szakmak.getLeiras()+"");
                    chi.setGuild(guild);
                }else{
                    guild++;
                    Szakmak szakmak = new Szakmak(guild);
                    etGuildName.setText(szakmak.getGuildName()+"");
                    etGuildInformation.setText(szakmak.getLeiras()+"");
                    chi.setGuild(guild);
                }
            }
        });

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    private void init(){
        btnGuildDown = findViewById(R.id.btnGuildDown);
        btnGuildUp = findViewById(R.id.btnGuildUp);
        etGuildName = findViewById(R.id.etGuildName);
        etGuildInformation = findViewById(R.id.etGuildInformation);
        btnCreate = findViewById(R.id.btnCreate);
    }
}
