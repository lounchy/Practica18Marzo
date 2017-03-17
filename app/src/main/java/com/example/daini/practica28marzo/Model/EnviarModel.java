package com.example.daini.practica28marzo.Model;

/**
 * Created by Daini on 15/03/2017.
 */

public class EnviarModel {
    private String para;
    private String asunto;
    private String texto;

    public EnviarModel(String para, String asunto, String texto) {
        this.para = para;
        this.asunto = asunto;
        this.texto = texto;
    }

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
