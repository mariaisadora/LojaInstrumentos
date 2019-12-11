package Model;

public class ModelVendaProduto {

    private int  codigoVendaP;
    private int produtoVenda;
    private double vendaProValor;
    private int vendas;
    private int vendaProQtd;
    private String nomeProduto;

   

    /**
    * Construtor
    */
    public ModelVendaProduto(){}

    /**
    * seta o valor de codigoVendaP
    * @param pCodigoVendaP
    */
    public void setCodigoVendaP(int  pCodigoVendaP){
        this.codigoVendaP = pCodigoVendaP;
    }
    /**
    * return pk_codigoVendaP
    */
    public int  getCodigoVendaP(){
        return this.codigoVendaP;
    }
    
     public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    /**
    * seta o valor de produtoVenda
    * @param pProdutoVenda
    */
    public void setProdutoVenda(int pProdutoVenda){
        this.produtoVenda = pProdutoVenda;
    }
    /**
    * return produtoVenda
    */
    public int getProdutoVenda(){
        return this.produtoVenda;
    }

    /**
    * seta o valor de valorProValor
    * @param pValorProValor
    */
    public void setVendaProValor(double  pVendaProValor){
        this.vendaProValor = pVendaProValor;
    }
    /**
    * return valorProValor
    */
    public double  getVendaProValor(){
        return this.vendaProValor;
    }

    /**
    * seta o valor de vendas
    * @param pVendas
    */
    public void setVendas(int pVendas){
        this.vendas = pVendas;
    }
    /**
    * return vendas
    */
    public int getVendas(){
        return this.vendas;
    }

    /**
    * seta o valor de vendaProQtd
    * @param pVendaProQtd
    */
    public void setVendaProQtd(int pVendaProQtd){
        this.vendaProQtd = pVendaProQtd;
    }
    /**
    * return vendaProQtd
    */
    public int getVendaProQtd(){
        return this.vendaProQtd;
    }

    @Override
    public String toString(){
        return "ModelVendaProduto {" + "::codigoVendaP = " + this.codigoVendaP 
                + "::produtoVenda = " + this.produtoVenda + "::valorProValor = " 
                + this.vendaProValor + "::vendas = " + this.vendas + "::vendaProQtd = " 
                + this.vendaProQtd +  "}";
    }
}