/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cmr.controller.facade;

import br.com.cmr.model.dao.IProducaoDAO;
import br.com.cmr.model.dao.ProducaoDAO;
import br.com.cmr.model.entity.Producao;
import java.util.List;

/**
 *
 * @author ritacosta
 */
public class ProducaoFacade {
    
    private IProducaoDAO dAO;

    public ProducaoFacade() {
        this.dAO = new ProducaoDAO();
    }
    
    public int save(Producao producao){
        return dAO.save(producao);
    }
    
    public int update(Producao producao){
        return dAO.update(producao);
    }
    
    public int remove(Long id){
        return dAO.remove(id);
    }
    
    public List<Producao> findAll(){
        return dAO.findAll();
    }
    
}
