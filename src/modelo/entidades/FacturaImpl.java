
package modelo.entidades;

public class FacturaImpl implements Factura {

    private String identifiador;
    private Cliente cliente;
    private Double importe;
    private Double descuento;
    private Double total;

    public FacturaImpl(String identificador) {
        this(identificador, null, null);

    }

    public FacturaImpl(String identifiador, Cliente cliente) {
        this(identifiador, cliente, null);

    }

    public FacturaImpl(String identifiador, Cliente cliente, Double importe) {
        this.identifiador = identifiador;
        this.cliente = cliente;
        this.importe = importe;
        if (this.importe != null) {
            this.descuento = importe * 0.10;
            this.total = this.importe - this.descuento;
        }

    }

    @Override
    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String getIdentificador() {
        return identifiador;
    }

    @Override
    public Double getImporte() {
        return importe;
    }

    @Override
    public void setImporte(Double importe) {
        this.importe = importe;
    }

    @Override
    public double getDescuento() {
        return this.descuento;
    }

    @Override
    public void setDescuento(double d) {
        this.descuento = d;
    }

    @Override
    public double getTotal() {
        return total;
    }

    @Override
    public void setTotal(double d) {
        this.total = d;
    }

}
