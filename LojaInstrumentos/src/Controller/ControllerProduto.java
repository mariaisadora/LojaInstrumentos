/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.DaoProduto;
import Model.ModelCliente;
import Model.ModelProduto;
import java.util.ArrayList;

/**
 *
 * @author luis.eoconrado
 */

public class ControllerProduto
 {
    private DaoProduto daoProduto = new DaoProduto();
    /**
     * Salvar cliente controller
     * @param pModelProduto
     * @return int
     */
    public int salvarProdutoController(ModelProduto pModelProduto){
        return this.daoProduto.salvarProdutoDAO(pModelProduto);  
    }
    /**
     * Excluir cliente pelo código
     * @param pCodigo
     * @return boolean
     */
    public boolean excluirProdutoController(int pCodigo){
        return this.daoProduto.excluirProdutoDAO(pCodigo);
    }
    /**
     * Alterar um cliente
     * @param pModelCliente
     * @return boolean
     */
    public boolean alterarProdutoController(ModelProduto pModelProduto){
        return this.daoProduto.alterarProdutoDAO(pModelProduto);
    }
    /**
     * Retornar cliente pelo código
     * @param pCodigo
     * @return ModelCliente
     */
    public ModelProduto retornarProdutoController(int pCodigo){
        return this.daoProduto.retornarProdutoDAO(pCodigo);
    }
    /**
     * Retornar lista de clientes
     * @return ListaModelCliente
     */
    public ArrayList<ModelProduto> retornarListaProdutoController(){
        return this.daoProduto.retornarListaProdutoDAO();
    } 
    
}
