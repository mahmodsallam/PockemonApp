package com.mahmoud.mostafa.pockemonapp.data.local;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
/***
 * this class is representing the databse table
 * and the element of this class is considered the
 * column of this Table
 * */
@Entity(tableName = "pockemon")
public class PockemonEntitiy {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String pockemonUtilities;
    private String pockemonMoves;
    private String url ;

    public PockemonEntitiy(String pockemonUtilities, String pockemonMoves , String url ) {
        this.pockemonUtilities = pockemonUtilities;
        this.pockemonMoves = pockemonMoves;
        this.url= url ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPockemonUtilities() {
        return pockemonUtilities;
    }

    public void setPockemonUtilities(String pockemonUtilities) {
        this.pockemonUtilities = pockemonUtilities;
    }

    public String getPockemonMoves() {
        return pockemonMoves;
    }

    public void setPockemonMoves(String pockemonMoves) {
        this.pockemonMoves = pockemonMoves;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
