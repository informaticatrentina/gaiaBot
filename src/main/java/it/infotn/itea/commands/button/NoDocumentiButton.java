package it.infotn.itea.commands.button;

import it.infotn.itea.ContextBot;
import it.infotn.itea.commands.CommandsButton;
import org.telegram.telegrambots.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;

public class NoDocumentiButton extends CommandsButton {

    public NoDocumentiButton(Update update) {
        this.update = update;
    }

    @Override
    public PartialBotApiMethod<Message> esegui(ContextBot context) {

        SendMessage sendMessage = new SendMessage().setChatId(context.utilityBot.getChatID(update));
         sendMessage.setText(context.messageBundleBuilder.getMessage("testo.NO.Documenti"));
        sendMessage.enableHtml(true);

        return sendMessage;
    }

}
