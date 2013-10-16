package com.everywod.data;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: cbertolasio
 * Date: 10/12/13
 * Time: 12:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class WorkoutLogEntity {
    private long id;
    private long workoutId;
    private String userName;
    private long userId;
    private String score;
    private String dateOfWod;
    private boolean isAPersonalRecord;
    private String note;
    private String dateCreated;

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(long workoutId) {
        this.workoutId = workoutId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getDateOfWod() {
        return dateOfWod;
    }

    public void setDateOfWod(String dateOfWod) {
        this.dateOfWod = dateOfWod;
    }

    public boolean isAPersonalRecord() {
        return isAPersonalRecord;
    }

    public void setAPersonalRecord(boolean APersonalRecord) {
        isAPersonalRecord = APersonalRecord;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
