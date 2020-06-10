package com.example.mytrip;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.provider.BaseColumns._ID;


public class DbHelper extends SQLiteOpenHelper {
    private static final String TAG = DbHelper.class.getSimpleName();

    private static final String DATABASE_NAME = "customers.db";
    private static final int DATABASE_VERSION = 1;
    Context context;
    SQLiteDatabase db;
    ContentResolver mContentResolver;


   // public final static String COLUMN_NAME = "imagename";
    public static final String TABLE_NAME = "customer_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "EMAIL";
    public static final String COL_3 = "PASSWORD";
    public static  final String COL_4 = "IMAGE";
    public static final String COL_5 = "FAVORITE";

    //public final static String TABLE_NAME = "imagetable";




    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContentResolver = context.getContentResolver();
        db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_IMAGE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
        "EMAIL TEXT,PASSWORD TEXT, IMAGE BLOB, FAVORITE TEXT)";
        db.execSQL(SQL_CREATE_IMAGE_TABLE);
        Log.d(TAG, "Database Created Successfully" );

    }

    /*public void addToDb(  byte[] image){
        ContentValues cv = new  ContentValues();
        cv.put(COLUMN_NAME,   image);
        db.insert( TABLE_NAME, null, cv );
    }*/


    public boolean insertData(Customer customer)
    {
        if(!checkExists(customer)) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(COL_2, customer.getEmail());
            contentValues.put(COL_3, customer.getPassword());
            contentValues.put(COL_4, customer.getImg());
            contentValues.put(COL_5, customer.getFavorite());
            long result = db.insert(TABLE_NAME,
                    null, contentValues);
            // success !
            return result != -1; // fail !
        }
        else
            return false;
    }





    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }



    public boolean checkExists(Customer customer)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery(
                "select * from "+TABLE_NAME+ " where EMAIL="+"'"+customer.getEmail()+"'",
                null);
        return res.getCount() > 0;
    }




    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery(
                "select * from "+TABLE_NAME,
                null);
    }


    public boolean updateData(String id, Customer customer)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,customer.getImg());
        contentValues.put(COL_3,customer.getFavorite());
        db.update(TABLE_NAME,
                contentValues, "ID = ?",
                new String[] { id });
        return true;
    }
    public Integer deleteData (String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,
                "ID = ?",new String[] {id});
    }

    public Cursor getLikeName(String strName) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery(
                "select * from " + TABLE_NAME + " where " + COL_2 + " LIKE '%" + strName + "%' ", null);
    }

}
