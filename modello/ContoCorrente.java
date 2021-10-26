package it.unibas.banca.modello;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ContoCorrente {
    
    private String Iban;
    private String intestatario;
    private Calendar data;
    private List<Movimento> movimenti = new ArrayList<>();

    public ContoCorrente(String Iban, String intestatario, Calendar data) {
        this.Iban = Iban;
        this.intestatario = intestatario;
        this.data = data;
    }

    public String getIban() {
        return Iban;
    }

    public String getIntestatario() {
        return intestatario;
    }

    public Calendar getData() {
        return data;
    }

    public List<Movimento> getMovimenti() {
        return movimenti;
    }
    
    public void aggiungiMovimento(Movimento movimento) {
        this.movimenti.add(movimento);
    }
    
}
