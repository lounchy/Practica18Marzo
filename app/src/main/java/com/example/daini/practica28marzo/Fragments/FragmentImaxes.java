package com.example.daini.practica28marzo.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.daini.practica28marzo.Activity.ResultadoActivity;
import com.example.daini.practica28marzo.Adapters.ImaxesAdapter;
import com.example.daini.practica28marzo.EscuchaButton;
import com.example.daini.practica28marzo.Model.ImaxesModel;
import com.example.daini.practica28marzo.R;

import java.util.List;

/**
 * Created by Daini on 14/03/2017.
 */

public class FragmentImaxes extends Fragment {
    private List<ImaxesModel> imaxeArray = EscuchaButton.imaxeArray;
    private List<String> posNombreArray;
    private ResultadoActivity resultadoActivity;
    private ImaxesAdapter imaxesAdapter;


    public void setListener(ResultadoActivity resultadoActivity) {
        this.resultadoActivity = resultadoActivity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_imaxes, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        posNombreArray = EscuchaButton.nombreArray;// aray de selecionados nombres

        imaxesAdapter = new ImaxesAdapter(posNombreArray, getContext());
        ListView listView = (ListView) getView().findViewById(R.id.fragment_imaxes_list_view);
        listView.setAdapter(imaxesAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                resultadoActivity.imaxeSelecionado(imaxeArray.get(position));
            }
        });
    }
}
