/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sna.model.service;

import br.com.sna.model.dao.Arquivo;
import java.util.List;

/**
 *
 * @author Danilo
 */
public interface ArquivoController {
    /**
     * 
     * @param arquivo Crud do arquivo 
     */
     public void save(Arquivo arquivo);
     public void update(Arquivo arquivo);
     public void delete(Arquivo arquivo);
     public List<Arquivo> lista_arquivo();
     public List<Arquivo> lista_arquivo_ano(String ano);
     public List<Arquivo> lista_arquivo_ano_mes(String ano, String mes);

}
