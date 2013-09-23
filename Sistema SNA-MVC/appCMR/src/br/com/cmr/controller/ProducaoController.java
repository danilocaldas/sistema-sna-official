/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cmr.controller;

import br.com.cmr.controller.facade.ProducaoFacade;
import br.com.cmr.model.entity.Producao;
import java.util.List;

/**
 *
 * @author ritacosta
 */
public class ProducaoController {
    
    private ProducaoFacade facade;

    public ProducaoController(ProducaoFacade facade) {
        this.facade = new ProducaoFacade();
    }
    
    public int salvarProducao(Producao producao){
        return facade.save(producao);
    }
    
    public int atualizarProducao(Producao producao){
        return facade.update(producao);
    }
    
    public int excluirProducao(Long id){
        return facade.remove(id);
    }
    
    public List<Producao> listarProducao(){
        return facade.findAll();
    }
}
