
package controlador;

import java.util.List;
import modelo.ClienteModel;
import modelo.entidades.Cliente;
import vista.cliente.ClienteView;



public interface ClienteController extends Controller<ClienteModel, ClienteView, String>{
    
    public List<Cliente> listaClienteEntidadGesture ();
    public int contarPorCliente(String pk);
    public List listClienteFactura();
    public List listaDatos();
    public Cliente obtenerCliente(String pk);
    public double mayorImporte(String pk);
    public double sumaImportesPorCliente(String pk);
}
