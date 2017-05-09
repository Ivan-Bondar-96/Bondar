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

public class CinemaItem extends AppCompatActivity {
    private Toolbar toolbarC;
    private ImageView imageViewC;
    private TextView descrC;
    private String punkt;
    Bundle bundle;
    String[] descC= new String[2];

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinema_item);
        toolbarC= (Toolbar) findViewById(R.id.toolbar_cinema);
        descrC=(TextView)  findViewById(R.id.descr_cinema);
        imageViewC = (ImageView) findViewById(R.id.imageView_cinema);
        bundle= getIntent().getExtras();
        punkt="div.text p";
        toolbarC.setTitle(bundle.getString("Nazva"));
        Picasso.with(this).load(bundle.getString("foto")).into(imageViewC);

        initDescrC();

    }

    public void ClickBackC (View v)
    {
        super.onBackPressed();
    }

    public void ClickAdressC (View v)
    {
            punkt = null;
            punkt = "div.text p";
            if(descC[1]!=null){initDataC(descC[1]);}
            else{initDescrC();}


    }

    public void ClickOpusC (View v)
    {
            punkt = null;
            punkt = "div.description p";
            if(descC[0]!=null){initDataC(descC[0]);}
            else{initDescrC();}

    }

    private void initDescrC()
    {
        CinemaParsDesc pars=new CinemaParsDesc();
        try
        {
            String text = new String(pars.execute(bundle.getString("URL")).get());
            descrC.setText(Html.fromHtml(text));
            descrC.setMovementMethod(LinkMovementMethod.getInstance());
        }
        catch (InterruptedException e)
        { e.printStackTrace();}
        catch (ExecutionException e)
        {e.printStackTrace();}
    }

    private void initDataC(String data)
    {
        descrC.setText(Html.fromHtml(data));
        descrC.setMovementMethod(LinkMovementMethod.getInstance());
    }

    class CinemaParsDesc extends AsyncTask<String,Void,String>
    {
        String info = new String();

        @Override
        protected String doInBackground(String... params)
        {
            try
            {
                Document document = Jsoup.connect(params[0]).get();
                info = document.select(punkt).first().html();
                if(punkt == "div.text p")
                {descC[0]=info;}
                else {descC[1]=info;}
            }
            catch (IOException e) {e.printStackTrace();}
            return info;
        }
    }

}
