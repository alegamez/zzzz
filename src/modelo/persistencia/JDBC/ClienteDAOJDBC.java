
package modelo.persistencia.JDBC;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.entidades.Cliente;
import modelo.entidades.ClienteImpl;
import modelo.persistencia.ClienteDAO;


public class ClienteDAOJDBC implements ClienteDAO {

    public void create(Cliente entidad) {

        String sql = "insert into clientes(dni,nombre,direccion) values (?,?,?)";
        try {
            PreparedStatement stm = Persistencia.createConnection().prepareStatement(sql);
            stm.setString(1, entidad.getDNI());
            stm.setString(2, entidad.getNombre());
            stm.setString(3, entidad.getDireccion());

            stm.execute();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
    }

    public Cliente read(String pk) {
        Cliente c = null;
        String sql = "SELECT * FROM clientes where DNI = ?";
        try {
            PreparedStatement stmt = Persistencia.createConnection().prepareStatement(sql);
            stmt.setString(1, pk);
            ResultSet res = stmt.executeQuery();
            String dni, nombre, direccion;
            if (res.next()) {
                dni = res.getString("DNI");
                nombre = res.getString("nombre");
                direccion = res.getString("direccion");
                c = new ClienteImpl(dni, nombre, direccion);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
        return c;
    }

    public void update(Cliente entidad) {
        String sql = "update clientes set nombre=?, direccion=? where DNI like ?";
        try {
            PreparedStatement stm = Persistencia.createConnection().prepareStatement(sql);
            stm.setString(1, entidad.getNombre());
            stm.setString(2, entidad.getDireccion());
            stm.setString(3, entidad.getDNI());

            stm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
    }

    public void delete(Cliente entidad) {
        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            stmt.executeUpdate("DELETE FROM clientes where DNI=" + entidad.getDNI());

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
    }

    public List<Cliente> list() {
        List<Cliente> contactos = new ArrayList<Cliente>();

        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM clientes ");
            String dni, nombre, direccion;
            while (res.next()) {

                dni = res.getString("DNI");
                nombre = res.getString("nombre");
                direccion = res.getString("direccion");
                contactos.add(new ClienteImpl(dni, nombre, direccion));
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
        return contactos;
    }

    public List listClienteFactura() {
        List<Cliente> contactos = new ArrayList<Cliente>();

        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM vfacturas ");
            String dni, nombre, direccion, identificador, id_cliente;
            double importe;
            while (res.next()) {

                dni = res.getString("DNI");
                nombre = res.getString("nombre");
                direccion = res.getString("direccion");
                identificador = res.getString("identificador");
                id_cliente = res.getString("id_cliente");
                importe = res.getDouble("importe");
                contactos.add(new ClienteImpl(dni, nombre, direccion));
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
        return contactos;
    }

    @Override
    public int contarPorCliente(String pk) {
        int total = 0;
        String sql = "SELECT COUNT(dni) as total FROM facturacion.vfacturas WHERE DNI = ? ";
        try {
            PreparedStatement stmt = Persistencia.createConnection().prepareStatement(sql);
            stmt.setString(1, pk);
            ResultSet res = stmt.executeQuery();
            res.next();
            total = res.getInt("total");

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
        return total;
    }

    @Override
    public List listDatos() {
        List<Cliente> contactos = new ArrayList<Cliente>();

        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            ResultSet res = stmt.executeQuery("SELECT DISTINCT (DNI) FROM clientes");
            String dni, nombre, direccion;
            while (res.next()) {

                dni = res.getString("DNI");
                //nombre = res.getString("nombre");
                //direccion = res.getString("direccion");
                contactos.add(new ClienteImpl(dni));
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
        return contactos;
    }

    @Override
    public double mayorImporte(String pk) {
        double mayor = 0;
        String sql = "SELECT MAX(importe) as maxI FROM vfacturas where dni = ?";
        try {
            PreparedStatement stmt = Persistencia.createConnection().prepareStatement(sql);
            stmt.setString(1, pk);
            ResultSet res = stmt.executeQuery();
            res.next();
            mayor = res.getDouble("maxI");

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
        return mayor;

    }

    @Override
    public double sumaImportesCliente(String pk) {
       double mayor = 0;
        String sql = "SELECT SUM(importe * 0.9) as suma FROM vfacturas where dni = ?";
        try {
            PreparedStatement stmt = Persistencia.createConnection().prepareStatement(sql);
            stmt.setString(1, pk);
            ResultSet res = stmt.executeQuery();
            res.next();
            mayor = res.getDouble("suma");

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
        return mayor;
 
    }
    
    

}
