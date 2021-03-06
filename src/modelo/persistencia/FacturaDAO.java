package modelo.persistencia;


import java.util.List;
import modelo.entidades.Factura;

public interface FacturaDAO extends GenericDAO<Factura, String> {

    List<Factura> listByCliente(String nombre);
    double sumImportes();
    Factura mayorImporte();
    
    
}
