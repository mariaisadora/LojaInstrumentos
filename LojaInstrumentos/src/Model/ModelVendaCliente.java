
package Model;

import java.util.ArrayList;


public class ModelVendaCliente {
    
    private ModelVenda modelVenda;
    private ModelCliente modelCliente;
    private ArrayList<ModelVendaCliente> listaModelVendaCliente;

    /**
     * @return the modelVendas
     */
    public ModelVenda getModelVenda() {
        return modelVenda;
    }

    /**
     * @param modelVendas the modelVendas to set
     */
    public void setModelVenda(ModelVenda modelVenda) {
        this.modelVenda = modelVenda;
    }

    /**
     * @return the modelCliente
     */
    public ModelCliente getModelCliente() {
        return modelCliente;
    }

    /**
     * @param modelCliente the modelCliente to set
     */
    public void setModelCliente(ModelCliente modelCliente) {
        this.modelCliente = modelCliente;
    }

    /**
     * @return the listaModelVendasClientes
     */
    public ArrayList<ModelVendaCliente> getListaModelVendaCliente() {
        return listaModelVendaCliente;
    }

    /**
     * @param listaModelVendasClientes the listaModelVendasClientes to set
     */
    public void setListaModelVendaCliente(ArrayList<ModelVendaCliente> listaModelVendaCliente) {
        this.listaModelVendaCliente = listaModelVendaCliente;
    }
    
}
