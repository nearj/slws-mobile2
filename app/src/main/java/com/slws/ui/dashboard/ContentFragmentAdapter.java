package com.slws.ui.dashboard;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.slws.databinding.DashboardMenuItemBinding;
import com.slws.model.Content;

import java.util.ArrayList;
import java.util.List;

public class ContentFragmentAdapter
        extends RecyclerView.Adapter<ContentFragmentAdapter.ContentViewHolder> {
    private String[][] mDataset;
    private List<Content> mContentList;

    public ContentFragmentAdapter(String[][] dataset) {
        mDataset = dataset;
    }

    public ContentFragmentAdapter() {
        this.mContentList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ContentFragmentAdapter.ContentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DashboardMenuItemBinding binding = DashboardMenuItemBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new ContentViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ContentViewHolder holder, int position) {
        Content content = mContentList.get(position);
        holder.bind(content);
    }

    public void setItem(List<Content> contentList) {
        if (contentList == null) {
            return;
        }
        this.mContentList = contentList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mContentList.size();
    }

    public static class ContentViewHolder extends RecyclerView.ViewHolder {
        private final DashboardMenuItemBinding binding;

        public ContentViewHolder(DashboardMenuItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Content content) {
            binding.setContent(content);
            binding.layout.setBackgroundColor(Color.MAGENTA);
        }
    }
}
