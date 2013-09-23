/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cmr.model.dao;

import br.com.cmr.model.entity.Procedimento;
import java.util.List;

/**
 *
 * @author Danilo
 */
public interface IProcedimentoDAO {
    int save(Procedimento procedimento);
    int update(Procedimento procedimento);
    int remove(Long id);
    List<Procedimento> findAll();
}
