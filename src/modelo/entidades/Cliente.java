
package modelo.entidades;

import java.util.List;


public interface Cliente extends Entidad{

    String getDNI();

    String getDireccion();

    String getNombre();

    void setDNI(String DNI);

    void setDireccion(String direccion);

    void setNombre(String nombre);

    List<Factura> getFacturas();

    void setFacturas(List<Factura> facturas);

    void addFactura(Factura factura);

    void removeFactura(Factura factura);
}
