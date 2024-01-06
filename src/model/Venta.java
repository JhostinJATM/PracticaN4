package model;

public class Venta {

    private Integer id;
    private Double precio;
    private String fecha;
    private String nro_fact;
    private Vendedor vendedor;
    private Auto auto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNro_fact() {
        return nro_fact;
    }

    public void setNro_fact(String nro_fact) {
        this.nro_fact = nro_fact;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public Boolean comparar(Venta c, String field, Integer type) {
        switch (type) {
            case 1:
                if (field.equalsIgnoreCase("id")) {
                    return getId().intValue() > c.getId().intValue();
                } else if (field.equalsIgnoreCase("precio")) {
                    return getPrecio().doubleValue() > c.getPrecio().doubleValue();
                } else if (field.equalsIgnoreCase("fecha")) {
                    return getFecha().compareTo(c.getFecha()) > 0;
                } else if (field.equalsIgnoreCase("nro_fact")) {
                    return getNro_fact().compareTo(c.getNro_fact()) > 0;
                } else if (field.equalsIgnoreCase("vendedor")) {
                    return getVendedor().getNombre().compareTo(c.getVendedor().getNombre()) > 0;
                } else if (field.equalsIgnoreCase("auto")) {
                    return getAuto().getMarca().compareTo(c.getAuto().getMarca()) > 0;
                }
                break;
            case 0:
                if (field.equalsIgnoreCase("id")) {
                    return getId().intValue() < c.getId().intValue();
                } else if (field.equalsIgnoreCase("precio")) {
                    return getPrecio().doubleValue() < c.getPrecio().doubleValue();
                } else if (field.equalsIgnoreCase("fecha")) {
                    return getFecha().compareTo(c.getFecha()) < 0;
                } else if (field.equalsIgnoreCase("nro_fact")) {
                    return getNro_fact().compareTo(c.getNro_fact()) < 0;
                }else if (field.equalsIgnoreCase("vendedor")) {
                    return getVendedor().getNombre().compareTo(c.getVendedor().getNombre()) < 0;
                } else if (field.equalsIgnoreCase("auto")) {
                    return getAuto().getMarca().compareTo(c.getAuto().getMarca()) < 0;
                }
                break;
            default:
                return null;
        }
        return null;
    }

}
