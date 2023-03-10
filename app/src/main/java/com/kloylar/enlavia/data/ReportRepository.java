package com.kloylar.enlavia.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.kloylar.enlavia.data.database.LocalDatabase;
import com.kloylar.enlavia.data.database.ReportDAO;
import com.kloylar.enlavia.model.ReportData;

import java.util.List;

public class ReportRepository {
    private ReportDAO reportDAO;
    private LiveData<List<ReportData>> listLiveDataReport;

    public ReportRepository(Application application) {
        LocalDatabase db = LocalDatabase.getInstance(application);
        reportDAO = db.userDAO();
        listLiveDataReport = reportDAO.getAll();
    }

    /**
     * funcion para notificar al observador el cambio de datos
     * @return
     */
    public LiveData<List<ReportData>> getListReports(){
        return listLiveDataReport;
    }

    /**
     * Inserta la informacion de un nuevo reporte en la base de datos
     * usando un hilo distinto de la UI
     * @param reportData
     */
    public void insertReport(ReportData reportData) {
        LocalDatabase.databaseWriteExecutor.execute(()->{
            reportDAO.insertReport(reportData);
        });
    }

}
