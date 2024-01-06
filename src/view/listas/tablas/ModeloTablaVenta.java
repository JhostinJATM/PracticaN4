package view.listas.tablas;

import controller.TDA.Listas.Execptions.VacioExpection;
import controller.TDA.Listas.LinkedList;

import javax.swing.table.AbstractTableModel;
import model.Venta;

public class ModeloTablaVenta extends AbstractTableModel {

    private LinkedList<Venta> ventas;

    @Override
    public int getRowCount() {
        return getVentas().getSize();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Venta venta = null;
        try {
            venta = ventas.get(row);
        } catch (VacioExpection e) {
            throw new RuntimeException(e);
        }
        switch (col) {
            case 0:
                return (venta != null && venta.getVendedor() != null) ? venta.getVendedor().getNombre() : "";
            case 1:
                return (venta != null && venta.getAuto() != null) ? venta.getAuto().getMarca() : "";
            case 2:
                return (venta != null) ? venta.getPrecio() : "";
            case 3:
                return (venta != null) ? venta.getFecha() : "";
            case 4:
                return (venta != null) ? venta.getNro_fact() : "";
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
           case 0:
                return "Vendedor";
            case 1:
                return "Marca Auto";
            case 2:
                return "Precio";
            case 3:
                return "Fecha";
            case 4:
                return "Nro. Factura";
            default:
                return null;
        }
    }

    public LinkedList<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(LinkedList<Venta> ventas) {
        this.ventas = ventas;
    }
}
