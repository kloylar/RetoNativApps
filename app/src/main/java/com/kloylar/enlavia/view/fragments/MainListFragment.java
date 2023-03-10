package com.kloylar.enlavia.view.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.snackbar.Snackbar;
import com.kloylar.enlavia.MainActivity;
import com.kloylar.enlavia.R;
import com.kloylar.enlavia.databinding.FragmentMainListBinding;
import com.kloylar.enlavia.model.ReportData;
import com.kloylar.enlavia.view.recyclerviewadapters.ReportListAdapter;
import com.kloylar.enlavia.viewmodel.DataBaseViewModel;
import com.kloylar.enlavia.viewmodel.MainListFragmentViewModel;

import java.util.ArrayList;

public class MainListFragment extends Fragment {

    private MainListFragmentViewModel mViewModel;


    private FragmentMainListBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        binding = FragmentMainListBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ReportListAdapter adapter =  new ReportListAdapter(new ArrayList<ReportData>());
        binding.recyclerView.setAdapter(adapter);

        //observador para los cambios en la base de datos
        ((MainActivity)getActivity()).dataBaseViewModel.getListReports().observe(getViewLifecycleOwner(), reports ->{
            adapter.UpdateReportData(reports);
        });
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MainListFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        requireActivity().addMenuProvider(new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                menu.findItem(R.id.action_save).setVisible(false);
                menu.findItem(R.id.action_edit).setVisible(false);
                menu.findItem(R.id.action_settings).setVisible(false);
            }
            @Override
            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                return false;
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}