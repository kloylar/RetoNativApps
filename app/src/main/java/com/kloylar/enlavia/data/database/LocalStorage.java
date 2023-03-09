package com.kloylar.enlavia.data.database;

import com.kloylar.enlavia.data.DataAccess;
import com.kloylar.enlavia.model.ReportData;

import java.util.List;

/**
 * Implementación de la interfaz DataAccess para el caso de datos leidos desde la base de datos local del dispositivo
 */
public class LocalStorage implements DataAccess {

    @Override
    public List<ReportData> getReports() {
        return null;
    }

    @Override
    public void saveReport(ReportData reportData) {

    }

    @Override
    public void deleteReport(ReportData reportData) {

    }

    @Override
    public void updateReport(ReportData reportData) {

    }
}
