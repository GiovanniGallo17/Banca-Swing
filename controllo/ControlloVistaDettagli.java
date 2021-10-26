package it.unibas.banca.controllo;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.KeyStroke;

public class ControlloVistaDettagli {

    private Action azioneAggiugni = new AzioneAggiungi();

    public Action getAzioneAggiugni() {
        return azioneAggiugni;
    }

    private class AzioneAggiungi extends AbstractAction {

        public AzioneAggiungi() {
            this.putValue(NAME, "Aggiungi");
            this.putValue(SHORT_DESCRIPTION, "Aggiungi movimento");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_M);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("alt ctrl M"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    }
}
