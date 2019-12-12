package com.slws.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import android.os.Bundle;
import com.slws.R;
import com.slws.model.Content;
import com.slws.ui.home.HtmlParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Iterator;


public class HomeViewModel extends ViewModel /*implements ParserResponseInterface*/{

    private MutableLiveData<String> mText;


    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }
    public void getCrwal(){
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
                //Content(String mTitle, String mDetails, String mDate, String mDeparture, String nNumOfURL)
                ///textInfos.add(new Content(title, "", date, departure, info.split("'")[3]));
            }
        }
    }
    /*
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
*/
    public LiveData<String> getText() {
        return mText;
    }
}