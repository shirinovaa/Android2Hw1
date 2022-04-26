package com.example.android2hm1.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android2hm1.data.model.BoardModel;
import com.example.android2hm1.utils.interfaces.ItemClickListener;
import com.example.android2hw1.databinding.ItemBoardBinding;

import java.util.ArrayList;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.BoardViewHolder> {
    ArrayList<BoardModel> list = new ArrayList<>();
    ItemClickListener listener;


    public BoardAdapter(ArrayList<BoardModel> list, ItemClickListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public BoardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBoardBinding binding =
                ItemBoardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new BoardViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BoardViewHolder holder, int position) {
        holder.onBind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class BoardViewHolder extends RecyclerView.ViewHolder {
        private final ItemBoardBinding binding;

        public BoardViewHolder(ItemBoardBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(BoardModel boardModel) {
            binding.boardImg.setAnimation(boardModel.getAnimation());
            binding.descriptionTv.setText(boardModel.getDescription());
            binding.nextBtn.setText(boardModel.getButtonText());
            binding.nextBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.itemClick(getAdapterPosition());
                }
            });
        }
    }
}
