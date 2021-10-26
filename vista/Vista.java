package it.unibas.banca.vista;

import it.unibas.banca.Applicazione;
import it.unibas.banca.modello.ContoCorrente;
import it.unibas.banca.modello.Costanti;
import java.util.List;

public class Vista extends javax.swing.JPanel {

    public void inizializza() {
        initComponents();
        inizializzaAzioni();
        this.tabellaConti.setModel(new ModelloTabellaConti());
    }

    private void inizializzaAzioni() {
        this.bottoneCerca.setAction(Applicazione.getInstance().getControlloVista().getAzioneCerca());
        this.bottoneSeleziona.setAction(Applicazione.getInstance().getControlloVista().getAzioneSeleziona());
    }

    public boolean isOrdinamentoData() {
        return this.radioData.isSelected();
    }

    public boolean isOrdinamentoNome() {
        return this.radioNome.isSelected();
    }
    
    public int getRigaSelezionata() {
        return this.tabellaConti.getSelectedRow();
    }

    public void aggiornaTabella() {
        ModelloTabellaConti modelloTabella = (ModelloTabellaConti) this.tabellaConti.getModel();
        List<ContoCorrente> listaFiltrata = (List<ContoCorrente>) Applicazione.getInstance().getModello().getBean(Costanti.LISTA_FILTRATA);
        modelloTabella.setConti(listaFiltrata);
        modelloTabella.aggiornaContenuto();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioData = new javax.swing.JRadioButton();
        radioNome = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabellaConti = new javax.swing.JTable();
        bottoneCerca = new javax.swing.JButton();
        bottoneSeleziona = new javax.swing.JButton();

        radioData.setText("Ordinamento data");
        radioData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDataActionPerformed(evt);
            }
        });

        radioNome.setText("Ordinamento Nome");

        tabellaConti.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabellaConti);

        bottoneCerca.setText("jButton1");

        bottoneSeleziona.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(radioData)
                        .addGap(29, 29, 29)
                        .addComponent(radioNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(bottoneCerca))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bottoneSeleziona)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioData)
                    .addComponent(radioNome)
                    .addComponent(bottoneCerca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottoneSeleziona)
                .addGap(6, 6, 6))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void radioDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioDataActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneCerca;
    private javax.swing.JButton bottoneSeleziona;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radioData;
    private javax.swing.JRadioButton radioNome;
    private javax.swing.JTable tabellaConti;
    // End of variables declaration//GEN-END:variables
}
