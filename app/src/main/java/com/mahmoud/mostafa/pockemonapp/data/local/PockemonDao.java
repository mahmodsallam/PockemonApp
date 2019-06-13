package com.mahmoud.mostafa.pockemonapp.data.local;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import io.reactivex.Observable;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * this interface is representing what we are going to do
 * on this database inserting , updating or deleting and performing
 * custom queries as well
 */
@Dao
public interface PockemonDao {
    @Insert(onConflict = REPLACE)
    void insertPockemon(PockemonEntitiy entitiy);

    @Query("select * from pockemon where id =  :id")
    PockemonEntitiy getPockemonWithId(int id);

    @Query("select * from pockemon")
    LiveData<List<PockemonEntitiy>> getAllPockemonsLiveData();


    @Query("select * from pockemon")
    List<PockemonEntitiy> getPockemonsRx();

    @Delete
    void deletePockemon(PockemonEntitiy pockemonEntitiy);

    @Update
    void updatePockemon(PockemonEntitiy pockemonEntitiy);

    @Query("delete  from pockemon where id = :id ")
    void deleteById(int id);
}
