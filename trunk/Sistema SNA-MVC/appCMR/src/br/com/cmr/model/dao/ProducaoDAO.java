/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cmr.model.dao;

import br.com.cmr.model.entity.Producao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ritacosta
 */
public class ProducaoDAO implements IProducaoDAO {

    private static final String SQL_INSERT = "insert into PRODUCAO (FUNCIONARIO, PRESTADOR, PROCEDIMENTO"
            + "DATA, DATA_ENTRADA, DATA_DIGITACAO, QUANTIDADE)values(?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE FROM PRODUCAO SET FUNCIONARIO = ?, PRESTADOR = ?, PROCEDIMENTO = ?,"
            + "DATA = ?, DATA_ENTRADA = ?, DATA_DIGITACAO = ?, QUANTIDADE = ? WHERE ID = ?";
    private static final String SQL_DELETE = "DELETE FROM PRODUCAO WHERE ID = ?";
    private static final String SQL_LISTAR = "SELECT * FROM PRODUCAO";

    @Override
    public int save(Producao producao) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            pstm = conn.prepareStatement(SQL_INSERT);
            pstm.setString(1, producao.getFuncionario());
            pstm.setString(2, producao.getPrestador());
            pstm.setString(3, producao.getProcedimento());
            pstm.setDate(4, producao.getData());
            pstm.setDate(5, producao.getDataEntrada());
            pstm.setDate(6, producao.getDataDigitacao());
            pstm.setString(7, producao.getQuantidade());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            } finally {
                DBConnection.close(conn, pstm, null);
            }
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(Producao producao) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            pstm = conn.prepareStatement(SQL_UPDATE);
            pstm.setString(1, producao.getFuncionario());
            pstm.setString(2, producao.getPrestador());
            pstm.setString(3, producao.getProcedimento());
            pstm.setDate(4, producao.getData());
            pstm.setDate(5, producao.getDataEntrada());
            pstm.setDate(6, producao.getDataDigitacao());
            pstm.setString(7, producao.getQuantidade());
            pstm.setLong(8, producao.getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            } finally {
                DBConnection.close(conn, pstm, null);
            }
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public int remove(Long id) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            pstm = conn.prepareStatement(SQL_DELETE);
            pstm.setLong(1, id);
            result = pstm.executeUpdate();
        } catch (SQLException ex) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            } finally {
                DBConnection.close(conn, pstm, null);
            }
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Producao> findAll() {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        List<Producao> producoes = new ArrayList<>();
        ResultSet rs = null;
        try {
            pstm = conn.prepareStatement(SQL_LISTAR);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Producao producao = new Producao();
                producao.setId(rs.getLong("id"));
                producao.setFuncionario(rs.getString("funcionario"));
                producao.setPrestador(rs.getString("prestador"));
                producao.setProcedimento(rs.getString("procedimento"));
                producao.setData(rs.getDate("data"));
                producao.setDataEntrada(rs.getDate("data_entrada"));
                producao.setDataDigitacao(rs.getDate("data_digitacao"));
                producao.setQuantidade(rs.getString("quantidade"));
                producoes.add(producao);
            }
        } catch (SQLException ex) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            } finally {
                DBConnection.close(conn, pstm, rs);
            }
            ex.printStackTrace();
        }
        return producoes;
    }
}
