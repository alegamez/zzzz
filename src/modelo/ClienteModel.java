
package modelo;

import modelo.entidades.Cliente;
import controlador.ClienteController;
import java.util.List;


public interface ClienteModel extends Model<ClienteController, Cliente, String> {

    int contarPorCliente(String pk);
    List listDatos();
    List listClienteFactura();
    double mayorImporte(String pk);
}
