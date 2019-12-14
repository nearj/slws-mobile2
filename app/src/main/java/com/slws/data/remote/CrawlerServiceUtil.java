package com.slws.data.remote;

import android.os.AsyncTask;

import com.slws.model.Content;
import com.slws.utils.BoardTitle;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CrawlerServiceUtil extends AsyncTask<Integer, Void, List<Content>> {
    Document doc;
    String title, author, departure, date, detailString, mURL;
    List<Content> contentList = new ArrayList<>();

    public CrawlerServiceUtil(BoardTitle boardTitle) {
        mURL = boardTitle.getURL();
    }

    @Override
    protected List<Content> doInBackground(Integer... integers) {
        for (Integer i : integers) {
            mURL += i + "&epTicket=LOG";

            try {
                doc = Jsoup.connect(mURL).get();

                Elements element = doc.select("ul.listType.view li");
                Iterator<Element> ie1 = element.select("span").iterator();
                Iterator<Element> ie2 = element.select("ul li").iterator();
                Iterator<Element> ie3 = element.select("#view_content p").iterator();


                title = ie1.next().text();
                author = ie2.next().text();
                departure = ie2.next().text();
                date = ie2.next().text();
                detailString = "";

                while (ie3.hasNext()) {
                    String detail = ie3.next().text();
                    detailString += detail + "\n";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            contentList.add(new Content(title, author, departure, date, detailString));
        }
        return contentList;
    }

}
