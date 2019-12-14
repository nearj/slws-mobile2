package com.slws.ui.keyword;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.slws.R;
import com.slws.databinding.FragmentKeywordRecyclerBinding;
import com.slws.model.Keyword;

public class KeywordFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ObservableArrayList<Keyword> keywordList;

    public static KeywordFragment newInstance() {
        return new KeywordFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        FragmentKeywordRecyclerBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_keyword_recycler, container, false);
        View root = binding.getRoot();
                //inflater.inflate(R.layout.fragment_keyword, container, false);
                //binding.getRoot();

        mRecyclerView = root.findViewById(R.id.keyword_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);


        //crawling();
        mAdapter = new KeywordFragmentAdapter();
        keywordList = new ObservableArrayList<>();
        binding.keywordRecyclerView.setHasFixedSize(true);
        binding.keywordRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.setKeywordList(this.keywordList);
        binding.keywordRecyclerView.setAdapter(mAdapter);

        doDummy();
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       // mViewModel = ViewModelProviders.of(this).get(KeywordViewModel.class);
        // TODO: Use the ViewModel
    }
    private void doDummy(){
        keywordList.add(new Keyword("공지사항"));
    }
}
