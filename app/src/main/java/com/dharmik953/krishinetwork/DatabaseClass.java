package com.dharmik953.krishinetwork;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.net.PortUnreachableException;
import java.util.List;

public class DatabaseClass extends SQLiteOpenHelper {

    Context context;
    private static final String DatabaseName = "krishi";
    private static final int DatabaseVersion = 1;
    private static final String TableName = "data";
    private static final String ColumnId = "id";
    private static final String ColumnTitle = "name";
    private static final String ColumnDescription = "email";

    public DatabaseClass(@Nullable Context context) {
        super(context, DatabaseName, null, DatabaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TableName +
                " (" + ColumnId + " INTEGER , " +
                ColumnTitle + " TEXT, " +
                ColumnDescription + " TEXT," +
                 "IMG BLOB );";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean save(int id, String name, String email,byte [] img){
        try{

            ContentValues cv = new ContentValues();
            cv.put("id",id);
            cv.put("name",name);
            cv.put("email",email);
            cv.put("img",img);

            SQLiteDatabase db = this.getWritableDatabase();
            db.insert(TableName,null,cv);
            return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public String getname(String query){
        try {

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery(query,null);

            if (cursor.moveToFirst()){
                return  cursor.getString(0);
            }
            return null;

        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

     public String getEmail(String query){
        try {

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery(query,null);

            if (cursor.moveToFirst()){
                return  cursor.getString(0);
            }
            return null;

        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public byte [] get(String query){
        try {

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery(query,null);

            if (cursor.moveToFirst()){
                return  cursor.getBlob(0);
            }
            return null;

        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


}
