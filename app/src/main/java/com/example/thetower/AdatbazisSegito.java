package com.example.thetower;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class AdatbazisSegito {
    public static final String DATABASE_NAME = "the_tower.db";
    public static final String TABLE_NAME = "character";

    public static final String KEY_ID = "_id";

    public static final String COL_NAME = "name";
    public static final String COL_SZAKMA = "szakma";
    public static final String COL_STAMINA = "stamina";
    public static final String COL_STRENGTH = "strength";
    public static final String COL_DEFFENSE = "deffense";
    public static final String COL_AGILITY = "agility";
    public static final String COL_ARMOR = "armor";
    public static final String COL_LIFEPOINT = "lifepoint";
    public static final String COL_ENABLESTATUSPOINT = "enableStatusPoint";
    public static final String COL_ATACKPOWER = "atackPower";
    public static final String COL_EXP = "exp";
    public static final String COL_CLAS = "clas";
    public static final String COL_CASH = "cash";
    public static final String COL_LEVEL = "level";

    public static final String COL_KARDLVL = "kardlvl";
    public static final String COL_PAJZSLVL = "pajzslvl";
    public static final String COL_FEJESLVL = "fejeslvl";
    public static final String COL_CHESTLVL = "chestlvl";
    public static final String COL_GATYALVL = "gatyalvl";
    public static final String COL_CIPOLVL = "cipolvl";

    public static final String[] ALL_KEYS = new String[] {KEY_ID, COL_NAME, COL_SZAKMA,COL_STAMINA,COL_STRENGTH,COL_DEFFENSE,COL_AGILITY,COL_ARMOR,COL_LIFEPOINT,COL_ENABLESTATUSPOINT,COL_ATACKPOWER,COL_EXP,COL_CLAS, COL_CASH,COL_LEVEL,COL_KARDLVL,COL_PAJZSLVL,COL_FEJESLVL,COL_CHESTLVL,COL_GATYALVL,COL_CIPOLVL};

    public static final int DATABASE_VERSION = 3;

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
                + COL_LIFEPOINT + " double not null, "
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
                + COL_CIPOLVL + " integer not null"
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

    public long insertRow(int id,String name, String szakma, int stamina, int strength, double deffense, int agility, int armor, double lifepoint, int enableStatusPoints, int atackPower,int exp, String clas, int cash, int level, int fegyverLvl, int pajzsLvl, int fejesLvl, int chestLvl, int gatyaLvl, int cipoLvl){
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_ID, id);
        initialValues.put(COL_NAME, name);
        initialValues.put(COL_SZAKMA, szakma);
        initialValues.put(COL_STAMINA, stamina);
        initialValues.put(COL_STRENGTH, strength);
        initialValues.put(COL_DEFFENSE, deffense);
        initialValues.put(COL_AGILITY, agility);
        initialValues.put(COL_ARMOR, armor);
        initialValues.put(COL_LIFEPOINT, lifepoint);
        initialValues.put(COL_ENABLESTATUSPOINT, enableStatusPoints);
        initialValues.put(COL_ATACKPOWER, atackPower);
        initialValues.put(COL_EXP, exp);
        initialValues.put(COL_CLAS, clas);
        initialValues.put(COL_CASH,cash);
        initialValues.put(COL_LEVEL,level);
        initialValues.put(COL_KARDLVL, fegyverLvl);
        initialValues.put(COL_PAJZSLVL,pajzsLvl);
        initialValues.put(COL_FEJESLVL,fejesLvl);
        initialValues.put(COL_CHESTLVL,chestLvl);
        initialValues.put(COL_GATYALVL,gatyaLvl);
        initialValues.put(COL_CIPOLVL,cipoLvl);

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
    public boolean updateRowHealth(int life) {
        String where = KEY_ID + "=" + 1;
        ContentValues newValues = new ContentValues();
        newValues.put(COL_STAMINA, life);
        return db.update(TABLE_NAME, newValues, where, null) != 0;
    }
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
    public boolean updateRowChest(int lvl) {
        String where = KEY_ID + "=" + 1;
        ContentValues newValues = new ContentValues();
        newValues.put(COL_CHESTLVL, lvl);
        return db.update(TABLE_NAME, newValues, where, null) != 0;
    }
    public boolean updateRowGatya(int lvl) {
        String where = KEY_ID + "=" + 1;
        ContentValues newValues = new ContentValues();
        newValues.put(COL_GATYALVL, lvl);
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
    //adatbázis elem lekérése
    public Cursor getStamina(long rowId) {
        String where = KEY_ID + "=" + rowId;
        Cursor c =     db.query(true, TABLE_NAME, ALL_KEYS,
                where, null, null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
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
