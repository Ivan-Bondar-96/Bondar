package com.qoobico.gotokino.parser;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import com.qoobico.gotokino.Cinema;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Ivan on 05.05.2017.
 */

public class CinemaPars extends AsyncTask<String,Void,ArrayList<Cinema>>
{
    Cinema cinema;
    ArrayList<Cinema> cinemas= new ArrayList<>();


    private String lnk1="http://kinoafisha.ua";

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected ArrayList<Cinema> doInBackground(String... params)
    {
        try
        {
            Document document= Jsoup.connect(params[0]).get();
            Elements item=document.select("div.item");
            for (Element element: item)
            {
                cinema= new Cinema(element.child(1).child(1).text(),
                        lnk1+ element.select("img").attr("src"),
                        element.child(1).child(2).text(),
                        lnk1+ element.child(0).attr("href") ) ;
                cinemas.add(cinema);

            }
        }
        catch (IOException e)
        {
            e.printStackTrace();

        }
        return cinemas;
    }
}