package it.infotn.itea;

import it.infotn.itea.utils.MessageBundleBuilder;
import it.infotn.itea.utils.UtilityBot;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class ContextBot extends TelegramLongPollingBot {

     //La mappa ha per chiave il chat_id e per valore l'ultimo ticket inserito

     Map<Long,Integer> mappaTicket = Collections.synchronizedMap(new HashMap<>());

     public final MessageBundleBuilder messageBundleBuilder = new MessageBundleBuilder();
     public final UtilityBot utilityBot = new UtilityBot();

     public Map<Long, Integer> getMappaTicket() {
          return mappaTicket;
     }

     public void setMappaTicket(HashMap<Long, Integer> mappaTicket) {
          this.mappaTicket = mappaTicket;
     }



}
