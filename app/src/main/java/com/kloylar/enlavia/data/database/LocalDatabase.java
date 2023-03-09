package com.kloylar.enlavia.data.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.kloylar.enlavia.model.ReportData;

@Database(entities = {ReportData.class}, version = 1)
public abstract class LocalDatabase extends RoomDatabase {
    public abstract ReportDAO userDAO();
}
