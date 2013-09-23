/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cmr.model.dao;

import br.com.cmr.model.entity.Funcionario;
import java.util.List;

/**
 *
 * @author Danilo
 */
public interface IFuncionarioDAO {
    
    int save(Funcionario funcionario);
    int update(Funcionario funcionario);
    int remove(Long id);
    List<Funcionario> findAll();
}
