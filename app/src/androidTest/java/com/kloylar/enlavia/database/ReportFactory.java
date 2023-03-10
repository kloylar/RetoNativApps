package com.kloylar.enlavia.database;

import com.kloylar.enlavia.model.ReportData;
import android.content.Context;
import android.os.Debug;
import android.os.Environment;
import android.util.Log;

import java.io.File;

public class ReportFactory {
    public static ReportData createReport(Context context, String description) {
        ReportData reportData = new ReportData(description);
        File imageFile = new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES),Long.toString(reportData.timestamp));
        reportData.imagePath = imageFile.getPath();
        return reportData;
    }
}
