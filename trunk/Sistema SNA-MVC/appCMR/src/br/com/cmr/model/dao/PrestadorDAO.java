/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cmr.model.dao;

import br.com.cmr.model.entity.Prestador;
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
public class PrestadorDAO implements IPrestadorDAO{
    
    private static final String sqlInsert = "insert into PRESTADOR (CNES, NOME)"
            + "VALUES (?,?)";
    private static final String sqlUpdate = "update PRESTADOR set CNES = ?, "
            + "NOME = ? where ID = ?";
    private static final String sqlDelete = "delete from PRESTADOR where ID = ? ";
    private static final String sqlFindAll = "select * from PRESTADOR";

    @Override
    public int save(Prestador prestador) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            int index = 0;
            pstm = conn.prepareStatement(sqlInsert);
            pstm.setString(++index, prestador.getCnes());
            pstm.setString(++index, prestador.getNome());
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
    public int update(Prestador prestador) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            int index = 0;
            pstm = conn.prepareStatement(sqlUpdate);
            pstm.setString(++index, prestador.getCnes());
            pstm.setString(++index, prestador.getNome());
            pstm.setLong(++index, prestador.getId());
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
        return result;  //To change body of generated methods, choose Tools | Templates.
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
        return result;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Prestador> findAll() {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        List<Prestador> prestadores = new ArrayList<>();
        ResultSet rs = null;
        try {
            pstm = conn.prepareStatement(sqlFindAll);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Prestador prestador = new  Prestador();
                prestador.setId(rs.getLong("id"));
                prestador.setCnes(rs.getString("cnes"));
                prestador.setNome(rs.getString("nome"));
                prestadores.add(prestador);
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
        return prestadores;
    }
    
}
