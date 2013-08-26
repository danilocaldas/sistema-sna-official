/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sna.control;

import br.com.sna.model.dao.Procedimento;
import br.com.sna.model.service.ProcedimentoImplements;
import br.com.sna.view.ProcedimentoFrm;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Danilo
 */
public class ProcedimentoActionControl implements ControlInterface, ActionListener {

    List<Procedimento> procedimentos;
    ListSelectionModel lsmProcedimento;
    private ProcedimentoFrm frm;
    private ProcedimentoImplements procedimentoImplements;

    public ProcedimentoActionControl(ProcedimentoFrm frm) {
        this.frm = frm;
        procedimentoImplements = new ProcedimentoImplements();
        attachListener();
        frm.setResizable(false);
        frm.getTbProcedimento().setSelectionBackground(Color.RED);
    }

    @Override
    public final void attachListener() {
        frm.getBtIncluirProcedimento().addActionListener(this);
        frm.getBtPrepararAlterarProcedimento().addActionListener(this);
        frm.getBtExcluirProcedimento().addActionListener(this);
        frm.getBtSalvarProcedimento().addActionListener(this);
        frm.getBtAlterarProcedimento().addActionListener(this);
        frm.getBtFinalizarProcedimento().addActionListener(this);
        frm.getBtLimpar().addActionListener(this);
        frm.getBtPesquisarProcedimento().addActionListener(this);

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
        frm.getBtIncluirProcedimento().setEnabled(!enabled);
        frm.getBtPrepararAlterarProcedimento().setEnabled(!enabled);
        frm.getBtExcluirProcedimento().setEnabled(!enabled);
        frm.getBtFinalizarProcedimento().setEnabled(enabled);
    }

    @Override
    public void limparCampos() {
        frm.getLabelId().setText("");
        frm.getTxtNomeProcedimento().setText("");
        frm.getFtxtCodigo().setText("");
    }

    @Override
    public void desabilitarCampoDoFrm() {
        frm.getTxtNomeProcedimento().setEnabled(false);
        frm.getFtxtCodigo().setEnabled(false);
    }

    @Override
    public void habilitarCamposDoFrm() {
        frm.getTxtNomeProcedimento().setEnabled(true);
        frm.getFtxtCodigo().setEnabled(true);
    }

    @Override
    public void prepararAlterar() {
        if (frm.getTbProcedimento().getSelectedRow() != -1) {
            enableButtonsToSaveAction();
            habilitarCamposDoFrm();
            habilitarBtAlterar();
           
        } else {
            JOptionPane.showMessageDialog(frm, "Selecione um registro!", "Alterar", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void preparaInserir() {
        enableButtonsToSaveAction();
        habilitarCamposDoFrm();
        habilitarBtSalvar();
       
    }

    @Override
    public void alterar() {
        if (verificarCampos()) {
            procedimentoImplements.update(formToProcedimento());
            JOptionPane.showMessageDialog(frm, "Procedimento Alterado", "Alterar", JOptionPane.INFORMATION_MESSAGE);
            disableButtonsToSaveAction();
            limparCampos();
            desabilitarCampoDoFrm();
            limparTabela(procedimentos);
            frm.searchProcedimentos();
        }
    }

    @Override
    public void salvar() {
        if (verificarCampos() || verifarCodigo()) {
            procedimentoImplements.save(formToProcedimento());
            JOptionPane.showMessageDialog(frm, "Procedimento Salvo", "Salvar", JOptionPane.INFORMATION_MESSAGE);
            disableButtonsToSaveAction();
            limparCampos();
            desabilitarCampoDoFrm();
            limparTabela(procedimentos);
            frm.searchProcedimentos();
        }
    }

    @Override
    public void excluir() {
        if (frm.getTbProcedimento().getSelectedRow() != -1) {
            String msg = "Deseja realmente excluir este procedimento?";
            String titulo = "Confimação";
            int yes = JOptionPane.showConfirmDialog(frm, msg, titulo, JOptionPane.YES_NO_OPTION);
            if (yes == JOptionPane.YES_OPTION) {
                procedimentoImplements.delete(formToProcedimento());
                JOptionPane.showMessageDialog(frm, "Procedimento Excluído", "Excluir", JOptionPane.INFORMATION_MESSAGE);
                disableButtonsToSaveAction();
                limparCampos();
                desabilitarCampoDoFrm();
                limparTabela(procedimentos);
                frm.searchProcedimentos();
            }else if(yes == JOptionPane.NO_OPTION){
                limparCampos();
                limparTabela(procedimentos);
            }
        } else {
            JOptionPane.showMessageDialog(frm, "Selecione um registro!");
        }
    }

    private Procedimento formToProcedimento() {
        Procedimento procedimento = new Procedimento();
        if (!"".equals(frm.getLabelId().getText())) {
            procedimento.setId(Long.parseLong(frm.getLabelId().getText()));
        }
        procedimento.setNome(frm.getTxtNomeProcedimento().getText());
        procedimento.setCodigo(Integer.parseInt(frm.getFtxtCodigo().getText()));

        return procedimento;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Incluir")) {
            preparaInserir();
        } else if (e.getActionCommand().equals("Modificar")) {
            prepararAlterar();
        } else if (e.getActionCommand().equals("Excluir")) {
            excluir();
        } else if (e.getActionCommand().equals("Salvar")) {
            salvar();

        } else if (e.getActionCommand().equals("Alterar")) {
            alterar();

        } else if (e.getActionCommand().equals("Finalizar")) {
            desabilitarBtAlterar();
            desabilitarBtSalvar();
            disableButtonsToSaveAction();
            limparCampos();
            desabilitarCampoDoFrm();
            limparTabela(procedimentos);
        } else if (e.getActionCommand().equals("Limpar")) {
            limparTabela(procedimentos);
        } else if (e.getActionCommand().equals("Listar Procedimentos")) {
            limparTabela(procedimentos);
            frm.searchProcedimentos();

        }
    }

    public void limparTabela(List<Procedimento> procedimento) {
        while (frm.tmProcedimento.getRowCount() > 0) {
            frm.tmProcedimento.removeRow(0);
        }
    }

    private void habilitarBtSalvar() {
        frm.getBtSalvarProcedimento().setEnabled(true);
    }

    private void desabilitarBtSalvar() {
        frm.getBtSalvarProcedimento().setEnabled(false);
    }

    private void habilitarBtAlterar() {
        frm.getBtAlterarProcedimento().setEnabled(true);
    }

    private void desabilitarBtAlterar() {
        frm.getBtAlterarProcedimento().setEnabled(false);
    }

    private boolean verifarCodigo() {
        try {
            if (Integer.parseInt(frm.getFtxtCodigo().getText()) > 0) {
                return true;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frm, "Preeencha o Código!", "Error" + ex, JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    private boolean verificarCampos() {
        if (!frm.getTxtNomeProcedimento().getText().equals("") && !frm.getFtxtCodigo().getText().equals("")) {
            return true;
        } else {
            JOptionPane.showMessageDialog(frm, "Falta preencher algum campo no formulário!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
