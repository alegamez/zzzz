
package vista.cliente;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import modelo.entidades.Cliente;
import vista.factura.FacturaViewImpl;


public class TableModel2 implements TableModel {


    private List<Cliente> clientes = new ArrayList<Cliente>();
    private List<TableModelListener> tableListeners = new ArrayList<TableModelListener>();
    private List<ListDataListener> dataListeners = new ArrayList<ListDataListener>();
    private ClienteViewImpl clienteView;
    //Implementacion Singleton
    private static TableModel2 model=null;

    private TableModel2(){}

    public static TableModel2 create(){
        if(model==null)
            model=new TableModel2();
        return model;
    }
    
    public void setClienteView(ClienteViewImpl v){
        this.clienteView = v;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
        fireContentsChanged();
    }

    protected void fireContentsChanged() {
        fireContentsChangedTableModel();
       
    }
    //--------------- MÉTODOS PROPIOS DE TableModel -------------------------

    public Cliente getRow(int indexRow) {
        return clientes.get(indexRow);
    }

    public int getRowCount() {
        return clientes.size();
    }

    public int getColumnCount() {
        return 4; //ya que tendremos tres valores a mostrar por contacto
    }

    public String getColumnName(int columnIndex) {
        String name = null;
        switch (columnIndex) {
            case 0:
                name = "Cliente";
                break;
            case 1:
                name = "Nº Facturas";
                break;
            case 2:
                name = "Mayor Importe bruto (€)";
                break;
            case 3:
                name = "Importe total (IVA aplicado) (€)";
                break;
        }
        return name;
    }

    public Class<?> getColumnClass(int columnIndex) {
        return String.class; //Todos los valores de contacto son un String
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; //No permito editar celdas
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Cliente contacto = clientes.get(rowIndex);
        String value = null;
        switch (columnIndex) {
            case 0:
                value = clienteView.getController().obtenerCliente(contacto.getDNI()).getNombre();
                break;
            case 1:
                value = String.valueOf(clienteView.getController().contarPorCliente(contacto.getDNI()));
                break;
            case 2:
                value = String.valueOf(clienteView.getController().mayorImporte(contacto.getDNI()));
                break;
            case 3:
                value = String.valueOf(clienteView.getController().sumaImportesPorCliente(contacto.getDNI()));
                break;
               
        }
        return value;

    }
    
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addTableModelListener(TableModelListener l) {
        tableListeners.add(l);
    }

    public void removeTableModelListener(TableModelListener l) {
        tableListeners.remove(l);
    }

    protected void fireContentsChangedTableModel() {
        //TableModelEvent event = new TableModelEvent(this,0,getRowCount());
        TableModelEvent event = new TableModelEvent(this, 0, this.getRowCount() - 1, TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
        for (TableModelListener listener : tableListeners) {
            listener.tableChanged(event);
        }
    }
    
}
