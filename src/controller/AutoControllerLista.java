package controller;

import controller.Ventas.DataAccessObject;
import controller.TDA.Listas.Execptions.VacioExpection;
import controller.TDA.Listas.LinkedList;
import controller.util.Utilidades;
import java.lang.reflect.Field;
import model.Auto;

public class AutoControllerLista extends DataAccessObject<Auto> {

    private LinkedList<Auto> autos = new LinkedList<>();
    private Auto auto;

    public AutoControllerLista() {
        super(Auto.class);
    }

    /**
     * @return the marcas
     */
    public LinkedList<Auto> getAutos() {
        if (autos.isEmpty()) {
            autos = this.listAll();
        }
        return autos;
    }

    /**
     * @param marcas the marcas to set
     */
    public void setAutos(LinkedList<Auto> autos) {
        this.autos = autos;
    }

    /**
     * @return the marca
     */
    public Auto getAuto() {

        if (auto == null) {
            auto = new Auto();
        }
        return auto;
    }

    /**
     * @param marca the marca to set
     */
    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public Boolean save() {

        this.auto.setId(generarId());
        return this.save(auto);
    }

    
    
    //Seguir Despues
    public LinkedList<Auto> ordenar(Integer type) throws VacioExpection {

//        getAutos();
        Integer n = autos.getSize();
        Auto[] m = autos.toArray();
        for (int i = 0; i < n - 1; i++) {
            int k = i;
            Auto t = m[i];
            for (int j = i + 1; j < n; j++) {
                Auto mj = m[j];
                if (type == 0) {
                    if (mj.getMarca().compareTo(t.getMarca()) < 0) {
                        t = mj;
                        k = j;
                    }
                } else {
                    if (mj.getMarca().compareTo(t.getMarca()) > 0) {
                        t = mj;
                        k = j;
                    }
                }
            }
            m[k] = m[i];
            m[i] = t;
        }
        autos = autos.toList(m);
        return autos;
    }

    
    
    //SEGUIR DESPUES
    public LinkedList<Auto> ordenar(Integer type, String field, LinkedList<Auto> lista) throws VacioExpection, Exception {
 
//        getAutos();
        Integer n = lista.getSize();
        Auto[] m = lista.toArray();
        Field faux = Utilidades.getField(Auto.class, field);
        if (faux != null) {
        
            for (int i = 0; i < n - 1; i++) {
                int k = i;
                Auto t = m[i];
                for (int j = i + 1; j < n; j++) {
                    //condicion por objetos
                    Auto mj = m[j];
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

    public LinkedList<Auto> buscar(LinkedList<Auto> lista, String text) throws Exception{
        
        LinkedList<Auto> lo = this.ordenar(0, "marca", lista); //ver video de youtbe 
        Auto[] m = lo.toArray();
        LinkedList<Auto> result = new LinkedList<>();
        for (int i = 0; i < lo.getSize(); i++) {
            if(m[i].getMarca().toLowerCase().startsWith(text.toLowerCase())){
                result.add(m[i]);
            }
        }
        return result;
    }
    
    public static void main(String[] args) throws VacioExpection {
        AutoControllerLista mc = new AutoControllerLista();
        try {
//            System.out.println(mc.ordenar(1, "id").print());
            System.out.println(mc.buscar(mc.listAll(), "Toyota").print()); 
            
            
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
