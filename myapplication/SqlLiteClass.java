package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;
import java.util.jar.Attributes;


public class SqlLiteClass extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "AllInOne.db";
    public static final String TABLE_NAME = "itemTable";
    public static final String COL_1 ="ID";
    public static final String COL_2 ="Name";
    public static final String COL_3 = "amount";
    public static final String COL_4 = "price";
    public static final String COL_5 ="Details";
    public static final String COL_6 ="dealer";


    public SqlLiteClass(@Nullable Context context) {
        super(context, DATABASE_NAME , null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TABLE_NAME + "( ID INTEGER PRIMARY KEY AUTOINCREMENT , name , amount , price, Details ,dealer  )");
    }

   @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insert (String name , String amount ,String price ,String details , String dealer )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2 ,name);
        contentValues.put(COL_3, amount );
        contentValues.put(COL_4, price);
        contentValues.put(COL_5 , details);
        contentValues.put(COL_6 , dealer);

        long result =db.insert(TABLE_NAME,null,contentValues);
        if (result == -1)
            return false;
        return true;
    }
    public int deleteRow(String del_name)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String[] whereargs={del_name};
        int count=db.delete(TABLE_NAME,COL_2 + "=?",whereargs);
        return count;
    }

    public void viewAll(Context context)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("Select * from "+ TABLE_NAME , null);
        if(res.getCount()==0)
        {
            showMessage("Error" , "Nothing to Show" , context);
            return ;
        }
        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext())
        {
            buffer.append("\n\nId :"+res.getString(0));
            buffer.append("\nName :"+res.getString(1));
            buffer.append("\nAmount :"+res.getString(2));
            buffer.append("\nPrice :"+res.getString(3));
            buffer.append("\nDetails :"+res.getString(4));
            buffer.append("\nDealer :"+res.getString(5));
        }

        showMessage("Items:",buffer.toString(),context);

    }
    public void showMessage(String title , String message,Context context) {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setCancelable(true);
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.show();
    }

    public void view(String name , Context context)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] column = {SqlLiteClass.COL_2 ,SqlLiteClass.COL_3 ,SqlLiteClass.COL_4 ,SqlLiteClass.COL_5,SqlLiteClass.COL_6};

        Cursor res = db.query(TABLE_NAME , column , "name = '" + name +"'",null,null,null , null);
        if(res.getCount()==0)
        {
            showMessage("Error" , "Nothing to Show" , context);
            return ;
        }
        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext())
        {
            buffer.append("\n\nId :"+res.getString(0));
            buffer.append("\nName :"+res.getString(1));
            buffer.append("\nAmount :"+res.getString(2));
            buffer.append("\nPrice :"+res.getString(3));
            buffer.append("\nDetails :"+res.getString(4));
            buffer.append("\nDealer :"+res.getString(5));
        }

        showMessage("Items:",buffer.toString(),context);

    }


    public Cursor viewName() {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        if(res.getCount()==0)
        {
            return null;
        }
        return res;
    }
}

