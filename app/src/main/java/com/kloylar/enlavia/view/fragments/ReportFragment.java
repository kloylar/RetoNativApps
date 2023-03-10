package com.kloylar.enlavia.view.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.textfield.TextInputEditText;
import com.kloylar.enlavia.MainActivity;
import com.kloylar.enlavia.R;
import com.kloylar.enlavia.databinding.FragmentReportBinding;
import com.kloylar.enlavia.model.ReportData;

public class ReportFragment extends Fragment {

    private FragmentReportBinding binding;
    private TextInputEditText editTextDescripcion;
    private ImageView imageViewReport;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentReportBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editTextDescripcion = binding.textDescription;
        imageViewReport = binding.imageReport;

        requireActivity().addMenuProvider(new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                menu.findItem(R.id.action_save).setVisible(true);
                menu.findItem(R.id.action_edit).setVisible(false);
                menu.findItem(R.id.action_settings).setVisible(false);
            }

            @Override
            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.getItemId() == R.id.action_save){
                    NavHostFragment.findNavController(ReportFragment.this)
                            .popBackStack();
                    ((MainActivity)getActivity()).dataBaseViewModel.insert(new ReportData(String.valueOf(editTextDescripcion.getText())));
                    return true;
                }
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