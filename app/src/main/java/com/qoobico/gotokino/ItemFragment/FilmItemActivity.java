package com.qoobico.gotokino.ItemFragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.qoobico.gotokino.R;
import com.squareup.picasso.Picasso;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class FilmItemActivity extends AppCompatActivity
{
    private Toolbar toolbar;
    private ImageView imageView;
    private TextView descr;
    private String punkt;
    Bundle bundle;
    String[] desc= new String[2];

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_item);
        toolbar= (Toolbar) findViewById(R.id.toolbar1);
        descr=(TextView)  findViewById(R.id.descr);
        imageView = (ImageView) findViewById(R.id.imageView1);
        bundle= getIntent().getExtras();
        punkt="div.description";
        toolbar.setTitle(bundle.getString("Nazva"));
        Picasso.with(this).load(bundle.getString("foto")).into(imageView);
        initDescr();
    }

    public void ClickBack (View v)
    {
        super.onBackPressed();
    }

    public void ClickOpus (View v)
    {
            punkt = null;
            punkt = "div.description";
            if(desc[1]!=null){initData(desc[1]);}
            else{initDescr();}


    }

    public void ClickSeans (View v)
    {

            punkt = null;
            punkt = "div.tabholder";
            if(desc[0]!=null){initData(desc[0]);}
            else{initDescr();}
        
    }

    private void initDescr()
    {
        FilmParsDesc pars=new FilmParsDesc();
        try
        {
            String text = new String(pars.execute(bundle.getString("URL")).get());
            descr.setText(Html.fromHtml(text));
            descr.setMovementMethod(LinkMovementMethod.getInstance());
        }
        catch (InterruptedException e)
        { e.printStackTrace();}
        catch (ExecutionException e)
        {e.printStackTrace();}
    }

    private void initData(String data)
    {
        descr.setText(Html.fromHtml(data));
        descr.setMovementMethod(LinkMovementMethod.getInstance());
    }

    class FilmParsDesc extends AsyncTask<String,Void,String>
    {
        String info = new String();

        @Override
        protected String doInBackground(String... params)
        {
            try
            {
                Document document = Jsoup.connect(params[0]).get();
                info = document.select(punkt).first().html();
                if(punkt == "div.tabholder"){desc[0]=info;}else {desc[1]=info;}
            }
            catch (IOException e) {e.printStackTrace();}
            return info;
        }
    }

}
