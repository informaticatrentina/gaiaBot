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

public class StartCommand extends Commands{


    public StartCommand(Update update) {
        super();
        this.update = update;
    }

    @Override
    public SendMessage esegui(ContextBot context) {

        //Genero una sessione

        SendMessage message = new SendMessage().setChatId(context.utilityBot.getChatID(update));




        StringBuffer testoDiPresentazione = new StringBuffer("\n");
        testoDiPresentazione.append("Ciao  <b>" + update.getMessage().getChat().getFirstName() + "</b>\n");

        testoDiPresentazione.append(context.messageBundleBuilder.getMessage("itea.benvenuto"));


        testoDiPresentazione.append("<b> SEI IN POSSESSO DEL CODICE FISCALE? EFFETTUA LA SELEZIONE </b>");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        message.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);



        List<KeyboardRow> keyboard = new ArrayList<>();
        // first keyboard line
        KeyboardRow keyboardFirstRow = new KeyboardRow();

        KeyboardButton codFiscYesButton = new KeyboardButton();
        codFiscYesButton.setText(CommandsButtonEnum.RICHIESTA_CF.getLabel());
        keyboardFirstRow.add(codFiscYesButton);

        KeyboardButton codFiscNoButton = new KeyboardButton();
        codFiscNoButton.setText(CommandsButtonEnum.RICHIESTA_CF_NO.getLabel());
        keyboardFirstRow.add(codFiscNoButton);

        keyboard.add(keyboardFirstRow);

        replyKeyboardMarkup.setKeyboard(keyboard);
        message.setReplyMarkup(replyKeyboardMarkup);

            //testoDiPresentazione.append( CommandsEnum.AUTENTICAZIONE.getCommand()).append(context.messageBundleBuilder.getMessage("command.autenticazione.testo"));

        message.setText(testoDiPresentazione.toString()).enableHtml(true);
        /*log(user_first_name, user_last_name, Long.toString(update.getMessage().getChatId()), update.getMessage().getText(), message.getText(),"");*/

        return message;

    }
}
