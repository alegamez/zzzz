
package modelo;

import modelo.entidades.Cliente;
import controlador.ClienteController;
import modelo.persistencia.ClienteDAO;
import modelo.persistencia.GenericDAO;
import modelo.persistencia.JDBC.ClienteDAOJDBC;
import java.util.*;


public class ClienteModelImpl extends AbstractModelImpl<ClienteController, Cliente, String> implements ClienteModel {

    @Override
    protected GenericDAO obtenerImplementacionDAO() {
        return new ClienteDAOJDBC();
        //return new ClienteDAOJPA();
    }

    @Override
    public int contarPorCliente(String pk) {
        ClienteDAO dao = (ClienteDAO) obtenerImplementacionDAO();
        return dao.contarPorCliente(pk);
    }

    @Override
    public List listDatos() {
        ClienteDAO dao = (ClienteDAO) obtenerImplementacionDAO();
        return dao.listDatos();
    }

    @Override
    public List listClienteFactura() {
        ClienteDAO dao = (ClienteDAO) obtenerImplementacionDAO();
        return dao.listClienteFactura();
    }
    
    @Override
    public double mayorImporte(String pk) {
        ClienteDAO dao = (ClienteDAO) obtenerImplementacionDAO();
        return dao.mayorImporte(pk);
    }
}
