package Controller;

import Model.ModelFormaPagamento;
import Dao.DaoFormaPagamento;
import java.util.ArrayList;


public class ControllerFormaPagamento {

    private DaoFormaPagamento daoFormaPagamento = new DaoFormaPagamento();

    /**
    * grava FormaPagamento
    * @param pModelFormaPagamento
    * return int
    */
    public int salvarFormaPagamentoController(ModelFormaPagamento pModelFormaPagamento){
        return this.daoFormaPagamento.salvarFormaPagamentoDAO(pModelFormaPagamento);
    }

    /**
    * recupera FormaPagamento
    * @param pIdForPag
    * return ModelFormaPagamento
    */
    public ModelFormaPagamento getFormaPagamentoController(int pIdForPag){
        return this.daoFormaPagamento.getFormaPagamentoDAO(pIdForPag);
    }

    /**
    * recupera uma lista deFormaPagamento
    * @param pIdForPag
    * return ArrayList
    */
    public ArrayList<ModelFormaPagamento> getListaFormaPagamentoController(){
        return this.daoFormaPagamento.getListaFormaPagamentoDAO();
    }

    /**
    * atualiza FormaPagamento
    * @param pModelFormaPagamento
    * return boolean
    */
    public boolean atualizarFormaPagamentoController(ModelFormaPagamento pModelFormaPagamento){
        return this.daoFormaPagamento.atualizarFormaPagamentoDAO(pModelFormaPagamento);
    }

    /**
    * exclui FormaPagamento
    * @param pIdPagamento
    * return boolean
    */
    public boolean excluirFormaPagamentoController(int pIdPagamento){
        return this.daoFormaPagamento.excluirFormaPagamentoDAO(pIdPagamento);
    }
}