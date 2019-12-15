package com.slws.ui.interests;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.slws.databinding.InterestMenuItemBinding;
import com.slws.model.Content;

import java.util.List;

public class InterestContentFragmentAdapter
        extends RecyclerView.Adapter<InterestContentFragmentAdapter.InterestContentViewHolder> {
    private List<Content> mContentList;

    public InterestContentFragmentAdapter(List<Content> contentList) {
        this.mContentList = contentList;
    }

    @NonNull
    @Override
    public InterestContentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        InterestMenuItemBinding binding = InterestMenuItemBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);

        return new InterestContentViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull InterestContentViewHolder holder, int position) {
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

    public static class InterestContentViewHolder extends RecyclerView.ViewHolder {
        private final InterestMenuItemBinding binding;

        public InterestContentViewHolder(InterestMenuItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Content content) {
            binding.setContentInterest(content);
        }
    }

}
