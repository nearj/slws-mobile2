package com.slws.ui.dashboard;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.slws.data.AppDataManager;
import com.slws.databinding.DashboardMenuItemBinding;
import com.slws.model.Content;
import com.slws.utils.BoardTitle;
import com.slws.utils.Spider;

import java.util.List;

public class ContentFragmentAdapter
        extends RecyclerView.Adapter<ContentFragmentAdapter.ContentViewHolder> {
    private List<Content> mContentList;
    AppDataManager appDataManager = new AppDataManager();

    public ContentFragmentAdapter(BoardTitle boardTitle) {
        List<Integer> seqs = Spider.getSeqeunces(boardTitle, 10);
//        Log.d(TAG, "ContentFragmentAdapter: " + seqs.size());
//        Log.d(TAG, "ContentFragmentAdapter: "+ seqs.toArray(new Integer[seqs.size()]));
        this.mContentList = appDataManager.
                getContents(boardTitle, seqs.toArray(new Integer[seqs.size()]));


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

            binding.layout.setBackgroundColor(Color.WHITE);
        }
    }
}
