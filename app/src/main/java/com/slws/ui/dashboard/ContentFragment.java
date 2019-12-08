package com.slws.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.slws.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ContentFragment extends Fragment {
    private ContentViewModel mViewModel;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String[][] mDataset;

    public static ContentFragment newInstance() {
        return new ContentFragment();
    }

    String url;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        String num = "1";
        url = "https://uos.ac.kr/korNotice/list.do?list_id=FA" + num + "&epTicket=LOG";

        View root = inflater.inflate(R.layout.dashboard_fragment_recycler, container, false);
        mRecyclerView = root.findViewById(R.id.dashboard_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        crawling();
        mAdapter = new ContentFragmentAdapter(new String[][]{
                {"hi", "bye", "die"},
                {"2.1", "2.2", "2.3"},
                {"3.1", "3.2", "3.3"},
                {"4.1", "4.2", "4.3"},
                {"5.1", "5.2", "5.3"},
                //{listOfTitles[0], listOfTitles[1], listOfTitles[2]}
        }
        );
        mRecyclerView.setAdapter(mAdapter);
        return root;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ContentViewModel.class);
    }


    public void crawling() {
        try{
            Document doc = Jsoup.connect(url).get();
            Elements titles = doc.select("div.listType li");
            int i = 0;
            for(Element e: titles){
                //System.out.println("Hello world");
                //System.out.println("title:"+e.text());
                //listOfTitles[i++] = e.text();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
