package com.example.android2hm1.ui.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.navigation.Navigation;

import com.example.android2hm1.App;
import com.example.android2hm1.data.model.TaskModel;
import com.example.android2hm1.ui.adapter.TaskAdapter;
import com.example.android2hm1.utils.interfaces.OnItemClickListener;
import com.example.android2hw1.R;
import com.example.android2hw1.databinding.FragmentTaskBinding;

import java.util.List;


public class TaskFragment extends Fragment {

    private FragmentTaskBinding binding;
    TaskAdapter adapter = new TaskAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTaskBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initClickers();
        binding.recyclerview.setAdapter(adapter);
        setData();
        onItemClick();
    }


    private void setData() {
        getDataFromDb();

    }

    private void getDataFromDb() {
        App.getApp().getDb().taskDao().getData().observe(getViewLifecycleOwner(), new Observer<List<TaskModel>>() {
            @Override
            public void onChanged(List<TaskModel> taskModels) {
                adapter.setList(taskModels);
            }
        });
    }

    private void initClickers() {
        binding.openCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(requireView()).navigate(R.id.createTaskFragment);
            }
        });
    }

    public void onItemClick() {
        adapter.setItemLongClickListener(new OnItemClickListener() {
            @Override
            public void itemLongClick(TaskModel model) {
                String setMessage = "Вы уверены, что хотите удалить?";
                String setTitle = "Удалить";
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                builder.setTitle(setTitle);
                builder.setMessage(setMessage);
                builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        App.getApp().getDb().taskDao().delete(model);
                    }
                })
                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert).show();
            }
        });
    }

}
