package com.example.mytrip;

//import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DbHelper extends SQLiteOpenHelper // UDI
{
    private static DbHelper singleton;
    //ContentResolver mContentResolver;
    private static final String TAG = DbHelper.class.getSimpleName();
    // database info
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "myTrip.db";
    public static final String TABLE_NAME = "user_table";
    // table columns
    public static final String ID = "ID";
    public static final String EMAIL = "EMAIL";
    public static final String PASSWORD = "PASSWORD";
    public static  final String IMAGE = "IMAGE";
    public static final String FAVORITE = "FAVORITE";
    //SQLiteDatabase db;

    // singleton implementation
    public static synchronized DbHelper getInstance(Context context)
    {
        if (singleton == null)
            singleton = new DbHelper(context.getApplicationContext());
        return singleton;
    }

    // should only be called by getInstance()
    private DbHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //mContentResolver = context.getContentResolver();
        //db = this.getWritableDatabase();
    }

    @Override
    // called only once, when DB is created
    public void onCreate(SQLiteDatabase db)
    {// if not exists is deprecated, a table with the same name cannot be created
        String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
                "("+
                ID + "ID INTEGER PRIMARY KEY AUTOINCREMENT," +// id assigned iteratively
                EMAIL + "TEXT," +
                PASSWORD + "TEXT," +
                IMAGE + "BLOB," +
                FAVORITE + "TEXT" +
                ")";
        db.execSQL(CREATE_TABLE);
        Log.d(TAG, "Database Created Successfully" );// log cat output
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        if (oldVersion != newVersion)
        {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }

    public long addOrUpdateUser(User usr)
    {
        SQLiteDatabase db = this.getWritableDatabase();// pulls db from cache, for editing
        long id = -1;
        db.beginTransaction();// helps with performance and ensures consistency
        try
        {
            //value insertion
            ContentValues values = new ContentValues();
            values.put(EMAIL, usr.getEmail());
            values.put(PASSWORD, usr.getPassword());
            values.put(IMAGE, usr.getImg());
            values.put(FAVORITE, usr.getFavorite());
            //long id = db.insert(TABLE_NAME, null, values);
            //usr.setCustomerId(id);
            //return usr;
            //try to update if user with email exists
            int rows = db.update(TABLE_NAME, values,
                    EMAIL + "= ?", new String[]{usr.getEmail()});
            if (rows == 1)// if there is such a user
            {
                String usrSelect = String.format("SELECT %s FROM %s WHERE %s = ?",
                        ID, TABLE_NAME, EMAIL);
                // getting the id of the updated user by email
                Cursor cursor = db.rawQuery(usrSelect,
                        new String[]{String.valueOf(usr.getEmail())});
                try
                {
                    if (cursor.moveToFirst())
                    {
                        id = cursor.getInt(0);// first row, first column is the user id
                        db.setTransactionSuccessful();
                    }
                }
                // always close the cursor after use to avoid leaks
                finally
                {
                    if (cursor != null && !cursor.isClosed())
                        cursor.close();
                }
            }
            else // if rows != 1 (users are unique so equivalent to rows == 0)
            {
                // inserting an new user to DB
                id = db.insertOrThrow(TABLE_NAME, null, values);
                db.setTransactionSuccessful();
            }
        }
        catch (Exception e)
        {
            Log.d(TAG, "Error while trying to create of update user");
        }
        finally { db.endTransaction(); }
        return id;
    }

    // returns table as a string
    public Cursor getAllData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery(
                "select * from "+TABLE_NAME,
                null);
    }

    // user updates:
    // picture
    public int updatePicture(User usr)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(IMAGE, usr.getImg());
        // Updating profile picture for user with that email
        return db.update(TABLE_NAME, values, EMAIL + " = ?",
                new String[] { String.valueOf(usr.getEmail()) });
    }

    // password
    public int updatePassword(User usr)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PASSWORD, usr.getPassword());
        // Updating password for user with that email
        return db.update(TABLE_NAME, values, EMAIL + " = ?",
                new String[] { String.valueOf(usr.getEmail()) });
    }

    // deletions-
    // remove a user by id
    public void deleteUser (String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        try
        {
            db.delete(TABLE_NAME, "ID = ?", new String[]{id});
            db.setTransactionSuccessful();
        }
        catch (Exception e)
        {
            Log.d(TAG, "Error while trying to delete a user");
        }
        finally { db.endTransaction(); }
    }

    // remove the table from the database
    public void deleteAllData()
    {
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try
        {
            db.delete(TABLE_NAME, null, null);
            db.setTransactionSuccessful();
        }
        catch (Exception e)
        {
            Log.d(TAG, "Error while trying to delete all users");
        }
        finally { db.endTransaction(); }
    }

    // search user names
    public Cursor findName(String strName)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery(
                "select * from " + TABLE_NAME + " where " + EMAIL +
                        " LIKE '%" + strName + "%' ", null);
    }
}