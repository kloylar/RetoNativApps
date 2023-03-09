package com.kloylar.enlavia.data.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.kloylar.enlavia.model.ReportData;

import java.util.List;

@Dao
public interface ReportDAO {
    @Query("SELECT * FROM ReportData")
    List<ReportData> getAll();

    @Query("SELECT * FROM ReportData WHERE id IN (:Id)")
    List<ReportData> loadAllByIds(int[] Id);

    @Insert
    long[] insertAll(ReportData... reports);

    @Insert
    long insertReport(ReportData report);

    @Update
    int updateReport(ReportData report);

    @Delete
    void delete(ReportData report);

}
