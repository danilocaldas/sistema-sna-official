/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sna.model.service;

import br.com.sna.model.dao.Producao;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Danilo
 */
public interface ProducaoController {
    
    /**
     * 
     * @param ListarProducao Crud da ListarProducao
     */
    public void save(Producao producao);
    public void update(Producao producao);
    public void delete(Producao producao);
    public List<Producao> ListarProducao(String funcionario_nome);
    public List<Producao> listProducao();
    public List<Producao> listProducao(String funcionario_nome, Date data_inicio, Date data_fim);
    
}
