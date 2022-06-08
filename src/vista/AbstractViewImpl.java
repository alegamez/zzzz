package vista;

import controlador.Controller;
import modelo.Model;

public abstract class AbstractViewImpl<C extends Controller> extends javax.swing.JPanel
        implements View<C> {

    private C controller;

    @Override
    public C getController() {
        return controller;
    }

    @Override
    public void setController(C controller) {
        this.controller = controller;
    }

    @Override
    public void dataModelChanged() {
        refresh();
    }

    protected abstract void refresh();

    @Override
    public void display() {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                setVisible(true);
                refresh();
            }
        });

    }

}
