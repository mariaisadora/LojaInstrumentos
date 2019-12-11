package Controller;

import Dao.DaoProdutoVendaP;
import java.util.ArrayList;
import Model.ModelProdutoVendaP;

public class ControllerProdutoVendaP {

    private DaoProdutoVendaP daoProdutoVendaP = new DaoProdutoVendaP();

    public ArrayList<ModelProdutoVendaP> getListaProdutoVendaPController(int pCodigoVenda) {
        return this.daoProdutoVendaP.getListaProdutoVendaPDAO(pCodigoVenda);
    }

}
