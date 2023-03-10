package com.kloylar.enlavia.view.recyclerviewadapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kloylar.enlavia.databinding.ItemReportCardBinding;
import com.kloylar.enlavia.model.ReportData;

class ReportViewHolder extends RecyclerView.ViewHolder{

    //el equivalente en camelcase del layout item_report_card.xml
    private final ItemReportCardBinding binding;

    public ReportViewHolder(@NonNull ItemReportCardBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(ReportData reportData){
        Log.d("viewHolder", String.valueOf(binding.textDescription));
        binding.textDescription.setText(reportData.description);
    }

    static ReportViewHolder create(ViewGroup parentViewGroup){
        //creacion de la vista correspondiente a un reporte
        ItemReportCardBinding cardBinding = ItemReportCardBinding.inflate(LayoutInflater.from(parentViewGroup.getContext()),parentViewGroup,false);
        return new ReportViewHolder(cardBinding);
    }

}
