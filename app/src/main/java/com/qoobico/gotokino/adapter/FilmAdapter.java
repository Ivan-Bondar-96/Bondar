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
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FilmAdapter extends ArrayAdapter<String> {

	private final Context context;
	private final List<Films> itemname;
	private final ArrayList<String> photo;

	public FilmAdapter(Context context, ArrayList<Films> itemname, ArrayList<String> photo) {
		super(context, R.layout.item_film, photo);
		// TODO Auto-generated constructor stub

		this.context=context;
		this.itemname=itemname;
		this.photo= photo;
	}

	public View getView(int position,View view,ViewGroup parent) {
		LayoutInflater inflater=LayoutInflater.from(context);
		View rowView=inflater.inflate(R.layout.item_film, null,true);

		TextView txtTitle = (TextView) rowView.findViewById(R.id.titel_film);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.foto_film);
		//TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);

		txtTitle.setText(itemname.get(position).getFilm_nazva());
		Picasso.with(context).load(photo.get(position)).into(imageView);
		//extratxt.setText("Description "+itemname.get(position));
		return rowView;

	};


}