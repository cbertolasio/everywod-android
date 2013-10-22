package com.everywod.data;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cbertolasio
 * Date: 10/12/13
 * Time: 1:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class WorkoutEntityDataSource {
    private SQLiteDatabase database;
    private MySqlLiteHelper dbHelper;
    private String[] allColumns = { MySqlLiteHelper.COLUMN_ID,
            MySqlLiteHelper.COLUMN_WORKOUTNAME,
            MySqlLiteHelper.COLUMN_WORKOUTTYPEID };


    public WorkoutEntityDataSource(Context context){
        dbHelper = new MySqlLiteHelper(context);
    }

    public void open() throws SQLException{
        database = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }

    public List<WorkoutEntity> getAllBenchmarks(){
        List<WorkoutEntity> workouts = new ArrayList<WorkoutEntity>();

        Cursor cursor = database.query(MySqlLiteHelper.TABLE_WORKOUT, allColumns, "WorkoutTypeId=?", new String[] { "B" }, null, null, "Name ASC");
        return getWorkoutEntities(workouts, cursor);
    }

    public List<WorkoutEntity> getAllHeroes(){
        List<WorkoutEntity> workouts = new ArrayList<WorkoutEntity>();

        Cursor cursor = database.query(MySqlLiteHelper.TABLE_WORKOUT, allColumns, "WorkoutTypeId=?", new String[] { "H" }, null, null, "Name ASC");
        return getWorkoutEntities(workouts, cursor);
    }

    public List<WorkoutEntity> getAllBasicWods(){
        List<WorkoutEntity> workouts = new ArrayList<WorkoutEntity>();

        Cursor cursor = database.query(MySqlLiteHelper.TABLE_WORKOUT, allColumns, "WorkoutTypeId=?", new String[] { "A" }, null, null, null);
        return getWorkoutEntities(workouts, cursor);
    }

    public List<WorkoutEntity> getAllGirls(){
        List<WorkoutEntity> workouts = new ArrayList<WorkoutEntity>();

        Cursor cursor = database.query(MySqlLiteHelper.TABLE_WORKOUT, allColumns, "WorkoutTypeId=?", new String[] { "G" }, null, null, "Name ASC");
        return getWorkoutEntities(workouts, cursor);
    }

    public List<WorkoutEntity> getAll(){
        List<WorkoutEntity> workouts = new ArrayList<WorkoutEntity>();

        Cursor cursor = database.query(MySqlLiteHelper.TABLE_WORKOUT, allColumns, null, null, null, null, "Name ASC");
        return getWorkoutEntities(workouts, cursor);
    }

    private List<WorkoutEntity> getWorkoutEntities(List<WorkoutEntity> workouts, Cursor cursor) {
        cursor.moveToFirst();
        while (! cursor.isAfterLast()){
            WorkoutEntity workout = toEntity(cursor);
            workouts.add(workout);
            cursor.moveToNext();
        }

        cursor.close();
        return workouts;
    }

    private WorkoutEntity toEntity(Cursor cursor){
        WorkoutEntity entity = new WorkoutEntity();
        entity.setId(cursor.getLong(0));
        entity.setName(cursor.getString(1));
        entity.setTypeId(cursor.getString(2));
        return entity;
    }
}
