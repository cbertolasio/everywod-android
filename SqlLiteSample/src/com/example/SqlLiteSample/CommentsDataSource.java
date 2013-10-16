package com.example.SqlLiteSample;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


/**
 * Created with IntelliJ IDEA.
 * User: cbertolasio
 * Date: 10/6/13
 * Time: 12:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class CommentsDataSource {
    private SQLiteDatabase database;
    private MySqlLiteHelper dbHelper;
    private String[] allColumns = { MySqlLiteHelper.COLUMN_ID, MySqlLiteHelper.COLUMN_COMMENT };


    public CommentsDataSource(Context context) {
        dbHelper = new MySqlLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }

    public Comment createComment(String comment){
        ContentValues values = new ContentValues();
        values.put(MySqlLiteHelper.COLUMN_COMMENT, comment);
        long insertId = database.insert(MySqlLiteHelper.TABLE_COMMENTS, null, values);
        Cursor cursor = database.query(MySqlLiteHelper.TABLE_COMMENTS, allColumns, MySqlLiteHelper.COLUMN_ID + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        Comment newComment = cursorToComment(cursor);
        cursor.close();
        return  newComment;
    }

    public void deleteComment(Comment comment){
        long id = comment.getId();
        System.out.println("Comment deleted with id: " + id);
        database.delete(MySqlLiteHelper.TABLE_COMMENTS, MySqlLiteHelper.COLUMN_ID + " = " + id, null);
    }

    public List<Comment> getAllComments(){
        List<Comment> comments = new ArrayList<Comment>();

        Cursor cursor = database.query(MySqlLiteHelper.TABLE_COMMENTS, allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (! cursor.isAfterLast()){
            Comment comment = cursorToComment(cursor);
            comments.add(comment);
            cursor.moveToNext();
        }

        cursor.close();
        return comments;
    }

    private Comment cursorToComment(Cursor cursor) {
        Comment comment = new Comment();
        comment.setId(cursor.getLong(0));
        comment.setComment(cursor.getString(1));
        return comment;
    }


}
