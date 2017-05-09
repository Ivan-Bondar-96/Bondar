package com.qoobico.gotokino.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.qoobico.gotokino.parser.FilmFotoPars;
import com.qoobico.gotokino.ItemFragment.FilmItemActivity;
import com.qoobico.gotokino.parser.FilmPars;
import com.qoobico.gotokino.Films;
import com.qoobico.gotokino.R;
import com.qoobico.gotokino.adapter.FilmAdapter;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class FilmsFragment extends AbstractTabFragment {
    private static final int LAYOUT = R.layout.films_fragment;
    private ListView rv;
    private Context context;
    private FilmAdapter adapter;
    private List<Films> items;
    private String lnk="http://kinoafisha.ua/kinoafisha/";


    public static FilmsFragment getInstance(Context context) {
        Bundle args = new Bundle();
        FilmsFragment fragment = new FilmsFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_item_films));

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);
        rv =(ListView) view.findViewById(R.id.rv);
        initializeData();

        rv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(view.getContext(), FilmItemActivity.class);
                intent.putExtra("Nazva", items.get(i).getFilm_nazva());
                intent.putExtra("foto", items.get(i).getFoto());
                intent.putExtra("URL", items.get(i).getUrl());
                startActivity(intent);
            }
        });

        return view;
    }
    private void initializeData(){
        FilmPars filmPars=new FilmPars();
        filmPars.execute(lnk);
        FilmFotoPars fotoPars= new FilmFotoPars();
        fotoPars.execute();
        try {
            items = filmPars.get();
        } catch (InterruptedException e) {
            e.printStackTrace();

        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        try {
            adapter =new FilmAdapter(context, filmPars.get(), fotoPars.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        rv.setAdapter(adapter);
      }

    public void setContext(Context context) {
        this.context = context;
    }

}
