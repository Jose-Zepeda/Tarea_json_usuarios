package org.example.jsonSample;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClsJson
{
    //Convierte un objeto a Json en una linea simple o de un solo elemento

    public String convierteObjetoJson(Object objeto, String archivo) throws IOException {

            ObjectMapper mapper = new ObjectMapper();
            //pasar el objeto a un archivo y lo guarda
            mapper.writeValue(new File(archivo), objeto);
            //pasa el json a un string
        String jsonInString = mapper.writeValueAsString(objeto);
        return jsonInString;



    }

//    public Object convierteJsonAObjeto(){
//        ObjectMapper mapper = new ObjectMapper();
//        Object objArchivo = new Object();
//        try {
//            objArchivo = mapper.readValue(new File("C:\\TMP\\p3.json"), mdBot.class);
//        } catch (Exception exception) {
//            System.out.println("Error: " + exception.getMessage());
//        }
//        return objArchivo;
//    }

    //Trabajando con multiples registros
//lee un archivo json y lo pone en un objeto de type arraylist
    public ArrayList<mdBot> convierteJsonAObjeto() {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<mdBot> listaObjetos = new ArrayList<>();

        try {
            //JSON de archivo a objeto
            listaObjetos = mapper.readValue(new File("C:\\tmp\\fuentes\\file.json"), new TypeReference<ArrayList<mdBot>>(){});
        } catch (Exception ex) {
            Logger.getLogger(ClsJson.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaObjetos;
    }


    //graba en un archivo json un objeto de tipo arraylist
    public String convierteObjetoJson(ArrayList<mdBot> listaObjetos) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        //Pasa el objeto a un archivo y lo guarda
        mapper.writeValue(new File("C:\\TMP\\file.json"), listaObjetos);
        //pasa el json a un string
        String jsonInString = mapper.writeValueAsString(listaObjetos);
        return jsonInString;
    }

    public static void main(String[] args) throws IOException {
        ClsJson objJson = new ClsJson();
        mdBot botData = new mdBot();
        botData = (mdBot) objJson.convierteJsonAObjeto();
        System.out.println("Nombre: " + botData.getNombre());

//        botData.setNombre("Sergio");
//        botData.setMensaje("Hola");
//        botData.setId(123456789L);
//try {
//        System.out.println(objJson.convierteObjetoJson(botData, "C:\\TMP\\p3.json"));
//    }
//catch (Exception exception) {
//    System.out.println("Error: " + exception.getMessage());
//    }
//
 }
} //fin de clase
