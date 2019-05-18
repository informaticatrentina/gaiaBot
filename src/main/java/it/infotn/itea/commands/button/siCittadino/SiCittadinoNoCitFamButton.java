package it.infotn.itea.commands.button.siCittadino;

import it.infotn.itea.CommandsButtonEnum;
import it.infotn.itea.ContextBot;
import it.infotn.itea.commands.CommandsButton;
import org.telegram.telegrambots.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class SiCittadinoNoCitFamButton extends CommandsButton {

    public SiCittadinoNoCitFamButton(Update update) {
        this.update = update;
    }

    @Override
    public PartialBotApiMethod<Message> esegui(ContextBot context) {

        SendMessage sendMessage = new SendMessage().setChatId(context.utilityBot.getChatID(update));
        sendMessage.setText(context.messageBundleBuilder.getMessage("testo.docAllegare") + " \n " + context.messageBundleBuilder.getMessage("testo.SI_EU.NoCittFam"));
        sendMessage.enableHtml(true);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        List<KeyboardRow> keyboard = new ArrayList<>();
        // first keyboard line
        KeyboardRow keyboardFirstRow = new KeyboardRow();

        KeyboardButton codFiscYesButton = new KeyboardButton();
        codFiscYesButton.setText(CommandsButtonEnum.SI_DOCUMENTI.getLabel());
        keyboardFirstRow.add(codFiscYesButton);

        KeyboardButton codFiscNoButton = new KeyboardButton();
        codFiscNoButton.setText(CommandsButtonEnum.NO_DOCUMENTI.getLabel());
        keyboardFirstRow.add(codFiscNoButton);

        keyboard.add(keyboardFirstRow);

        replyKeyboardMarkup.setKeyboard(keyboard);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);


        return sendMessage;

    }
}
