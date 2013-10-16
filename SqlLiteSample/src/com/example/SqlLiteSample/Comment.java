package com.example.SqlLiteSample;

/**
 * Created with IntelliJ IDEA.
 * User: cbertolasio
 * Date: 10/6/13
 * Time: 12:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class Comment {
    private long id;
    private String comment;

    public long getId(){
        return id;
    }

    public void setId (long id){
        this.id = id;
    }

    public String getComment(){
        return comment;
    }

    public void setComment(String comment){
        this.comment = comment;
    }

    // will be used by the  ArrayAdapter in the ListView
    @Override
    public String toString(){
        return comment;
    }
}
