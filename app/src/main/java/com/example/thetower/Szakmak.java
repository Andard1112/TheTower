package com.example.thetower;

public class Szakmak {
    private String guildName;
    private String leiras;
    private int szam;
    private boolean fegyverArCsokken =false,pancelArCsokken=false,atackPowerNo=false,armorNo=false;



    public Szakmak(int szam){
        this.szam = szam;
        switch (szam){
            case 1:
                this.guildName = "Fegyverkovács";
                this.fegyverArCsokken = true;
                this.leiras = "Amennyiben ezt a szakmát választod, akkor a fegyverkovácsnál vásárolt fegyverek(egykezes,kétkezes,tőr,íj) olcsóbb lesz 5%-al. Ez a szakma nagyon hasznos az összes hős osztály számára, de leginkább a Warior a Rouge és a Hunter-nek.";
                break;
            case 2:
                this.guildName = "Páncél kovács";
                this.leiras = "Amennyiben ezt a szakmát választod, akkor a páncél kovácsnál vásárolt felszerelések(páncél,pajzs,sisak,kesztyű,nadrág,csizma) olcsóbb lesz 5%-al. Ez a szakma nagyon hasznos az összes hős osztály számára, de leginkább a Knight-nak a leghasznosabb.";
                this.pancelArCsokken = true;
                break;
            case 3:
                this.guildName = "Fegyver szakértő";
                this.leiras = "Amennyiben ezt a szakmát választod, akkor a fegyvereid (egykezes,kétkezes,tőr,íj) nagyobbat fognak sebezni 5%-al. Ez a szakma nagyon hasznos az összes hős osztály számára, de leginkább a Warior a Rouge és a Hunter-nek.";
                this.atackPowerNo = true;
                break;
            case 4:
                this.guildName = "Páncél szakértő";
                this.leiras = "Amennyiben ezt a szakmát választod, akkor a páncélzatod(páncél,pajzs,sisak,kesztyű,nadrág,csizma) megnő a védelmük 5%-al. Ez a szakma nagyon hasznos az összes hős osztály számára, de leginkább a Knight-nak a leghasznosabb.";
                this.armorNo = true;
                break;
        }
    }
    public String getGuildName() {
        return guildName;
    }
    public String getLeiras() {
        return leiras;
    }

    public boolean isFegyverArCsokken() {
        return fegyverArCsokken;
    }

    public boolean isPancelArCsokken() {
        return pancelArCsokken;
    }

    public boolean isAtackPowerNo() {
        return atackPowerNo;
    }

    public boolean isArmorNo() {
        return armorNo;
    }
}
