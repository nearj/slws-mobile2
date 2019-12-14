package com.slws.data;

import com.slws.model.Content;
import com.slws.utils.BoardTitle;

import java.util.List;

public interface DataManager {
    List<Content> getContents(BoardTitle boardTitle, Integer... seqs);
}
