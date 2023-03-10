package com.kloylar.enlavia.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.kloylar.enlavia.data.ReportRepository;
import com.kloylar.enlavia.model.ReportData;

import java.util.List;

public class DataBaseViewModel extends AndroidViewModel {

    private ReportRepository repository;

    private final LiveData<List<ReportData>> listReports;

    public DataBaseViewModel(@NonNull Application application) {
        super(application);
        repository = new ReportRepository(application);
        listReports = repository.getListReports();
    }

    public LiveData<List<ReportData>> getListReports(){
        return listReports;
    }

    public void insert (ReportData reportData){
        repository.insertReport(reportData);
    }
}
