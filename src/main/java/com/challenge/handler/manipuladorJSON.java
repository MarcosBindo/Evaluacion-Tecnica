package com.challenge.handler;

import com.challenge.nubi.models.Encuesta;

import org.json.simple.JSONObject;

public class manipuladorJSON {
    private static JSONObject mainJson = new JSONObject();

    

    public static JSONObject agregarEncuesta(Encuesta encuesta){
        JSONObject encuestaData = new JSONObject();
        encuestaData.put("Nombre", encuesta.getNombre());
        encuestaData.put("Fecha de vencimiento", encuesta.getFecha_vencimiento());
        encuestaData.put("Preguntas", encuesta.getPreguntas());

        JSONObject objEncuesta = new JSONObject();
        objEncuesta.put(encuesta.getNEncuesta(), encuestaData);

        return objEncuesta;
    }
    
}
