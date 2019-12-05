package Controller;

import Dao.DaoCliente;
import java.util.ArrayList;
import Model.ModelCliente;

public class ControllerCliente {
    private DaoCliente daoCliente = new DaoCliente();
    /**
     * Salvar cliente controller
     * @param pModelCliente
     * @return int
     */
    public int salvarClienteController(ModelCliente pModelCliente){
        return this.daoCliente.salvarClienteDAO(pModelCliente);  
    }
    /**
     * Excluir cliente pelo código
     * @param pCodigo
     * @return boolean
     */
    public boolean excluirClienteController(int pCodigo){
        return this.daoCliente.excluirClienteDAO(pCodigo);
    }
    /**
     * Alterar um cliente
     * @param pModelCliente
     * @return boolean
     */
    public boolean alterarClienteController(ModelCliente pModelCliente){
        return this.daoCliente.alterarClienteDAO(pModelCliente);
    }
    /**
     * Retornar cliente pelo código
     * @param pCodigo
     * @return ModelCliente
     */
    public ModelCliente retornarClienteController(int pCodigo){
        return this.daoCliente.retornarClienteDAO(pCodigo);
    }
    /**
     * Retornar lista de clientes
     * @return ListaModelCliente
     */
    public ArrayList<ModelCliente> retornarListaClienteController(){
        return this.daoCliente.retornarListaClienteDAO();
    }
    

}
