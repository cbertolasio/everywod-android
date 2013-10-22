package com.everywod.data;

/**
 * Created with IntelliJ IDEA.
 * User: cbertolasio
 * Date: 10/12/13
 * Time: 1:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class WorkoutEntity {
    private long id;
    private String name;
    private String typeId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString(){
        return getName();
    }


}
