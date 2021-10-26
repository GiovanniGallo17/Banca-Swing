package it.unibas.banca.modello;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class Archivio {

    private List<ContoCorrente> contiCorrente = new ArrayList<>();

    public List<ContoCorrente> getContiCorrente() {
        return contiCorrente;
    }

    public void aggiungiContoCorrente(ContoCorrente contoCorrente) {
        this.contiCorrente.add(contoCorrente);
    }

    public List<ContoCorrente> cercaConti(String criterioOrdinamento) {
        List<ContoCorrente> listaConti = new ArrayList<>();
        for (ContoCorrente contoCorrente : contiCorrente) {
            listaConti.add(contoCorrente);
            if (criterioOrdinamento.equalsIgnoreCase(Costanti.COMPARATORE_DATA)) {
                Collections.sort(listaConti, new ComparatoreData());
            } else if (criterioOrdinamento.equalsIgnoreCase(Costanti.COMPARATORE_NOME)) {
                Collections.sort(listaConti, new ComparatoreNome());
            }
        }
        return listaConti;
    }

    public boolean verificaArchivio(ContoCorrente primoConto) {
        for (ContoCorrente contoCorrente : contiCorrente.subList(1, contiCorrente.size())) {
            if (isStessaData(primoConto, contoCorrente) && primoConto.getIntestatario().equalsIgnoreCase(contoCorrente.getIntestatario())) {
                return true;
            }
        }
        return false;
    }

    private boolean isStessaData(ContoCorrente conto1, ContoCorrente conto2) {
        Calendar c1 = conto1.getData();
        Calendar c2 = conto2.getData();
        int giorno1 = c1.get(Calendar.DAY_OF_MONTH);
        int mese1 = c1.get(Calendar.MONTH);
        int anno1 = c1.get(Calendar.YEAR);
        int giorno2 = c2.get(Calendar.DAY_OF_MONTH);
        int mese2 = c2.get(Calendar.MONTH);
        int anno2 = c2.get(Calendar.YEAR);
        return (anno1 == anno2 && giorno1 == giorno2 && mese1 == mese2);
    }
}
