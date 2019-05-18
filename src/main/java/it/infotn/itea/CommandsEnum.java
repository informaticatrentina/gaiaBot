package it.infotn.itea;

public enum CommandsEnum {

    START("/start"),
    AUTENTICAZIONE("/autenticazione"),
    SEGNALAZIONI("/segnalazioni"),
    ASSISTENZA("/assistenza"),
    HELP("/help");

    String command;

    CommandsEnum(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
