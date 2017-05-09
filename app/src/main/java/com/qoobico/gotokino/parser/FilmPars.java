package com.qoobico.gotokino.parser;

import android.content.Context;
import android.os.AsyncTask;

import com.qoobico.gotokino.Films;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Ivan on 02.05.2017.
 */

public class FilmPars extends AsyncTask<String,Void,ArrayList<Films>>
{
    private Context context;
    Films film;
    ArrayList<Films> films= new ArrayList<>();


    private String lnk1="http://kinoafisha.ua";

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected ArrayList<Films> doInBackground(String... params)
    {
        try
        {
            Document document= Jsoup.connect(params[0]).get();
            Elements item=document.select(".photo");
            for (Element element: item)
            {
                film= new Films(element.child(0).attr("title"),
                                "http://kinoafisha.ua/"+element.child(0).attr("src"),
                                lnk1 + element.attr("href") ) ;

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
