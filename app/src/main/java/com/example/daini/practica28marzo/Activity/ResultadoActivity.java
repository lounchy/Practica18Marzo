package com.example.daini.practica28marzo.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.daini.practica28marzo.EscuchaButton;
import com.example.daini.practica28marzo.Fragments.FragmentDetalle;
import com.example.daini.practica28marzo.Fragments.FragmentImaxes;
import com.example.daini.practica28marzo.Fragments.ScreenEnviar;
import com.example.daini.practica28marzo.Model.EnviarModel;
import com.example.daini.practica28marzo.Model.ImaxesModel;
import com.example.daini.practica28marzo.R;

import java.util.List;

public class ResultadoActivity extends AppCompatActivity {
    private List<ImaxesModel> imaxeArray = EscuchaButton.imaxeArray;
    private List<String> nombreArray = EscuchaButton.nombreArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentImaxes fragmentListado = (FragmentImaxes) fragmentManager.findFragmentById(R.id.fragment_imaxes);
        fragmentListado.setListener(this);

    }

    public void imaxeSelecionado(ImaxesModel imaxe) {
        //TODO llevar la fotografia al otro fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentDetalle fragmentDetalle = (FragmentDetalle) fragmentManager.findFragmentById(R.id.fragment_detalle);
        fragmentDetalle.mostrarDetalle(imaxe.getImaxe());
    }

    //creo menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, 1, 1, "Volver eligir");
        menu.add(Menu.NONE, 2, 2, "Enviar por email");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:// limpia lanza actividad para volver eligir
                imaxeArray.clear();
                nombreArray.clear();
                startActivity(new Intent(ResultadoActivity.this, MainActivity.class));
                break;
            case 2://lanza actividad de mandar mensaje por correo
                startActivity(new Intent(ResultadoActivity.this, SendMailActivity.class));

                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        //creo alert dialog
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("¿Que prefieres hacer?");
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Salir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();

            }
        });
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Volver eligir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Todo limpiar lanzar actividad para volver eligir
                imaxeArray.clear();
                nombreArray.clear();
                startActivity(new Intent(ResultadoActivity.this, MainActivity.class));

            }
        });
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Quedarme aqui", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

            }
        });
        alertDialog.show();

    }
}
