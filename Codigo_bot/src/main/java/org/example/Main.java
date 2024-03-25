package org.example;

import org.example.jsonSample.ClsJson;
import org.example.jsonSample.mdBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws TelegramApiException {

        System.out.println("Iniciando bot");
//        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
//        botsApi.registerBot(new Bot());


        ClsJson obj = new ClsJson();
        ArrayList<mdBot> listaCarreras = new ArrayList<>();
        mdBot carrera1 = new mdBot();
        carrera1.setNombre("Ingenieria en Sistemas");
        carrera1.setId(1L);
        carrera1.setMensaje("Hola");
        listaCarreras.add(carrera1);
        // Agrega más objetos mdBot a listaCarreras si es necesario
        carrera1 = new mdBot();
        carrera1.setNombre("prueba 2");
        carrera1.setId(5L);
        carrera1.setMensaje("otra cosa");
        listaCarreras.add(carrera1);
        try {
            System.out.println(obj.convierteObjetoJson(listaCarreras));
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        //recupera el archivo y lo pone en un objeto
        ArrayList<mdBot> listaChats = obj.convierteJsonAObjeto();
        for (mdBot dato : listaChats) {
            System.out.println("Nombre: " + dato.getNombre());
            System.out.println("Mensaje: " + dato.getMensaje());
            System.out.println("ID: " + dato.getId());
        }


    }
}