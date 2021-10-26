package it.unibas.banca.vista;

import it.unibas.banca.modello.ContoCorrente;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaConti extends AbstractTableModel {

    private List<ContoCorrente> conti = new ArrayList<>();

    public List<ContoCorrente> getConti() {
        return conti;
    }

    public void setConti(List<ContoCorrente> conti) {
        this.conti = conti;
    }

    @Override
    public int getRowCount() {
        return this.conti.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ContoCorrente conto = this.conti.get(rowIndex);
        if (columnIndex == 0) {
            return conto.getIban();
        } else if (columnIndex == 1) {
            return conto.getIntestatario();
        } else if (columnIndex == 2) {
            DateFormat df = DateFormat.getDateTimeInstance();
            return df.format(conto.getData().getTime());
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Iban";
        } else if (column == 1) {
            return "Intestatario";
        } else if (column == 2) {
            return "Data";
        }
        return "";
    }
    
    public void aggiornaContenuto() {
        this.fireTableDataChanged();
    }

}
