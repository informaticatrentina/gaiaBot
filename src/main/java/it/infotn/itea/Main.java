package it.infotn.itea;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Main {
    public static void main( final String[] args ) {


        //Inizializzo le API
        ApiContextInitializer.init();

        TelegramBotsApi botsApi= new TelegramBotsApi();

        //Registrazione del bot
        try {
            botsApi.registerBot(new InnovationInfotnBot());
        }catch (TelegramApiException e){
            e.printStackTrace();

        }




    }
}
