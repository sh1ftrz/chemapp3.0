package com.example.chemapp30.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Chemical.class, DangerousMix.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ChemicalDao chemicalDao();
    public abstract DangerousMixDao dangerousMixDao();

    private static AppDatabase INSTANCE;

    public static synchronized AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "chemapp.db")
                    .allowMainThreadQueries() // สำหรับศึกษา ใช้งานจริงควรใช้ Async
                    .build();
        }
        return INSTANCE;
    }
}
