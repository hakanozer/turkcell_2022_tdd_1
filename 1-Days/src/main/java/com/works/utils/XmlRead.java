package com.works.utils;

import com.works.props.Currency;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class XmlRead {


    public List<Currency> xml() {
        List<Currency> ls = new ArrayList<>();
        try {
            String url = "https://www.tcmb.gov.tr/kurlar/today.xml";
            String data = Jsoup.connect(url).timeout(15000).ignoreContentType(true).get().toString();
            Document doc = Jsoup.parse(data, Parser.xmlParser());
            Elements elements = doc.getElementsByTag("Currency");
            for(Element item : elements) {
                String ForexBuying = item.getElementsByTag("ForexBuying").text();
                String ForexSelling = item.getElementsByTag("ForexSelling").text();
                Currency c = new Currency();
                c.setForexSelling(ForexSelling);
                c.setForexBuying(ForexBuying);
                ls.add(c);
            }
        }catch (Exception ex) {

        }
        return ls;
    }

}
