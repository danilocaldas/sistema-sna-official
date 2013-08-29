/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sna.control;

import br.com.sna.model.dao.Funcionario;
import br.com.sna.model.dao.Prestador;
import br.com.sna.model.dao.Procedimento;
import br.com.sna.model.dao.Producao;
import br.com.sna.model.service.FuncionarioImplements;
import br.com.sna.model.service.PrestadorImplements;
import br.com.sna.model.service.ProcedimentoImplements;
import br.com.sna.model.service.ProducaoImplements;
import br.com.sna.view.ProducaoFrm;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Danilo
 */
public class ProducaoActionControl implements ControlInterface, ActionListener {

    public List<Procedimento> procedimentos;
    public List<Prestador> prestadores;
    public List<Funcionario> funcionarios;
    public List<Producao> producoes;
    public ProducaoImplements producaoImplements;
    public ProducaoFrm frm;
    public ProcedimentoImplements procedimentoImplements;
    public PrestadorImplements prestadorImplements;
    public FuncionarioImplements funcionarioImplements;

    public ProducaoActionControl(ProducaoFrm frm) {
        this.frm = frm;


        producaoImplements = new ProducaoImplements();
        procedimentoImplements = new ProcedimentoImplements();
        prestadorImplements = new PrestadorImplements();
        funcionarioImplements = new FuncionarioImplements();
        listarFuncionarios();
        listarPrestadores();
        listarProcedimentos();
        attachListener();

        frm.getTbProducao().setSelectionBackground(Color.RED);
        frm.setResizable(false);

    }

    @Override
    public final void attachListener() {
        frm.getBtIncluir().addActionListener(this);
        frm.getBtModificar().addActionListener(this);
        frm.getBtExcluir().addActionListener(this);
        frm.getBtSalvar().addActionListener(this);
        frm.getBtAlterar().addActionListener(this);
        frm.getBtFinalizar().addActionListener(this);
        frm.getRadioFuncionario().addActionListener(this);
        frm.getRadioPeriodo().addActionListener(this);
        frm.getRadioTodos().addActionListener(this);
        frm.getBoxFuncionarioManu().addActionListener(this);
        frm.getBtImprimir().addActionListener(this);
        frm.getBtLimpar().addActionListener(this);
        frm.getBtPesquisar().addActionListener(this);
        frm.getBtFinalizarManu().addActionListener(this);
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
    }

    @Override
    public void limparCampos() {
        frm.getjDateChooserDataEntrada().setDate(null);
        frm.getjDateChooserDataDigitacao().setDate(null);
        frm.getFtxtQuantidade().setText("");
    }

    @Override
    public void desabilitarCampoDoFrm() {
        frm.getjDateChooserDataEntrada().setEnabled(false);
        frm.getjDateChooserDataDigitacao().setEnabled(false);
        frm.getFtxtQuantidade().setEnabled(false);
    }

    @Override
    public void habilitarCamposDoFrm() {
        frm.getjDateChooserDataEntrada().setEnabled(true);
        frm.getjDateChooserDataDigitacao().setEnabled(true);
        frm.getFtxtQuantidade().setEnabled(true);
    }

    public void habilitarBtSalvar() {
        frm.getBtSalvar().setEnabled(true);
    }

    public void desabilitarBtSalvar() {
        frm.getBtSalvar().setEnabled(false);
    }

    public void habilitarBtAlterar() {
        frm.getBtAlterar().setEnabled(true);
    }

    public void desabilitarBtAlterar() {
        frm.getBtAlterar().setEnabled(false);
    }

    public boolean verificarCamposDatas() {
        if (frm.getjDateChooserDataEntrada().getDate() == null
                || frm.getjDateChooserDataDigitacao().getDate() == null) {
            JOptionPane.showMessageDialog(frm, "Preeencha as datas!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    private boolean verificarQuantidade() {
        try {
            if (Integer.parseInt(frm.getFtxtQuantidade().getText()) > 0) {
                return true;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frm, "Preeencha A quantidade!", "Error" + ex, JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    @Override
    public void prepararAlterar() {
        if (frm.getTbProducao().getSelectedRow() != -1) {
            enableButtonsToSaveAction();
            habilitarCamposDoFrm();
            habilitarBtAlterar();
            desabilitarBtSalvar();
        } else {
            JOptionPane.showMessageDialog(frm, "Selecione um registro!",
                    "Alterar", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void preparaInserir() {
        enableButtonsToSaveAction();
        habilitarCamposDoFrm();
        habilitarBtSalvar();
        desabilitarBtAlterar();
    }

    @Override
    public void alterar() {
        if (verificarCamposDatas() && verificarQuantidade()) {
            producaoImplements.update(formToProducao());
            JOptionPane.showMessageDialog(frm, "Producao Alterada", "Alterar", JOptionPane.INFORMATION_MESSAGE);
            disableButtonsToSaveAction();
            limparCampos();
            desabilitarCampoDoFrm();
            limparTabela(producoes);
            searchProducaoGeral();

        }
    }

    @Override
    public void salvar() {
        if (verificarCamposDatas() && verificarQuantidade()) {
            producaoImplements.save(formToProducao());
            JOptionPane.showMessageDialog(frm, "Producao Salva", "Salvar", JOptionPane.INFORMATION_MESSAGE);
            disableButtonsToSaveAction();
            limparCampos();
            desabilitarCampoDoFrm();
            limparTabela(producoes);
            searchProducaoGeral();
        }
    }

    @Override
    public void excluir() {
        if (frm.getTbProducao().getSelectedRow() != -1) {
            String msg = "Deseja realmente excluir esta produção?";
            String titulo = "Confimação";
            int yes = JOptionPane.showConfirmDialog(frm, msg, titulo, JOptionPane.YES_NO_OPTION);
            if (yes == JOptionPane.YES_OPTION) {
                producaoImplements.delete(formToProducao());
                JOptionPane.showMessageDialog(frm, "Produção excluída", "Excluir", JOptionPane.INFORMATION_MESSAGE);
                disableButtonsToSaveAction();
                limparCampos();
                desabilitarCampoDoFrm();
                limparTabela(producoes);
                searchProducaoGeral();
            }

        } else {
            JOptionPane.showMessageDialog(frm, "Selecione um registro!");
        }
    }

    public Producao formToProducao() {
        Producao producao = new Producao();
        if (!"".equals(frm.getLabelId().getText())) {
            producao.setId(Long.parseLong(frm.getLabelId().getText()));
        }
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dataEntrada =  (java.util.Date) frm.getjDateChooserDataEntrada().getDate();
        java.util.Date dataDigitacao = (java.util.Date) frm.getjDateChooserDataDigitacao().getDate();

        producao.setFuncionario_nome(frm.getBoxProfissional().getSelectedItem().toString());
        producao.setPrestador_nome(frm.getBoxPrestador().getSelectedItem().toString());
        producao.setProcedimento_nome(frm.getBoxProcedimento().getSelectedItem().toString());
        producao.setData_entrada(Date.valueOf(formato.format(dataEntrada)));
        producao.setData_digitacao(Date.valueOf(formato.format(dataDigitacao)));
        producao.setQuantidade(Integer.parseInt(frm.getFtxtQuantidade().getText()));

        return producao;

    }

    public final void listarProcedimentos() {
        procedimentos = procedimentoImplements.listProcedimento("%%");
        frm.getBoxProcedimento().removeAllItems();
        for (int i = 0; i < procedimentos.size(); i++) {
            frm.getBoxProcedimento().addItem(procedimentos.get(i).getNome());
        }
    }

    public final void listarFuncionarios() {
        funcionarios = funcionarioImplements.listFun("%%");
        frm.getBoxProfissional().removeAllItems();
        frm.getBoxFuncionarioManu().removeAllItems();
        for (int i = 0; i < funcionarios.size(); i++) {
            frm.getBoxProfissional().addItem(funcionarios.get(i).getNome());
            frm.getBoxFuncionarioManu().addItem(funcionarios.get(i).getNome());
        }
    }

    public final void listarPrestadores() {
        prestadores = prestadorImplements.listPrestador("%%");
        frm.getBoxPrestador().removeAllItems();
        for (int i = 0; i < prestadores.size(); i++) {
            frm.getBoxPrestador().addItem(prestadores.get(i).getNome());
        }
    }

    public void limparTabela(List<Producao> producoes) {
        while (frm.tmProducao.getRowCount() > 0) {
            frm.tmProducao.removeRow(0);
        }
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

        } else if (e.getActionCommand().equals("Limpar")) {
            limparTabela(producoes);
        } else if (e.getActionCommand().equals("Finalizar")) {
            desabilitarBtAlterar();
            desabilitarBtSalvar();
            disableButtonsToSaveAction();
            limparCampos();
            desabilitarCampoDoFrm();
        } else if (e.getActionCommand().equals("Pesquisar")) {
            pesquisarProdPorPeriodoProfissional();
            pesquisarProdPorProfissional();
            pesquisarProducaoGeral();
        } else if (e.getActionCommand().equals("Sair")) {
            frm.dispose();
        }
    }

    public void confirmarExclusão() {
        String msg = "Deseja realmente excluir esta produção?";
        String titulo = "Confimação";
        int yes = JOptionPane.showConfirmDialog(frm, msg, titulo, JOptionPane.YES_NO_OPTION);
        if (yes == JOptionPane.YES_OPTION) {
            excluir();

        }

    }

    public void pesquisarProducaoGeral() {
        if (frm.getRadioTodos().isSelected()) {
            limparTabela(producoes);
            searchProducaoGeral();
            somar();
        }
    }

    public void pesquisarProdPorProfissional() {
        if (frm.getRadioFuncionario().isSelected()) {
            limparTabela(producoes);
            searchProducaoProfissional();
            somar();
        }
    }

    public void pesquisarProdPorPeriodoProfissional() {
        if (frm.getRadioPeriodo().isSelected() && verificarDatasPesquisa()) {
            limparTabela(producoes);
            searchProducaoProfissionalPeriodo();
            somar();
        }
    }
    
    public void searchProducaoProfissionalPeriodo() {

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dataEntrada = (java.util.Date) frm.getjDateDe().getDate();
        java.util.Date dataDigitacao = (java.util.Date) frm.getjDataAte().getDate();
        producoes = producaoImplements.listProducao("%" + frm.getBoxFuncionarioManu().getSelectedItem().toString() + "%",
                Date.valueOf(formato.format(dataEntrada)), Date.valueOf(formato.format(dataDigitacao)));
        mostrarProducoes(producoes);

    }

    public void searchProducaoProfissional() {
        producoes = producaoImplements.ListarProducao("%" + frm.getBoxFuncionarioManu().getSelectedItem().toString() + "%");
        mostrarProducoes(producoes);

    }

    public void searchProducaoGeral() {
        producoes = producaoImplements.listProducao();
        mostrarProducoes(producoes);

    }

    public void mostrarProducoes(List<Producao> producoes) {
        while (frm.tmProducao.getRowCount() < 0) {
            frm.tmProducao.removeRow(0);
        }
        if (producoes.size() == 0) {
            JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum registro!");
        } else {
            String[] campos = new String[]{null, null, null, null, null, null, null};
            for (int i = 0; i < producoes.size(); i++) {
                frm.tmProducao.addRow(campos);
                frm.tmProducao.setValueAt(producoes.get(i).getId(), i, 0);
                frm.tmProducao.setValueAt(producoes.get(i).getFuncionario_nome(), i, 1);
                frm.tmProducao.setValueAt(producoes.get(i).getPrestador_nome(), i, 2);
                frm.tmProducao.setValueAt(producoes.get(i).getProcedimento_nome(), i, 3);
                frm.tmProducao.setValueAt(producoes.get(i).getData_entrada(), i, 4);
                frm.tmProducao.setValueAt(producoes.get(i).getData_digitacao(), i, 5);
                frm.tmProducao.setValueAt(producoes.get(i).getQuantidade(), i, 6);

            }
        }
    }
    
    public boolean verificarDatasPesquisa() {
        if (frm.getjDateDe().getDate() == null || frm.getjDataAte().getDate() == null) {
            JOptionPane.showMessageDialog(frm, "As datas devem ser preenchidas!");
            return false;
        } else {
            return true;
        }
    }

    public void tbProducaoLinhaSelecionada(JTable tb) {
        if (tb.getSelectedRow() != -1) {
            frm.getLabelId().setText(String.valueOf(producoes.get(tb.getSelectedRow()).getId()));
            frm.getBoxProfissional().setSelectedItem(producoes.get(tb.getSelectedRow()).getFuncionario_nome());
            frm.getBoxPrestador().setSelectedItem(producoes.get(tb.getSelectedRow()).getPrestador_nome());
            frm.getBoxProcedimento().setSelectedItem(producoes.get(tb.getSelectedRow()).getProcedimento_nome());
            frm.getjDateChooserDataEntrada().setDate(producoes.get(tb.getSelectedRow()).getData_entrada());
            frm.getjDateChooserDataDigitacao().setDate(producoes.get(tb.getSelectedRow()).getData_digitacao());
            frm.getFtxtQuantidade().setText(String.valueOf(producoes.get(tb.getSelectedRow()).getQuantidade()));
        } else {
            frm.getLabelId().setText("");
            frm.getjDateChooserDataDigitacao().setDate(null);
            frm.getjDateChooserDataEntrada().setDate(null);
            frm.getFtxtQuantidade().setText("");
        }
    }

    public void somar() {
        int total = 0;
        String valor = "";
        int linhas = frm.getTbProducao().getRowCount();
        for (int i = 0; i < linhas; i++) {
            valor = String.valueOf(frm.getTbProducao().getValueAt(i, 6));
            total = total + Integer.parseInt(valor);
        }
        frm.getLabelTotal().setText("Total: " + total);
    }
}
