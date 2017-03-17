package com.example.daini.practica28marzo.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.daini.practica28marzo.Model.EnviarModel;
import com.example.daini.practica28marzo.R;

import java.util.List;

/**
 * Created by Daini on 15/03/2017.
 */

public class HistorialAdapter extends ArrayAdapter<EnviarModel> {


    public HistorialAdapter(Context context, List<EnviarModel> enviarArray) {
        super(context, 0, enviarArray);

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View elemento = convertView;
        if (elemento == null) {
            elemento = LayoutInflater.from(getContext()).inflate(R.layout.pintar_historial, parent, false);

        } else {
            elemento = convertView;
        }

        TextView para = (TextView) elemento.findViewById(R.id.para_pintar_tv);
        TextView asunto = (TextView) elemento.findViewById(R.id.asunto_pintar_tv);
        TextView texto = (TextView) elemento.findViewById(R.id.texto_pintar_tv);


        EnviarModel dato = getItem(position);//saca la pos de dto

        para.setText(dato.getPara());
        asunto.setText(dato.getAsunto());
        texto.setText(dato.getTexto());

        return elemento;
    }
}
