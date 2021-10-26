package it.unibas.banca.modello;

import java.util.Comparator;

public class ComparatoreNome implements Comparator<ContoCorrente> {

    @Override
    public int compare(ContoCorrente o1, ContoCorrente o2) {
        return o1.getIntestatario().compareTo(o2.getIntestatario());
    }

}
