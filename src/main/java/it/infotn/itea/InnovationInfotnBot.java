package it.infotn.itea;

import it.infotn.itea.commands.Commands;
import it.infotn.itea.commands.SegnalazioniCommand;
import it.infotn.itea.commands.StartCommand;
import it.infotn.itea.commands.button.*;
import it.infotn.itea.commands.button.noCittadino.NoCittadinoButton;
import it.infotn.itea.commands.button.noCittadino.NoCittadinoSoggiornoRicongiungimentoButton;
import it.infotn.itea.commands.button.noCittadino.NoCittadinoSoggiornoSubordinatoButton;
import it.infotn.itea.commands.button.noCittadino.NoCittadinoSoggiornoValiditaButton;
import it.infotn.itea.commands.button.siCittadino.*;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.InputStream;
import java.util.EnumSet;
import java.util.Optional;

public class InnovationInfotnBot extends ContextBot {


    public String getBotToken() {
        return messageBundleBuilder.getMessage("itea.botToken");
    }

    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {

            System.out.println("Il codice update ID è " + update.getUpdateId().toString());
            Long chat_id = update.getMessage().getChatId();
            System.out.println("Arrivata codice chat_id numero " + chat_id);
            operationCommand(update);

        } else if (update.hasCallbackQuery()) {
            operationButton(update);

        }
    }

    public String getBotUsername() {
        return "InnovazioneInfotnBot";
    }

    private void operationButton(Update update) {
        String message_text = update.getCallbackQuery()==null?update.getMessage().getText():update.getCallbackQuery().getData();



        //Controllo se il messaggio è presente nell'enum
        Optional<CommandsButtonEnum> isThereCommand = EnumSet.allOf(CommandsButtonEnum.class)
                .stream()
                .filter(commandsButtonEnum -> message_text.contains(commandsButtonEnum.getCommand())
                        || commandsButtonEnum.getLabel().equals(message_text))
                .findFirst();

        if (!isThereCommand.isPresent()) {
            this.operation(update, message_text);
        } else {

             if (isThereCommand.get().command.equals(CommandsButtonEnum.RICHIESTA_CF_NO.command) ) {

                NoCodiceFiscaleButton noCodiceFiscaleButton = new NoCodiceFiscaleButton(update);
                try {
                    execute((SendMessage)noCodiceFiscaleButton.esegui(this));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }else if (isThereCommand.get().command.equals(CommandsButtonEnum.RICHIESTA_CF.command) ) {

                SiCodiceFiscaleButton siCodiceFiscaleButton = new SiCodiceFiscaleButton(update);
                try {
                    execute((SendMessage)siCodiceFiscaleButton.esegui(this));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
             else if (isThereCommand.get().command.equals(CommandsButtonEnum.SI_CITTADINO.command) ) {

                 SiCittadinoButton siCittadinoButton = new SiCittadinoButton(update);
                 try {
                     execute((SendMessage)siCittadinoButton.esegui(this));
                 } catch (TelegramApiException e) {
                     e.printStackTrace();
                 }
             }else if (isThereCommand.get().command.equals(CommandsButtonEnum.NO_CITTADINO.command) ) {

                 NoCittadinoButton noCittadinoButton = new NoCittadinoButton(update);
                 try {
                     execute((SendMessage)noCittadinoButton.esegui(this));
                 } catch (TelegramApiException e) {
                     e.printStackTrace();
                 }
             }else if (isThereCommand.get().command.equals(CommandsButtonEnum.NO_CITTADINO_SOGGIORNO_VALIDITA.command) ) {

                 NoCittadinoSoggiornoValiditaButton noCittadinoSoggiornoValiditaButton = new NoCittadinoSoggiornoValiditaButton(update);
                 try {
                     execute((SendMessage)noCittadinoSoggiornoValiditaButton.esegui(this));
                 } catch (TelegramApiException e) {
                     e.printStackTrace();
                 }
             }
             else if (isThereCommand.get().command.equals(CommandsButtonEnum.NO_CITTADINO_SOGGIORNO_SUBORDINATO.command) ) {

                 NoCittadinoSoggiornoSubordinatoButton noCittadinoSoggiornoSubordinatoButton = new NoCittadinoSoggiornoSubordinatoButton(update);
                 try {
                     execute((SendMessage)noCittadinoSoggiornoSubordinatoButton.esegui(this));
                 } catch (TelegramApiException e) {
                     e.printStackTrace();
                 }
             }
             else if (isThereCommand.get().command.equals(CommandsButtonEnum.NO_CITTADINO_SOGGIORNO_RICONGIUNGIMENTO.command) ) {

                 NoCittadinoSoggiornoRicongiungimentoButton noCittadinoSoggiornoRicongiungimentoButton = new NoCittadinoSoggiornoRicongiungimentoButton(update);
                 try {
                     execute((SendMessage)noCittadinoSoggiornoRicongiungimentoButton.esegui(this));
                 } catch (TelegramApiException e) {
                     e.printStackTrace();
                 }
             }


             else if (isThereCommand.get().command.equals(CommandsButtonEnum.SI_CITTADINO_LAVORATORE_SUB_AUT.command) ) {

                 SiCittadinoLavAutButton siCittadinoLavAutButton = new SiCittadinoLavAutButton(update);
                 try {
                     execute((SendMessage)siCittadinoLavAutButton.esegui(this));
                 } catch (TelegramApiException e) {
                     e.printStackTrace();
                 }
             }

             else if (isThereCommand.get().command.equals(CommandsButtonEnum.SI_CITTADINO_RISORSE_SUFF.command) ) {

                 SiCittadinoRisorseSufficientiButton siCittadinoRisorseSufficientiButton = new SiCittadinoRisorseSufficientiButton(update);
                 try {
                     execute((SendMessage)siCittadinoRisorseSufficientiButton.esegui(this));
                 } catch (TelegramApiException e) {
                     e.printStackTrace();
                 }
             }

             else if (isThereCommand.get().command.equals(CommandsButtonEnum.SI_CITTADINO_STUDENTE.command) ) {

                 SiCittadinoStudenteButton siCittadinoStudenteButton = new SiCittadinoStudenteButton(update);
                 try {
                     execute((SendMessage)siCittadinoStudenteButton.esegui(this));
                 } catch (TelegramApiException e) {
                     e.printStackTrace();
                 }
             }


             else if (isThereCommand.get().command.equals(CommandsButtonEnum.SI_CITTADINO_FAMIGLIARE.command) ) {

                 SiCittadinoNoCitFamButton siCittadinoNoCitFamButton = new SiCittadinoNoCitFamButton(update);
                 try {
                     execute((SendMessage)siCittadinoNoCitFamButton.esegui(this));
                 } catch (TelegramApiException e) {
                     e.printStackTrace();
                 }
             }

             else if (isThereCommand.get().command.equals(CommandsButtonEnum.SI_NO_CITTADINO_FAMIGLIARE.command) ) {

                 SiCittadinoFamigliareButton siCittadinoFamigliareButton = new SiCittadinoFamigliareButton(update);
                 try {
                     execute((SendMessage)siCittadinoFamigliareButton.esegui(this));
                 } catch (TelegramApiException e) {
                     e.printStackTrace();
                 }
             }


             else if (isThereCommand.get().command.equals(CommandsButtonEnum.NO_DOCUMENTI.command) || isThereCommand.get().command.equals(CommandsButtonEnum.NO_DOC_ALLOGGIO.command) ) {

                 NoDocumentiButton noDocumentiButton = new NoDocumentiButton(update);
                 try {
                     execute((SendMessage)noDocumentiButton.esegui(this));

                 } catch (TelegramApiException e) {
                     e.printStackTrace();
                 }
             }

             else if (isThereCommand.get().command.equals(CommandsButtonEnum.SI_DOCUMENTI.command) ) {

                 SiDocumentiButton siDocumentiButton = new SiDocumentiButton(update);
                 try {

                     SendPhoto sendPhotoRequest = new SendPhoto();
                     sendPhotoRequest.setChatId(utilityBot.getChatID(update));
                     InputStream stream = this.getClass().getResourceAsStream("/titolaritaAlloggio.png");
                     sendPhotoRequest.setNewPhoto("Foto comune di Trento", stream);

                     System.out.println("Comando arrivato " + message_text);

                     sendPhoto(sendPhotoRequest);
                     execute((SendMessage)siDocumentiButton.esegui(this));




                 } catch (TelegramApiException e) {
                     e.printStackTrace();
                 }
             }


             else if (isThereCommand.get().command.equals(CommandsButtonEnum.SI_DOC_ALLOGGIO.command) ) {

                 SiDocumentiAlloggioButton siDocumentiAlloggioButton = new SiDocumentiAlloggioButton(update);
                 try {
                     execute((SendMessage)siDocumentiAlloggioButton.esegui(this));

                 } catch (TelegramApiException e) {
                     e.printStackTrace();
                 }
             }





        }

    }

    private void operationCommand(Update update) {
        String message_text = update.getMessage().getText();

        Optional<CommandsButtonEnum> isThereCommand = EnumSet.allOf(CommandsButtonEnum.class)
                .stream()
                .filter(commandsButtonEnum -> commandsButtonEnum.getLabel().equals(message_text))
                .findFirst();
        if (isThereCommand.isPresent()){
            this.operationButton(update);
        }else {
            this.operation(update, message_text);
        }

    }

    private void operation(Update update, String message_text) {

        Commands command;
        if (message_text.contains(CommandsEnum.START.command)) {

            SendPhoto sendPhotoRequest = new SendPhoto();
            sendPhotoRequest.setChatId(utilityBot.getChatID(update));


            InputStream stream = this.getClass().getResourceAsStream("/comune.jpg");
            sendPhotoRequest.setNewPhoto("Foto comune di Trento", stream);

            try {
                sendPhoto(sendPhotoRequest);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

            command = new StartCommand(update);
            SendMessage sendMessage = command.esegui(this);
            /*getAuthButton(sendMessage);*/
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (message_text.contains(CommandsEnum.SEGNALAZIONI.command)) {
            command = new SegnalazioniCommand(update);
            try {
                execute(command.esegui(this));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }



        }

    }


}
