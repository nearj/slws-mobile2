package com.slws.binding;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableArrayList;
import androidx.recyclerview.widget.RecyclerView;

import com.slws.model.Content;
import com.slws.ui.dashboard.ContentFragmentAdapter;

public class AdapterBinding {
    @BindingAdapter("bind:item")
    public static void bindItem(RecyclerView recyclerView, ObservableArrayList<Content> contentList) {
        ContentFragmentAdapter adapter = (ContentFragmentAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.setItem(contentList);
        }
    }
}
