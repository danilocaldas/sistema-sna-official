/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cmr.teste;

import br.com.cmr.controller.ProducaoController;
import br.com.cmr.controller.facade.ProducaoFacade;
import br.com.cmr.model.dao.DBConnection;
import br.com.cmr.model.entity.Producao;
import java.sql.Date;

/**
 *
 * @author ritacosta
 */
public class ProducaoTeste {
    
    public static void main(String[] args){
        DBConnection.createTableProducao();
        Producao producao = new Producao();
        producao.setId(Long.MAX_VALUE);
        producao.setFuncionario("Danilo");
        producao.setPrestador("HAM");
        producao.setProcedimento("ONCO");
        producao.setData(new Date(2013, 12, 24));
        producao.setDataEntrada(new Date(2013, 01, 23));
        producao.setDataDigitacao(new Date(2013, 05, 11));
        producao.setQuantidade("11");

        ProducaoFacade facade = new ProducaoFacade();
        ProducaoController pc = new ProducaoController(facade);
        pc.atualizarProducao(producao);
        
        
        
        
    }
}
