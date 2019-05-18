package it.infotn.itea.commands.button;

import it.infotn.itea.CommandsButtonEnum;
import it.infotn.itea.ContextBot;
import it.infotn.itea.commands.CommandsButton;
import it.infotn.itea.utils.UtilityBot;
import org.telegram.telegrambots.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class SiDocumentiAlloggioButton extends CommandsButton {

    public SiDocumentiAlloggioButton(Update update) {
        this.update = update;
    }

    public final UtilityBot utilityBot = new UtilityBot();
    @Override
    public PartialBotApiMethod<Message> esegui(ContextBot context) {



        SendMessage sendMessage = new SendMessage().setChatId(context.utilityBot.getChatID(update));
        sendMessage.setText(context.messageBundleBuilder.getMessage("testo.SI.Documenti.Alloggio"));
        sendMessage.enableHtml(true);



        return sendMessage;

    }

}
