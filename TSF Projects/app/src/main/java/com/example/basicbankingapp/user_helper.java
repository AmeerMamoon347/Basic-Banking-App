package com.example.basicbankingapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class user_helper extends SQLiteOpenHelper {

    String TABLE_NAME = user_Contract.user_Entry.TABLE_NAME;

    public static final String DATABASE_NAME = "user.db";

    public static final int DATABASE_VERSION = 1;

    public user_helper(Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

     String SQL_CREATE_USER_TABLE = "CREATE TABLE " +user_Contract.user_Entry.TABLE_NAME + " ("
             + user_Contract.user_Entry.COLUMN_USER_NAME +" TEXT," + user_Contract.user_Entry.COLUMN_USER_ACCOUNT_NO +
             " INTEGER, " + user_Contract.user_Entry.COLUMN_USER_EMAIL + " TEXT, " + user_Contract.user_Entry.COLUMN_PHONE_NO +
             " TEXT," + user_Contract.user_Entry.COLUMN_BALANCE + " INTEGER, " +  user_Contract.user_Entry.COLUMN_USER_IFSC_CODE + " TEXT);";

     db.execSQL(SQL_CREATE_USER_TABLE);

     db.execSQL("insert into "+TABLE_NAME+" values('Ameer Mamoon',84588121,'ameer@gmail.com','982121112',15000,'7834')");
     db.execSQL("insert into "+TABLE_NAME+" values('Gupta',23588121,'gupta@gmail.com','782121112',10000,'6734')");
     db.execSQL("insert into "+TABLE_NAME+" values('Sharma',12588121,'sharma@gmail.com','232121112',20000,'9734')");
     db.execSQL("insert into "+TABLE_NAME+" values('Remo',34588121,'Ramo@gmail.com','982121112',50000,'5734')");
     db.execSQL("insert into "+TABLE_NAME+" values('Faisal',89288121,'faisal523@gmail.com','452121112',25000,'34343')");
     db.execSQL("insert into "+TABLE_NAME+" values('Saif',67288121,'saif@gmail.com','98121112',60000,'12343')");
     db.execSQL("insert into "+TABLE_NAME+" values('Abdullah',12121212,'abd@gmail.com','872121112',5000,'92343')");
     db.execSQL("insert into "+TABLE_NAME+" values('Khan',96288121,'khan123@gmail.com','692121112',25000,'45343')");
     db.execSQL("insert into "+TABLE_NAME+" values('George',432323232,'george@gmail.com','789121112',45000,'12343')");
     db.execSQL("insert into "+TABLE_NAME+" values('Asif',912288121,'asif@gmail.com','98221112',30000,'5643')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        if(oldVersion != newVersion)
        {
            db.execSQL("DROP TABLE IF EXISTS "+ user_Contract.user_Entry.TABLE_NAME);
            onCreate(db);
        }

    }

    public Cursor readData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + user_Contract.user_Entry.TABLE_NAME,null);
        return cursor;
    }

    public Cursor readPartiCularData(int accountNo)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+ user_Contract.user_Entry.TABLE_NAME+" where "+
                user_Contract.user_Entry.COLUMN_USER_ACCOUNT_NO+" = "+accountNo,null);

        return cursor;
    }

    public void amountUpdate(int accountNo, int amount)
    {
        Log.d("tag","update amount");
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("update "+user_Contract.user_Entry.TABLE_NAME+" set "+user_Contract.user_Entry.COLUMN_BALANCE+
                " = " +amount + " where " +user_Contract.user_Entry.COLUMN_USER_ACCOUNT_NO + " = " + accountNo);
    }
}
