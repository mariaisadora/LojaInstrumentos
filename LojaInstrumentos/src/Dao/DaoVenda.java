package Dao;

import Connection.ConnectionFactory;
import Model.ModelVenda;
import java.util.ArrayList;
/**
*
* @author dell
*/
public class DaoVenda extends ConnectionFactory{

    /**
    * grava Vendas
    * @param pModelVendas
    * return int
    */
    public int salvarVendasDAO(ModelVenda pModelVendas){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO venda ("
                    + "fk_cliente_venda,"
                    + "data_venda,"
                    + "valor_venda"
                + ") VALUES ("
                    + "'" + pModelVendas.getClienteVenda() + "',"
                    + "'" + pModelVendas.getDataVenda() + "',"
                    + "'" + pModelVendas.getValorVenda() + "'"
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
    * recupera Vendas
    * @param pCodigoVenda
    * return ModelVendas
    */
    public ModelVenda getVendasDAO(int pCodigoVenda){
        ModelVenda modelVendas = new ModelVenda();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo_venda,"
                    + "fk_cliente_venda,"
                    + "data_venda,"
                    + "valor_venda"
                 + " FROM"
                     + " venda"
                 + " WHERE"
                     + " codigo_venda = '" + pCodigoVenda + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelVendas.setCodigoVenda(this.getResultSet().getInt(1));
                modelVendas.setClienteVenda(this.getResultSet().getInt(2));
                modelVendas.setDataVenda(this.getResultSet().getDate(3));
                modelVendas.setValorVenda(this.getResultSet().getDouble(4));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelVendas;
    }

    /**
    * recupera uma lista de Vendas
        * return ArrayList
    */
    public ArrayList<ModelVenda> getListaVendasDAO(){
        ArrayList<ModelVenda> listamodelVendas = new ArrayList();
        ModelVenda modelVendas = new ModelVenda();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo_venda,"
                    + "fk_cliente_venda,"
                    + "data_venda,"
                    + "valor_venda"
                 + " FROM"
                     + " venda"
                + ";"
            );

            while(this.getResultSet().next()){
                modelVendas = new ModelVenda();
                modelVendas.setCodigoVenda(this.getResultSet().getInt(1));
                modelVendas.setClienteVenda(this.getResultSet().getInt(2));
                modelVendas.setDataVenda(this.getResultSet().getDate(3));
                modelVendas.setValorVenda(this.getResultSet().getDouble(4));
                listamodelVendas.add(modelVendas);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelVendas;
    }

    /**
    * atualiza Vendas
    * @param pModelVendas
    * return boolean
    */
    public boolean atualizarVendasDAO(ModelVenda pModelVendas){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE venda SET "
                    + "fk_cliente_venda = '" + pModelVendas.getClienteVenda() + "',"
                    + "data_venda = '" + pModelVendas.getDataVenda() + "',"
                    + "valor_venda = '" + pModelVendas.getValorVenda() + "'"
                + " WHERE "
                    + "codigo_venda = '" + pModelVendas.getCodigoVenda() + "'"
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
    * exclui Vendas
    * @param pCodigoVenda
    * return boolean
    */
    public boolean excluirVendasDAO(int pCodigoVenda){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM venda "
                + " WHERE "
                    + "codigo_venda = '" + pCodigoVenda + "'"
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