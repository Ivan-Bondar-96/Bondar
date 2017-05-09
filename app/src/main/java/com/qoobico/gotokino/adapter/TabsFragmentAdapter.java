package com.qoobico.gotokino.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.qoobico.gotokino.Films;
import com.qoobico.gotokino.fragment.AbstractTabFragment;
import com.qoobico.gotokino.fragment.FilmsFragment;
import com.qoobico.gotokino.fragment.CinemaFragment;
import com.qoobico.gotokino.fragment.CalendarFragment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TabsFragmentAdapter extends FragmentPagerAdapter {

    private Map<Integer, AbstractTabFragment> tabs;
    private Context context;
    private List<Films> data;

    public TabsFragmentAdapter(Context context, FragmentManager fm, List<Films> data) {
        super(fm);
        this.data = data;
        this.context = context;
        initTabsMap(context);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getTitle();
    }

    @Override
    public Fragment getItem(int position) {
        return tabs.get(position);
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    private void initTabsMap(Context context) {
        tabs = new HashMap<>();
        tabs.put(0, FilmsFragment.getInstance(context));
        tabs.put(1, CinemaFragment.getInstance(context));
        tabs.put(2, CalendarFragment.getInstance(context));
    }


}
