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

    public Usuario(String username, String pass) {
        id = count.incrementAndGet();
        this.username = username;
        this.pass = pass;
    }

    public void agregarEncuesta(Encuesta encuesta) {
        manipuladorJSON mJson = new manipuladorJSON();
        mJson.agregarEncuesta(encuesta);
    }
}
