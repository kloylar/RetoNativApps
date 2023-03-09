package com.kloylar.enlavia.model;

import android.graphics.Bitmap;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class ReportData {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "timestamp")
    public long timestamp;
    @ColumnInfo(name = "description")
    public String description;
    @ColumnInfo(name = "imagePath")
    public String imagePath;
    @Ignore
    public Bitmap image;


}
