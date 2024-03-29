/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sna.model.service;

/**
 *
 * @author Danilo
 */
public class Query {
    //CRUD FUNCIONARIO

    String cadastraFuncionario = "INSERT INTO FUNCIONARIO (NOME, SENHA) VALUES (?, ?)";
    String consultaFuncionario = "SELECT * FROM FUNCIONARIO ORDER BY NOME ASC";
    String listaFuncionario = "SELECT * FROM FUNCIONARIO WHERE NOME LIKE ? ORDER BY NOME ASC";
    String excluirFuncionario = "DELETE FROM FUNCIONARIO WHERE ID LIKE ?";
    String updateFuncionario = "UPDATE FUNCIONARIO SET NOME = ? ,SENHA = ? WHERE ID = ?";
    //CRUD PROCEDIMENTO
    String cadastraProcedimento = "INSERT INTO PROCEDIMENTO (CODIGO, NOME) VALUES (?, ?)";
    String consultaProcedimento = "SELECT * FROM PROCEDIMENTO ORDER BY NOME ASC";
    String listaProcedimento = "SELECT * FROM PROCEDIMENTO WHERE NOME LIKE ? ORDER BY NOME ASC";
    String excluirProcedimento = "DELETE FROM PROCEDIMENTO WHERE CODIGO LIKE ?";
    String updateProcedimento = "UPDATE PROCEDIMENTO SET NOME = ?,CODIGO = ? WHERE ID = ?";
    //CRUD PRESTADOR
    String cadastraPrestador = "INSERT INTO PRESTADOR (CNES, NOME) VALUES (?, ?)";
    String consultaPrestador = "SELECT * FROM PRESTADOR ORDER BY NOME ASC";
    String listaPrestador = "SELECT * FROM PRESTADOR WHERE NOME LIKE ? ORDER BY NOME ASC";
    String excluirPrestador = "DELETE FROM PRESTADOR WHERE CNES LIKE ?";
    String updatePrestador = "UPDATE PRESTADOR SET NOME = ?,CNES = ? WHERE ID = ?";
    //CRUD PRODUCAO
    String cadastraProducao = "INSERT INTO PRODUCAO (FUNCIONARIO_NOME, PRESTADOR_NOME, PROCEDIMENTO_NOME , "
            + "DATA_DIGITACAO, DATA_ENTRADA, QUANTIDADE) VALUES (?, ?, ?, ?, ?, ?)";
    String consultaProducaoTodos = "SELECT * FROM PRODUCAO ORDER BY FUNCIONARIO_NOME";
    String consultaProducaoProfissional = "SELECT * FROM PRODUCAO WHERE FUNCIONARIO_NOME LIKE ? ORDER BY DATA_DIGITACAO";
    String consultaProducaoPeriodo = "SELECT * FROM PRODUCAO WHERE FUNCIONARIO_NOME LIKE ? "
            + "AND DATA_DIGITACAO BETWEEN ? AND ?";
    String excluirProducao = "DELETE FROM PRODUCAO WHERE ID LIKE ?";
    String updateProducao = "UPDATE PRODUCAO SET FUNCIONARIO_NOME = ?, PRESTADOR_NOME = ?, PROCEDIMENTO_NOME = ?, DATA_DIGITACAO = ?,"
            + "DATA_ENTRADA = ?,QUANTIDADE = ? WHERE ID = ?";
    String listaProducao = "SELECT * FROM PRODUCAO ORDER BY ID ASC";
    //CRUD ARQUIVO
    String cadastraArquivo = "INSERT INTO CAIXA (NUMERO, ANO, MES, COR, PRESTADOR_NOME, PROCEDIMENTO_NOME) VALUES(?, ?, ?, ?, ?, ?)";
    String consultaArquivo = "SELECT * FROM CAIXA ORDER BY NUMERO";
    String consultaArquivoAno = "SELECT * FROM CAIXA WHERE ANO LIKE ? ORDER BY NUMERO";
    String consultaArquivoAnoMes = "SELECT * FROM CAIXA WHERE ANO LIKE ? AND MES LIKE ? ORDER BY NUMERO";
    
    String excluirCaixa = "DELETE FROM CAIXA WHERE NUMERO = ? AND ANO = ?";
    String updateArquivo = "UPDATE CAIXA SET ANO = ?,MES = ?,COR = ?,PRESTADOR_NOME = ?,PROCEDIMENTO_NOME = ? WHERE NUMERO = ?";
    //SOMA PRODUCAO
    String somaProducao = "SELECT SUM(quantidade) FROM PRODUCAO GROUP BY FUNCIONARIO_NOME LIKE ?";
    //Query modo de seleção de pesquisa da produção
    String conString = "";
}
