/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sna.control;

import br.com.sna.model.dao.Funcionario;
import br.com.sna.model.service.FuncionarioImplements;
import br.com.sna.view.FuncionarioFrm;
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
public class FuncionarioActionControl implements ActionListener {

    List<Funcionario> funcionarios;
    ListSelectionModel lsmFuncionario;
    private FuncionarioFrm frm;
    private FuncionarioImplements funcionarioImplements;

    public FuncionarioActionControl(FuncionarioFrm frm) {
        this.frm = frm;
        funcionarioImplements = new FuncionarioImplements();
        attachListener();
        frm.getTbFuncionario().setSelectionBackground(Color.red);
        frm.setResizable(false);
    }

    public final void attachListener() {
        frm.getBtPrepararAlterarFuncionario().addActionListener(this);
        frm.getBtAlterar().addActionListener(this);
        frm.getBtIncluirFuncionario().addActionListener(this);
        frm.getBtExcluirFuncionario().addActionListener(this);
        frm.getBtFinalizarFuncionario().addActionListener(this);
        frm.getBtSalvarFuncionario().addActionListener(this);
        frm.getBtPesquisar().addActionListener(this);
        frm.getBtLimpar().addActionListener(this);
    }

    private void enableButtonsToSaveAction() {
        enableDisableButtonsToEdit(true);
    }

    private void disableButtonsToSaveAction() {
        enableDisableButtonsToEdit(false);
    }

    private void enableDisableButtonsToEdit(boolean enabled) {
        frm.getBtIncluirFuncionario().setEnabled(!enabled);
        frm.getBtPrepararAlterarFuncionario().setEnabled(!enabled);
        frm.getBtExcluirFuncionario().setEnabled(!enabled);
        frm.getBtFinalizarFuncionario().setEnabled(enabled);
    }

    private void habilitarBtSalvar() {
        frm.getBtSalvarFuncionario().setEnabled(true);
    }

    private void desabilitarBtSalvar() {
        frm.getBtSalvarFuncionario().setEnabled(false);
    }

    private void habilitarBtAlterar() {
        frm.getBtAlterar().setEnabled(true);
    }

    private void desabilitarBtAlterar() {
        frm.getBtAlterar().setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals("Incluir")) {
            preparaInserirFuncionario();
        } else if (event.getActionCommand().equals("Modificar")) {
            prepararAlterarFuncionario();
        } else if (event.getActionCommand().equals("Excluir")) {
            excluir();
        } else if (event.getActionCommand().equals("Salvar")) {
            salvar();
            desabilitarBtSalvar();
        } else if (event.getActionCommand().equals("Alterar")) {
            alterar();
            desabilitarBtAlterar();
        } else if (event.getActionCommand().equals("Limpar")) {
            limparTabela(funcionarios);
        } else if (event.getActionCommand().equals("Finalizar")) {
            desabilitarBtAlterar();
            desabilitarBtSalvar();
            disableButtonsToSaveAction();
            limparTabela(funcionarios);
            limparCampos();
            desabilitarCampoDoFrm();
        }
    }

    private void limparCampos() {
        frm.getTxtNomeFuncionario().setText("");
        frm.getPtxtSenhaFuncionario().setText("");
        frm.getLabelId().setText("");
    }

    private void desabilitarCampoDoFrm() {
        frm.getTxtNomeFuncionario().setEnabled(false);
        frm.getPtxtSenhaFuncionario().setEnabled(false);
    }

    private void habilitarCamposDoFrm() {
        frm.getTxtNomeFuncionario().setEnabled(true);
        frm.getPtxtSenhaFuncionario().setEnabled(true);
    }

    private void prepararAlterarFuncionario() {
        if (frm.getTbFuncionario().getSelectedRow() != -1) {
            enableButtonsToSaveAction();
            habilitarCamposDoFrm();
            habilitarBtAlterar();
            desabilitarBtSalvar();

        } else {
            JOptionPane.showMessageDialog(frm, "Selecione um registro!", "Modificar", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void preparaInserirFuncionario() {
        enableButtonsToSaveAction();
        habilitarCamposDoFrm();
        habilitarBtSalvar();
        desabilitarBtAlterar();
    }

    private void alterar() {
        if (verificarCampos()) {
            funcionarioImplements.update(formToFuncionario());
            JOptionPane.showMessageDialog(frm, "Funcionario Alterado", "Alterar", JOptionPane.INFORMATION_MESSAGE);
            disableButtonsToSaveAction();
            limparCampos();
            desabilitarCampoDoFrm();
            limparTabela(funcionarios);
            frm.searchFuncionario();
        }
    }

    private void salvar() {
        if (verificarCampos()) {
            funcionarioImplements.save(formToFuncionario());
            JOptionPane.showMessageDialog(frm, "Funcionario salvo", "Salvar", JOptionPane.INFORMATION_MESSAGE);
            disableButtonsToSaveAction();
            limparCampos();
            desabilitarCampoDoFrm();
            limparTabela(funcionarios);
            frm.searchFuncionario();
        }
    }

    private void excluir() {
        if (frm.getTbFuncionario().getSelectedRow() != -1) {
            String msg = "Deseja realmente excluir este funcionário?";
            String titulo = "Confimação";
            int yes = JOptionPane.showConfirmDialog(frm, msg, titulo, JOptionPane.YES_NO_OPTION);
            if (yes == JOptionPane.YES_OPTION) {
                funcionarioImplements.delete(formToFuncionario());
                JOptionPane.showMessageDialog(frm, "Funcionario excluido", "Excluir", JOptionPane.INFORMATION_MESSAGE);
                disableButtonsToSaveAction();
                limparCampos();
                desabilitarCampoDoFrm();
                limparTabela(funcionarios);
                frm.searchFuncionario();
            }else if (yes == JOptionPane.NO_OPTION){
                limparCampos();
                limparTabela(funcionarios);
            }
        } else {
            JOptionPane.showMessageDialog(frm, "Selecione um registro!", "Excluir", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private Funcionario formToFuncionario() {

        Funcionario funcionario = new Funcionario();
        if (!"".equals(frm.getLabelId().getText())) {
            funcionario.setId(Long.parseLong(frm.getLabelId().getText()));
        }
        funcionario.setNome(frm.getTxtNomeFuncionario().getText());
        funcionario.setSenha(frm.getPtxtSenhaFuncionario().getText());

        return funcionario;
    }

    public void limparTabela(List<Funcionario> funcionario) {
        while (frm.tmFuncionario.getRowCount() > 0) {
            frm.tmFuncionario.removeRow(0);
        }
    }

    private boolean verificarCampos() {
        if (!frm.getTxtNomeFuncionario().getText().equals("") && !frm.getPtxtSenhaFuncionario().getText().equals("")) {
            return true;
        } else {
            JOptionPane.showMessageDialog(frm, "Falta preencher algum campo no formulário!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
}
