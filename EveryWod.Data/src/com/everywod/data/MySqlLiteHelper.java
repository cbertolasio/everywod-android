package com.everywod.data;

import android.*;
import android.R;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteTransactionListener;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: cbertolasio
 * Date: 10/6/13
 * Time: 12:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class MySqlLiteHelper extends SQLiteOpenHelper {
    public static final String TABLE_WORKOUT = "Workout";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_WORKOUTNAME = "Name";
    public static final String COLUMN_WORKOUTTYPEID = "WorkoutTypeId";


    public static final String TABLE_WORKOUTLOG = "WorkoutLog";
    public static final String COLUMN_WORKOUT_ID = "WorkoutId";
    public static final String COLUMN_USERID = "UserId";
    public static final String COLUMN_USERNAME = "UserName";
    public static final String COLUMN_SCORE = "Score";
    public static final String COLUMN_DATEOFWOD = "DateOfWod";
    public static final String COLUMN_ISAPERSONALRECORD = "IsAPersonalRecord";
    public static final String COLUMN_NOTE = "Note";
    public static final String COLUMN_DATECREATED = "DateCreated";

    private static final String DATABASE_NAME = "everywod.db";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_WORKOUT_TABLE = "create table " +
            TABLE_WORKOUT + "(" +
            COLUMN_ID + " integer primary key, " +
            COLUMN_WORKOUTNAME + " text not null, " +
            COLUMN_WORKOUTTYPEID + " text not null);";

    private static final String CREATE_WORKOUTLOG_TABLE = "create table " +
            TABLE_WORKOUTLOG + "(" + COLUMN_ID + " integer primary key autoincrement, " +
            COLUMN_WORKOUT_ID + " integer not null, " +
            COLUMN_USERNAME + " text null, " +
            COLUMN_USERID + " integer null, " +
            COLUMN_SCORE + " text not null, " +
            COLUMN_DATEOFWOD + " string not null, " +
            COLUMN_ISAPERSONALRECORD + " numeric not null, " +
            COLUMN_NOTE + " text not null, " +
            COLUMN_DATECREATED + " string not null " +
            ");";

    public MySqlLiteHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database){
        database.execSQL(CREATE_WORKOUT_TABLE);
        database.execSQL(CREATE_WORKOUTLOG_TABLE);

        CreateWorkoutData(database);
    }

    private void CreateWorkoutData(SQLiteDatabase database) {
        database.beginTransaction();

        try {
            String command = "INSERT INTO Workout(_id, Name, WorkoutTypeId) VALUES(?,?,?)";
            SQLiteStatement insert = database.compileStatement(command);

            execInsert(insert, 1, "Back Squat", "B");
            execInsert(insert, 2, "Shoulder Press", "B");
            execInsert(insert, 3, "Deadlift", "B");
            execInsert(insert, 4, "Front Squat", "B");
            execInsert(insert, 5, "Bench Press", "B");
            execInsert(insert, 6, "Thruster", "B");
            execInsert(insert, 7, "Push Press", "B");
            execInsert(insert, 8, "Push Jerk", "B");
            execInsert(insert, 9, "Jerk", "B");
            execInsert(insert, 11, "Overhead Squat", "B");
            execInsert(insert, 12, "Clean", "B");
            execInsert(insert, 13, "Clean & Jerk", "B");
            execInsert(insert, 14, "Snatch", "B");
            execInsert(insert, 15, "Snatch Balance", "B");
            execInsert(insert, 16, "Squat Clean", "B");
            execInsert(insert, 17, "Pullups - ME", "B");
            execInsert(insert, 18, "Dips / Ring Dips - ME", "B");
            execInsert(insert, 19, "Muscle-Ups - ME", "B");
            execInsert(insert, 20, "Push-Ups - ME", "B");
            execInsert(insert, 21, "Tabata Squats - ME", "B");
            execInsert(insert, 22, "Sit-Ups (ME in 2 min.)", "B");
            execInsert(insert, 24, "Squats (ME in 2 min.)", "B");
            execInsert(insert, 25, "Hand Stand Hold - ME", "B");
            execInsert(insert, 26, "Hand Stand Push-Ups - ME", "B");
            execInsert(insert, 27, "L-Sit ME", "B");
            execInsert(insert, 28, "500M Row", "B");
            execInsert(insert, 29, "1000M Row", "B");
            execInsert(insert, 30, "2000M Row", "B");
            execInsert(insert, 31, "5k Row", "B");
            execInsert(insert, 32, "400M Run", "B");
            execInsert(insert, 33, "800M Run", "B");
            execInsert(insert, 34, "1 Mile Run", "B");
            execInsert(insert, 35, "5k", "B");
            execInsert(insert, 36, "1/2 Marathon", "B");
            execInsert(insert, 37, "Marathon", "B");
            execInsert(insert, 38, "10k", "B");
            execInsert(insert, 39, "Double Unders - ME", "B");
            execInsert(insert, 40, "Single Unders", "B");
            execInsert(insert, 41, "Burpees (ME in 2 min.)", "B");
            execInsert(insert, 43, "Burpees (100 for time)", "B");
            execInsert(insert, 44, "Annie", "G");
            execInsert(insert, 45, "Angie", "G");
            execInsert(insert, 46, "Barbara", "G");
            execInsert(insert, 47, "Chelsea", "G");
            execInsert(insert, 48, "Cindy", "G");
            execInsert(insert, 49, "Diane", "G");
            execInsert(insert, 50, "Elizabeth", "G");
            execInsert(insert, 51, "Fran", "G");
            execInsert(insert, 52, "Frelen", "G");
            execInsert(insert, 53, "Grace", "G");
            execInsert(insert, 54, "Helen", "G");
            execInsert(insert, 55, "Isabel", "G");
            execInsert(insert, 56, "Jackie", "G");
            execInsert(insert, 57, "Karen", "G");
            execInsert(insert, 58, "Kelly", "G");
            execInsert(insert, 59, "Linda", "G");
            execInsert(insert, 60, "Lynne", "G");
            execInsert(insert, 61, "Mary", "G");
            execInsert(insert, 62, "Nancy", "G");
            execInsert(insert, 63, "Nasty Girls", "G");
            execInsert(insert, 64, "Nicole", "G");
            execInsert(insert, 65, "Adam Brown", "H");
            execInsert(insert, 66, "Arnie", "H");
            execInsert(insert, 67, "Badger", "H");
            execInsert(insert, 68, "Blake", "H");
            execInsert(insert, 69, "Brenton", "H");
            execInsert(insert, 70, "Bulger", "H");
            execInsert(insert, 71, "Bull", "H");
            execInsert(insert, 72, "Coe", "H");
            execInsert(insert, 73, "Collin", "H");
            execInsert(insert, 74, "Daniel", "H");
            execInsert(insert, 75, "Danny", "H");
            execInsert(insert, 77, "DT", "H");
            execInsert(insert, 78, "Erin", "H");
            execInsert(insert, 79, "Forrest", "H");
            execInsert(insert, 80, "Garrett", "H");
            execInsert(insert, 81, "Griff", "H");
            execInsert(insert, 82, "Hansen", "H");
            execInsert(insert, 83, "Helton", "H");
            execInsert(insert, 84, "Holbrook", "H");
            execInsert(insert, 85, "Jack", "H");
            execInsert(insert, 86, "Jason", "H");
            execInsert(insert, 87, "Jerry", "H");
            execInsert(insert, 88, "John Runkle", "H");
            execInsert(insert, 89, "Johnson", "H");
            execInsert(insert, 90, "Josh", "H");
            execInsert(insert, 91, "Joshie", "H");
            execInsert(insert, 92, "JT", "H");
            execInsert(insert, 93, "Ledesma", "H");
            execInsert(insert, 94, "Luce", "H");
            execInsert(insert, 96, "Lumberjack 20", "H");
            execInsert(insert, 97, "McGhee", "H");
            execInsert(insert, 98, "Michael", "H");
            execInsert(insert, 99, "Mr. Joshua", "H");
            execInsert(insert, 100, "Murph", "H");
            execInsert(insert, 101, "Nate", "H");
            execInsert(insert, 102, "Nutts", "H");
            execInsert(insert, 103, "Paul", "H");
            execInsert(insert, 104, "Randy", "H");
            execInsert(insert, 105, "RJ", "H");
            execInsert(insert, 106, "Roy", "H");
            execInsert(insert, 107, "Ryan", "H");
            execInsert(insert, 108, "Severin", "H");
            execInsert(insert, 109, "Stephen", "H");
            execInsert(insert, 111, "The Seven", "H");
            execInsert(insert, 112, "Thompson", "H");
            execInsert(insert, 113, "Tommy V", "H");
            execInsert(insert, 114, "Tyler", "H");
            execInsert(insert, 115, "War Frank", "H");
            execInsert(insert, 116, "Whitten", "H");
            execInsert(insert, 117, "Wittman", "H");
            execInsert(insert, 999999, "Basic WOD", "A");

            database.setTransactionSuccessful();
        }
        catch (Exception ex){
            Log.e("EVERYWOD", "exception", ex);
        }
        finally {
            database.endTransaction();
        }
    }

    private void execInsert(SQLiteStatement insert, int id, String workoutName, String workoutTypeId) {
        insert.clearBindings();
        insert.bindLong(1, id);
        insert.bindString(2, workoutName);
        insert.bindString(3, workoutTypeId);
        insert.execute();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        Log.w(MySqlLiteHelper.class.getName(),
                "upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORKOUT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORKOUTLOG);
        onCreate(db);
    }

}
