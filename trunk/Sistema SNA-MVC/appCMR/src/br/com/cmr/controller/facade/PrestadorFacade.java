/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cmr.controller.facade;

import br.com.cmr.model.dao.IPrestadorDAO;
import br.com.cmr.model.dao.PrestadorDAO;
import br.com.cmr.model.entity.Prestador;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class PrestadorFacade {
    
    private IPrestadorDAO dao;

    public PrestadorFacade() {
        this.dao = new PrestadorDAO();
    }
    
    public int save(Prestador prestador){
        return dao.save(prestador);
    }

    public int update(Prestador prestador){
        return dao.update(prestador);
    }
    
    public int remove(Long id){
        return dao.remove(id);
    }
    
    public List<Prestador> findAll(){
        return dao.findAll();
    }
}
