package com.example.daini.practica28marzo.Activity;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.daini.practica28marzo.EscuchaButton;
import com.example.daini.practica28marzo.Model.ImaxesModel;
import com.example.daini.practica28marzo.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<ImaxesModel> arrayList;
    private List<ImaxesModel> imaxeArray = EscuchaButton.imaxeArray;
    private List<String> nombreArray = EscuchaButton.nombreArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EscuchaButton escuchaButton = new EscuchaButton(this);
        ImageView ivSi = (ImageView) findViewById(R.id.si);
        ImageView ivNo = (ImageView) findViewById(R.id.no);

        ivSi.setOnClickListener(escuchaButton);
        ivNo.setOnClickListener(escuchaButton);


        //El arra fijo para eligir
        arrayList = new ArrayList<>();
        arrayList.add(new ImaxesModel(R.drawable.amor, "Amor"));
        arrayList.add(new ImaxesModel(R.drawable.cortando_raises, "Raices"));
        arrayList.add(new ImaxesModel(R.drawable.embarazada, "Madre Tierra"));
        arrayList.add(new ImaxesModel(R.drawable.felicidad, "Felicidad"));
        arrayList.add(new ImaxesModel(R.drawable.nina_fumando, "Soy mayor"));
        arrayList.add(new ImaxesModel(R.drawable.nino_y_gato, "La musica"));
        arrayList.add(new ImaxesModel(R.drawable.nino_y_perro, "Ayuda"));
        arrayList.add(new ImaxesModel(R.drawable.no_hay_diferencias, "Hermanos"));
        arrayList.add(new ImaxesModel(R.drawable.soldado_y_mariposa, "Ojos"));
        arrayList.add(new ImaxesModel(R.drawable.tierra_con_fiebre, "Ayudame"));


        ImaxesModel imaxesModel = arrayList.get(0);
        TextView textView = (TextView) findViewById(R.id.mi_tv);
        textView.setText(imaxesModel.getNombre());

    }

    @Override
    public void onBackPressed() {

        //seteo alert dialog
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("¿Quieres salir?");
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

            }
        });
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Sí", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                imaxeArray.clear();//limpia array de imaxes
                nombreArray.clear();//limpia el array de nombres
                finishAffinity();//termia app

            }
        });

        alertDialog.show();
    }
}
