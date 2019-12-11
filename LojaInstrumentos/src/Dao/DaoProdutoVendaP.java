

package Dao;

import Connection.ConnectionFactory;
import java.util.ArrayList;
import Model.ModelProduto;
import Model.ModelProdutoVendaP;
import Model.ModelVendaProduto;

public class DaoProdutoVendaP extends ConnectionFactory {
    
   public ArrayList<ModelProdutoVendaP> getListaProdutoVendaPDAO(int pCodigoVenda){
       ArrayList<ModelProdutoVendaP> listaModelProdutoVendaP = new ArrayList<>();
       ModelProdutoVendaP modelProdutoVendaP = new ModelProdutoVendaP();
       ModelProduto modelProduto = new ModelProduto();
       ModelVendaProduto modelVendaProduto = new ModelVendaProduto();
       try {
           this.conectar();
           this.executarSQL("SELECT "
                   + "tbl_produto.pk_id_produto, "
                    + "tbl_produto.pro_estoque, "
                    + "tbl_produto.pro_nome, "
                    + "tbl_produto.pro_valor,"         
                    + "tbl_vendas_produtos.fk_produto, "
                    + "tbl_vendas_produtos.fk_vendas, "
                    + "tbl_vendas_produtos.pk_id_venda_produto,"
                    + "tbl_vendas_produtos.ven_pro_quantidade, "
                    + "tbl_vendas_produtos.ven_pro_valor "
                    + "FROM tbl_vendas_produtos "
                    + "INNER JOIN tbl_produto ON tbl_produto.pk_id_produto = tbl_vendas_produtos.fk_produto "
                    + "WHERE tbl_vendas_produtos.fk_vendas = '"+pCodigoVenda+"';");
           
           while (this.getResultSet().next()){
               modelProdutoVendaP = new ModelProdutoVendaP();
               modelProduto = new ModelProduto();
               modelVendaProduto = new ModelVendaProduto();
               
               modelProduto.setCodigoProduto(this.getResultSet().getInt(1));
               modelProduto.setNomeProduto(this.getResultSet().getString(2));
               modelProduto.setDescricaoProduto(this.getResultSet().getString(3));
               modelProduto.setQuantidadeEstoqueProduto(this.getResultSet().getInt(4));
               modelProduto.setValorProduto(this.getResultSet().getDouble(5));
               
               modelVendaProduto.setCodigoVendaP(this.getResultSet().getInt(5));
               modelVendaProduto.setProdutoVenda(this.getResultSet().getInt(6));
               modelVendaProduto.setVendaProValor(this.getResultSet().getDouble(7));
               modelVendaProduto.setVendas(this.getResultSet().getInt(8));
               modelVendaProduto.setVendaProQtd(this.getResultSet().getInt(9));
               
               modelProdutoVendaP.setModelProduto(modelProduto);
               modelProdutoVendaP.setModelVendaProduto(modelVendaProduto);
               
               listaModelProdutoVendaP.add(modelProdutoVendaP);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }finally{
           this.fecharConexao();
       }
           return listaModelProdutoVendaP;
   } 
    
}
