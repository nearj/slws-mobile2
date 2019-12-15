package com.slws.data;

import com.slws.data.remote.CrawlerServiceUtil;
import com.slws.model.Content;
import com.slws.utils.BoardTitle;
import com.slws.utils.Spider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class AppDataManager {
    private static final String TAG = "AppDataManager";
    private static Map<BoardTitle, List<Content>> database = new HashMap<>();
    private static boolean mLoad = false;
    private static Random random = new Random();

    public static List<Content> getContents(BoardTitle boardTitle, Integer... seqs) {
        initialization();
        return AppDataManager.database.get(boardTitle);
    }

    public static void setInterest(BoardTitle boardTitle, int idx, boolean interest) {
        initialization();
        List<Content> contents = AppDataManager.database.get(boardTitle);
        Content content = contents.get(idx);
        content.setInterest(interest);
        contents.set(idx, content);
        AppDataManager.database.put(boardTitle, contents);
    }

    public static void setDone(BoardTitle boardTitle, int idx, boolean done) {
        initialization();
        List<Content> contents = AppDataManager.database.get(boardTitle);
        Content content = contents.get(idx);
        content.setDone(done);
        contents.set(idx, content);
        AppDataManager.database.put(boardTitle, contents);
    }

    public static List<Content> getDoneList(boolean isDone) {
        initialization();
        return new ArrayList<Content>() {
            {
                for (BoardTitle boardTitle : BoardTitle.BOARD_TITLES)
                    for (Content content : AppDataManager.database.get(boardTitle))
                        if (content.isDone() == isDone)
                            add(content);
            }
        };
    }


    public static List<Content> getInterestList(boolean inInterest) {
        initialization();
        return new ArrayList<Content>() {
            {
                for (BoardTitle boardTitle : BoardTitle.BOARD_TITLES)
                    for (Content content : AppDataManager.database.get(boardTitle))
                        if (content.inInterest() == inInterest)
                            add(content);
            }
        };
    }

    public static List<Content> getLists() {
        initialization();
        return new ArrayList<Content>() {
            {
                for (BoardTitle boardTitle : BoardTitle.BOARD_TITLES)
                    for (Content content : AppDataManager.database.get(boardTitle))
                        if (content.inInterest())
                            add(content);
            }
        };
    }

    private static void initialization() {
        if (!AppDataManager.mLoad) {
            for (BoardTitle board : BoardTitle.BOARD_TITLES) {
                List<Integer> seqs = Spider.getSeqeunces(board, 10);
                try {
                    List<Content> contents =
                            new CrawlerServiceUtil(board).execute(seqs.toArray(new Integer[seqs.size()])).get();
                    for (Content c : contents) {
                        c.setDone(random.nextBoolean());
                        c.setInterest(random.nextBoolean());
                    }
                    AppDataManager.database.put(board, contents);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            AppDataManager.mLoad = true;
        }
    }


}

