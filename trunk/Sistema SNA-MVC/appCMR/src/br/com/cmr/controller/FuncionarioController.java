/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cmr.controller;

import br.com.cmr.controller.facade.FuncionarioFacade;
import br.com.cmr.model.entity.Funcionario;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class FuncionarioController {
    
    private FuncionarioFacade facade;

    public FuncionarioController() {
        this.facade = new FuncionarioFacade();
    }
    
    public int addFuncionario(Funcionario funcionario){
        return facade.save(funcionario);
    }
    
    public int updateFuncionario(Funcionario funcionario){
        return facade.update(funcionario);
    }
    
    public int excluirFuncionario(Long id){
        return facade.remove(id);
    }
    
    public List<Funcionario> finfFuncionario(){
        return facade.findAll();
    }
}
