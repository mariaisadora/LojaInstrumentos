package Dao;

import model.ModelVendaProduto;
import java.util.ArrayList;
import Connection.ConnectionFactory;
/**
*
* @author dell
*/
public class DaoVendaProduto extends ConnectionFactory {

    /**
    * grava VendaProduto
    * @param pModelVendaProduto
    * return int
    */
    public int salvarVendaProdutoDAO(ModelVendaProduto pModelVendaProduto){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO venda_produto ("
                    + "produto_venda,"
                    + "valor_pro_valor,"
                    + "vendas,"
                    + "venda_pro_qtd"
                + ") VALUES ("
                    + "'" + pModelVendaProduto.getCodigoVendaP() + "',"
                    + "'" + pModelVendaProduto.getProdutoVenda() + "',"
                    + "'" + pModelVendaProduto.getValorProValor() + "',"
                    + "'" + pModelVendaProduto.getVendas() + "',"
                    + "'" + pModelVendaProduto.getVendaProQtd() + "'"
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
    * recupera VendaProduto
    * @param pCodigoVendaP
    * return ModelVendaProduto
    */
    public ModelVendaProduto getVendaProdutoDAO(int  pCodigoVendaP){
        ModelVendaProduto modelVendaProduto = new ModelVendaProduto();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_codigo_venda_p,"
                    + "produto_venda,"
                    + "valor_pro_valor,"
                    + "vendas,"
                    + "venda_pro_qtd"
                 + " FROM"
                     + " venda_produto"
                 + " WHERE"
                     + " pk_codigo_venda_p = '" + pCodigoVendaP + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelVendaProduto.setCodigoVendaP(this.getResultSet().getInt (1));
                modelVendaProduto.setProdutoVenda(this.getResultSet().getInt(2));
                modelVendaProduto.setValorProValor(this.getResultSet().getDouble (3));
                modelVendaProduto.setVendas(this.getResultSet().getInt(4));
                modelVendaProduto.setVendaProQtd(this.getResultSet().getInt(5));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelVendaProduto;
    }

    /**
    * recupera uma lista de VendaProduto
        * return ArrayList
    */
    public ArrayList<ModelVendaProduto> getListaVendaProdutoDAO(){
        ArrayList<ModelVendaProduto> listamodelVendaProduto = new ArrayList();
        ModelVendaProduto modelVendaProduto = new ModelVendaProduto();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_codigo_venda_p,"
                    + "produto_venda,"
                    + "valor_pro_valor,"
                    + "vendas,"
                    + "venda_pro_qtd"
                 + " FROM"
                     + " venda_produto"
                + ";"
            );

            while(this.getResultSet().next()){
                modelVendaProduto = new ModelVendaProduto();
                modelVendaProduto.setCodigoVendaP(this.getResultSet().getInt (1));
                modelVendaProduto.setProdutoVenda(this.getResultSet().getInt(2));
                modelVendaProduto.setValorProValor(this.getResultSet().getDouble (3));
                modelVendaProduto.setVendas(this.getResultSet().getInt(4));
                modelVendaProduto.setVendaProQtd(this.getResultSet().getInt(5));
                listamodelVendaProduto.add(modelVendaProduto);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelVendaProduto;
    }

    /**
    * atualiza VendaProduto
    * @param pModelVendaProduto
    * return boolean
    */
    public boolean atualizarVendaProdutoDAO(ModelVendaProduto pModelVendaProduto){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE venda_produto SET "
                    + "produto_venda = '" + pModelVendaProduto.getProdutoVenda() + "',"
                    + "valor_pro_valor = '" + pModelVendaProduto.getValorProValor() + "',"
                    + "vendas = '" + pModelVendaProduto.getVendas() + "',"
                    + "venda_pro_qtd = '" + pModelVendaProduto.getVendaProQtd() + "'"
                + " WHERE "
                    + "pk_codigo_venda_p = '" + pModelVendaProduto.getCodigoVendaP() + "'"
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
    * exclui VendaProduto
    * @param pCodigoVendaP
    * return boolean
    */
    public boolean excluirVendaProdutoDAO(int  pCodigoVendaP){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM venda_produto "
                + " WHERE "
                    + "pk_codigo_venda_p = '" + pCodigoVendaP + "'"
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