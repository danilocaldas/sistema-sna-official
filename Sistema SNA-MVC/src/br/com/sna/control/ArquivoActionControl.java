/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sna.control;

import br.com.sna.model.dao.Prestador;
import br.com.sna.model.dao.Procedimento;
import br.com.sna.model.service.PrestadorImplements;
import br.com.sna.view.ArquivoFrm;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author Danilo
 */
public class ArquivoActionControl implements ControlInterface{
    DefaultListModel lista = new DefaultListModel();
    PrestadorImplements prestadorImplements;
    
    ArquivoFrm frm;
    
    List<Prestador> prestadores;
    List<Procedimento> procedimentos;
    
    public ArquivoActionControl(ArquivoFrm frm) {
       this.frm = frm;
       prestadorImplements = new PrestadorImplements();
       
       attachListener();
    }
 
    
    
    
    @Override
    public final void attachListener() {
        
    }

    @Override
    public void enableButtonsToSaveAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void disableButtonsToSaveAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enableDisableButtonsToEdit(boolean enabled) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void limparCampos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void desabilitarCampoDoFrm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void habilitarCamposDoFrm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void prepararAlterar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void preparaInserir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void salvar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    
}
