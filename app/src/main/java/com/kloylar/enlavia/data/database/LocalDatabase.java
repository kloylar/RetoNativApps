package com.kloylar.enlavia.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.kloylar.enlavia.model.ReportData;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {ReportData.class}, version = 1)
public abstract class LocalDatabase extends RoomDatabase {
    private static volatile LocalDatabase INSTANCE = null;
    private static final String DB_NAME ="LocalReportDatabase";
    private static final int NUMBER_OF_THREADS = 2;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public abstract ReportDAO userDAO();

    public static LocalDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (LocalDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),LocalDatabase.class, "word_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
