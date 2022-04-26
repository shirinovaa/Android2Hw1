package com.example.android2hm1.ui.fragments.authentification;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.android2hw1.R;
import com.example.android2hw1.databinding.FragmentFinishRegistrationBinding;

public class FinishRegistrationFragment extends Fragment {
    private FragmentFinishRegistrationBinding binding;
    SharedPreferences preferences;

    public static final String FILE_NAME = "registration";
    public static final String IS_SHOW_KEY = "isShowRegistr";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFinishRegistrationBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preferences = requireActivity().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
                preferences.edit().putBoolean(IS_SHOW_KEY, true).apply();
                Navigation.findNavController(requireView()).navigate(R.id.taskFragment);
            }
        });
    }
}