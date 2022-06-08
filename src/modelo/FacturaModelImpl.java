
package modelo;

import controlador.FacturaController;
import java.util.List;
import modelo.entidades.Factura;
import modelo.persistencia.FacturaDAO;
import modelo.persistencia.GenericDAO;
import modelo.persistencia.JDBC.FacturaDAOJDBC;


public class FacturaModelImpl extends AbstractModelImpl<FacturaController,Factura,String> implements FacturaModel{

    @Override
    protected GenericDAO obtenerImplementacionDAO(){
        return new FacturaDAOJDBC();
        //return new FacturaDAOJPA();
    }

    @Override
    public List<Factura> listarPorCliente(String nombre) {
        FacturaDAO dao=(FacturaDAO)obtenerImplementacionDAO();
        return dao.listByCliente(nombre);
    }
    
    @Override
    public double sumarImportes(){
        FacturaDAO dao=(FacturaDAO)obtenerImplementacionDAO();
        return dao.sumImportes();
    }
    
    @Override
    public Factura mayorImporte(){
        FacturaDAO dao=(FacturaDAO)obtenerImplementacionDAO();
        return dao.mayorImporte();
    }
    
   

}
