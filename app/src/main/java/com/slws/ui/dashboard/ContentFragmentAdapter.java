package com.slws.ui.dashboard;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.slws.R;

import java.util.ArrayList;
import java.util.List;

public class ContentFragmentAdapter
        extends RecyclerView.Adapter<ContentFragmentAdapter.ContentViewHolder> {
    private String[][] mDataset;

    public ContentFragmentAdapter(String[][] dataset) {
        mDataset = dataset;
    }


    @NonNull
    @Override
    public ContentFragmentAdapter.ContentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RelativeLayout v = (RelativeLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dashboard_menu_item, parent, false);
        ContentViewHolder vh = new ContentViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ContentViewHolder holder, int position) {
        for (int i = 0; i < mDataset[position].length; i++)
            holder.menuItem.get(i).setText(mDataset[position][i]);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    public static class ContentViewHolder extends RecyclerView.ViewHolder {
        public List<TextView> menuItem = new ArrayList<>();

        public ContentViewHolder(RelativeLayout v) {
            super(v);
            menuItem.add(v.findViewById(R.id.dashboard_menu_item_title));
            menuItem.add(v.findViewById(R.id.dashboard_menu_item_detail));
            menuItem.add(v.findViewById(R.id.dashboard_menu_item_date));
        }
    }
}
