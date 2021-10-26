package it.unibas.banca.controllo;

import it.unibas.banca.Applicazione;
import it.unibas.banca.modello.Archivio;
import it.unibas.banca.modello.ContoCorrente;
import it.unibas.banca.modello.Costanti;
import it.unibas.banca.vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.KeyStroke;

public class ControlloVista {

    private Action azioneCerca = new AzioneCerca();
    private Action azioneSeleziona = new AzioneSeleziona();

    public Action getAzioneSeleziona() {
        return azioneSeleziona;
    }

    public Action getAzioneCerca() {
        return azioneCerca;
    }

    private class AzioneSeleziona extends AbstractAction {

        public AzioneSeleziona() {
            this.putValue(NAME, "Seleziona");
            this.putValue(SHORT_DESCRIPTION, "seleziona conto corrente");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_S);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("alt ctrl S"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Vista vista = Applicazione.getInstance().getVista();
            List<ContoCorrente> listaFiltrata = (List<ContoCorrente>) Applicazione.getInstance().getModello().getBean(Costanti.LISTA_FILTRATA);
            int rigaSelezionata = vista.getRigaSelezionata();
            if(rigaSelezionata == -1) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Selezionare un conto corrente");
                return;
            }
            ContoCorrente contoSelezionato = listaFiltrata.get(rigaSelezionata);
            Applicazione.getInstance().getModello().putBean(Costanti.CONTO_SELEZIONATO, contoSelezionato);
            Applicazione.getInstance().getVistaDettagli().visualizza();
        }
    }

    private class AzioneCerca extends AbstractAction {

        public AzioneCerca() {
            this.putValue(NAME, "Cerca");
            this.putValue(SHORT_DESCRIPTION, "Cerca conti correnti secondo l'ordinamento scelto");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("alt ctrl C"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Vista vista = Applicazione.getInstance().getVista();
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBean(Costanti.ARCHIVIO);
            String criterioOrdinamento = null;
            if (vista.isOrdinamentoData()) {
                criterioOrdinamento = Costanti.COMPARATORE_DATA;
            } else if (vista.isOrdinamentoNome()) {
                criterioOrdinamento = Costanti.COMPARATORE_NOME;
            }
            List<ContoCorrente> listaFiltrata = archivio.cercaConti(criterioOrdinamento);
            Applicazione.getInstance().getModello().putBean(Costanti.LISTA_FILTRATA, listaFiltrata);
            vista.aggiornaTabella();
        }
    }
}
