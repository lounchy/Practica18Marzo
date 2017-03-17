package com.example.daini.practica28marzo.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.daini.practica28marzo.Activity.SendMailActivity;
import com.example.daini.practica28marzo.Adapters.HistorialAdapter;
import com.example.daini.practica28marzo.BaseDatos;
import com.example.daini.practica28marzo.Model.EnviarModel;
import com.example.daini.practica28marzo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daini on 15/03/2017.
 */

public class ScreenHistorial extends Fragment {
    private List<EnviarModel> enviarArray;
    private HistorialAdapter historialAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.enviar_email_screen_historial, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        BaseDatos baseDatos = new BaseDatos(getContext(), BaseDatos.HISTORIAL, null, 1);


        enviarArray = baseDatos.sacarEnviarArray();//encuentro array

        historialAdapter = new HistorialAdapter(getContext(), enviarArray); //declaro adapter

        ListView listView = (ListView) getView().findViewById(R.id.historial_listView);
        listView.setAdapter(historialAdapter);//seteo adapter

//        Log.e(getClass().getCanonicalName(), "size = " + enviarArray.size());

    }
}
