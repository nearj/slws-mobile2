package com.slws.data;

import com.slws.data.remote.CrawlerServiceUtil;
import com.slws.model.Content;
import com.slws.utils.BoardTitle;

import java.util.List;

public class AppDataManager implements DataManager {
    private static final String TAG = "AppDataManager";
    private List<Content> contentList;
    private boolean mLoad = false;

    public AppDataManager() {
    }

    @Override
    public List<Content> getContents(BoardTitle boardTitle, Integer... seqs) {
        try {
            contentList = new CrawlerServiceUtil(boardTitle).execute(seqs).get();
            return contentList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contentList;
    }

}
