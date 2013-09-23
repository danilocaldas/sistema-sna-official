/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cmr.model.dao;

import br.com.cmr.model.entity.Producao;
import java.util.List;

/**
 *
 * @author ritacosta
 */
public interface IProducaoDAO {
    
    int save(Producao producao);
    int update(Producao producao);
    int remove(Long id);
    List<Producao> findAll();
}
