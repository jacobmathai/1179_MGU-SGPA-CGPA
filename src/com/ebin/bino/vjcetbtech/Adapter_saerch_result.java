package com.ebin.bino.vjcetbtech;

import java.io.File;
import java.util.List;

import mg.sgpa.cgpa.R;



import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


class Adapter_saerch_result extends ArrayAdapter<Item>{

	Context context;
	TextView name;
	ImageView icon;
	List<Item> result;
	
	public Adapter_saerch_result(Context context, int resource,List<Item> result) {
		super(context, resource, result);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.result = result;
	}


@Override
public View getView(int position, View convertView, ViewGroup parent) {
	// TODO Auto-generated method stub
	
	LayoutInflater la = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	View v = la.inflate(R.layout.frount_menu_single_item_def, null);
    Item o = result.get(position);
	

	name = (TextView) v.findViewById(R.id.tv_frount_menu);
	icon = (ImageView) v.findViewById(R.id.imageview_frount_menu);
	
	name.setText(o.getName());

	//Toast.makeText(context, o.getImage(), Toast.LENGTH_SHORT).show();
String uri = "drawable/" + o.getImage().toString();
	int imageResource = context.getResources().getIdentifier(uri, null,context.getPackageName());
	Drawable image = context.getResources().getDrawable(imageResource);
icon.setImageDrawable(image);
	

//if((o.getName()=="Sorry, No match found")){
//	icon.setVisibility(View.INVISIBLE);
//}
	
	
	
	return v;
}
	
	
	
}