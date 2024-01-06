/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Jhostin
 */
public class Vendedor {

    private Integer id;
    private String nombre;
    private String apellido;
    private String ruc;
    private String direccion;
    private String numeroTelefonico;
    private String correoElectronico;

    public Vendedor() {
    }

    public Vendedor(Integer id, String nombre, String apellido, String ruc, String direccion, String numeroTelefonico, String correoElectronico) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ruc = ruc;
        this.direccion = direccion;
        this.numeroTelefonico = numeroTelefonico;
        this.correoElectronico = correoElectronico;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }

    public Boolean comparar(Vendedor c, String field, Integer type) {
        switch (type) {
            case 1:
                if (field.equalsIgnoreCase("id")) {
                    return getId().intValue() > c.getId().intValue();
                } else if (field.equalsIgnoreCase("nombre")) {
                    return getNombre().compareTo(c.getNombre()) > 0;
                } else if (field.equalsIgnoreCase("apellido")) {
                    return getApellido().compareTo(c.getApellido()) > 0;
                } else if (field.equalsIgnoreCase("ruc")) {
                    return getRuc().compareTo(c.getRuc()) > 0;
                } else if (field.equalsIgnoreCase("direccion")) {
                    return getDireccion().compareTo(c.getDireccion()) > 0;
                } else if (field.equalsIgnoreCase("numeroTelefonico")) {
                    return getNumeroTelefonico().compareTo(c.getNumeroTelefonico()) > 0;
                } else if (field.equalsIgnoreCase("correoElectronico")) {
                    return getCorreoElectronico().compareTo(c.getCorreoElectronico()) > 0;
                }
                break;
            case 0:
                if (field.equalsIgnoreCase("id")) {
                    return getId().intValue() < c.getId().intValue();
                } else if (field.equalsIgnoreCase("nombre")) {
                    return getNombre().compareTo(c.getNombre()) < 0;
                } else if (field.equalsIgnoreCase("apellido")) {
                    return getApellido().compareTo(c.getApellido()) < 0;
                } else if (field.equalsIgnoreCase("ruc")) {
                    return getRuc().compareTo(c.getRuc()) < 0;
                } else if (field.equalsIgnoreCase("direccion")) {
                    return getDireccion().compareTo(c.getDireccion()) < 0;
                } else if (field.equalsIgnoreCase("numeroTelefonico")) {
                    return getNumeroTelefonico().compareTo(c.getNumeroTelefonico()) < 0;
                } else if (field.equalsIgnoreCase("correoElectronico")) {
                    return getCorreoElectronico().compareTo(c.getCorreoElectronico()) < 0;
                }
                break;
            default:
                return null;
        }
        return null;
    }

}
