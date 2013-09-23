/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cmr.model.dao;

import br.com.cmr.model.entity.Prestador;
import java.util.List;

/**
 *
 * @author Danilo
 */
public interface IPrestadorDAO {
    int save(Prestador prestador);
    int update(Prestador prestador);
    int remove(Long id);
    List<Prestador> findAll();
}
