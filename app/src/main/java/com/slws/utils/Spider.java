package com.slws.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Spider {
    private static Map<BoardTitle, Integer> lastestSeq = new HashMap<BoardTitle, Integer>() {
        {
            put(BoardTitle.일반공지, 21745);
            put(BoardTitle.학사공지, 7032);
            put(BoardTitle.직원채용, 1081);
//            put(BoardTitle.창업공지, 435);
//            put(BoardTitle.입찰공고, 659);
            put(BoardTitle.시설공사, 132);
            put(BoardTitle.행사안내, 949);
            put(BoardTitle.비교과교육, 17);
        }
    };

    public static List<Integer> getSeqeunces(BoardTitle boardTitle, int size) {

        return new ArrayList<Integer>() {
            {
                for (int i = 0; i < size; i++) {
                    add(lastestSeq.get(boardTitle).intValue() - i);
                }
            }
        };
    }

    public static void setLastestSeq(BoardTitle boardTitle, int lastest) {
        Spider.lastestSeq.put(boardTitle, lastest);
    }
}
