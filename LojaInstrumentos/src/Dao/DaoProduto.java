
package Dao;

import Connection.ConnectionFactory;
import Model.ModelProduto;
import java.util.ArrayList;


public class DaoProduto extends ConnectionFactory {

    /**
     * Cadastrar um Produto no banco
     *
     * @param pModelProduto
     * @return
     */
    public int salvarProdutoDAO(ModelProduto pModelProduto) {
        try {
            this.conectar();
            return this.insertSQL("INSERT INTO produto("
                    + "nome_prod,descricao_prod,quantidade_estoque_prod,valor_prod)"
                    + "VALUES("
                    + "'" + pModelProduto.getNomeProduto() + "',"
                    + "'" + pModelProduto.getDescricaoProduto()+ "',"
                    + "'" + pModelProduto.getQuantidadeEstoqueProduto()+ "',"        
                    + "'" + pModelProduto.getValorProduto()+ "'"
                    + ");");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * Excluir um produto do banco
     *
     * @param pCodigoProduto
     * @return boolean
     */
    public boolean excluirProdutoDAO(int pCodigoProduto) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("DELETE FROM produto "
                    + "WHERE cod_prod = " + pCodigoProduto);
        } catch (Exception e) {
            return false;

        } finally {
            this.fecharConexao();
        }
    }

    /**
     * Alterar dados do Produto
     *
     * @param pModelProduto
     * @return boolean
     */
    public boolean alterarProdutoDAO(ModelProduto pModelProduto) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("UPDATE produto SET "
                    + "nome_prod = '" + pModelProduto.getNomeProduto()+ "',"
                    + "descricao_prod = '" + pModelProduto.getDescricaoProduto()+ "',"
                    + "quantidade_estoque_prod = '" + pModelProduto.getQuantidadeEstoqueProduto()+ "',"        
                    + "valor_prod = '" + pModelProduto.getValorProduto()+ "'");
                    

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }

    }

    /**
     * Retornar um produto pelo código
     *
     * @param pCodigoProduto
     * @return ModelProduto
     */
    public ModelProduto retornarProdutoDAO(int pCodigoProduto) {
        ModelProduto modelProduto = new ModelProduto();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "cod_prod, nome_prod,descricao_prod,"
                    + "quantidade_estoque_prod,valor_prod"
                    + "FROM produto WHERE cod_prod = " + pCodigoProduto);
                   
            while (this.getResultSet().next()) {
                modelProduto.setCodigoProduto(this.getResultSet().getInt("cod_prod"));
                modelProduto.setNomeProduto(this.getResultSet().getString("nome_prod"));
                modelProduto.setDescricaoProduto(this.getResultSet().getString("descricao_prod"));
                modelProduto.setQuantidadeEstoqueProduto(this.getResultSet().getInt("quantidade_estoque_prod"));
                modelProduto.setValorProduto(this.getResultSet().getDouble("valor_prod"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelProduto;
    }

    /**
     * Retornar uma lista completa de produtos
     *
     * @return listaModelCliente
     */
    public ArrayList<ModelProduto> retornarListaProdutoDAO() {
        ArrayList<ModelProduto> listaModelProduto = new ArrayList<>();
        ModelProduto modelProduto = new ModelProduto();
        try {
            this.conectar();
            this.executarSQL("SELECT cod_prod,"
                    + "nome_prod,"
                    + "descricao_prod,"
                    + "quantidade_estoque_prod,"
                    + "valor_prod "
                    + "FROM produto;");

            while (this.getResultSet().next()) {
                modelProduto.setCodigoProduto(this.getResultSet().getInt("cod_prod"));
                modelProduto.setNomeProduto(this.getResultSet().getString("nome_prod"));
                modelProduto.setDescricaoProduto(this.getResultSet().getString("descricao_prod"));
                modelProduto.setQuantidadeEstoqueProduto(this.getResultSet().getInt("quantidade_estoque_prod"));
                modelProduto.setValorProduto(this.getResultSet().getDouble("valor_prod"));
               
                listaModelProduto.add(modelProduto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaModelProduto;
    } 
}
        
   
    

