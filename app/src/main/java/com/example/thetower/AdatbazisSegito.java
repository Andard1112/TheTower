package com.example.thetower;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdatbazisSegito extends SQLiteOpenHelper {
    private static final int DBversion = 1;
    private static final String DBname = "The_Tower";

    private static final String TABLE_NAME = "clas";

    private static final String COL_ID = "id";
    private static final String COL_NAME = "name";
    private static final String COL_STAMINA = "stamina";
    private static final String COL_STRENGTH = "strength";
    private static final String COL_DEFFENSE = "deffense";
    private static final String COL_AGILITY = "agility";
    private static final String COL_ATACKPOWER = "atackPower";

    public AdatbazisSegito(Context context){
        super(context,DBname,null,DBversion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTables = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME + "(" +
                COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_NAME+" TEXT," +
                COL_STAMINA+" INTEGER," +
                COL_STRENGTH+" INTEGER," +
                COL_DEFFENSE+" INTEGER," +
                COL_AGILITY+" INTEGER," +
                COL_ATACKPOWER+" INTEGER)";
        db.execSQL(createTables);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    public Cursor adatLekerdezes(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
    }
}
