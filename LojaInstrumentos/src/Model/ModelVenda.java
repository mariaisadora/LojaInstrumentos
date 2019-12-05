package Model;

import java.sql.Date;

/**
*
* @author dell
*/
public class ModelVenda {

    private int codigoVenda;
    private int clienteVenda;
    private Date dataVenda;
    private double valorVenda;

    /**
    * Construtor
    */
    public ModelVenda(){}

    /**
    * seta o valor de codigoVenda
    * @param pCodigoVenda
    */
    public void setCodigoVenda(int pCodigoVenda){
        this.codigoVenda = pCodigoVenda;
    }
    /**
    * return codigoVenda
    */
    public int getCodigoVenda(){
        return this.codigoVenda;
    }

    /**
    * seta o valor de clienteVenda
    * @param pClienteVenda
    */
    public void setClienteVenda(int pClienteVenda){
        this.clienteVenda = pClienteVenda;
    }
    /**
    * return fk_clienteVenda
    */
    public int getClienteVenda(){
        return this.clienteVenda;
    }

    /**
    * seta o valor de dataVenda
    * @param pDataVenda
    */
    public void setDataVenda(Date pDataVenda){
        this.dataVenda = pDataVenda;
    }
    /**
    * return dataVenda
    */
    public Date getDataVenda(){
        return this.dataVenda;
    }

    /**
    * seta o valor de valorVenda
    * @param pValorVenda
    */
    public void setValorVenda(double pValorVenda){
        this.valorVenda = pValorVenda;
    }
    /**
    * return valorVenda
    */
    public double getValorVenda(){
        return this.valorVenda;
    }

    @Override
    public String toString(){
        return "ModelVendas {" + "::codigoVenda = " + this.codigoVenda + "::clienteVenda = " + this.clienteVenda + "::dataVenda = " + this.dataVenda + "::valorVenda = " + this.valorVenda +  "}";
    }
}