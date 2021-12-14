package com.challenge.nubi.models;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

public class Pregunta {
    private String pregunta;
    private ArrayList<String> respuestas;

    public Pregunta(String pregunta) {
        this.pregunta = pregunta;
        this.respuestas = new ArrayList<String>();
    }

    public void agregarRespuestas(String respuesta) {
        if (respuestas.size() >= 0 && respuestas.size() < 4) {
            this.respuestas.add(respuesta);
        } else {
            switch (respuestas.size()) {
                case 0:
                    System.out.println("Se tiene que agregar al menos una pregunta");
                    break;
                default:
                    System.out.println("El maximo de respuestas es 4");
                    break;
            }
        }
    }
}
