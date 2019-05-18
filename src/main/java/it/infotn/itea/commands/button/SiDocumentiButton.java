package it.infotn.itea.commands.button;

import it.infotn.itea.CommandsButtonEnum;
import it.infotn.itea.ContextBot;
import it.infotn.itea.commands.CommandsButton;
import it.infotn.itea.commands.StartCommand;
import it.infotn.itea.utils.UtilityBot;
import org.telegram.telegrambots.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SiDocumentiButton extends CommandsButton {

    public SiDocumentiButton(Update update) {
        this.update = update;
    }

    public final UtilityBot utilityBot = new UtilityBot();
    @Override
    public PartialBotApiMethod<Message> esegui(ContextBot context) {



        SendMessage sendMessage = new SendMessage().setChatId(context.utilityBot.getChatID(update));
        sendMessage.setText(context.messageBundleBuilder.getMessage("testo.SI.Documenti"));
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
        codFiscYesButton.setText(CommandsButtonEnum.SI_DOC_ALLOGGIO.getLabel());
        keyboardFirstRow.add(codFiscYesButton);

        KeyboardButton codFiscNoButton = new KeyboardButton();
        codFiscNoButton.setText(CommandsButtonEnum.NO_DOC_ALLOGGIO.getLabel());
        keyboardFirstRow.add(codFiscNoButton);

        keyboard.add(keyboardFirstRow);

        replyKeyboardMarkup.setKeyboard(keyboard);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);






        return sendMessage;

    }

}
