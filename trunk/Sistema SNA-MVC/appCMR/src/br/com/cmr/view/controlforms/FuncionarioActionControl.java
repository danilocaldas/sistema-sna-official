/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cmr.view.controlforms;

import br.com.cmr.controller.FuncionarioController;
import br.com.cmr.model.entity.Funcionario;
import br.com.cmr.view.FormFuncionario;
import br.com.cmr.view.tables.FuncionarioCellRenderer;
import br.com.cmr.view.tables.FuncionarioTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Danilo
 */
public class FuncionarioActionControl implements ActionListener {

    private FormFuncionario frm;
    private List<Funcionario> listFuncionarios;
    private Long idFuncionario;

    public FuncionarioActionControl(FormFuncionario frm) {
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

    private void onCancelar() {
        enableFields(false);
        frm.getTxtId().setText("");
        frm.getTxtCargo().setText("");
        frm.getTxtNome().setText("");
        frm.getTxtSobrenome().setText("");

    }

    private void onSaveFuncionario() {
        Funcionario funcionario = new Funcionario();
        if (frm.getTxtCargo().getText().length() > 0
                && frm.getTxtNome().getText().length() > 0 && frm.getTxtSobrenome().getText().length() > 0) {
            funcionario.setCargo(frm.getTxtCargo().getText());
            funcionario.setNome(frm.getTxtNome().getText());
            funcionario.setSobrenome(frm.getTxtSobrenome().getText());
        } else {
            JOptionPane.showMessageDialog(frm, "Todos os campos são obrigatórios!");
            return;
        }

        int result = 0;
        
        if (idFuncionario == null) {
            result = new FuncionarioController().addFuncionario(funcionario);
        } else {
            funcionario.setId(idFuncionario);
            result = new FuncionarioController().updateFuncionario(funcionario);
            idFuncionario = null;
        }
        if(result == 1){
            JOptionPane.showMessageDialog(frm, "Funcionário inserido com sucesso!");
            enableFields(false);
            onCancelar();
            refreshTable();
        } else {
            JOptionPane.showMessageDialog(frm, "Tente novamente!");
        }
    }
    
    private void onAlterarFuncionario() {
        int indexRow = frm.getTbFuncionario().getSelectedRow();
        if (indexRow == -1) {
            JOptionPane.showMessageDialog(frm, "Selecione o funcionário a ser alterado!");
            return;
        }
        Funcionario funcionario = new FuncionarioTableModel(listFuncionarios).get(indexRow);
        idFuncionario = funcionario.getId();
        frm.getTxtId().setText(String.valueOf(funcionario.getId()));
        frm.getTxtNome().setText(funcionario.getNome());
        frm.getTxtSobrenome().setText(funcionario.getSobrenome());
        frm.getTxtCargo().setText(funcionario.getCargo());
        enableFields(true);
    }

    private void removerFuncionario() {
        int indexRow = frm.getTbFuncionario().getSelectedRow();
        if (indexRow == -1) {
            JOptionPane.showMessageDialog(frm, "Selecione o funcionário a ser removido!");
            return;
        }
        Funcionario funcionario = new FuncionarioTableModel(listFuncionarios).get(indexRow);
        int confirm = JOptionPane.showConfirmDialog(frm, "Confirmar a exclusão?", "Excluir Funcionário", JOptionPane.YES_NO_OPTION);
        if (confirm != 0) {
            return;
        }
        int result = new FuncionarioController().excluirFuncionario(funcionario.getId());
        if (result == 1) {
            JOptionPane.showMessageDialog(frm, "Funcionário removido com sucesso!");
            refreshTable();
        } else {
            JOptionPane.showMessageDialog(frm, "Tente novamente!");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Salvar":
                onSaveFuncionario();
                break;
            case "Novo":
                enableFields(true);
                break;
            case "Cancelar":
                onCancelar();
                break;
            case "Excluir":
                removerFuncionario();
                break;
            case "Atualizar":
                onAlterarFuncionario();
                break;
        } 
    }

    private void refreshTable() {
        listFuncionarios = new FuncionarioController().finfFuncionario();
        if (listFuncionarios != null) {
            frm.getTbFuncionario().setModel(new FuncionarioTableModel(listFuncionarios));
            frm.getTbFuncionario().setDefaultRenderer(Object.class, new FuncionarioCellRenderer());
        }
    }

    private void enableFields(boolean enable) {
        frm.getTxtCargo().setEnabled(enable);
        frm.getTxtNome().setEnabled(enable);
        frm.getTxtSobrenome().setEnabled(enable);

    }
}
