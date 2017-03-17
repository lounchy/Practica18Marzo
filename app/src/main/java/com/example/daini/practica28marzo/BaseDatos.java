package com.example.daini.practica28marzo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.daini.practica28marzo.Model.EnviarModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daini on 15/03/2017.
 */

public class BaseDatos extends SQLiteOpenHelper {

    private static final String BASE_DATOS = "CREATE TABLE HISTORIAL(id INTEGER PRIMARY KEY AUTOINCREMENT, correo TEXT, asunto TEXT, texto TEXT)";
    public static String HISTORIAL = "Historail";

    public BaseDatos(Context context, String nombreBaseDatos, SQLiteDatabase.CursorFactory cursorFactory, int version) {
        super(context, nombreBaseDatos, cursorFactory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(BASE_DATOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //guardar/insertar datos
    public void insertarDatos(EnviarModel enviarModel) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL("INSERT INTO HISTORIAL(correo, asunto, texto)" + "VALUES('" +
                enviarModel.getPara() + "'," +
                "'" + enviarModel.getAsunto() + "'," +
                "'" + enviarModel.getTexto() + "'" + ")");
        sqLiteDatabase.close();

    }

    //crear ell array de datos para poder encontrar y sacar
    public List<EnviarModel> sacarEnviarArray() {
        List<EnviarModel> enviarArray = null;

        String Consulta = "SELECT correo, asunto, texto, nr FROM HISTORIAL";
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(Consulta, null);

        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            enviarArray = new ArrayList<>();
            do {
                String correo = cursor.getString(0);
                String asunto = cursor.getString(1);
                String texto = cursor.getString(2);

                EnviarModel enviarModel = new EnviarModel(correo, asunto, texto);
                enviarArray.add(enviarModel);
            } while (cursor.moveToNext());
            cursor.close();
        }
        sqLiteDatabase.close();
        return enviarArray;
    }
}
