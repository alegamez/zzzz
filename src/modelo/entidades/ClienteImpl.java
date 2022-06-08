
package modelo.entidades;

import java.util.ArrayList;
import java.util.List;


public class ClienteImpl implements Cliente {

    private String nombre;
    private String DNI;
    private String direccion;
    private List<Factura> facturas;

    public ClienteImpl(String DNI) {
        this(DNI, null, null);
    }

    public ClienteImpl(String DNI, String nombre, String direccion) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.direccion = direccion;
        this.facturas = new ArrayList();
    }

    @Override
    public String getDNI() {
        return DNI;
    }

    @Override
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    @Override
    public String getDireccion() {
        return direccion;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void addFactura(Factura factura) {
        this.facturas.add(factura);
    }

    @Override
    public void removeFactura(Factura factura) {
        this.facturas.remove(factura);
    }

    @Override
    public List<Factura> getFacturas() {
        return facturas;
    }

    @Override
    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

   

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClienteImpl other = (ClienteImpl) obj;
        if ((this.DNI == null) ? (other.DNI != null) : !this.DNI.equals(other.DNI)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.DNI != null ? this.DNI.hashCode() : 0);
        return hash;
    }

    public String toString() {
        return getNombre();
    }

}
