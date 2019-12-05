package Dao;

import Connection.ConnectionFactory;
import java.util.ArrayList;
import Model.ModelCliente;

public class DaoCliente extends ConnectionFactory {

    /**
     * Cadastrar um cliente no banco
     *
     * @param pModelCliente
     * @return
     */
    public int salvarClienteDAO(ModelCliente pModelCliente) {
        try {
            this.conectar();
            return this.insertSQL("INSERT INTO cliente("
                    + "nome_cli,sobrenome_cli,cpf_cli, endereco_cli,"
                    + " cidade_cli,cep_cli,uf_cli,celular_cli)"
                    + "VALUES("
                    + "'" + pModelCliente.getNomeCliente() + "',"
                    + "'" + pModelCliente.getSobrenomeCliente() + "',"
                    + "'" + pModelCliente.getCpfCliente() + "',"        
                    + "'" + pModelCliente.getEnderecoCliente() + "',"
                    + "'" + pModelCliente.getCidadeCliente() + "',"
                    + "'" + pModelCliente.getCepCliente() + "',"        
                    + "'" + pModelCliente.getUfCliente() + "',"
                    + "'" + pModelCliente.getCelularCliente() + "'"
                    + ");");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
//        try {
//            this.conectar();
//            //cliente(nome_cli,sobrenome_cli,cpf_cli,endereco_cli,cidade_cli,cep_cli,uf_cli,celular_cli)
//            return this.insertSQL("INSERT INTO cliente("
//                    + "nome_cli,sobrenome_cli,cpf_cli,endereco_cli,"
//                    + "cidade_cli,cep_cli,uf_cli,celular_cli)"
//                    + "VALUES("
//                    + "'" + pModelCliente.getNomeCliente() + "',"
//                    + "'" + pModelCliente.getSobrenomeCliente() + "',"
//                    + "'" + pModelCliente.getCpfCliente() + "',"        
//                    + "'" + pModelCliente.getEnderecoCliente() + "',"
//                    + "'" + pModelCliente.getCidadeCliente() + "',"
//                    + "'" + pModelCliente.getCepCliente() + "',"        
//                    + "'" + pModelCliente.getUfCliente() + "',"
//                    + "'" + pModelCliente.getCelularCliente() + "'"
//                    + ");");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return 0;
//        } finally {
//            this.fecharConexao();
//        }
    }

    /**
     * Excluir um cliente do banco
     *
     * @param pCodigoCliente
     * @return boolean
     */
    public boolean excluirClienteDAO(int pCodigoCliente) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("DELETE FROM cliente "
                    + "WHERE cod_cli = " + pCodigoCliente);
        } catch (Exception e) {
            return false;

        } finally {
            this.fecharConexao();
        }
    }

    /**
     * Alterar dados do cliente
     *
     * @param pModelCliente
     * @return boolean
     */
    public boolean alterarClienteDAO(ModelCliente pModelCliente) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("UPDATE cliente SET "
                    + "nome_cli = '" + pModelCliente.getNomeCliente() + "',"
                    + "sobrenome_cli = '" + pModelCliente.getSobrenomeCliente() + "',"        
                    + "cpf_cli = '" + pModelCliente.getCpfCliente() + "',"        
                    + "endereco_cli = '" + pModelCliente.getEnderecoCliente() + "',"
                    + "cidade_cli = '" + pModelCliente.getCidadeCliente() + "',"
                    + "cep_cli = '" + pModelCliente.getCepCliente() + "',"
                    + "uf_cli = '" + pModelCliente.getUfCliente() + "',"
                    + "celular_cli = '" + pModelCliente.getCelularCliente() + "'"
                    + " WHERE cod_cli = '" + pModelCliente.getCodigoCliente() + "'");

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }

    }

    /**
     * Retornar um cliente pelo código
     *
     * @param pCodigoCliente
     * @return ModelCliente
     */
    public ModelCliente retornarClienteDAO(int pCodigoCliente) {
        ModelCliente modelCliente = new ModelCliente();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "cod_cli, nome_cli, endereco_cli,"
                    + " cidade_cli, cep_cli,uf_cli, celular_cli"
                    + " FROM cliente WHERE cod_cli = " + pCodigoCliente);
            while (this.getResultSet().next()) {
                modelCliente.setCodigoCliente(this.getResultSet().getInt("cod_cli"));
                modelCliente.setNomeCliente(this.getResultSet().getString("nome_cli"));
                modelCliente.setSobrenomeCliente(this.getResultSet().getString("sobrenome_cli"));
                modelCliente.setCpfCliente(this.getResultSet().getString("cpf_cli"));
                modelCliente.setEnderecoCliente(this.getResultSet().getString("endereco_cli"));
                modelCliente.setCidadeCliente(this.getResultSet().getString("cidade_cli"));
                modelCliente.setCepCliente(this.getResultSet().getString("cep_cli"));
                modelCliente.setUfCliente(this.getResultSet().getString("uf_cli"));
                modelCliente.setCelularCliente(this.getResultSet().getString("celular_cli"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelCliente;
    }

    /**
     * Retornar uma lista completa de clientes
     *
     * @return listaModelCliente
     */
    public ArrayList<ModelCliente> retornarListaClienteDAO() {
        ArrayList<ModelCliente> listaModelCliente = new ArrayList<>();
        ModelCliente modelCliente = new ModelCliente();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "cod_cli,nome_cli,sobrenome_cli,cpf_cli,endereco_cli,"
                    + "cidade_cli,cep_cli,uf_cli,celular_cli "
                    + "FROM cliente;");

            while (this.getResultSet().next()) {
                modelCliente = new ModelCliente();
                modelCliente.setCodigoCliente(this.getResultSet().getInt("cod_cli"));
                modelCliente.setNomeCliente(this.getResultSet().getString("nome_cli"));
                modelCliente.setSobrenomeCliente(this.getResultSet().getString("sobrenome_cli"));
                modelCliente.setCpfCliente(this.getResultSet().getString("cpf_cli"));
                modelCliente.setEnderecoCliente(this.getResultSet().getString("endereco_cli"));
                modelCliente.setCidadeCliente(this.getResultSet().getString("cidade_cli"));
                modelCliente.setCepCliente(this.getResultSet().getString("cep_cli"));
                modelCliente.setUfCliente(this.getResultSet().getString("uf_cli"));
                modelCliente.setCelularCliente(this.getResultSet().getString("celular_cli"));
                listaModelCliente.add(modelCliente);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaModelCliente;
    }
}
