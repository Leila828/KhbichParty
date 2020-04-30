package com.example.khbichparty;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class MateAdapter extends ArrayAdapter {
    List<Mate> mate;

    public MateAdapter( Context context, List<Mate> mates) {
        super(context, 0,mates);
        mate=mates;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//LayoutInflater : Instancie un fichier XML de mise en page dans les objets
        if (convertView ==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.item,parent,false);
        }
        MateViewHolder viewHolder=(MateViewHolder) convertView.getTag();
        if (viewHolder==null){

            viewHolder=new MateViewHolder();
            viewHolder.name=(TextView) convertView.findViewById(R.id.titre);
            viewHolder.zone=(TextView) convertView.findViewById(R.id.text);
            convertView.setTag(viewHolder);  }
       Mate mate= (Mate) getItem(position);

        viewHolder.name.setText(mate.name);
        viewHolder.zone.setText(mate.zone);


        return convertView;

    }





}
