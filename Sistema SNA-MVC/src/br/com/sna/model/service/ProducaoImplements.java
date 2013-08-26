/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sna.model.service;

import br.com.sna.connection.ConnectionfactoryMYSQL;
import br.com.sna.model.dao.Producao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Danilo
 */
public class ProducaoImplements implements ProducaoController {

    ConnectionfactoryMYSQL bdConnection = new ConnectionfactoryMYSQL();
    Query query = new Query();
    PreparedStatement pstmt;
    ResultSet rset;

    @Override
    public void save(Producao producao) {
        int index = 0;
        try {
            pstmt = bdConnection.conectar().prepareStatement(query.cadastraProducao);
            pstmt.setString(++index, producao.getFuncionario_nome());
            pstmt.setString(++index, producao.getPrestador_nome());
            pstmt.setString(++index, producao.getProcedimento_nome());
            pstmt.setDate(++index, producao.getData_digitacao());
            pstmt.setDate(++index, producao.getData_entrada());
            pstmt.setInt(++index, producao.getQuantidade());
            pstmt.executeUpdate();
            bdConnection.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(ProducaoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Producao producao) {
        int index = 0;
        try {
            pstmt = bdConnection.conectar().prepareStatement(query.updateProducao);
            pstmt.setString(++index, producao.getFuncionario_nome());
            pstmt.setString(++index, producao.getPrestador_nome());
            pstmt.setString(++index, producao.getProcedimento_nome());
            pstmt.setDate(++index, producao.getData_digitacao());
            pstmt.setDate(++index, producao.getData_entrada());
            pstmt.setInt(++index, producao.getQuantidade());
            pstmt.setLong(++index, producao.getId());
            pstmt.executeUpdate();
            bdConnection.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(ProducaoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Producao producao) {
        int index = 0;
        try {
            pstmt = bdConnection.conectar().prepareStatement(query.excluirProducao);
            //pstmt.setString(++index, producao.getFuncionario_nome());
            pstmt.setLong(++index, producao.getId());
            pstmt.executeUpdate();
            bdConnection.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(ProducaoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Producao> ListarProducao(String funcionario_nome) {
        List<Producao> producoes = new ArrayList<Producao>();
        try {
            pstmt = bdConnection.conectar().prepareStatement(query.consultaProducaoProfissional);
            pstmt.setString(1, funcionario_nome);
            rset = pstmt.executeQuery();
            Producao pro;
            while (rset.next()) {
                pro = new Producao();
                pro.setId(rset.getLong("id"));
                pro.setFuncionario_nome(rset.getString("funcionario_nome"));
                pro.setPrestador_nome(rset.getString("prestador_nome"));
                pro.setProcedimento_nome(rset.getString("procedimento_nome"));
                pro.setData_digitacao(rset.getDate("data_entrada"));
                pro.setData_entrada(rset.getDate("data_digitacao"));
                pro.setQuantidade(rset.getInt("quantidade"));
                producoes.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProducaoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
        return producoes;
    }

    @Override
    public List<Producao> listProducao() {
        List<Producao> producao = new ArrayList<Producao>();
        try {
            pstmt = bdConnection.conectar().prepareStatement(query.conString + query.consultaProducaoTodos);
            rset = pstmt.executeQuery();
            Producao pro2;
            while (rset.next()) {
                pro2 = new Producao();
                pro2.setId(rset.getLong("id"));
                pro2.setFuncionario_nome(rset.getString("funcionario_nome"));
                pro2.setPrestador_nome(rset.getString("prestador_nome"));
                pro2.setProcedimento_nome(rset.getString("procedimento_nome"));
                pro2.setData_entrada(rset.getDate("data_entrada"));
                pro2.setData_digitacao(rset.getDate("data_digitacao"));
                pro2.setQuantidade(rset.getInt("quantidade"));
                producao.add(pro2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProducaoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
        return producao;
    }

    @Override
    public List<Producao> listProducao(String funcionario_nome, Date data_inicio, Date data_fim) {
        List<Producao> producoes = new ArrayList<Producao>();
        try {
            pstmt = bdConnection.conectar().prepareStatement(query.consultaProducaoPeriodo);
            pstmt.setString(1, funcionario_nome);
            pstmt.setDate(2, data_inicio);
            pstmt.setDate(3, data_fim);
            rset = pstmt.executeQuery();
            Producao pro3;
            while (rset.next()) {
                pro3 = new Producao();
                pro3.setId(rset.getLong("id"));
                pro3.setFuncionario_nome(rset.getString("funcionario_nome"));
                pro3.setPrestador_nome(rset.getString("prestador_nome"));
                pro3.setProcedimento_nome(rset.getString("procedimento_nome"));
                pro3.setData_entrada(rset.getDate("data_entrada"));
                pro3.setData_digitacao(rset.getDate("data_digitacao"));
                pro3.setQuantidade(rset.getInt("quantidade"));
                producoes.add(pro3);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProducaoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
        return producoes;
    }

   
}
