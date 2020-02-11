package com.example.thetower;

public class Classes {
    private String name,leiras;
    private int szam,stamina,strength,deffense,agility,atackPower;

    public Classes(int szam) {
        this.szam = szam;
        switch (szam){
            case 1:
                name = "Knight";
                break;
            case 2:
                name = "Warior";
                break;
            case 3:
                name = "Rouge";
                break;
            case 4:
                name = "Hunter";
                break;
        }
        switch (szam){
            case 1:
                stamina = 6;
                break;
            default:
                stamina = 3;
                break;
        }
        switch (szam){
            case 1:
                strength = 3;
                break;
            case 2:
                strength = 6;
                break;
            case 3:
                strength = 2;
                break;
            case 4:
                strength = 3;
                break;
        }
        switch (szam){
            case 1:
                deffense = 4;
                break;
            case 2:
                deffense = 2;
                break;
            case 3:
                deffense = 1;
                break;
            case 4:
                deffense = 2;
                break;
        }
        switch (szam){
            case 1:
                agility = 1;
                break;
            case 2:
                agility = 1;
                break;
            case 3:
                agility = 6;
                break;
            case 4:
                agility = 5;
                break;
        }
        switch (szam){
            case 1:
                atackPower = 1;
                break;
            default:
                atackPower = 3;
                break;
        }
        switch (szam){
            case 1:
                leiras = "Ez a kaszt a védekezésre specializálódott. Nem sebez sokat, ellenben kitartó és sok életerővel és páncéllal rendelkezik. Az egyetlen hős, aki tud viselni pajzsot és egykezest, de nem tud semilyen más fegyvert használni.";
                break;
            case 2:
                leiras = "Ez a kaszt a támadásra specializálódott. Sokat sebez, de cserébe nagyon kevés élete van és közepes páncélzata. Az egyetlen hős, aki kétkezes fegyvert tud használni, de nem tud semilyen más fegyvert használni.";
                break;
            case 3:
                leiras = "Ez a kaszt a támadásra specializálódott. Sokat sebez, de cserébe nagyon kevés élete van és gyenge a páncélzata. Az egyetlen hős, aki két tőrt tud használni, de nem tud semilyen más fegyvert használni.";
                break;
            case 4:
                leiras = "Ez a kaszt a támadásra specializálódott.Sokat sebez, de cserébe nagyon kevés élete van és gyenge a páncélzata. Az egyetlen hős, aki ijjat tud használni, de nem tud semilyen más fegyvert használni.";
                break;
        }
    }

    public String getName() {
        return name;
    }

    public int getStamina() {
        return stamina;
    }

    public int getStrength() {
        return strength;
    }

    public int getDeffense() {
        return deffense;
    }

    public int getAgility() {
        return agility;
    }

    public int getAtackPower() {
        return atackPower;
    }
    public String getLeiras() {
        return leiras;
    }
}
