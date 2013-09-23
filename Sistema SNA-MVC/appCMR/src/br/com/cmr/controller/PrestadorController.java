/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cmr.controller;

import br.com.cmr.controller.facade.PrestadorFacade;
import br.com.cmr.model.entity.Prestador;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class PrestadorController {
    private PrestadorFacade facade;

    public PrestadorController() {
        this.facade = new PrestadorFacade();
    }
    
    public int addPrestador(Prestador prestador){
        return facade.save(prestador);
    }
    
    public int updatePrestador(Prestador prestador){
        return facade.update(prestador);
    }
    
    public int excluirPrestador(Long id){
        return facade.remove(id);
    }
    
    public List<Prestador> finfPrestador(){
        return facade.findAll();
    }
}
