/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import controller.AutoControllerLista;
import controller.VendedorControllerLista;
import model.Auto;
import model.Vendedor;

/**
 *
 * @author juanc
 */
public class Main {

    public static void main(String[] args) {

        AutoControllerLista autoController = new AutoControllerLista();
        Auto auto1 = new Auto(autoController.generarId(), "Rojo", 25000.0, "Toyota", "2022");
        autoController.setAuto(auto1);
        autoController.save();
        
        AutoControllerLista autoController1 = new AutoControllerLista();
        Auto auto2 = new Auto(autoController1.generarId(), "Azul", 22000.0, "Nissan", "2023");
        autoController1.setAuto(auto2);
        autoController1.save();
        
        AutoControllerLista autoController2 = new AutoControllerLista();
        Auto auto3 = new Auto(autoController2.generarId(), "Gris", 28000.0, "Hyundai", "2021");
        autoController2.setAuto(auto3);
        autoController2.save();
        
        AutoControllerLista autoController3 = new AutoControllerLista();
        Auto auto4 = new Auto(autoController3.generarId(), "Negro", 35000.0, "Audi", "2022");
        autoController3.setAuto(auto4);
        autoController3.save();
        
        AutoControllerLista autoController4 = new AutoControllerLista();
        Auto auto5 = new Auto(autoController4.generarId(), "Blanco", 20000.0, "Kia", "2023");
        autoController4.setAuto(auto5);
        autoController4.save();


        VendedorControllerLista vendedorController = new VendedorControllerLista();
        Vendedor vendedori1 = vendedorController.getVendedor();
        vendedori1.setId(vendedorController.generarId());
        vendedori1.setNombre("Adelaide");
        vendedori1.setApellido("Brienne");
        vendedori1.setCorreoElectronico("adelaide@gmail.com");
        vendedori1.setDireccion("Calle A");
        vendedori1.setRuc("123456789");
        vendedori1.setNumeroTelefonico("123-456-7890");
        vendedorController.setVendedor(vendedori1);
        vendedorController.save();

        VendedorControllerLista vendedorController1 = new VendedorControllerLista();
        Vendedor vendedori2 = vendedorController1.getVendedor();
        vendedori2.setId(vendedorController1.generarId());
        vendedori2.setNombre("Luzbel");
        vendedori2.setApellido("Sparda");
        vendedori2.setCorreoElectronico("luzbel@gmail.com");
        vendedori2.setDireccion("Calle B");
        vendedori2.setRuc("987654321");
        vendedori2.setNumeroTelefonico("987-654-3210");
        vendedorController1.setVendedor(vendedori2);
        vendedorController1.save();

        VendedorControllerLista vendedorController2 = new VendedorControllerLista();
        Vendedor vendedori3 = vendedorController2.getVendedor();
        vendedori3.setId(vendedorController2.generarId());
        vendedori3.setNombre("Lilith");
        vendedori3.setApellido("Summer");
        vendedori3.setCorreoElectronico("lilith@gmail.com");
        vendedori3.setDireccion("Calle C");
        vendedori3.setRuc("456789123");
        vendedori3.setNumeroTelefonico("456-789-1230");
        vendedorController2.setVendedor(vendedori3);
        vendedorController2.save();

        VendedorControllerLista vendedorController3 = new VendedorControllerLista();
        Vendedor vendedori4 = vendedorController3.getVendedor();
        vendedori4.setId(vendedorController3.generarId());
        vendedori4.setNombre("Link");
        vendedori4.setApellido("Corner");
        vendedori4.setCorreoElectronico("link@gmail.com");
        vendedori4.setDireccion("Calle D");
        vendedori4.setRuc("789123456");
        vendedori4.setNumeroTelefonico("789-123-4560");
        vendedorController3.setVendedor(vendedori4);
        vendedorController3.save();

        VendedorControllerLista vendedorController4 = new VendedorControllerLista();
        Vendedor vendedori5 = vendedorController4.getVendedor();
        vendedori5.setId(vendedorController4.generarId());
        vendedori5.setNombre("Lexs");
        vendedori5.setApellido("Dommer");
        vendedori5.setCorreoElectronico("lexs@gmail.com");
        vendedori5.setDireccion("Calle E");
        vendedori5.setRuc("321654987");
        vendedori5.setNumeroTelefonico("321-654-9870");
        vendedorController4.setVendedor(vendedori5);
        vendedorController4.save();

    }
}
