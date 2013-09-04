/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sna.control;

import br.com.sna.connection.ConnectionfactoryMYSQL;
import br.com.sna.model.dao.Arquivo;
import br.com.sna.model.dao.Prestador;
import br.com.sna.model.dao.Procedimento;
import br.com.sna.model.service.ArquivoImplements;
import br.com.sna.model.service.PrestadorImplements;
import br.com.sna.view.ArquivoFrm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Danilo
 */
public class ArquivoActionControl implements ControlInterface, ActionListener {

    public DefaultListModel lista_presta = new DefaultListModel();
    public DefaultListModel lista_proce = new DefaultListModel();
    PrestadorImplements prestadorImplements;
    ArquivoImplements arquivoImplements;
    ResultSet rset;
    PreparedStatement pstmt;
    ArquivoFrm frm;
    ConnectionfactoryMYSQL conn;
    List<Prestador> prestadores;
    List<Procedimento> procedimentos;
    List<Arquivo> arquivos;

    public ArquivoActionControl(ArquivoFrm frm) {
        this.frm = frm;
        prestadorImplements = new PrestadorImplements();
        arquivoImplements = new ArquivoImplements();
        conn = new ConnectionfactoryMYSQL();
        attachListener();

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

    public void limpaListas() {
        lista_presta.removeAllElements();
        lista_proce.removeAllElements();
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
        frm.getBtIncluir().addActionListener(this);
        frm.getBtModificar().addActionListener(this);
        frm.getBtExcluir().addActionListener(this);
        frm.getBtSalvar().addActionListener(this);
        frm.getBtAlterar().addActionListener(this);
        frm.getBtFinalizar().addActionListener(this);
        frm.getBtLimparPrestador().addActionListener(this);
        frm.getBtLimparProcedimento().addActionListener(this);
        frm.getRadioAno().addActionListener(this);
        frm.getRadioAnoMes().addActionListener(this);
        frm.getRadioTodos().addActionListener(this);
        frm.getRadioContCaixa().addActionListener(this);
        frm.getRadioFolhaRosto().addActionListener(this);
        frm.getBtPesquisarArquivo().addActionListener(this);
        frm.getBtLimparPesquisaArquivo().addActionListener(this);
        frm.getBtImprimirArquivo().addActionListener(this);
        frm.getBtSairArquivoManu().addActionListener(this);
    }

    private void limparAreaPrestador() {
        frm.getAreaTxConteudoPres().setText("");
    }

    private void limparAreaProcedimento() {
        frm.getAreaTxConteuProce().setText("");
    }

    @Override
    public void enableButtonsToSaveAction() {
        enableDisableButtonsToEdit(true);
    }

    @Override
    public void disableButtonsToSaveAction() {
        enableDisableButtonsToEdit(false);
    }

    @Override
    public void enableDisableButtonsToEdit(boolean enabled) {
        frm.getBtIncluir().setEnabled(!enabled);
        frm.getBtModificar().setEnabled(!enabled);
        frm.getBtExcluir().setEnabled(!enabled);
        frm.getBtFinalizar().setEnabled(enabled);
        frm.getJlistPrestadores().setEnabled(enabled);
        frm.getJlistProcedimentos().setEnabled(enabled);
    }

    private boolean verificarNumeroInserido() {
        if ("".equals(frm.getFtxtNumeroIdentificao().getText())) {
            JOptionPane.showMessageDialog(frm, "Insira o numero de indentificação da caixa!",
                    "Atenção", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    private boolean verificarAreaPreechidas() {
        if ("".equals(frm.getAreaTxConteudoPres().getText())
                || "".equals(frm.getAreaTxConteuProce().getText())) {
            JOptionPane.showMessageDialog(frm, "Insira o prestador e procedimento que constaram na caixa!",
                    "Atenção", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void limparCampos() {
        frm.getFtxtNumeroIdentificao().setText("");
        frm.getAreaTxConteudoPres().setText("");
        frm.getAreaTxConteuProce().setText("");
    }

    @Override
    public void desabilitarCampoDoFrm() {
        frm.getFtxtNumeroIdentificao().setEnabled(false);
        frm.getTxtAnoArquivamento().setEnabled(false);
        frm.getBoxMesArquivamento().setEnabled(false);
        frm.getBoxCorCaixa().setEnabled(false);
        
        frm.getBtLimparPrestador().setEnabled(false);
        frm.getBtLimparProcedimento().setEnabled(false);
    }

    @Override
    public void habilitarCamposDoFrm() {
        frm.getFtxtNumeroIdentificao().setEnabled(true);
        frm.getTxtAnoArquivamento().setEnabled(true);
        frm.getBoxMesArquivamento().setEnabled(true);
        frm.getBoxCorCaixa().setEnabled(true);
        frm.getBtLimparPrestador().setEnabled(true);
        frm.getBtLimparProcedimento().setEnabled(true);
    }

    private void desbilitarBtSalvar() {
        frm.getBtSalvar().setEnabled(false);
    }

    private void desbilitarBtAlterar() {
        frm.getBtAlterar().setEnabled(false);
    }

    @Override
    public void prepararAlterar() {
        if (frm.getTbArquivo().getSelectedRow() != -1) {
            preencherListaPrestador();
            preencherListaProcedimento();
            enableButtonsToSaveAction();
            habilitarCamposDoFrm();
            frm.getBtAlterar().setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(frm, "Selecione um registro!");
        }
    }

    @Override
    public void preparaInserir() {
        preencherListaPrestador();
        preencherListaProcedimento();
        enableButtonsToSaveAction();
        habilitarCamposDoFrm();
        limparCampos();
        frm.getBtSalvar().setEnabled(true);
    }

    @Override
    public void alterar() {
        if (verificarNumeroInserido() && verificarAreaPreechidas()) {
            arquivoImplements.update(formToArquivo());
            JOptionPane.showMessageDialog(frm, "Caixa alterada!", "Alterar", JOptionPane.INFORMATION_MESSAGE);
            comportamentoFrmAposCrud();
        }
    }

    public void comportamentoFrmAposCrud() {
        limparCampos();
        desabilitarCampoDoFrm();
        disableButtonsToSaveAction();
        limpaListas();
        desbilitarBtSalvar();
        desbilitarBtAlterar();
        limparTabela(arquivos);

    }

    @Override
    public void salvar() {
        if (verificarNumeroInserido() && verificarAreaPreechidas()) {
            arquivoImplements.save(formToArquivo());
            JOptionPane.showMessageDialog(frm, "Caixa salva!", "Salvar", JOptionPane.INFORMATION_MESSAGE);
            comportamentoFrmAposCrud();
        }
    }

    public boolean compTxtParaExclusao() {
        if (frm.getTbArquivo().getSelectedRow() != -1) {
            frm.getFtxtNumeroIdentificao().setEnabled(true);
            frm.getFtxtNumeroIdentificao().setEditable(false);
            frm.getFtxtNumeroIdentificao().setEnabled(true);
            frm.getFtxtNumeroIdentificao().setEditable(false);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void excluir() {
        if (compTxtParaExclusao()) {
            String msg = "Deseja realmente excluir esta caixa?";
            String titulo = "Confimação";
            int yes = JOptionPane.showConfirmDialog(frm, msg, titulo, JOptionPane.YES_NO_OPTION);
            if (yes == JOptionPane.YES_OPTION) {
                arquivoImplements.delete(formToArquivo());
                JOptionPane.showMessageDialog(frm, "Caixa excluída",
                        "Excluir", JOptionPane.INFORMATION_MESSAGE);

                limparCampos();
                disableButtonsToSaveAction();
                desabilitarCampoDoFrm();
                limparTabela(arquivos);
                // frm.getFtxtNumeroIdentificao().setText("");
            }
        } else {
            JOptionPane.showMessageDialog(frm, "Selecione um registro!");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Limpar Prestador")) {
            limparAreaPrestador();
        } else if (e.getActionCommand().equals("Limpar Procedimento")) {
            limparAreaProcedimento();
        } else if (e.getActionCommand().equals("Salvar")) {
            salvar();
        } else if (e.getActionCommand().equals("Incluir")) {
            preparaInserir();

        } else if (e.getActionCommand().equals("Modificar")) {
            prepararAlterar();
        } else if (e.getActionCommand().equals("Alterar")) {
            alterar();
        } else if (e.getActionCommand().equals("Finalizar")) {
            disableButtonsToSaveAction();
            desbilitarBtAlterar();
            desbilitarBtSalvar();
            desabilitarCampoDoFrm();
            limparCampos();
            limpaListas();
        } else if (e.getActionCommand().equals("Pesquisar")) {
            pesquisaTodos();
            pesquisaArquivoAno();
            pesquisaArquivoAnoMes();
        } else if (e.getActionCommand().equals("Limpar")) {
            limparTabela(arquivos);
        } else if (e.getActionCommand().equals("Sair")) {
            frm.dispose();
        } else if (e.getActionCommand().equals("Excluir")) {
            excluir();
        }
    }

    private Arquivo formToArquivo() {

        Arquivo arquivo = new Arquivo();
        if (!"".equals(frm.getFtxtNumeroIdentificao().getText())) {
            arquivo.setNumero(Integer.parseInt(frm.getFtxtNumeroIdentificao().getText()));
        }
        arquivo.setAno(String.valueOf(frm.getTxtAnoArquivamento().getYear()));
        arquivo.setMes(frm.getBoxMesArquivamento().getSelectedItem().toString());
        arquivo.setCor(frm.getBoxCorCaixa().getSelectedItem().toString());
        arquivo.setPrestador_nome(frm.getAreaTxConteudoPres().getText());
        arquivo.setProcedimento_nome(frm.getAreaTxConteuProce().getText());

        return arquivo;
    }

    public void limparTabela(List<Arquivo> arquivos) {
        while (frm.tmArquivo.getRowCount() > 0) {
            frm.tmArquivo.removeRow(0);
        }
    }

    private void pesquisaArquivoAno() {
        if (frm.getRadioAno().isSelected()) {
            limparTabela(arquivos);
            searchArquivoAno();
        }
    }

    private void pesquisaArquivoAnoMes() {
        if (frm.getRadioAnoMes().isSelected()) {
            limparTabela(arquivos);
            searchArquivoAnoMes();
        }
    }

    private void pesquisaTodos() {
        if (frm.getRadioTodos().isSelected()) {
            limparTabela(arquivos);
            searchArquivoGeral();
        }
    }

    public final void searchArquivoAno() {
        arquivos = arquivoImplements.lista_arquivo_ano("" + frm.getBoxPesquisaAno().getYear() + "");
        mostrarArquivos(arquivos);
    }

    public final void searchArquivoAnoMes() {
        arquivos = arquivoImplements.lista_arquivo_ano_mes("%" + frm.getBoxPesquisaAno().getYear() + "%",
                "%" + frm.getBoxMesArquivamentoManu().getSelectedItem().toString() + "%");
        mostrarArquivos(arquivos);
    }

    public final void searchArquivoGeral() {
        arquivos = arquivoImplements.lista_arquivo();
        mostrarArquivos(arquivos);
    }

    public void mostrarArquivos(List<Arquivo> arquivos) {
        while (frm.tmArquivo.getRowCount() < 0) {
            frm.tmArquivo.removeRow(0);
        }
        if (arquivos.size() == 0) {
            JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum registro!");
        } else {
            String[] campos = new String[]{null, null, null, null, null, null};
            for (int i = 0; i < arquivos.size(); i++) {
                frm.tmArquivo.addRow(campos);
                frm.tmArquivo.setValueAt(arquivos.get(i).getNumero(), i, 0);
                frm.tmArquivo.setValueAt(arquivos.get(i).getAno(), i, 1);
                frm.tmArquivo.setValueAt(arquivos.get(i).getMes(), i, 2);
                frm.tmArquivo.setValueAt(arquivos.get(i).getCor(), i, 3);
                frm.tmArquivo.setValueAt(arquivos.get(i).getPrestador_nome(), i, 4);
                frm.tmArquivo.setValueAt(arquivos.get(i).getProcedimento_nome(), i, 5);

            }
        }
    }

    public void tbArquivoLinhaSelecionada(JTable tb) {
        if (tb.getSelectedRow() != -1) {
            frm.getFtxtNumeroIdentificao().setValue(arquivos.get(tb.getSelectedRow()).getNumero());
            frm.getBoxPesquisaAno().setYear(Integer.valueOf(arquivos.get(tb.getSelectedRow()).getAno()));
            frm.getBoxMesArquivamento().setSelectedItem(arquivos.get(tb.getSelectedRow()).getMes());
            frm.getBoxCorCaixa().setSelectedItem(arquivos.get(tb.getSelectedRow()).getCor());
            frm.getAreaTxConteudoPres().setText(arquivos.get(tb.getSelectedRow()).getPrestador_nome());
            frm.getAreaTxConteuProce().setText(arquivos.get(tb.getSelectedRow()).getProcedimento_nome());
        } else {
            frm.getFtxtNumero().setText("");
            frm.getAreaTxConteudoPres().setText("");
            frm.getAreaTxConteuProce().setText("");
        }
    }
}
