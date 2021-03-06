package it.infotn.itea.commands;

import it.infotn.itea.ContextBot;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Commands {


    protected Update update;

    public abstract SendMessage esegui(ContextBot context);


    protected void log(String first_name, String last_name, String user_id, String txt, String bot_answer, String numeroTelefono) {
        System.out.println("\n ----------------------------");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        System.out.println("Message from " + first_name + " " + last_name + ". (id = " + user_id + " + telefono: " + numeroTelefono +") \n Text - " + txt);

        System.out.println("Bot answer: \n Text - " + bot_answer);
    }

   /* protected Long getChatID(){
        if (update.getMessage()!=null && update.getMessage().getChatId()!=null ){
            return update.getMessage().getChatId();
        }else if(update.getCallbackQuery()!=null && update.getCallbackQuery().getMessage()!=null && update.getCallbackQuery().getMessage().getChatId()!=null){
            return update.getCallbackQuery().getMessage().getChatId();
        }else {
            return  null;
        }


    }*/
}
