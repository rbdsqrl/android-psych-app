package com.rbdsqrl.mindsafe.repo;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {DiaryPage.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase appDatabase;

    abstract DiaryPageDao getDiaryPageDao();

    static AppDatabase getAppDatabase(Context context){
        if(appDatabase == null) {
            appDatabase = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class,
                    "mindsafe-db").allowMainThreadQueries().build();
        }
        return appDatabase;
    }

    public static void destroyAppDatabase() {
        appDatabase = null;
    }
}
