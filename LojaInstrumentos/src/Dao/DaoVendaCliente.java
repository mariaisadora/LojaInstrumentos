package Dao;

import Connection.ConnectionFactory;
import java.util.ArrayList;
import Model.ModelCliente;
import Model.ModelVenda;
import Model.ModelVendaCliente;

public class DaoVendaCliente extends ConnectionFactory {

    public ArrayList<ModelVendaCliente> getListaVendasClienteDAO() {
        ArrayList<ModelVendaCliente> listaModelVendaCliente = new ArrayList();
        ModelVenda modelVenda = new ModelVenda();
        ModelCliente modelCliente = new ModelCliente();
        ModelVendaCliente modelVendasCliente = new ModelVendaCliente();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "tbl_vendas.pk_id_vendas,"
                    + "tbl_vendas.fk_cliente,"
                    + "tbl_vendas.ven_data_venda,"
                    + "tbl_vendas.ven_valor_liquido,"
                    + "tbl_vendas.ven_valor_bruto,"
                    + "tbl_vendas.ven_desconto,"
                    + "tbl_cliente.pk_id_cliente,"
                    + "tbl_cliente.cli_nome,"
                    + "tbl_cliente.cli_endereco,"
                    + "tbl_cliente.cli_bairro,"
                    + "tbl_cliente.cli_cidade,"
                    + "tbl_cliente.cli_uf,"
                    + "tbl_cliente.cli_cep,"
                    + "tbl_cliente.cli_telefone"
                    + " FROM "
                    + " tbl_vendas INNER JOIN tbl_cliente "
                    + "ON tbl_cliente.pk_id_cliente = tbl_vendas.fk_cliente; "
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelVenda = new ModelVenda();
                modelCliente = new ModelCliente();
                modelVendasCliente = new ModelVendaCliente();

                modelVenda.setCodigoVenda(this.getResultSet().getInt(1));
                modelVenda.setClienteVenda(this.getResultSet().getInt(2));
                modelVenda.setDataVenda(this.getResultSet().getDate(3));
                modelVenda.setValorVenda(this.getResultSet().getDouble(4));

                //cliente
                modelCliente.setCodigoCliente(this.getResultSet().getInt(5));
                modelCliente.setNomeCliente(this.getResultSet().getString(6));
                modelCliente.setSobrenomeCliente(this.getResultSet().getString(7));
                modelCliente.setCpfCliente(this.getResultSet().getString(8));
                modelCliente.setEnderecoCliente(this.getResultSet().getString(9));
                modelCliente.setCidadeCliente(this.getResultSet().getString(10));
                modelCliente.setCepCliente(this.getResultSet().getString(11));
                modelCliente.setUfCliente(this.getResultSet().getString(12));
                modelCliente.setTelefoneCliente(this.getResultSet().getString(13));

                modelVendasCliente.setModelVenda(modelVenda);
                modelVendasCliente.setModelCliente(modelCliente);

                listaModelVendaCliente.add(modelVendasCliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaModelVendaCliente;
    }

    public ModelVendaCliente getListaVendasClienteDAO(int pCodigoVenda) {
        ModelVenda modelVenda = new ModelVenda();
        ModelCliente modelCliente = new ModelCliente();
        ModelVendaCliente modelVendasCliente = new ModelVendaCliente();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "tbl_vendas.pk_id_vendas,"
                    + "tbl_vendas.fk_cliente,"
                    + "tbl_vendas.ven_data_venda,"
                    + "tbl_vendas.ven_valor_liquido,"
                    + "tbl_vendas.ven_valor_bruto,"
                    + "tbl_vendas.ven_desconto,"
                    + "tbl_cliente.pk_id_cliente,"
                    + "tbl_cliente.cli_nome,"
                    + "tbl_cliente.cli_endereco,"
                    + "tbl_cliente.cli_bairro,"
                    + "tbl_cliente.cli_cidade,"
                    + "tbl_cliente.cli_uf,"
                    + "tbl_cliente.cli_cep,"
                    + "tbl_cliente.cli_telefone"
                    + " FROM "
                    + " tbl_vendas INNER JOIN tbl_cliente "
                    + "ON tbl_cliente.pk_id_cliente = tbl_vendas.fk_cliente "
                    + " WHERE "
                    + " tbl_vendas.pk_id_vendas = '" + pCodigoVenda + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelVenda = new ModelVenda();
                modelCliente = new ModelCliente();
                modelVendasCliente = new ModelVendaCliente();

                modelVenda.setCodigoVenda(this.getResultSet().getInt(1));
                modelVenda.setClienteVenda(this.getResultSet().getInt(2));
                modelVenda.setDataVenda(this.getResultSet().getDate(3));
                modelVenda.setValorVenda(this.getResultSet().getDouble(4));

                //cliente
                modelCliente.setCodigoCliente(this.getResultSet().getInt(5));
                modelCliente.setNomeCliente(this.getResultSet().getString(6));
                modelCliente.setSobrenomeCliente(this.getResultSet().getString(7));
                modelCliente.setCpfCliente(this.getResultSet().getString(8));
                modelCliente.setEnderecoCliente(this.getResultSet().getString(9));
                modelCliente.setCidadeCliente(this.getResultSet().getString(10));
                modelCliente.setCepCliente(this.getResultSet().getString(11));
                modelCliente.setUfCliente(this.getResultSet().getString(12));
                modelCliente.setTelefoneCliente(this.getResultSet().getString(13));

                modelVendasCliente.setModelVenda(modelVenda);
                modelVendasCliente.setModelCliente(modelCliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelVendasCliente;
    }

}
