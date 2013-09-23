/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cmr.view.controlforms;

import br.com.cmr.controller.ProcedimentoController;
import br.com.cmr.model.entity.Procedimento;
import br.com.cmr.view.FormProcedimemto;
import br.com.cmr.view.tables.ProcPrestCellRenderer;
import br.com.cmr.view.tables.ProcedimentoTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Danilo
 */
public class ProcedimentoActionControl implements ActionListener {

    public FormProcedimemto frm;
    public List<Procedimento> listProcedimento;
    private Long idProcedimento;

    public ProcedimentoActionControl(FormProcedimemto frm) {

        this.frm = frm;
        addButoesToForm();
        refreshTable();
        enableFields(false);
        frm.getTxtId().setEnabled(false);

    }

    private void addButoesToForm() {
        frm.getBtNovo().addActionListener(this);
        frm.getBtAtualizar().addActionListener(this);
        frm.getBtSalvar().addActionListener(this);
        frm.getBtExcluir().addActionListener(this);
        frm.getBtCancelar().addActionListener(this);
    }

    private void enableFields(boolean enable) {
        frm.getTxtCodigo().setEnabled(enable);
        frm.getTxtNome().setEnabled(enable);
    }

    private void onCancelar() {
        enableFields(false);
        frm.getTxtId().setText("");
        frm.getTxtCodigo().setText("");
        frm.getTxtNome().setText("");
        
    }

    private void refreshTable() {
        listProcedimento = new ProcedimentoController().finfPProcedimento();
        if (listProcedimento != null) {
            frm.getTbProcedimento().setModel(new ProcedimentoTableModel(listProcedimento));
            frm.getTbProcedimento().setDefaultRenderer(Object.class, new ProcPrestCellRenderer());
        }
    }

    private void onSaveProcedimento() {
        Procedimento procedimento = new Procedimento();
        if (frm.getTxtCodigo().getText().length() > 0
                && frm.getTxtNome().getText().length() > 0) {
            procedimento.setCodigo(frm.getTxtCodigo().getText());
            procedimento.setNome(frm.getTxtNome().getText());
        } else {
            JOptionPane.showMessageDialog(frm, "Todos os campos são obrigatórios!");
            return;
        }

        int result = 0;
        if (idProcedimento == null) {
            result = new ProcedimentoController().addProcedimento(procedimento);
        } else {
            procedimento.setId(idProcedimento);
            result = new ProcedimentoController().updateProcedimento(procedimento);
            idProcedimento = null;
        }

        if (result == 1) {
            JOptionPane.showMessageDialog(frm, "Procedimento inserido com sucesso!");
            enableFields(false);
            onCancelar();
            refreshTable();
        } else {
            JOptionPane.showMessageDialog(frm, "Tente novamente!");
        }
    }

    private void onAlterarProcedimento() {
        int indexRow = frm.getTbProcedimento().getSelectedRow();
        if (indexRow == -1) {
            JOptionPane.showMessageDialog(frm, "Selecione o livro a ser alterado!");
            return;
        }
        Procedimento procedimento = new ProcedimentoTableModel(listProcedimento).get(indexRow);
        idProcedimento = procedimento.getId();
        frm.getTxtId().setText(String.valueOf(procedimento.getId()));
        frm.getTxtCodigo().setText(procedimento.getCodigo());
        frm.getTxtNome().setText(procedimento.getNome());
        enableFields(true);
    }

    private void removerProcedimento() {
        int indexRow = frm.getTbProcedimento().getSelectedRow();
        if (indexRow == -1) {
            JOptionPane.showMessageDialog(frm, "Selecione o livro a ser removido!");
            return;
        }
        Procedimento procedimento = new ProcedimentoTableModel(listProcedimento).get(indexRow);
        int confirm = JOptionPane.showConfirmDialog(frm, "Confirmar a exclusão?", "Excluir Procedimento", JOptionPane.YES_NO_OPTION);
        if (confirm != 0) {
            return;
        }
        int result = new ProcedimentoController().excluirProcedimento(procedimento.getId());
        if (result == 1) {
            JOptionPane.showMessageDialog(frm, "Procedimento removido com sucesso!");
            refreshTable();
        } else {
            JOptionPane.showMessageDialog(frm, "Tente novamente!");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Salvar":
                onSaveProcedimento();
                break;
            case "Novo":
                enableFields(true);
                break;
            case "Cancelar":
                onCancelar();
                break;
            case "Excluir":
                removerProcedimento();
                break;
            case "Atualizar":
                onAlterarProcedimento();
                break;
        }
    }
}
