package com.example.daini.practica28marzo.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.daini.practica28marzo.Activity.SendMailActivity;
import com.example.daini.practica28marzo.BaseDatos;
import com.example.daini.practica28marzo.Model.EnviarModel;
import com.example.daini.practica28marzo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daini on 15/03/2017.
 */

public class ScreenEnviar extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.enviar_email_screen_enviar, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        final ImageButton enviarB = (ImageButton) getView().findViewById(R.id.enviar);
        enviarB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //encotrar edit text en xml
                EditText paraEt = (EditText) getView().findViewById(R.id.para);
                EditText asuntoEt = (EditText) getView().findViewById(R.id.asunto);
                EditText textoEt = (EditText) getView().findViewById(R.id.texto);
                //sacar texto de edittext
                String para = paraEt.getText().toString();
                String asunto = asuntoEt.getText().toString();
                String texto = textoEt.getText().toString();

                if (!para.equals("") && !asunto.equals("") && !texto.equals("")) {
                    EnviarModel enviarModel = new EnviarModel(para, asunto, texto);

                    //creo base de datos para que siempre aparezca en historial todas mensajes mandados
                    BaseDatos baseDatos = new BaseDatos(getContext(), BaseDatos.HISTORIAL, null, 1);
                    baseDatos.insertarDatos(enviarModel);
                    baseDatos.close();

                    //reseteo la actividad para que en historial aparezca registro al dar botton enviar
                    Intent i = new Intent(getContext(), SendMailActivity.class);
                    startActivity(i);

                    //preparo Email Intent
                    Intent enviar = new Intent(Intent.ACTION_SENDTO);
                    enviar.setData(Uri.parse("mailto:"));
                    enviar.putExtra(Intent.EXTRA_EMAIL, para);
                    enviar.putExtra(Intent.EXTRA_SUBJECT, asunto);
                    enviar.putExtra(Intent.EXTRA_TEXT, texto);
                    startActivity(enviar);

                } else {
                    Toast.makeText(getContext(), "Tienes que llenar todos campos", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
