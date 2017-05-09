package com.qoobico.gotokino.parser;

import android.content.Context;
import android.os.AsyncTask;

import com.qoobico.gotokino.Films;
import com.qoobico.gotokino.Soon;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Ivan on 02.05.2017.
 */

public class SoonPars extends AsyncTask<String,Void,ArrayList<Soon>>
{
    private Context context;
    Soon film;
    ArrayList<Soon> films= new ArrayList<>();


    private String lnk1="http://kinoafisha.ua";

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected ArrayList<Soon> doInBackground(String... params)
    {
        try
        {
            Document document= Jsoup.connect(params[0]).get();
            Elements item=document.select(".photo");
            for (Element element: item)
            {
                film.setSoon_film(element.child(0).attr("title"));
                film.setPhoto_soon_film("http://kinoafisha.ua/"+element.child(0).attr("src"));
                film.setUrl_soon_film(lnk1 + element.attr("href"));
                films.add(film);

            }
        }
        catch (IOException e)
        {
            e.printStackTrace();

        }
        return films;
    }
}
