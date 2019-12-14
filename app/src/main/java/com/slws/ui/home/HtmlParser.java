package com.slws.ui.home;

import android.os.AsyncTask;

import com.slws.model.Content;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class HtmlParser extends AsyncTask<String, Void, Boolean> {
    private ParserResponseInterface parserResponseInterface;
    private ArrayList<Content> textInfos = new ArrayList<Content>();
    public HtmlParser(ParserResponseInterface parserResponseInterface){
        this.parserResponseInterface = parserResponseInterface;
    }
    @Override
    protected Boolean doInBackground(String... params){
        String url = "https://uos.ac.kr/korNotice/list.do?list_id=FA1";
        Document doc = null;

        try{
            doc = Jsoup.connect(url).get();
        }catch(IOException e){
            e.printStackTrace();
        }
        Elements element = doc.select("ul.listType li");

        Iterator<Element> ie1 = element.select("a").iterator();
        Iterator<Element> ie2 = element.select("ul li").iterator();
        Iterator<Element> ie3 = element.select("a span.mhide").iterator();

        String title = "";
        while (ie1.hasNext()) {
            Element tit_info = ie1.next();
            if(!(title = tit_info.text()).equals("")) {
                String info = tit_info.attr("href");
                if(info.equals("#")) {
                    info = tit_info.attr("onclick");
                }
                if(!title.substring(0,1).equals("["))
                {
                    title = title.replace(ie3.next().text(), "");
                }
                String departure = ie2.next().text();
                String date = ie2.next().text();
                String visited = ie2.next().text();
                ie2.next();
                //Content(String mTitle, String mDetail, String mDate, String mDeparture, String nNumOfURL)
                textInfos.add(new Content(title, "", date, departure, info.split("'")[3]));
            }
        }
        return true;

    }
    public ArrayList<Content> getNoticeList(){
        return textInfos;
    }
}
