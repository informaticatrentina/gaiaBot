package it.infotn.itea.commands;

import it.infotn.itea.ContextBot;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;

public class BaseCommand extends Commands{
    public BaseCommand(Update update) {
        super();
        this.update = update;
    }

    @Override
    public SendMessage esegui(ContextBot context) {

        return null;

    }
}
