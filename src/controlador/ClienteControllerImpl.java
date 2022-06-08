
package controlador;

import java.util.List;
import modelo.ClienteModel;
import modelo.entidades.Cliente;
import modelo.entidades.ClienteImpl;
import vista.cliente.ClienteView;


public class ClienteControllerImpl extends AbstractControllerImpl<ClienteModel, ClienteView, String> implements ClienteController{
    
    @Override
    protected Cliente generaEntidad(List<String> datos){
        String DNI=datos.get(0);
        String nombre=datos.get(1);
        String direccion=datos.get(2);
        Cliente c=new ClienteImpl(DNI);
        c.setNombre(nombre);
        c.setDireccion(direccion);
        return c;

    }
    @Override
    protected Cliente generaEntidad(String pk){
        return new ClienteImpl(pk);
    }

    @Override
    public List<Cliente> listaClienteEntidadGesture (){
        return getModel().listar();
    }
    @Override
    public int contarPorCliente(String pk) {
       return getModel().contarPorCliente(pk);
    }
   @Override
    public List listaDatos(){
        return getModel().listDatos();
    }
    
    @Override
    public List listClienteFactura(){
        return getModel().listClienteFactura();
    }

    @Override
    public Cliente obtenerCliente(String pk) {
        return getModel().obtenerEntidad(pk);
    }
    
     @Override
    public double mayorImporte(String pk) {
        return getModel().mayorImporte(pk);
    }

    @Override
    public double sumaImportesPorCliente(String pk) {
        return getModel().sumaImportesCliente(pk);
    }
    
    
}
