/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sna.model.service;

import br.com.sna.connection.ConnectionfactoryMYSQL;
import br.com.sna.model.dao.Arquivo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Danilo
 */
public class ArquivoImplements implements ArquivoController {

    ConnectionfactoryMYSQL bdConnection = new ConnectionfactoryMYSQL();
    Query query = new Query();
    PreparedStatement pstmt;
    ResultSet rset;

    @Override
    public void save(Arquivo arquivo) {
        int index = 0;
        try {
            pstmt = bdConnection.conectar().prepareStatement(query.cadastraArquivo);
            pstmt.setInt(++index, arquivo.getNumero());
            pstmt.setString(++index, arquivo.getAno());
            pstmt.setString(++index, arquivo.getMes());
            pstmt.setString(++index, arquivo.getCor());
            pstmt.setString(++index, arquivo.getPrestador_nome());
            pstmt.setString(++index, arquivo.getProcedimento_nome());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir o objeto arquivo. "
                    + "Erro :" + ex.getMessage());
        } finally {
            try {
                pstmt.close();
                bdConnection.desconectar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a operação de inserir o objeto arquivo. "
                        + "Erro :" + ex.getMessage());
            }
        }
    }

    @Override
    public void update(Arquivo arquivo) {
        int index = 0;
        try {
            pstmt = bdConnection.conectar().prepareStatement(query.updateArquivo);
            pstmt.setString(++index, arquivo.getAno());
            pstmt.setString(++index, arquivo.getMes());
            pstmt.setString(++index, arquivo.getCor());
            pstmt.setString(++index, arquivo.getPrestador_nome());
            pstmt.setString(++index, arquivo.getProcedimento_nome());
            pstmt.setInt(++index, arquivo.getNumero());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar o objeto arquivo. "
                    + "Erro :" + ex.getMessage());
        } finally {
            try {
                pstmt.close();
                bdConnection.desconectar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a operação de alteração do objeto arquivo. "
                        + "Erro :" + ex.getMessage());
            }
        }
    }

    @Override
    public void delete(Arquivo arquivo) {
        try {
            pstmt = bdConnection.conectar().prepareStatement(query.excluirCaixa);
            pstmt.setInt(1, arquivo.getNumero());
            pstmt.setString(2, arquivo.getAno());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o objeto arquivo. "
                    + "Erro :" + ex.getMessage());
        } finally {
            try {
                pstmt.close();
                bdConnection.desconectar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a operação de exclusão do objeto arquivo. "
                        + "Erro :" + ex.getMessage());
            }
        }
    }

    @Override
    public List<Arquivo> lista_arquivo() {
        List<Arquivo> arquivos = new ArrayList<Arquivo>();
        try {
            pstmt = bdConnection.conectar().prepareStatement(query.consultaArquivo);
            rset = pstmt.executeQuery();
            Arquivo arq;
            while (rset.next()) {
                arq = new Arquivo();
                arq.setNumero(rset.getInt("numero"));
                arq.setAno(rset.getString("ano"));
                arq.setMes(rset.getString("mes"));
                arq.setCor(rset.getString("cor"));
                arq.setPrestador_nome(rset.getString("prestador_nome"));
                arq.setProcedimento_nome(rset.getString("procedimento_nome"));
                arquivos.add(arq);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar o objeto arquivo. "
                    + "Erro :" + ex.getMessage());
        } finally {
            try {
                pstmt.close();
                bdConnection.desconectar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a operação de listagem do objeto arquivo. "
                        + "Erro :" + ex.getMessage());
            }
        }
        return arquivos;
    }

    @Override
    public List<Arquivo> lista_arquivo_ano(String ano) {
        List<Arquivo> arquivos = new ArrayList<Arquivo>();
        try {
            pstmt = bdConnection.conectar().prepareStatement(query.consultaArquivoAno);
            pstmt.setString(1, ano);
            rset = pstmt.executeQuery();
            Arquivo arq;
            while (rset.next()) {
                arq = new Arquivo();
                arq.setNumero(rset.getInt("numero"));
                arq.setAno(rset.getString("ano"));
                arq.setMes(rset.getString("mes"));
                arq.setCor(rset.getString("cor"));
                arq.setPrestador_nome(rset.getString("prestador_nome"));
                arq.setProcedimento_nome(rset.getString("procedimento_nome"));
                arquivos.add(arq);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar o objeto arquivo. "
                    + "Erro :" + ex.getMessage());
        } finally {
            try {
                pstmt.close();
                bdConnection.desconectar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a operação de listagem do objeto arquivo. "
                        + "Erro :" + ex.getMessage());
            }
        }
        return arquivos;
    }

    @Override
    public List<Arquivo> lista_arquivo_ano_mes(String ano, String mes) {
        List<Arquivo> arquivos = new ArrayList<Arquivo>();
        try {
            pstmt = bdConnection.conectar().prepareStatement(query.consultaArquivoAnoMes);
            pstmt.setString(1, ano);
            pstmt.setString(2, mes);
            rset = pstmt.executeQuery();
            Arquivo arq;
            while (rset.next()) {
                arq = new Arquivo();
                arq.setNumero(rset.getInt("numero"));
                arq.setAno(rset.getString("ano"));
                arq.setMes(rset.getString("mes"));
                arq.setCor(rset.getString("cor"));
                arq.setPrestador_nome(rset.getString("prestador_nome"));
                arq.setProcedimento_nome(rset.getString("procedimento_nome"));
                arquivos.add(arq);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar o objeto arquivo. "
                    + "Erro :" + ex.getMessage());
        } finally {
            try {
                pstmt.close();
                bdConnection.desconectar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a operação de listagem do objeto arquivo. "
                        + "Erro :" + ex.getMessage());
            }
        }
        return arquivos;
    }
}
