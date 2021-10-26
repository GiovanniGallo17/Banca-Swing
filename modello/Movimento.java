package it.unibas.banca.modello;

import java.util.Calendar;

public class Movimento {
    
    private Calendar data;
    private double importo;
    private String tipologia;

    public Movimento(Calendar data, double importo, String tipologia) {
        this.data = data;
        this.importo = importo;
        this.tipologia = tipologia;
    }

    public Calendar getData() {
        return data;
    }

    public double getImporto() {
        return importo;
    }

    public String getTipologia() {
        return tipologia;
    }
    
    
    
}
