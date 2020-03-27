package com.example.thetower;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class AdatbazisSegito {
    private static final String DATABASE_NAME = "the_tower.db";
    private static final String TABLE_NAME = "character";

    private static final String KEY_ID = "_id";

    private static final String COL_NAME = "name";
    private static final String COL_SZAKMA = "szakma";
    private static final String COL_STAMINA = "stamina";
    private static final String COL_STRENGTH = "strength";
    private static final String COL_DEFFENSE = "deffense";
    private static final String COL_AGILITY = "agility";
    private static final String COL_ARMOR = "armor";
    private static final String COL_DUNGEONSZINT = "dungeonSzint";
    private static final String COL_ENABLESTATUSPOINT = "enableStatusPoint";
    private static final String COL_ATACKPOWER = "atackPower";
    private static final String COL_EXP = "exp";
    private static final String COL_CLAS = "clas";
    private static final String COL_CASH = "cash";
    private static final String COL_LEVEL = "level";

    private static final String COL_KARDLVL = "kardlvl";
    private static final String COL_PAJZSLVL = "pajzslvl";
    private static final String COL_FEJESLVL = "fejeslvl";
    private static final String COL_CHESTLVL = "chestlvl";
    private static final String COL_GATYALVL = "gatyalvl";
    private static final String COL_CIPOLVL = "cipolvl";
    private static final String COL_UPGRADECOSTFEGYVER = "upgradeCostFegyver";
    private static final String COL_UPGRADECOSTSISAK = "upgradeCostSisak";
    private static final String COL_UPGRADECOSTVERT = "upgradeCostVert";
    private static final String COL_UPGRADECOSTGATYA = "upgradeCostGatya";
    private static final String COL_UPGRADECOSTCIPO = "upgradeCostCipo";

    private static final String[] ALL_KEYS = new String[] {KEY_ID, COL_NAME, COL_SZAKMA,COL_STAMINA,COL_STRENGTH,COL_DEFFENSE,COL_AGILITY,COL_ARMOR,COL_DUNGEONSZINT,COL_ENABLESTATUSPOINT,COL_ATACKPOWER,COL_EXP,COL_CLAS, COL_CASH,COL_LEVEL,COL_KARDLVL,COL_PAJZSLVL,COL_FEJESLVL,COL_CHESTLVL,COL_GATYALVL,COL_CIPOLVL, COL_UPGRADECOSTFEGYVER,COL_UPGRADECOSTSISAK,COL_UPGRADECOSTVERT,COL_UPGRADECOSTGATYA,COL_UPGRADECOSTCIPO};

    private static final int DATABASE_VERSION = 3;

    private static final String DATABASE_CREATE_SQL =
            "create table " + TABLE_NAME
                + " (" + KEY_ID + " integer primary key, "
                + COL_NAME + " text not null, "
                + COL_SZAKMA + " text not null, "
                + COL_STAMINA + " integer not null, "
                + COL_STRENGTH + " integer not null, "
                + COL_DEFFENSE + " integer not null, "
                + COL_AGILITY + " integer not null, "
                + COL_ARMOR + " integer not null default 0, "
                + COL_DUNGEONSZINT + " integer not null, "
                + COL_ENABLESTATUSPOINT + " integer, "
                + COL_ATACKPOWER + " integer not null, "
                + COL_EXP + " integer not null,"
                + COL_CLAS + " text not null, "
                + COL_CASH + " integer not null,"
                + COL_LEVEL + " integer not null,"
                + COL_KARDLVL + " integer not null,"
                + COL_PAJZSLVL + " integer not null,"
                + COL_FEJESLVL + " integer not null,"
                + COL_CHESTLVL + " integer not null,"
                + COL_GATYALVL + " integer not null,"
                + COL_CIPOLVL + " integer not null,"
                + COL_UPGRADECOSTFEGYVER + " intent not null,"
                + COL_UPGRADECOSTSISAK + " intent not null,"
                + COL_UPGRADECOSTVERT + " intent not null,"
                + COL_UPGRADECOSTGATYA + " intent not null,"
                + COL_UPGRADECOSTCIPO + " intent not null"
            + ");";

    private final Context context;
    private DatabaseHelper myDBHelper;
    private SQLiteDatabase db;

    public AdatbazisSegito(Context context) {
        this.context = context;
        myDBHelper = new DatabaseHelper(context);

    }

    public AdatbazisSegito open(){
        db = myDBHelper.getWritableDatabase();
        return this;
    }

    private void openPorRead(){
        db = myDBHelper.getReadableDatabase();

    }
    public void close(){
        myDBHelper.close();
    }

    public long insertRow(int id,String name, String szakma, int stamina, int strength, double deffense, int agility, int armor, int dungeonSzint, int enableStatusPoints, int atackPower,int exp, String clas, int cash, int level, int fegyverLvl, int pajzsLvl, int fejesLvl, int chestLvl, int gatyaLvl, int cipoLvl, int upgradeCostFegyver, int upgradeCostSisak, int upgradeCostVert, int upgradeCostGatya, int upgradeCostCipo){
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_ID, id); //0
        initialValues.put(COL_NAME, name); //1
        initialValues.put(COL_SZAKMA, szakma); //2
        initialValues.put(COL_STAMINA, stamina); //3
        initialValues.put(COL_STRENGTH, strength); //4
        initialValues.put(COL_DEFFENSE, deffense); //5
        initialValues.put(COL_AGILITY, agility); //6
        initialValues.put(COL_ARMOR, armor); //7
        initialValues.put(COL_DUNGEONSZINT, dungeonSzint); //8
        initialValues.put(COL_ENABLESTATUSPOINT, enableStatusPoints); //9
        initialValues.put(COL_ATACKPOWER, atackPower); //10
        initialValues.put(COL_EXP, exp); //11
        initialValues.put(COL_CLAS, clas); //12
        initialValues.put(COL_CASH,cash); //13
        initialValues.put(COL_LEVEL,level); //14
        initialValues.put(COL_KARDLVL, fegyverLvl); //15
        initialValues.put(COL_PAJZSLVL,pajzsLvl); //16
        initialValues.put(COL_FEJESLVL,fejesLvl); //17
        initialValues.put(COL_CHESTLVL,chestLvl); //18
        initialValues.put(COL_GATYALVL,gatyaLvl); //19
        initialValues.put(COL_CIPOLVL,cipoLvl); //20
        initialValues.put(COL_UPGRADECOSTFEGYVER, upgradeCostFegyver); //21
        initialValues.put(COL_UPGRADECOSTSISAK,upgradeCostSisak); //22
        initialValues.put(COL_UPGRADECOSTVERT,upgradeCostVert); //23
        initialValues.put(COL_UPGRADECOSTGATYA,upgradeCostGatya); //24
        initialValues.put(COL_UPGRADECOSTCIPO,upgradeCostCipo); //25

        return db.insert(TABLE_NAME, null,initialValues);
    }

    public boolean deleteRow(long rowID){
        String where = KEY_ID + "= ?";
        String[] whereArgs = new String[]{String.valueOf(rowID)};
        return db.delete(TABLE_NAME,where,whereArgs)!= 0;
    }

    public Cursor getRow(long rowID){
        String where = KEY_ID + "= ?";
        String[] whereArgs = new String[]{String.valueOf(rowID)};
        this.openPorRead();
        Cursor c = db.query(true,TABLE_NAME,ALL_KEYS, where, whereArgs,null,null,null,null);
        if (c != null){
            c.moveToFirst();
        }
        return c;
    }
    //adatbázis elem frissítés
    public boolean updateAgility(int agility){
        String where = KEY_ID + "=" + 1;
        ContentValues newValues = new ContentValues();
        newValues.put(COL_AGILITY,agility);
        return db.update(TABLE_NAME, newValues,where,null) != 0;
    }
    public boolean updateStamina(int stamina){
        String where = KEY_ID + "=" + 1;
        ContentValues newValues = new ContentValues();
        newValues.put(COL_STAMINA,stamina);
        return db.update(TABLE_NAME,newValues,where,null) != 0;
    }
    public boolean updateStrength(int strength){
        String where = KEY_ID + "=" + 1;
        ContentValues newValues = new ContentValues();
        newValues.put(COL_STRENGTH,strength);
        return db.update(TABLE_NAME,newValues,where,null) != 0;
    }
    public boolean updateDeffense(int deffense){
        String where = KEY_ID + "=" + 1;
        ContentValues newValues = new ContentValues();
        newValues.put(COL_DEFFENSE,deffense);
        return db.update(TABLE_NAME,newValues,where,null) != 0;

    }
    public boolean updateRowAtackPowerh(int ap) {
        String where = KEY_ID + "=" + 1;
        ContentValues newValues = new ContentValues();
        newValues.put(COL_ATACKPOWER, ap);
        return db.update(TABLE_NAME, newValues, where, null) != 0;
    }
    public boolean updateRowFegyverLvl(int lvl) {
        String where = KEY_ID + "=" + 1;
        ContentValues newValues = new ContentValues();
        newValues.put(COL_KARDLVL, lvl);
        return db.update(TABLE_NAME, newValues, where, null) != 0;
    }
    public boolean updateRowPajzsLvl(int lvl) {
        String where = KEY_ID + "=" + 1;
        ContentValues newValues = new ContentValues();
        newValues.put(COL_PAJZSLVL, lvl);
        return db.update(TABLE_NAME, newValues, where, null) != 0;
    }
    public boolean updateRowFejes(int lvl) {
        String where = KEY_ID + "=" + 1;
        ContentValues newValues = new ContentValues();
        newValues.put(COL_FEJESLVL, lvl);
        return db.update(TABLE_NAME, newValues, where, null) != 0;
    }

    public boolean updateRowDungeonSzint(int lvl) {
        String where = KEY_ID + "=" + 1;
        ContentValues newValues = new ContentValues();
        newValues.put(COL_DUNGEONSZINT, lvl);
        return db.update(TABLE_NAME, newValues, where, null) != 0;
    }
    public boolean updateRowCipo(int lvl) {
        String where = KEY_ID + "=" + 1;
        ContentValues newValues = new ContentValues();
        newValues.put(COL_CIPOLVL, lvl);
        return db.update(TABLE_NAME, newValues, where, null) != 0;
    }
    public boolean updateCash(int cash){
        String where = KEY_ID + "=" + 1;
        ContentValues newValues = new ContentValues();
        newValues.put(COL_CASH,cash);
        return db.update(TABLE_NAME, newValues,where,null) != 0;
    }
    public boolean updateEXP(int exp){
        String where = KEY_ID + "=" + 1;
        ContentValues newValues = new ContentValues();
        newValues.put(COL_EXP,exp);
        return db.update(TABLE_NAME, newValues,where,null) != 0;
    }
    public boolean updateLvL(int lvl){
        String where = KEY_ID + "=" + 1;
        ContentValues newValues = new ContentValues();
        newValues.put(COL_LEVEL,lvl);
        return db.update(TABLE_NAME, newValues,where,null) != 0;
    }
    public boolean updateEnableStatuszPoint(int statuszPoint){
        String where = KEY_ID + "=" + 1;
        ContentValues newValues = new ContentValues();
        newValues.put(COL_ENABLESTATUSPOINT,statuszPoint);
        return db.update(TABLE_NAME, newValues,where,null) != 0;
    }
    public boolean updateRowArmor(int armor){
        String where = KEY_ID + "=" + 1;
        ContentValues newValues = new ContentValues();
        newValues.put(COL_ARMOR,armor);
        return db.update(TABLE_NAME, newValues,where,null) != 0;
    }
    public boolean updateRowUpgradeCostFegyver(int upgradeCostFegyver){
        String where = KEY_ID + "=" + 1;
        ContentValues newValues = new ContentValues();
        newValues.put(COL_UPGRADECOSTFEGYVER,upgradeCostFegyver);
        return db.update(TABLE_NAME, newValues,where,null) != 0;
    }
    public boolean updateRowUpgradeCostSisak(int upgradeCostSisak){
        String where = KEY_ID + "=" + 1;
        ContentValues newValues = new ContentValues();
        newValues.put(COL_UPGRADECOSTSISAK,upgradeCostSisak);
        return db.update(TABLE_NAME, newValues,where,null) != 0;
    }
    public boolean updateRowUpgradeCostVert(int upgradeCostVert){
        String where = KEY_ID + "=" + 1;
        ContentValues newValues = new ContentValues();
        newValues.put(COL_UPGRADECOSTVERT,upgradeCostVert);
        return db.update(TABLE_NAME, newValues,where,null) != 0;
    }
    public boolean updateRowUpgradeCostGatya(int upgradeCostGatya){
        String where = KEY_ID + "=" + 1;
        ContentValues newValues = new ContentValues();
        newValues.put(COL_UPGRADECOSTGATYA,upgradeCostGatya);
        return db.update(TABLE_NAME, newValues,where,null) != 0;
    }
    public boolean updateRowUpgradeCostCipo(int upgradeCostCipo){
        String where = KEY_ID + "=" + 1;
        ContentValues newValues = new ContentValues();
        newValues.put(COL_UPGRADECOSTCIPO,upgradeCostCipo);
        return db.update(TABLE_NAME, newValues,where,null) != 0;
    }
    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase _db) {
            _db.execSQL(DATABASE_CREATE_SQL);
        }

        @Override
        public void onUpgrade(SQLiteDatabase _db, int oldVersion, int newVersion) {
            Log.w(DATABASE_NAME, "Upgrading application's database from version " + oldVersion
                    + " to " + newVersion + ", which will destroy all old data!");

            // Destroy old database:
            _db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

            // Recreate new database:
            onCreate(_db);
        }
    }
}
