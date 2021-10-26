package it.unibas.banca;

import it.unibas.banca.controllo.ControlloFrame;
import it.unibas.banca.controllo.ControlloVista;
import it.unibas.banca.controllo.ControlloVistaDettagli;
import it.unibas.banca.modello.Modello;
import it.unibas.banca.persistenza.DaoArchivio;
import it.unibas.banca.persistenza.IDAOArchivio;
import it.unibas.banca.vista.Frame;
import it.unibas.banca.vista.Vista;
import it.unibas.banca.vista.VistaDettagli;
import javax.swing.SwingUtilities;

public class Applicazione {
    
    private static Applicazione singleton = new Applicazione();
    
    public static Applicazione getInstance() {
        return singleton;
    }
    
    private Applicazione() {}
    
    private Modello modello;
    private Frame frame;
    private Vista vista;
    private ControlloFrame controlloFrame;
    private ControlloVista controlloVista;
    private IDAOArchivio daoArchivio;
    private VistaDettagli vistaDettagli;
    private ControlloVistaDettagli controlloVistaDettagli;

    public VistaDettagli getVistaDettagli() {
        return vistaDettagli;
    }

    public ControlloVistaDettagli getControlloVistaDettagli() {
        return controlloVistaDettagli;
    }

    public Modello getModello() {
        return modello;
    }

    public Frame getFrame() {
        return frame;
    }

    public Vista getVista() {
        return vista;
    }

    public ControlloFrame getControlloFrame() {
        return controlloFrame;
    }

    public ControlloVista getControlloVista() {
        return controlloVista;
    }

    public IDAOArchivio getDaoArchivio() {
        return daoArchivio;
    }
    
    private void inizializza() {
        this.modello = new Modello();
        this.frame = new Frame();
        this.vista = new Vista();
        this.controlloFrame = new ControlloFrame();
        this.controlloVista = new ControlloVista();
        this.daoArchivio = new DaoArchivio();
        this.vistaDettagli = new VistaDettagli(frame, true);
        this.controlloVistaDettagli = new ControlloVistaDettagli();
        this.frame.inizializza();
        this.vista.inizializza();
        this.vistaDettagli.inizializza();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Applicazione.getInstance().inizializza();
            }
        } );
    }
}
