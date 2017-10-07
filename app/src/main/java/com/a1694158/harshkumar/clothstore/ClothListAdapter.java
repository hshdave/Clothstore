package com.a1694158.harshkumar.clothstore;

import android.content.Context;
import android.content.Intent;
import android.os.IInterface;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Harsh on 10/7/2017.
 */

public class ClothListAdapter extends BaseAdapter {


    ArrayList<Clothes> clarray;
    Context c;
    LayoutInflater layoutInflater;

    public ClothListAdapter(ArrayList<Clothes> clarray, Context c) {
        this.clarray = clarray;
        this.c = c;
    }

    @Override
    public int getCount() {
        return clarray.size();
    }

    @Override
    public Object getItem(int i) {
        return clarray.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        if(layoutInflater == null)
        {
            layoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if(view == null)
        {
            view  = layoutInflater.inflate(R.layout.listcontent,viewGroup,false);
        }

        ImageView imageView = view.findViewById(R.id.img_lcon);
        TextView textView = view.findViewById(R.id.txt_lnm);


        Picasso.with(c).load(clarray.get(i).getUrl()).into(imageView);
        textView.setText(clarray.get(i).getName());


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nm = clarray.get(i).getName();
                String path =  clarray.get(i).getUrl();
                Intent i = new Intent(c,ShirtContent.class);
                i.putExtra("name",nm);
                i.putExtra("path",path);
                c.startActivity(i);

            }
        });


        return view;
    }
}
