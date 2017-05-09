package com.qoobico.gotokino.parser;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Ivan on 02.05.2017.
 */

public class DateSoon extends AsyncTask<Void,Void,ArrayList<String>> {
    ArrayList<String> date = new ArrayList<>();

    @Override
    protected ArrayList<String> doInBackground(Void... params) {

        try {
            Document document = Jsoup.connect("http://kinoafisha.ua/skoro/").get();
            Elements date1 = document.select("div.date");

            for (Element element : date1) {
                date.add(element.text());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return date;
    }
}