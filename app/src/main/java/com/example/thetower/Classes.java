package com.example.thetower;

public class Classes {
    private String name;
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
}
