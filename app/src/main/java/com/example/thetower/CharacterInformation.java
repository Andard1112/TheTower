package com.example.thetower;

public class CharacterInformation {
    public String name;
    private int guild;
    private int stamina;
    private int strength;
    private double deffense;
    private int agility;
    private double crit;
    private int armor;
    private double lifepoint;
    private int enableStatusPoint;
    private int atackPower;
    private double missCheance;

    public int getClas() {
        return clas;
    }

    public void setClas(int clas) {
        this.clas = clas;
    }

    private int clas;

    public double getMissCheance() {
        return missCheance;
    }

    public void setMissCheance(double missCheance) {
        this.missCheance = missCheance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGuild() {
        return guild;
    }

    public void setGuild(int guild) {
        this.guild = guild;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.atackPower = this.atackPower + strength;
        this.strength = strength;
    }

    public double getDeffense() {
        return deffense;
    }

    public void setDeffense(double deffense) {
        this.deffense = deffense;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.missCheance = this.missCheance*this.agility;
        this.agility = agility;
    }

    public double getCrit() {
        return crit;
    }

    public void setCrit(double crit) {
        this.crit = crit;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public double getLifepoint() {
        return lifepoint;
    }

    public void setLifepoint(double lifepoint) {
        this.lifepoint = lifepoint;
    }

    public int getEnableStatusPoint() {
        return enableStatusPoint;
    }

    public void setEnableStatusPoint(int enableStatusPoint) {
        this.enableStatusPoint = enableStatusPoint;
    }

    public int getAtackPower() {
        return atackPower;
    }

    public void setAtackPower(int atackPower) {
        this.atackPower = atackPower;
    }

    public CharacterInformation() {
        this.crit = 5;
        this.armor = 0;
        this.lifepoint = 100;
        this.enableStatusPoint = 0;
        this.missCheance = 0;
    }

}
