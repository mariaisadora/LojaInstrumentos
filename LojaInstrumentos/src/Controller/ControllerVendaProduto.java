package Controller;

import Model.ModelVendaProduto;
import Dao.DaoVendaProduto;
import java.util.ArrayList;

/**
*
* @author dell
*/
public class ControllerVendaProduto {

    private DaoVendaProduto daoVendaProduto = new DaoVendaProduto();

    /**
    * grava VendaProduto
    * @param pModelVendaProduto
    * return int
    */
    public int salvarVendaProdutoController(ModelVendaProduto pModelVendaProduto){
        return this.daoVendaProduto.salvarVendaProdutoDAO(pModelVendaProduto);
    }

    /**
    * recupera VendaProduto
    * @param pCodigoVendaP
    * return ModelVendaProduto
    */
    public ModelVendaProduto getVendaProdutoController(int  pCodigoVendaP){
        return this.daoVendaProduto.getVendaProdutoDAO(pCodigoVendaP);
    }

    /**
    * recupera uma lista deVendaProduto
    * @param pCodigoVendaP
    * return ArrayList
    */
    public ArrayList<ModelVendaProduto> getListaVendaProdutoController(){
        return this.daoVendaProduto.getListaVendaProdutoDAO();
    }

    /**
    * atualiza VendaProduto
    * @param pModelVendaProduto
    * return boolean
    */
    public boolean atualizarVendaProdutoController(ModelVendaProduto pModelVendaProduto){
        return this.daoVendaProduto.atualizarVendaProdutoDAO(pModelVendaProduto);
    }

    /**
    * exclui VendaProduto
    * @param pCodigoVendaP
    * return boolean
    */
    public boolean excluirVendaProdutoController(int  pCodigoVendaP){
        return this.daoVendaProduto.excluirVendaProdutoDAO(pCodigoVendaP);
    }
}