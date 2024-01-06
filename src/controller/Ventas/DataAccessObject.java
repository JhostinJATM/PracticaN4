/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Ventas;

import com.thoughtworks.xstream.XStream;
import controller.TDA.Listas.LinkedList;
import java.io.FileOutputStream;
import java.io.FileReader;

/**
 *
 * @author Jhostin
 */
public class DataAccessObject<T> implements TransferObject<T> {
    
    private XStream xstream;
    private Class<T> clazz;
    private String URL;
    
    public DataAccessObject(Class<T> clazz) {
        xstream = Conection.getXstream();
        this.clazz = clazz;
        URL = Conection.getURL() + this.clazz.getSimpleName() + ".json";
    }
    
    @Override
    public Boolean save(T data) {
        LinkedList<T> list = listAll();
        list.add(data);
        try {
            this.xstream.toXML(list, new FileOutputStream(URL));
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }
    
    @Override
    public Boolean update(T data, Integer index) {
        LinkedList<T> list = listAll();
        
        if (index >= 0 && index < list.getSize()) {
            try {
                {          
                    list.update(data, index);
                    this.xstream.alias(list.getClass().getName(), LinkedList.class);
                    this.xstream.toXML(list, new FileOutputStream(URL));
                    return true;
                }
                
            } catch (Exception e) {
                System.out.println("Zzzzzzzz no se pudo modificar");
                return false;
            }
        } else {
            return false;
        }
    }
    
    @Override
    public LinkedList<T> listAll() {
        LinkedList<T> list = new LinkedList<>();
        try {
            list = (LinkedList<T>) xstream.fromXML(new FileReader(URL));
        } catch (Exception e) {
        }
        return list;
    }
    
    @Override
    public T find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Integer generarId() {
        return listAll().getSize() + 1;
        
    }
    
}
