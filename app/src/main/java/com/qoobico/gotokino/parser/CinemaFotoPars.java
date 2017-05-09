package com.qoobico.gotokino.parser;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Ivan on 05.05.2017.
 */

public class CinemaFotoPars extends AsyncTask<Void,Void,ArrayList<String>> {
    ArrayList<String> foto = new ArrayList<>();

    @Override
    protected ArrayList<String> doInBackground(Void... params) {

        try {
            Document document = Jsoup.connect("http://kinoafisha.ua/cinema/").get();

            Elements photo = document.select(".photo");
            for (Element element : photo) {
                foto.add("http://kinoafisha.ua/"+element.child(0).attr("src"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return foto;
    }
}