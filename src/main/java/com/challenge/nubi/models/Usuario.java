package com.challenge.nubi.models;

import java.util.concurrent.atomic.AtomicInteger;

import com.challenge.nubi.handler.manipuladorJSON;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Usuario {

    private static final AtomicInteger count = new AtomicInteger();

    private int id;
    private String username;
    private String pass;
    private boolean registrado;
    private int token;

    public Usuario(String username, String pass) {
        id = count.incrementAndGet();
        this.username = username;
        this.pass = pass;
        this.registrado = false;

    }
    //Funcion que hace la comprobacion si el usuario esta registrado o no
    public void agregarEncuesta(Encuesta encuesta) {
        if (this.registrado == true) {
            manipuladorJSON mJson = new manipuladorJSON();
            mJson.agregarEncuesta(encuesta);
        } else {
            System.out.println("Registrarse para subir encuestas");
        }
    }

    public void agregarPregunta(Encuesta encuesta,Pregunta pregunta) {
        encuesta.agregarPregunta(pregunta);
    }

    public void cargarRespuestas(Pregunta pregunta, String respuesta){
        pregunta.agregarRespuestas(respuesta);
    }

    // Metodo para simular que un usuario se registro
    public void registrarse() {
        this.registrado = true;
        // this.token = (int) ((Math.random() * (1000000000 - 10000)) + 10000);
    }
}
