package com.slws.data.local;

import com.slws.utils.Text;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Iterator;

public class ILocalData {
    public Text crawling(String url) {
        Text details;
        String url_add = "https://uos.ac.kr/korNotice/view.do?list_id=FA1&seq=" + url + "&sort=0&pageIndex=1&searchCnd=&searchWrd=&cate_id=&viewAuth=Y&writeAuth=Y&board_list_num=10&lpageCount=10&epTicket=ST-287196-PULOCys2IXtSqbn4wj9ax5RrNgKBGVZu2mh-22";
        Document doc = null;
        try {
            doc = Jsoup.connect(url_add).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements element = doc.select("ul.listType.view li");
        //System.out.println(element.text());

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
        System.out.println(detailString);

        details = new Text(url, detailString, author);
        return details;
    }
}
