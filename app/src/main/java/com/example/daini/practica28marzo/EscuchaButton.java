package com.example.daini.practica28marzo;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.daini.practica28marzo.Activity.MainActivity;
import com.example.daini.practica28marzo.Activity.ResultadoActivity;
import com.example.daini.practica28marzo.Model.ImaxesModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daini on 13/03/2017.
 */

public class EscuchaButton implements View.OnClickListener {
    private MainActivity mainActivity;
    private int pos = 0; //pos = para poder añadir el item al pos correcta
    private ImageView imageView;
    public static List<ImaxesModel> imaxeArray = new ArrayList<>();
    public static List<String> nombreArray = new ArrayList<>();

    public EscuchaButton(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.si:
                casoSi();
                break;
            case R.id.no:
                casoNo();
                break;

        }
    }

    private void casoSi() {
        /**
         * TODO encontrar item en pos actual, guardar en un array nombre en otro imagen, actualizar pos, preparar siguinte imagen y visualizar
         * **/
        ArrayList<ImaxesModel> array = MainActivity.arrayList;
        ImaxesModel imaxesModel = array.get(pos);
        imaxeArray.add(new ImaxesModel(imaxesModel.getImaxe()));
        nombreArray.add(imaxesModel.getNombre());

        pos = pos + 1;
        int nuevaPos = pos;

        if (pos < array.size()) {

            imaxesModel = array.get(nuevaPos);
            imageView = (ImageView) mainActivity.findViewById(R.id.foto_iw);
            imageView.setImageResource(imaxesModel.getImaxe());
            TextView textView = (TextView) mainActivity.findViewById(R.id.mi_tv);
            textView.setText(imaxesModel.getNombre());
            Log.e(getClass().getCanonicalName(), " array size = " + array.size() + "    " + pos);
            Log.e(getClass().getCanonicalName(), " imaxeArray Size = " + array.size());

        } else {
            mainActivity.startActivity(new Intent(mainActivity, ResultadoActivity.class));
        }

    }

    private void casoNo() {
        /**
         * TODO encontrar item en pos actual, actualizar pos, preparar siguinte imagen y visualizar
         * **/
        ArrayList<ImaxesModel> array = MainActivity.arrayList;
        pos = pos + 1;
        if (pos < array.size()) {
            ImaxesModel imaxesModel = array.get(pos);
            imageView = (ImageView) mainActivity.findViewById(R.id.foto_iw);
            imageView.setImageResource(imaxesModel.getImaxe());
            TextView textView = (TextView) mainActivity.findViewById(R.id.mi_tv);
            textView.setText(imaxesModel.getNombre());
            Log.e(getClass().getCanonicalName(), " array size = " + array.size() + "    " + pos);
            Log.e(getClass().getCanonicalName(), " imaxeArray Size = " + array.size());
        } else {
            mainActivity.startActivity(new Intent(mainActivity, ResultadoActivity.class));
        }

    }
}
