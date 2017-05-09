package com.qoobico.gotokino.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qoobico.gotokino.Cinema;
import com.qoobico.gotokino.R;
import com.qoobico.gotokino.fragment.CinemaFragment;
import com.qoobico.gotokino.fragment.FilmsFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CinemaAdapter extends ArrayAdapter<String> {

	private final CinemaFragment context;
	private final List<Cinema> itemname;
	private final ArrayList<String> photo;

	public CinemaAdapter(CinemaFragment context, ArrayList<Cinema> itemname, ArrayList<String> photo) {
		super(context.getContext(), R.layout.cinema_item, photo);
		// TODO Auto-generated constructor stub

		this.context=context;
		this.itemname=itemname;
		this.photo= photo;
	}

	public View getView(int position, View view, ViewGroup parent) {
		LayoutInflater inflater=LayoutInflater.from(context.getContext());
		View rowView=inflater.inflate(R.layout.cinema_item, null,true);

		TextView txtTitle = (TextView) rowView.findViewById(R.id.name_cinema);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.foto_cinema);
		TextView cinemaAdress = (TextView) rowView.findViewById(R.id.cinema_adres);

		txtTitle.setText(itemname.get(position).getCinema_nazva());
		Picasso.with(context.getContext()).load(photo.get(position)).into(imageView);
		cinemaAdress.setText(itemname.get(position).getAdress());
		return rowView;

	};


}
