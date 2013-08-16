package com.mirai.Moekanji_N5;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Weroth
 * Date: 6/24/13
 * Time: 10:47 PM
 *
 */
public class KanjiDatabase extends SQLiteOpenHelper {
    private SQLiteDatabase db; // a reference to the database manager class.
    private static final String DATABASE_NAME = "Kanji.sqlite"; // the name of our database
    private static final int VERSION = 1; // the version of the database

    // Kanjis table name
    private static final String TABLE_KANJI = "Kanji";

    private static File DATABASE_FILE = null;

    /*
    // the names for our database columns
    private final String TABLE_NAME = "Kanji";
    private final String TABLE_ROW_ID = "kanji_id";
    private final String TABLE_ROW_ONE = "category";
    private final String TABLE_ROW_TWO = "kanji";
    */

    // This is an indicator if we need to copy the
    // database file.
    private boolean mInvalidDatabaseFile = false;
    private boolean mIsUpgraded = false;
    private Context mcontext;

    /**
     * number of users of the database connection.
     * */
    private int mOpenConnections = 0;
    private static KanjiDatabase mInstance;

    synchronized static public KanjiDatabase getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new KanjiDatabase(context.getApplicationContext());
        }
        return mInstance;
    }

    // Constructor
    public KanjiDatabase(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.mcontext = context;

        // This will set the DATABASE_FILE to the path used by
        // SQLiteOpenHelper when it creates database files.
        DATABASE_FILE = context.getDatabasePath(DATABASE_NAME);

        SQLiteDatabase db = null;
        try {
            db = getReadableDatabase();
            if (db != null) {
                db.close();
            }
            if (mInvalidDatabaseFile) {
                copyDatabase();
            }
        } catch (SQLiteException e) {
        } finally {
            if (db != null && db.isOpen()) {
                db.close();
            }
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        mInvalidDatabaseFile = true;
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int old_version, int new_version) {
        mInvalidDatabaseFile = true;
    }

    public void copyDatabase() {
        AssetManager assetManager = mcontext.getResources().getAssets();
        InputStream in = null;
        OutputStream out = null;

        try {
            in = assetManager.open(DATABASE_NAME);
            out = new FileOutputStream(DATABASE_FILE);
            byte[] buffer = new byte[1024];
            int read = 0;
            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
        } catch (IOException e) {
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                }
            }
        }
        setDatabaseVersion();
        mInvalidDatabaseFile = false;

    }

    private void setDatabaseVersion() {
        SQLiteDatabase db = null;
        try {
            db = SQLiteDatabase.openDatabase(DATABASE_FILE.getAbsolutePath(), null,
            SQLiteDatabase.OPEN_READWRITE);
            db.execSQL("PRAGMA user_version = " + VERSION);
        } catch (SQLiteException e ) {
        } finally {
            if (db != null && db.isOpen()) {
                db.close();
            }
        }
    }
    //public List<Kanji> getKanjiByCategory(String category) {
    // Get all Kanji in a List
    public List<Kanji> getAllKanji() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Kanji> kanjiList = new LinkedList<Kanji>();

        String selectQuery = "SELECT * FROM " + TABLE_KANJI;
        Cursor cursor = db.rawQuery(selectQuery,null);

        // Cannot find table

        // Looping through all rows and adding to list
//        if (cursor.moveToFirst()) {
            while (cursor.moveToNext())
            {
                Kanji kanji = new Kanji();
                // Set values
                // The order of the columns in the table is how the sql table is constructed
                kanji.setId(Integer.parseInt(cursor.getString(0)));

                kanji.setKanji(cursor.getString(1));

                kanji.setMeaning(cursor.getString(2));

                kanji.setCategory_id(Integer.parseInt(cursor.getString(3)));

                kanji.setOn(cursor.getString(4));
                //kanji.setCategory_id(cursor.getString(2));


                // Add to list
                kanjiList.add(kanji);
            }
            /*
            do {

            }  while (cursor.moveToNext());
             */


//        }
        return kanjiList;
    }

}