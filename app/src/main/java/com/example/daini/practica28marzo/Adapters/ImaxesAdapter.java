package com.example.daini.practica28marzo.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.daini.practica28marzo.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daini on 13/03/2017.
 */

public class ImaxesAdapter extends BaseAdapter {
    private Context context;
    private List<String> posNombreArray;


    public ImaxesAdapter(List<String> posNombreArray, Context context) {
        this.posNombreArray = posNombreArray;
        this.context = context;
    }

    @Override
    public int getCount() {
        return posNombreArray.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View elemento = convertView;
        if (elemento == null) {
            elemento = LayoutInflater.from(context).inflate(R.layout.pintar_imaxes, parent, false);
        } else {
            elemento = convertView;
        }


        TextView nombretv = (TextView) elemento.findViewById(R.id.nombre);
        nombretv.setText(this.posNombreArray.get(position));//saca el nombre del array y setea en textview
        return elemento;
    }
}
