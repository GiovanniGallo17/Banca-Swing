package it.unibas.banca.vista;

import it.unibas.banca.modello.ContoCorrente;
import it.unibas.banca.modello.Movimento;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaMovimenti extends AbstractTableModel {
    
    List<Movimento> movimenti = new ArrayList<>();

    public List<Movimento> getMovimenti() {
        return movimenti;
    }

    public void setMovimenti(List<Movimento> movimenti) {
        this.movimenti = movimenti;
    }
    
    
    @Override
    public int getRowCount() {
        return this.movimenti.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Movimento movimento = this.movimenti.get(rowIndex);
        if (columnIndex == 0) {
            return movimento.getImporto();
        } else if (columnIndex == 1) {
            return movimento.getTipologia();
        } else if (columnIndex == 2) {
            DateFormat df = DateFormat.getDateTimeInstance();
            return df.format(movimento.getData().getTime());
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Importo";
        } else if (column == 1) {
            return "Tipologia";
        } else if (column == 2) {
            return "Data";
        }
        return "";
    }

    public void aggiornaContenuto() {
        this.fireTableDataChanged();
    }
}
