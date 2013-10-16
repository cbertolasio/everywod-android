package com.example.SqlLiteSample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created with IntelliJ IDEA.
 * User: cbertolasio
 * Date: 10/6/13
 * Time: 12:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class MySqlLiteHelper extends SQLiteOpenHelper {
    public static final String TABLE_COMMENTS = "Comments";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_COMMENT = "Comment";

    private static final String DATABASE_NAME = "comments.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE = "create table " +
            TABLE_COMMENTS + "(" + COLUMN_ID +
            " integer primary key autoincrement, " + COLUMN_COMMENT +
            " text not null);";

    public MySqlLiteHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database){
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        Log.w(MySqlLiteHelper.class.getName(),
                "upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENTS);
        onCreate(db);
    }
}
