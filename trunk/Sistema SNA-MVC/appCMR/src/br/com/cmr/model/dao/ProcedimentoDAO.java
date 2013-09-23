/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cmr.model.dao;

import br.com.cmr.model.entity.Procedimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class ProcedimentoDAO implements IProcedimentoDAO {

    private static final String sqlInsert = "insert into PROCEDIMENTO (CODIGO, NOME)"
            + "VALUES (?,?)";
    private static final String sqlUpdate = "update PROCEDIMENTO set CODIGO = ?, "
            + "NOME = ? where ID = ?";
    private static final String sqlDelete = "delete from PROCEDIMENTO where ID = ? ";
    private static final String sqlFindAll = "select * from PROCEDIMENTO";

    @Override
    public int save(Procedimento procedimento) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            int index = 0;
            pstm = conn.prepareStatement(sqlInsert);
            pstm.setString(++index, procedimento.getCodigo());
            pstm.setString(++index, procedimento.getNome());
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
    public int update(Procedimento procedimento) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            int index = 0;
            pstm = conn.prepareStatement(sqlUpdate);
            pstm.setString(++index, procedimento.getCodigo());
            pstm.setString(++index, procedimento.getNome());
            pstm.setLong(++index, procedimento.getId());
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
    public int remove(Long id) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            pstm = conn.prepareStatement(sqlDelete);
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
    public List<Procedimento> findAll() {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        List<Procedimento> procedimentos = new ArrayList<>();
        ResultSet rs = null;
        try {
            pstm = conn.prepareStatement(sqlFindAll);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Procedimento procedimento = new Procedimento();
                procedimento.setId(rs.getLong("id"));
                procedimento.setCodigo(rs.getString("codigo"));
                procedimento.setNome(rs.getString("nome"));
                procedimentos.add(procedimento);
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
        return procedimentos;
    }
    
}
