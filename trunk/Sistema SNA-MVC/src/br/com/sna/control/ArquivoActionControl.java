/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sna.control;

import br.com.sna.connection.ConnectionfactoryMYSQL;
import br.com.sna.model.dao.Prestador;
import br.com.sna.model.dao.Procedimento;
import br.com.sna.model.service.PrestadorImplements;
import br.com.sna.view.ArquivoFrm;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author Danilo
 */
public class ArquivoActionControl implements ControlInterface {

    public DefaultListModel lista_presta = new DefaultListModel();
    public DefaultListModel lista_proce = new DefaultListModel();
    public DefaultListModel lista_conteu_proce = new DefaultListModel();
    
    PrestadorImplements prestadorImplements;
    ResultSet rset;
    PreparedStatement pstmt;
    ArquivoFrm frm;
    ConnectionfactoryMYSQL conn;
    List<Prestador> prestadores;
    List<Procedimento> procedimentos;

    public ArquivoActionControl(ArquivoFrm frm) {
        this.frm = frm;
        prestadorImplements = new PrestadorImplements();
        conn = new ConnectionfactoryMYSQL();
        attachListener();
        preencherListaPrestador();
        preencherListaProcedimento();
    }

    public final void preencherListaPrestador() {
        frm.getJlistPrestadores().setModel(lista_presta);
       
        try {
            atualizaPrestador();
            rset = pstmt.executeQuery();
            while (rset.next()) {
                lista_presta.addElement(rset.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArquivoActionControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public final void preencherListaProcedimento() {
        frm.getJlistProcedimentos().setModel(lista_proce);
        try {
            atualizaProcedimento();
            rset = pstmt.executeQuery();
            while (rset.next()) {
                lista_proce.addElement(rset.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArquivoActionControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void atualizaPrestador() {
        try {
            String sql_pres = "select * from prestador";
            pstmt = conn.conectar().prepareStatement(sql_pres);
        } catch (SQLException ex) {
            Logger.getLogger(ArquivoActionControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void atualizaProcedimento() {
        try {
            String sql_pro = "select * from procedimento";
            pstmt = conn.conectar().prepareStatement(sql_pro);
        } catch (SQLException ex) {
            Logger.getLogger(ArquivoActionControl.class.getName()).log(Level.SEVERE, null, ex);
        }
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
