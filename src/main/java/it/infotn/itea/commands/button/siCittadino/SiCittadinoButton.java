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

public class SiCittadinoButton extends CommandsButton {

    public SiCittadinoButton(Update update) {
        this.update = update;
    }

    @Override
    public PartialBotApiMethod<Message> esegui(ContextBot context) {

        SendMessage sendMessage = new SendMessage().setChatId(context.utilityBot.getChatID(update));
        sendMessage.setText(context.messageBundleBuilder.getMessage("testo.siCittadino"));
        sendMessage.enableHtml(true);


        sendMessage.enableHtml(true);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        List<KeyboardRow> keyboard = new ArrayList<>();
        // first keyboard line
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        KeyboardRow keyboardThirdRow = new KeyboardRow();
        KeyboardRow keyboardFourthRow = new KeyboardRow();
        KeyboardRow keyboardFifthRow = new KeyboardRow();

        KeyboardButton cittSoggValid = new KeyboardButton();
        cittSoggValid.setText(CommandsButtonEnum.SI_CITTADINO_LAVORATORE_SUB_AUT.getLabel());
        keyboardFirstRow.add(cittSoggValid);

        KeyboardButton cittSoggRinnovo = new KeyboardButton();
        cittSoggRinnovo.setText(CommandsButtonEnum.SI_CITTADINO_RISORSE_SUFF.getLabel());
        keyboardSecondRow.add(cittSoggRinnovo);

        KeyboardButton cittSoggSubordinato = new KeyboardButton();
        cittSoggSubordinato.setText(CommandsButtonEnum.SI_CITTADINO_STUDENTE.getLabel());
        keyboardThirdRow.add(cittSoggSubordinato);

        KeyboardButton cittSoggRincon = new KeyboardButton();
        cittSoggRincon.setText(CommandsButtonEnum.SI_CITTADINO_FAMIGLIARE.getLabel());
        keyboardFourthRow.add(cittSoggRincon);

        KeyboardButton cittFamNoEu = new KeyboardButton();
        cittFamNoEu.setText(CommandsButtonEnum.SI_NO_CITTADINO_FAMIGLIARE.getLabel());
        keyboardFifthRow.add(cittFamNoEu);

        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
        keyboard.add(keyboardThirdRow);
        keyboard.add(keyboardFourthRow);
        keyboard.add(keyboardFifthRow);

        replyKeyboardMarkup.setKeyboard(keyboard);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);


        return sendMessage;
    }

}
