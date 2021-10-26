package it.unibas.banca.controllo;

import it.unibas.banca.Applicazione;
import it.unibas.banca.modello.Archivio;
import it.unibas.banca.modello.ContoCorrente;
import it.unibas.banca.modello.Costanti;
import it.unibas.banca.persistenza.DaoException;
import it.unibas.banca.persistenza.IDAOArchivio;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.KeyStroke;

public class ControlloFrame {

    private Action azioneEsci = new AzioneEsci();
    private Action azioneCarica = new AzioneCarica();
    private Action azioneVerifica = new AzioneVerifica();

    public Action getAzioneEsci() {
        return azioneEsci;
    }

    public Action getAzioneCarica() {
        return azioneCarica;
    }

    public Action getAzioneVerifica() {
        return azioneVerifica;
    }

    private class AzioneCarica extends AbstractAction {

        public AzioneCarica() {
            this.putValue(NAME, "Carica archivio");
            this.putValue(SHORT_DESCRIPTION, "Carica archivio da file");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_A);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("alt ctrl A"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            IDAOArchivio daoArchivio = Applicazione.getInstance().getDaoArchivio();
            try {
                Archivio archivio = daoArchivio.carica("");
                Applicazione.getInstance().getFrame().mostraMessaggio("Archivio caricato con successo");
                Applicazione.getInstance().getModello().putBean(Costanti.ARCHIVIO, archivio);
                Applicazione.getInstance().getControlloFrame().getAzioneVerifica().setEnabled(true);
                Applicazione.getInstance().getControlloVista().getAzioneCerca().setEnabled(true);
                Applicazione.getInstance().getControlloVista().getAzioneSeleziona().setEnabled(true);
            } catch (DaoException ex) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Impossibile caricare l'archivio" + ex.getMessage());
            }
        }
    }

    private class AzioneVerifica extends AbstractAction {

        public AzioneVerifica() {
            this.putValue(NAME, "Verifica");
            this.putValue(SHORT_DESCRIPTION, "Verifica se nell'archivio sono presenti conticorrente con stesso come sottoscritti nella stessa data");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_V);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("alt ctrl V"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
           Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBean(Costanti.ARCHIVIO);
           ContoCorrente conto = archivio.getContiCorrente().get(0);
           if (archivio.verificaArchivio(conto)) {
               Applicazione.getInstance().getFrame().mostraMessaggio("Nell'archivio sono presenti piu' conticorrente sottoscritti nella stessa data da stesso intestatario");
           } else {
               Applicazione.getInstance().getFrame().mostraMessaggio("Nell'archivio non sono presenti piu' conticorrente sottoscritti nella stessa data da stesso intestatario");
           }
        }
    }

    private class AzioneEsci extends AbstractAction {

        public AzioneEsci() {
            this.putValue(NAME, "Esci");
            this.putValue(SHORT_DESCRIPTION, "Esci dall'applicazione");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_E);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("alt ctrl E"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
