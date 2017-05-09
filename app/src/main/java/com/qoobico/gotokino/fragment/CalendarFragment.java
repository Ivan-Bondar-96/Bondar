package com.qoobico.gotokino.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.qoobico.gotokino.Films;
import com.qoobico.gotokino.R;
import com.qoobico.gotokino.Soon;
import com.qoobico.gotokino.adapter.FilmAdapter;
import com.qoobico.gotokino.adapter.SoonAdapter;
import com.qoobico.gotokino.parser.DateSoon;
import com.qoobico.gotokino.parser.FilmFotoPars;
import com.qoobico.gotokino.parser.FilmPars;
import com.qoobico.gotokino.parser.SoonPars;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class CalendarFragment extends AbstractTabFragment {
    private static final int LAYOUT = R.layout.calendar_fragment;
    private ListView rv;
    private Context context;
    private SoonAdapter adapter;
    private List<Soon> items;
    private String lnk="http://kinoafisha.ua/kinoafisha/";

    public static CalendarFragment getInstance(Context context) {
        Bundle args = new Bundle();
        CalendarFragment fragment = new CalendarFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_item_calendar));

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);
        rv =(ListView) view.findViewById(R.id.listVie);
        initializeData();
        return view;
    }

    private void initializeData(){
        SoonPars filmPars=new SoonPars();
        filmPars.execute(lnk);
        DateSoon dateSon= new DateSoon();
        dateSon.execute();
        try {
            items = filmPars.get();
        } catch (InterruptedException e) {
            e.printStackTrace();

        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        try {
            adapter =new SoonAdapter(context, filmPars.get(), dateSon.get());
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
