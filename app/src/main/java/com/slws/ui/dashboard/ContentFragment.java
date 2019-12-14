package com.slws.ui.dashboard;

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
import com.slws.data.AppDataManager;
import com.slws.databinding.DashboardFragmentRecyclerBinding;
import com.slws.model.Content;
import com.slws.utils.BoardTitle;

public class ContentFragment extends Fragment {
    private ContentViewModel mViewModel;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String[][] mDataset;
    private ObservableArrayList<Content> contentList;
    AppDataManager appDataManager = new AppDataManager();

    public static ContentFragment newInstance() {
        return new ContentFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        DashboardFragmentRecyclerBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.dashboard_fragment_recycler, container, false);
        View root = binding.getRoot();

        mRecyclerView = root.findViewById(R.id.dashboard_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);


        //crawling();
        mAdapter = new ContentFragmentAdapter();
        contentList = new ObservableArrayList<>();
        binding.dashboardRecyclerView.setHasFixedSize(true);
        binding.dashboardRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.setContentList(this.contentList);
        binding.dashboardRecyclerView.setAdapter(mAdapter);

        return root;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        mViewModel = ViewModelProviders.of(this).get(ContentViewModel.class);
    }


}
