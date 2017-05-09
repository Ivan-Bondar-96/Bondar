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

import com.qoobico.gotokino.Cinema;
import com.qoobico.gotokino.ItemFragment.CinemaItem;
import com.qoobico.gotokino.R;
import com.qoobico.gotokino.adapter.CinemaAdapter;
import com.qoobico.gotokino.parser.CinemaFotoPars;
import com.qoobico.gotokino.parser.CinemaPars;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class CinemaFragment extends AbstractTabFragment {
    private static final int LAYOUT = R.layout.cinema_fragment;
    private ListView lv;
    private String lnk="http://kinoafisha.ua/cinema/";

    private List<Cinema> items;

    public static CinemaFragment getInstance(Context context) {
        Bundle args = new Bundle();
        CinemaFragment fragment = new CinemaFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_item_cinema));

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);
        lv =(ListView) view.findViewById(R.id.lv);
        initializeData();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(view.getContext(), CinemaItem.class);
                intent.putExtra("Nazva", items.get(i).getCinema_nazva());
                intent.putExtra("foto", items.get(i).getCinemaPhoto());
                intent.putExtra("URL", items.get(i).getUrl());
                startActivity(intent);
            }
        });

        return view;
    }
    private void initializeData(){
        CinemaPars cinemaPars=new CinemaPars();
        cinemaPars.execute(lnk);
        CinemaFotoPars fotoPars= new CinemaFotoPars();
        fotoPars.execute();
        CinemaAdapter adapter=null;
        try {
            items=cinemaPars.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        try {
            adapter =new CinemaAdapter(this, cinemaPars.get(), fotoPars.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        lv.setAdapter(adapter);
    }

    public void setContext(Context context) {
        this.context = context;
    }

}
