package it.infotn.itea.commands;

import it.infotn.itea.CommandsButtonEnum;
import it.infotn.itea.ContextBot;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class SegnalazioniCommand extends Commands{


    public SegnalazioniCommand(Update update) {
        super();
        this.update = update;
    }

    @Override
    public SendMessage esegui(ContextBot context) {


        SendMessage message = new SendMessage().setChatId(context.utilityBot.getChatID(update));



        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        List<KeyboardRow> keyboard = new ArrayList<>();
//        // first keyboard line
//        KeyboardRow keyboardFirstRow = new KeyboardRow();
//        KeyboardButton keyboardAppartamento = new KeyboardButton();
//        keyboardAppartamento.setText(CommandsButtonEnum.SEGNALAZIONE_APPARTAMENTO.getLabel());
//        keyboardFirstRow.add(keyboardAppartamento);
//
//        KeyboardButton keyboardPartiComuni = new KeyboardButton();
//        keyboardPartiComuni.setText(CommandsButtonEnum.SEGNALAZIONE_PARTICOMUNI.getLabel());
//        keyboardFirstRow.add(keyboardPartiComuni);
//
//        KeyboardButton keyboardRiscaldamento = new KeyboardButton();
//        keyboardRiscaldamento.setText(CommandsButtonEnum.SEGNALAZIONE_CALDAIA.getLabel());
//        keyboardFirstRow.add(keyboardRiscaldamento);
//
//         keyboard.add(keyboardFirstRow);
//
//
//        KeyboardRow keyboardSecondRow = new KeyboardRow();
//        KeyboardButton keyboardSegnalazioniAperte = new KeyboardButton();
//        keyboardSegnalazioniAperte.setText(CommandsButtonEnum.SEGNALAZIONI_LISTA.getLabel());
//        keyboardSecondRow.add(keyboardSegnalazioniAperte);

//        keyboard.add(keyboardSecondRow);
//
//        replyKeyboardMarkup.setKeyboard(keyboard);
//        message.setReplyMarkup(replyKeyboardMarkup);


        /*message.setReplyMarkup(markupInline);*/
        message.setText("Seleziona il tipo di guasto per identificare il problema");
        return message;

    }
}
