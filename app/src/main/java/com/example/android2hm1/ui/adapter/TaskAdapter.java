package com.example.android2hm1.ui.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android2hm1.data.model.TaskModel;
import com.example.android2hm1.utils.interfaces.OnItemClickListener;
import com.example.android2hw1.databinding.ItemButtonsBinding;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    List<TaskModel> list = new ArrayList<>();
    OnItemClickListener itemClickListener;


    public void setItemLongClickListener(OnItemClickListener onItemClickListener) {
        this.itemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemButtonsBinding binding = ItemButtonsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new TaskViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        holder.onBind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setList(List<TaskModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {

        private final ItemButtonsBinding binding;

        public TaskViewHolder(@NonNull ItemButtonsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(TaskModel model) {
            binding.categoryBtn.setText(model.getTask());
            binding.textBtn.setText(model.getDate());
            binding.tvBtn.setText(model.getRepeat());
            binding.getRoot().setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    itemClickListener.itemLongClick(model);
                    return false;
                }
            });
        }
    }
}