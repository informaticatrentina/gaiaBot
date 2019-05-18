package it.infotn.itea.commands.button;

import it.infotn.itea.ContextBot;
import it.infotn.itea.commands.CommandsButton;
import org.telegram.telegrambots.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.api.methods.send.SendDocument;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;

import java.io.InputStream;

public class NoCodiceFiscaleButton extends CommandsButton {

    public NoCodiceFiscaleButton(Update update) {
        this.update = update;
    }

    @Override
    public PartialBotApiMethod<Message> esegui(ContextBot context) {

        SendMessage sendMessage = new SendMessage().setChatId(context.utilityBot.getChatID(update));
         sendMessage.setText(context.messageBundleBuilder.getMessage("testo.noCodFisc"));
        sendMessage.enableHtml(true);


        return sendMessage;
    }

}
