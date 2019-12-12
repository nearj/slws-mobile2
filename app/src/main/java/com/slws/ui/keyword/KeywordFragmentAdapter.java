package com.slws.ui.keyword;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.slws.databinding.KeywordMenuItemBinding;
import com.slws.model.Keyword;

import java.util.ArrayList;
import java.util.List;

public class KeywordFragmentAdapter
        extends RecyclerView.Adapter<KeywordFragmentAdapter.KeywordViewHolder> {
    private List<Keyword> mKeywordList;

    public KeywordFragmentAdapter() {
        this.mKeywordList = new ArrayList<>();
    }

    @NonNull
    @Override
    public KeywordFragmentAdapter.KeywordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        KeywordMenuItemBinding binding = KeywordMenuItemBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new KeywordViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull KeywordViewHolder holder, int position) {
        Keyword Keyword = mKeywordList.get(position);
        holder.bind(Keyword);
    }

    public void setItem(List<Keyword> KeywordList) {
        if (KeywordList == null) {
            return;
        }
        this.mKeywordList = KeywordList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mKeywordList.size();
    }

    public static class KeywordViewHolder extends RecyclerView.ViewHolder {
        private final KeywordMenuItemBinding binding;

        public KeywordViewHolder(KeywordMenuItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Keyword Keyword) {
            binding.setKeyword(Keyword);
            binding.layout.setBackgroundColor(Color.MAGENTA);
        }
    }
}
