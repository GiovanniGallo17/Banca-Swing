package it.unibas.banca.persistenza;

import it.unibas.banca.modello.Archivio;
import it.unibas.banca.modello.ContoCorrente;
import it.unibas.banca.modello.Costanti;
import it.unibas.banca.modello.Movimento;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DaoArchivio implements IDAOArchivio {

    @Override
    public Archivio carica(String nomeFile) throws DaoException {
        Archivio archivio = new Archivio();
        ContoCorrente c1 = new ContoCorrente("IT8000", "Mario Rossi", new GregorianCalendar(2021, Calendar.AUGUST, 10, 12, 00));
        c1.aggiungiMovimento(new Movimento(new GregorianCalendar(2021, Calendar.SEPTEMBER, 20, 12, 00), 1000, Costanti.BONIFICO));
        c1.aggiungiMovimento(new Movimento(new GregorianCalendar(2021, Calendar.SEPTEMBER, 25, 15, 00), -500, Costanti.POS));
        c1.aggiungiMovimento(new Movimento(new GregorianCalendar(2021, Calendar.OCTOBER, 3, 10, 00), 1000, Costanti.BONIFICO));
        archivio.aggiungiContoCorrente(c1);
        ContoCorrente c2 = new ContoCorrente("IT5402", "Luca Guerra", new GregorianCalendar(2021, Calendar.AUGUST, 14, 12, 00));
        c2.aggiungiMovimento(new Movimento(new GregorianCalendar(2021, Calendar.SEPTEMBER, 10, 15, 00), 5000, Costanti.BONIFICO));
        c2.aggiungiMovimento(new Movimento(new GregorianCalendar(2021, Calendar.SEPTEMBER, 25, 17, 30), -1500, Costanti.BONIFICO));
        c2.aggiungiMovimento(new Movimento(new GregorianCalendar(2021, Calendar.OCTOBER, 3, 10, 00), -500, Costanti.BANCOMAT));
        archivio.aggiungiContoCorrente(c2);
        ContoCorrente c3 = new ContoCorrente("IT2001", "Mario Rossi", new GregorianCalendar(2021, Calendar.AUGUST, 15, 10, 00));
        c3.aggiungiMovimento(new Movimento(new GregorianCalendar(2021, Calendar.SEPTEMBER, 20, 12, 00), 7000, Costanti.BONIFICO));
        archivio.aggiungiContoCorrente(c3);
        ContoCorrente c4 = new ContoCorrente("IT5501", "Maria Bianchi", new GregorianCalendar(2021, Calendar.OCTOBER, 1, 12, 00));
        c2.aggiungiMovimento(new Movimento(new GregorianCalendar(2021, Calendar.OCTOBER, 10, 9, 00), 3000, Costanti.BONIFICO));
        c2.aggiungiMovimento(new Movimento(new GregorianCalendar(2021, Calendar.OCTOBER, 25, 15, 00), -150, Costanti.BANCOMAT));
        archivio.aggiungiContoCorrente(c4);
        return archivio;
    }
}
