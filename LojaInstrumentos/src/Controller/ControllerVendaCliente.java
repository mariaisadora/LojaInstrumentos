package Controller;

import Dao.DaoVendaCliente;
import java.util.ArrayList;
import Model.ModelVendaCliente;

public class ControllerVendaCliente {

    private DaoVendaCliente daoVendaCliente = new DaoVendaCliente();

    public ArrayList<ModelVendaCliente> getListaVendaClienteController() {
        return this.daoVendaCliente.getListaVendasClienteDAO();
    }

    public ModelVendaCliente getListaVendaClienteController(int pCodigoVenda) {
        return this.daoVendaCliente.getListaVendasClienteDAO(pCodigoVenda);
    }

}
