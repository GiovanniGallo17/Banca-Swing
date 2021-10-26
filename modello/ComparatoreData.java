package it.unibas.banca.modello;

import java.util.Comparator;

public class ComparatoreData implements Comparator<ContoCorrente> {

    @Override
    public int compare(ContoCorrente o1, ContoCorrente o2) {
        return o1.getData().compareTo(o2.getData());
    }
    
}
