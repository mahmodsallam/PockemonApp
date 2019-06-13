package com.mahmoud.mostafa.pockemonapp.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * this class is the representation of our database
 * we will use the Dao to perform different operations on it
 * as you now generating a database is a heavy process so
 * we generating it only if it is not existing
 */
@Database(entities = {PockemonEntitiy.class}, version = 1)
public abstract class PockemonDatabse extends RoomDatabase {
    private static PockemonDatabse instance;

    public static synchronized PockemonDatabse getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), PockemonDatabse.class,
                    "pockemons_db").build();
        }
        return instance;
    }

    public abstract PockemonDao getPockemonsDao();

}

