package it.infotn.itea;

public enum CommandsButtonEnum {

    RICHIESTA_CF("codicefiscale:codiceFiscale", "POSSIEDO IL CODICE FISCALE"),
    RICHIESTA_CF_NO("codicefiscaleNO:codiceFiscaleNO", "NON POSSIEDO IL CODICE FISCALE"),
    SI_CITTADINO("cittadinoSI:cittadinoSI", "SI"),
    NO_CITTADINO("cittadinoNO:cittadinoNO", "NO"),

    NO_CITTADINO_SOGGIORNO_VALIDITA("possessoSoggiornoValidita:possessoSoggiornoValidita", "SONO IN POSESSO DI TITOLO DI SOGGIORNO IN CORSO DI VALIDITA'"),
    NO_CITTADINO_SOGGIORNO_RINNOVO("possessoSoggiornoRinnovo:possessoSoggiornoRinnovo", "SONO IN POSESSO DI TITOLO DI SOGGIORNO IN CORSO DI RINNOVO"),
    NO_CITTADINO_SOGGIORNO_SUBORDINATO("possessoSoggiornoRinnovo:possessoSoggiornoRinnovo", "SONO IN ATTESA DEL RILASCIO DEL PRIMO PERMESSO DI SOGGIORNO PER LAVORO SUBORDINATO"),
    NO_CITTADINO_SOGGIORNO_RICONGIUNGIMENTO("possessoSoggiornoRinnovo:possessoSoggiornoRinnovo", "SONO IN ATTESA DEL RILASCIO DEL PERMESSO DI SOGGIORNO PER RICONGIUNGIMENTO FAMILIARE"),



    SI_CITTADINO_LAVORATORE_SUB_AUT("lavoratoreAutSub:lavoratoreAutSub", "Cittadino lavoratore subordinato o autonomo (Art. 7 comma 3 d.lgs. n. 30/2007)"),
    SI_CITTADINO_RISORSE_SUFF("risorseSuff:risorseSuff", "Cittadino titolare di risorse economiche sufficienti al soggiorno (non lavoratore)"),
    SI_CITTADINO_STUDENTE("studente:studente", "Cittadino studente (non lavoratore)"),
    SI_CITTADINO_FAMIGLIARE("famigliare:famigliare", "Familiare UE di cittadino di cui ai punti precedenti"),
    SI_NO_CITTADINO_FAMIGLIARE("noCittFamigliare:noCittFamigliare", "Cittadino di Stato non appartenete all'Unione, familiare di cittadino dell'Unione Europea"),


    SI_DOCUMENTI("documentiSI:documentiSI", "HO TUTTI I DOCUMENTI"),
    NO_DOCUMENTI("documentiNO:documentiNO", "NON HO TUTTI I DOCUMENTI"),

    SI_DOC_ALLOGGIO("documentiAlloggioSI:documentiAlloggioSI", "POSSIEDO I DOCUMENTI ALLOGGIO"),
    NO_DOC_ALLOGGIO("documentiAlloggioNO:documentiAlloggioNO", "NON POSSIEDO I DOCUMENTI ALLOGGIO");


    String command;
    String label;


    CommandsButtonEnum(String command, String label) {

        this.command = command;
        this.label = label;

    }

    public String getCommand() {
        return command;
    }

    public String getLabel() {
        return label;
    }
    }
