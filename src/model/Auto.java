/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Jhostin
 */
public class Auto {

    private Integer Id;
    private String color;
    private Double precio;
    private String marca;
    private String añoFabricacion;

    public Auto() {
    }

    public Auto(Integer Id, String color, Double precio, String marca, String añoFabricacion) {
        this.Id = Id;
        this.color = color;
        this.precio = precio;
        this.marca = marca;
        this.añoFabricacion = añoFabricacion;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getAñoFabricacion() {
        return añoFabricacion;
    }

    public void setAñoFabricacion(String añoFabricacion) {
        this.añoFabricacion = añoFabricacion;
    }

    @Override
    public String toString() {
        return marca;
    }

    public Boolean comparar(Auto c, String field, Integer type) {

        switch (type) {
            case 1:
                if (field.equalsIgnoreCase("marca")) {
                    return getMarca().compareTo(c.getMarca()) > 0;
                } else if (field.equalsIgnoreCase("id")) {
                    return getId().intValue() > c.getId().intValue();
                } else if (field.equalsIgnoreCase("color")) {
                    return getColor().compareTo(c.getColor()) > 0;
                } else if (field.equalsIgnoreCase("precio")) {
                    return getPrecio().compareTo(c.getPrecio()) > 0;
                } else if (field.equalsIgnoreCase("añoFabricacion")) {
                    return getAñoFabricacion().compareTo(c.getAñoFabricacion()) > 0;
                }
                break;
            case 0:
                if (field.equalsIgnoreCase("marca")) {
                    return getMarca().compareTo(c.getMarca()) < 0;
                } else if (field.equalsIgnoreCase("id")) {
                    return getId().intValue() < c.getId().intValue();
                } else if (field.equalsIgnoreCase("color")) {
                    return getColor().compareTo(c.getColor()) < 0;
                } else if (field.equalsIgnoreCase("precio")) {
                    return getPrecio().compareTo(c.getPrecio()) < 0;
                } else if (field.equalsIgnoreCase("añoFabricacion")) {
                    return getAñoFabricacion().compareTo(c.getAñoFabricacion()) < 0;
                }
                break;
            default:
                return null;
        }
        return null;
    }

}
