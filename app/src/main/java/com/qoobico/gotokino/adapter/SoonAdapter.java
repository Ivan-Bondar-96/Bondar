package com.qoobico.gotokino.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qoobico.gotokino.Films;
import com.qoobico.gotokino.R;
import com.qoobico.gotokino.Soon;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SoonAdapter extends ArrayAdapter<String> {

	private final Context context;
	private final List<Soon> itemname;
	private final ArrayList<String> date;

	public SoonAdapter(Context context, ArrayList<Soon> itemname, ArrayList<String> date) {
		super(context, R.layout.item_soon, date);
		// TODO Auto-generated constructor stub

		this.context=context;
		this.itemname=itemname;
		this.date= date;
	}

	public View getView(int position,View view,ViewGroup parent) {
		LayoutInflater inflater=LayoutInflater.from(context);
		View rowView=inflater.inflate(R.layout.item_film, null,true);

		TextView txtTitle = (TextView) rowView.findViewById(R.id.film_nazva_soon);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.film_soon_foto);
		TextView data = (TextView) rowView.findViewById(R.id.data_soon);

		txtTitle.setText(itemname.get(position).getSoon_film());
		data.setText(date.get(position));
		Picasso.with(context).load(itemname.get(position).getPhoto_soon_film()).into(imageView);
		//extratxt.setText("Description "+itemname.get(position));
		return rowView;

	};


}