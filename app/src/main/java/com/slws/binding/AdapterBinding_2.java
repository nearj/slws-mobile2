package com.slws.binding;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableArrayList;
import androidx.recyclerview.widget.RecyclerView;

import com.slws.model.Keyword;
import com.slws.ui.dashboard.ContentFragmentAdapter;
import com.slws.ui.keyword.KeywordFragmentAdapter;

public class AdapterBinding_2 {
    @BindingAdapter("bind:item")
    public static void bindItem(RecyclerView recyclerView, ObservableArrayList<Keyword> keywordList) {
        KeywordFragmentAdapter adapter = (KeywordFragmentAdapter)recyclerView.getAdapter();
        if (adapter != null) {
            adapter.setItem(keywordList);
        }
    }
}
