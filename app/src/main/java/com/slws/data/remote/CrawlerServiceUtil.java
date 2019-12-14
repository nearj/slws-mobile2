package com.slws.data.remote;

import android.os.AsyncTask;

import com.slws.model.Content;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CrawlerServiceUtil extends AsyncTask<String, Void, Content> {
    @Override
    protected Content doInBackground(String... strings) {
        String doc_no = "1";
        String url = "https://uos.ac.kr/korNotice/view.do?list_id=FA1&seq=" + doc_no +
                "&sort=0&pageIndex=1&searchCnd=&searchWrd=&cate_id=&viewAuth=Y&writeAuth=Y&board_list_num=10&lpageCount=10&epTicket=ST-287196-PULOCys2IXtSqbn4wj9ax5RrNgKBGVZu2mh-22";
        Document doc;
        List<String> buf = new ArrayList<>();
        try {
            doc = Jsoup.connect(url).get();

            Elements element = doc.select("ul.listType.view li");
            Iterator<Element> ie1 = element.select("span").iterator();
            Iterator<Element> ie2 = element.select("ul li").iterator();
            Iterator<Element> ie3 = element.select("#view_content p").iterator();

            String title = ie1.next().text();
            String author = ie2.next().text();
            String departure = ie2.next().text();
            String date = ie2.next().text();
            String detailString = "";

            while (ie3.hasNext()) {
                String detail = ie3.next().text();
                detailString += detail + "\n";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
