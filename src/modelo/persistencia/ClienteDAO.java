package modelo.persistencia;

import modelo.entidades.Cliente;
import java.util.*;

public interface ClienteDAO extends GenericDAO<Cliente, String> {

    int contarPorCliente(String pk);
    List listClienteFactura();
    List listDatos();
    double mayorImporte(String pk);
}
