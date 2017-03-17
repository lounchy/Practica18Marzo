package com.example.daini.practica28marzo.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.daini.practica28marzo.Model.ImaxesModel;
import com.example.daini.practica28marzo.R;

/**
 * Created by Daini on 14/03/2017.
 */

public class FragmentDetalle extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detalle, container, false);

    }

    public void mostrarDetalle(int imaxen) {
        ImageView image = (ImageView) getView().findViewById(R.id.pintar_imagen);
        image.setImageResource(imaxen);
    }
}
