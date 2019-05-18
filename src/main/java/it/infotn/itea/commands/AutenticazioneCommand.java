package it.infotn.itea.commands;

import it.infotn.itea.ContextBot;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class AutenticazioneCommand extends Commands{

    public AutenticazioneCommand(Update update) {
        super();
        this.update = update;
    }
    @Override
    public SendMessage esegui(ContextBot context) {
        SendMessage message = new SendMessage().setChatId(context.utilityBot.getChatID(update));

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        message.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);


        List<KeyboardRow> keyboard = new ArrayList<>();
        // first keyboard line
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        KeyboardButton keyboardButton = new KeyboardButton();
        keyboardButton.setText(context.messageBundleBuilder.getMessage("button.autenticazione")).setRequestContact(true);
        keyboardFirstRow.add(keyboardButton);
        keyboard.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboard);

        message.setText("Clicca sul bottone sotto per effettuare la registrazione");

        return message;
    }
}
