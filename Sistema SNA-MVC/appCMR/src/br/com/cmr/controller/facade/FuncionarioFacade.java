/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cmr.controller.facade;

import br.com.cmr.model.dao.FuncionarioDAO;
import br.com.cmr.model.dao.IFuncionarioDAO;
import br.com.cmr.model.entity.Funcionario;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class FuncionarioFacade {
    
    private IFuncionarioDAO dao;

    public FuncionarioFacade() {
        this.dao = new FuncionarioDAO();
    }
    
    public int save (Funcionario funcionario){
        return dao.save(funcionario);
    }
    
    public int update(Funcionario funcionario){
        return dao.update(funcionario);
    }

    public int remove(Long id){
        return dao.remove(id);
    }
    
    public List<Funcionario> findAll(){
        return dao.findAll();
    }
}
