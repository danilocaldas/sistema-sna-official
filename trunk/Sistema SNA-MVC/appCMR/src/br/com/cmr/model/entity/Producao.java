/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cmr.model.entity;

import java.sql.Date;

/**
 *
 * @author Danilo
 */
public class Producao {
    
    private Long id;
    private String funcionario;
    private String prestador;
    private String procedimento;
    private Date data;
    private Date dataEntrada;
    private Date dataDigitacao;
    private String quantidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public String getPrestador() {
        return prestador;
    }

    public void setPrestador(String prestador) {
        this.prestador = prestador;
    }

    public String getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(String procedimento) {
        this.procedimento = procedimento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataDigitacao() {
        return dataDigitacao;
    }

    public void setDataDigitacao(Date dataDigitacao) {
        this.dataDigitacao = dataDigitacao;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Producao{" + "id=" + id + ", funcionario=" + funcionario + ", prestador=" + prestador + ", procedimento=" + procedimento + ", data=" + data + ", dataEntrada=" + dataEntrada + ", dataDigitacao=" + dataDigitacao + ", quantidade=" + quantidade + '}';
    }
    
    
}
