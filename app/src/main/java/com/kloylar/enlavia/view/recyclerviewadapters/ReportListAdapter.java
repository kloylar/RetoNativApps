package com.kloylar.enlavia.view.recyclerviewadapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kloylar.enlavia.R;
import com.kloylar.enlavia.databinding.ItemReportCardBinding;
import com.kloylar.enlavia.model.ReportData;

import java.util.List;

public class ReportListAdapter extends RecyclerView.Adapter<ReportViewHolder> {

    //Listado con todos los reportes a visualizar
    private List<ReportData> reportDataList;

    public ReportListAdapter(@NonNull List<ReportData> reportDataList) {
        this.reportDataList = reportDataList;
    }

    public void UpdateReportData(@NonNull List<ReportData> reportDataList){
        this.reportDataList.clear();
        this.reportDataList.addAll(reportDataList);
        notifyDataSetChanged();
    }

    public void AddReportData(@NonNull ReportData reportData){
        reportDataList.add(reportData);
        notifyItemChanged(reportDataList.size()-1);
    }

    @NonNull
    @Override
    public ReportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ReportViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ReportViewHolder holder, int position) {
        //actualizar los datos visualizados con los leidos del origen de datos
        holder.bind(reportDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return reportDataList.size();
    }


}
