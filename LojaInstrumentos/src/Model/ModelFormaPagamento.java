package Model;
/**
*
* @author Leandro
*/
public class ModelFormaPagamento {

    private int idPagamento;
    private String descricaoPagamento;
    private float descontoPagamento;
    private int parcelasPagamento;
    private int situacaoPagamento;

    /**
    * Construtor
    */
    public ModelFormaPagamento(){}

    /**
    * seta o valor de idForPag
    * @param pIdForPag
    */
    public void setIdForPag(int pIdForPag){
        this.idPagamento = pIdForPag;
    }
    /**
    * return pk_idForPag
    */
    public int getIdForPag(){
        return this.idPagamento;
    }

    /**
    * seta o valor de descricaoForPag
    * @param pDescricaoForPag
    */
    public void setDescricaoForPag(String pDescricaoForPag){
        this.descricaoPagamento = pDescricaoForPag;
    }
    /**
    * return descricaoForPag
    */
    public String getDescricaoForPag(){
        return this.descricaoPagamento;
    }

    /**
    * seta o valor de descontoForPag
    * @param pDescontoForPag
    */
    public void setDescontoForPag(float pDescontoForPag){
        this.descontoPagamento = pDescontoForPag;
    }
    /**
    * return descontoForPag
    */
    public float getDescontoForPag(){
        return this.descontoPagamento;
    }

    /**
    * seta o valor de parcelasForPag
    * @param pParcelasForPag
    */
    public void setParcelasForPag(int pParcelasForPag){
        this.parcelasPagamento = pParcelasForPag;
    }
    /**
    * return parcelasForPag
    */
    public int getParcelasForPag(){
        return this.parcelasPagamento;
    }

    /**
    * seta o valor de situacaoForPag
    * @param pSituacaoForPag
    */
    public void setSituacaoForPag(int pSituacaoForPag){
        this.situacaoPagamento = pSituacaoForPag;
    }
    /**
    * return situacaoForPag
    */
    public int getSituacaoForPag(){
        return this.situacaoPagamento;
    }

    @Override
    public String toString(){
        return "ModelFormaPagamento {" + "::idForPag = " + this.idPagamento + "::descricaoForPag = " 
                + this.descricaoPagamento + "::descontoForPag = " + this.descontoPagamento + "::parcelasForPag = " 
                + this.parcelasPagamento + "::situacaoForPag = " + this.situacaoPagamento +  "}";
    }
}