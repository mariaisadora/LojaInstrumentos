package Controller;

import Model.ModelVenda;
import Dao.DaoVenda;
import java.util.ArrayList;

/**
*
* @author dell
*/
public class ControllerVenda {

    private DaoVenda daoVendas = new DaoVenda();

    /**
    * grava Vendas
    * @param pModelVendas
    * return int
    */
    public int salvarVendasController(ModelVenda pModelVendas){
        return this.daoVendas.salvarVendasDAO(pModelVendas);
    }

    /**
    * recupera Vendas
    * @param pCodigoVenda
    * return ModelVendas
    */
    public ModelVenda getVendasController(int pCodigoVenda){
        return this.daoVendas.getVendasDAO(pCodigoVenda);
    }

    /**
    * recupera uma lista deVendas
    * @param pCodigoVenda
    * return ArrayList
    */
    public ArrayList<ModelVenda> getListaVendasController(){
        return this.daoVendas.getListaVendasDAO();
    }

    /**
    * atualiza Vendas
    * @param pModelVendas
    * return boolean
    */
    public boolean atualizarVendasController(ModelVenda pModelVendas){
        return this.daoVendas.atualizarVendasDAO(pModelVendas);
    }

    /**
    * exclui Vendas
    * @param pCodigoVenda
    * return boolean
    */
    public boolean excluirVendasController(int pCodigoVenda){
        return this.daoVendas.excluirVendasDAO(pCodigoVenda);
    }
    
    /**
     * Gerar o relatorio da venda
     * @param codigoVenda
     * @return 
     */
    public boolean gerarRelatorioVenda(int codigoVenda) {
        return this.daoVendas.RelatorioVendaDAO(codigoVenda);

    }
}