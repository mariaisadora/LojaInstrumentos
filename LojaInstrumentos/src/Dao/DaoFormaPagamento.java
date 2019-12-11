package Dao;

import Model.ModelFormaPagamento;
import Connection.ConnectionFactory;
import java.util.ArrayList;
/**
*
* @author Leandro
*/
public class DaoFormaPagamento extends ConnectionFactory {

    /**
    * grava FormaPagamento
    * @param pModelFormaPagamento
    * return int
    */
    public int salvarFormaPagamentoDAO(ModelFormaPagamento pModelFormaPagamento){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO pagamento ("
                    + "id_pagamento,"
                    + "descricao_pagamento,"
                    + "parcelas_pagamento,"
                    + "situacao_pagamento"
                + ") VALUES ("
                    + "'" + pModelFormaPagamento.getIdForPag() + "',"
                    + "'" + pModelFormaPagamento.getDescricaoForPag() + "',"
                    + "'" + pModelFormaPagamento.getParcelasForPag() + "',"
                    + "'" + pModelFormaPagamento.getSituacaoForPag() + "'"
                + ");"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * recupera FormaPagamento
    * @param pIdForPag
    * return ModelFormaPagamento
    */
    public ModelFormaPagamento getFormaPagamentoDAO(int pIdForPag){
        ModelFormaPagamento modelFormaPagamento = new ModelFormaPagamento();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id_pagamento,"
                    + "descricao_pagamento,"
                    + "parcelas_pagamento,"
                    + "situacao_pagamento"
                 + " FROM"
                     + " pagamento"
                 + " WHERE"
                     + " id_pagamento = '" + pIdForPag + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelFormaPagamento.setIdForPag(this.getResultSet().getInt(1));
                modelFormaPagamento.setDescricaoForPag(this.getResultSet().getString(2));
                modelFormaPagamento.setParcelasForPag(this.getResultSet().getInt(3));
                modelFormaPagamento.setSituacaoForPag(this.getResultSet().getInt(4));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelFormaPagamento;
    }

    /**
    * recupera uma lista de FormaPagamento
        * return ArrayList
    */
    public ArrayList<ModelFormaPagamento> getListaFormaPagamentoDAO(){
        ArrayList<ModelFormaPagamento> listamodelFormaPagamento = new ArrayList();
        ModelFormaPagamento modelFormaPagamento = new ModelFormaPagamento();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id_pagamento,"
                    + "descricao_pagamento,"
                    + "parcelas_pagamento,"
                    + "situacao_pagamento"
                 + " FROM"
                     + " pagamento"
                + ";"
            );

            while(this.getResultSet().next()){
                modelFormaPagamento = new ModelFormaPagamento();
                modelFormaPagamento.setIdForPag(this.getResultSet().getInt(1));
                modelFormaPagamento.setDescricaoForPag(this.getResultSet().getString(2));
                modelFormaPagamento.setParcelasForPag(this.getResultSet().getInt(3));
                modelFormaPagamento.setSituacaoForPag(this.getResultSet().getInt(4));
                listamodelFormaPagamento.add(modelFormaPagamento);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelFormaPagamento;
    }

    /**
    * atualiza FormaPagamento
    * @param pModelFormaPagamento
    * return boolean
    */
    public boolean atualizarFormaPagamentoDAO(ModelFormaPagamento pModelFormaPagamento){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE pagamento SET "
                    + "id_pagamento = '" + pModelFormaPagamento.getIdForPag() + "',"
                    + "descricao_pagamento = '" + pModelFormaPagamento.getDescricaoForPag() + "',"
                    + "parcelas_pagamento = '" + pModelFormaPagamento.getParcelasForPag() + "',"
                    + "situacao_pagamento = '" + pModelFormaPagamento.getSituacaoForPag() + "'"
                + " WHERE "
                    + "id_pagamento = '" + pModelFormaPagamento.getIdForPag() + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * exclui FormaPagamento
    * @param pIdForPag
    * return boolean
    */
    public boolean excluirFormaPagamentoDAO(int pIdForPag){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM pagamento "
                + " WHERE "
                    + "id_pagamento = '" + pIdForPag + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }
}