/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cmr.model.dao;

import br.com.cmr.model.entity.Funcionario;
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
public class FuncionarioDAO implements IFuncionarioDAO{
    
    private static final String sqlInsert = "insert into FUNCIONARIO (NOME, SOBRENOME, CARGO)"
            + "VALUES (?,?,?)";
    private static final String sqlUpdate = "update FUNCIONARIO set NOME = ?, "
            + "SOBRENOME = ?, CARGO = ? where ID = ?";
    private static final String sqlDelete = "delete from FUNCIONARIO where ID = ? ";
    private static final String sqlFindAll = "select * from FUNCIONARIO";

    @Override
    public int save(Funcionario funcionario) {
         Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            int index = 0;
            pstm = conn.prepareStatement(sqlInsert);
            pstm.setString(++index, funcionario.getNome());
            pstm.setString(++index, funcionario.getSobrenome());
            pstm.setString(++index, funcionario.getCargo());
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
    public int update(Funcionario funcionario) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            int index = 0;
            pstm = conn.prepareStatement(sqlUpdate);
            pstm.setString(++index, funcionario.getNome());
            pstm.setString(++index, funcionario.getSobrenome());
            pstm.setString(++index, funcionario.getCargo());
            pstm.setLong(++index,   funcionario.getId());
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
    public List<Funcionario> findAll() {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        List<Funcionario> funcionarios = new ArrayList<>();
        ResultSet rs = null;
        try {
            pstm = conn.prepareStatement(sqlFindAll);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Funcionario funcionario = new  Funcionario();
                funcionario.setId(rs.getLong("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setSobrenome(rs.getString("sobrenome"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionarios.add(funcionario);
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
        return funcionarios;
    } 
    
}
