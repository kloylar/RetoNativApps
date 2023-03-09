package com.kloylar.enlavia.data;

import com.kloylar.enlavia.model.ReportData;

import java.util.List;

/**
 * Interfaz para implementar cualquier origen de datos de reportes
 */
public interface DataAccess {
    public List<ReportData> getReports();
    public void saveReport(ReportData reportData);
    public void deleteReport(ReportData reportData);
    public void updateReport(ReportData reportData);
}
