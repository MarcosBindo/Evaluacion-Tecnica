package com.challenge.handler;

import java.io.FileWriter;
import java.io.IOException;

import com.challenge.nubi.models.Encuesta;
import com.challenge.nubi.models.Pregunta;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class manipuladorJSON {
    private static JSONObject mainJson = new JSONObject();
    private static JSONObject encuestas = new JSONObject();

    public static JSONObject agregarPregunta(Pregunta pregunta) {
        JSONObject preguntaData = new JSONObject();
        JSONArray respuestas = new JSONArray();

        preguntaData.put("Pregunta", pregunta.getPregunta());
        for (String opciones : pregunta.getRespuestas()) {
            respuestas.add(opciones);
        }
        return preguntaData;
    }

    public static void agregarEncuesta(Encuesta encuesta) {
        JSONObject encuestaData = new JSONObject();
        JSONArray preguntas = new JSONArray();
        encuestaData.put("Nombre", encuesta.getNombre());
        encuestaData.put("Fecha de vencimiento", encuesta.getFecha_vencimiento());

        for (Pregunta pregunta : encuesta.getPreguntas()) {
            JSONObject objPregunta = agregarPregunta(pregunta);
            preguntas.add(objPregunta);
        }

        encuestas.put(encuesta.getNEncuesta(), encuestaData);
        escribirJSON(mainJson);
    }

    private static void escribirJSON(JSONObject objeto) {
        objeto.clear();
        objeto.put("Encuestas", encuestas);
        try (FileWriter file = new FileWriter("bd.json", false)) {
            file.write(objeto.toString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
