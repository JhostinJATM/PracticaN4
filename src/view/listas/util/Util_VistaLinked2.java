package view.listas.util;

import controller.TDA.Listas.Execptions.VacioExpection;
import controller.VendedorControllerLista;
import javax.swing.JComboBox;
import model.Vendedor;

public class Util_VistaLinked2 {

    public static void cargarVendedor(JComboBox cbxAuto) throws VacioExpection {
        VendedorControllerLista mc = new VendedorControllerLista();

        cbxAuto.removeAllItems();
        try {
            for (int i = 0; i < mc.getVendedores().getSize(); i++) {
                cbxAuto.addItem(mc.getVendedores().get(i));
            }
        } catch (VacioExpection e) {
            e.printStackTrace();
        }

    }

    public static Vendedor getComboVendedor(JComboBox cbx) {
        return (Vendedor) cbx.getSelectedItem();
    }

}
