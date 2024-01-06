package controller;

import controller.Ventas.DataAccessObject;
import controller.TDA.Listas.Execptions.VacioExpection;
import controller.TDA.Listas.LinkedList;
import controller.util.Utilidades;
import java.lang.reflect.Field;
import model.Vendedor;
import model.Venta;

public class VendedorControllerLista extends DataAccessObject<Vendedor> {

    private LinkedList<Vendedor> vendedores = new LinkedList<>();
    private Vendedor vendedor;

    public VendedorControllerLista() {
        super(Vendedor.class);
    }

    /**
     * @return the marcas
     */
    public LinkedList<Vendedor> getVendedores() {
        if (vendedores.isEmpty()) {
            vendedores = this.listAll();
        }
        return vendedores;
    }

    /**
     * @param marcas the marcas to set
     */
    public void setMarcas(LinkedList<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }

    /**
     * @return the marca
     */
    public Vendedor getVendedor() {

        if (vendedor == null) {
            vendedor = new Vendedor();
        }
        return vendedor;
    }

    /**
     * @param marca the marca to set
     */
    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Boolean save() {

        this.vendedor.setId(generarId());
        return this.save(vendedor);
    }

    
    
    //Seguir Despues
    public LinkedList<Vendedor> ordenar(Integer type) throws VacioExpection {

        getVendedores();
        Integer n = vendedores.getSize();
        Vendedor[] m = vendedores.toArray();
        //Double Integer
        for (int i = 0; i < n - 1; i++) {
            int k = i;
            Vendedor t = m[i];
            for (int j = i + 1; j < n; j++) {
                //condicion por objetos
                Vendedor mj = m[j];
                if (type == 0) {
                    if (mj.getNombre().compareTo(t.getNombre()) < 0) {
                        t = mj;
                        k = j;
                    }
                } else {
                    if (mj.getNombre().compareTo(t.getNombre()) > 0) {
                        t = mj;
                        k = j;
                    }
                }
            }
            m[k] = m[i];
            m[i] = t;
        }
        vendedores = vendedores.toList(m);
        return vendedores;
    }

    
    
    //SEGUIR DESPUES
    public LinkedList<Vendedor> ordenar(Integer type, String field, LinkedList<Vendedor> lista) throws VacioExpection, Exception {
 
//        getVendedores();
        Integer n = lista.getSize();
        Vendedor[] m = lista.toArray();
        Field faux = Utilidades.getField(Venta.class, field);
        if (faux != null) {
        
            for (int i = 0; i < n - 1; i++) {
                int k = i;
                Vendedor t = m[i];
                for (int j = i + 1; j < n; j++) {
                    //condicion por objetos
                    Vendedor mj = m[j];
                    if (mj.comparar(t, field, type)) {
                        t = mj;
                        k = j;
                    }
                }
                m[k] = m[i];
                m[i] = t;
            }
            lista = lista.toList(m);
        }else{
            throw new Exception("No existe ese criterio de busqueda");
        }
        return lista;
    }

    public LinkedList<Vendedor> buscar(LinkedList<Vendedor> lista, String text) throws Exception{
        
        LinkedList<Vendedor> lo = this.ordenar(0, "nombre", lista); //ver video de youtbe 
        Vendedor[] m = lo.toArray();
        LinkedList<Vendedor> result = new LinkedList<>();
        for (int i = 0; i < lo.getSize(); i++) {
            if(m[i].getNombre().toLowerCase().startsWith(text.toLowerCase())){
                result.add(m[i]);
            }
        }
        return result;
    }
    
    public static void main(String[] args) throws VacioExpection {
        VendedorControllerLista mc = new VendedorControllerLista();
        try {
//            System.out.println(mc.ordenar(1, "id").print());
            System.out.println(mc.buscar(mc.listAll(), "Adelaide").print()); 
            
            
//            mc.getMarca().setId(10);
//            mc.getMarca().setNombre("Test");
//            mc.getMarca().setEstado(true);
//            Marca[] marcas = mc.listAll().toArray();
//            for (Marca m : marcas) {
//                Object resp = Utilidades.getData(m, "nombre");
//                System.out.println(resp);
//            }
//            Field id = Utilidades.getField(Marca.class, "estado");
//            Object resp = Utilidades.getData(mc.getMarca(), "nombre");
//            if(resp != null){
//                System.out.println("OK " + resp.toString());
//            }else{
//                System.out.println("No hay como");
//            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(AutoControllerLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
