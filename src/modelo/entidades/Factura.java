

package modelo.entidades;


public interface Factura extends Entidad{

    Cliente getCliente();

    String getIdentificador();

    Double getImporte();

    void setImporte(Double importe);
    
    double getDescuento();
    void setDescuento(double d);
    double getTotal();
    void setTotal(double d);



}
