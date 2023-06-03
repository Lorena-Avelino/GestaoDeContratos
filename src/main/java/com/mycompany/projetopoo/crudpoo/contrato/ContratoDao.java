/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo.crudpoo.contrato;

/**
 *
 * @author loren
 */

import com.mycompany.projetopoo.crudpoo.repository.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContratoDao extends Dao<Contrato> {
    private static ContratoDao conexao;
    
    private ContratoDao(){
        
    }
    
    public static ContratoDao conectar(){
        if(conexao==null) return conexao = new ContratoDao();
        else return conexao;
    }
    
    public static final String TABLE = "contrato";

    @Override
    public String getSaveStatment() {
        return "insert into " + TABLE + "(redacao, ultimaAtualizacao, id_cliente)  values (?, ?, ?)";
    }

    @Override
    public String getUpdateStatment() {
        return "update " + TABLE + " set redacao = ?, ultimaAtualizacao = ?, id_cliente = ? where id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Contrato e) {
        try {
            pstmt.setString(1, e.getRedacao());
            // OR
            // pstmt.setObject(1, e.getDescription(), java.sql.Types.VARCHAR);

            // Null values
            // NOT! pstmt.setByte(2, e.getProgress());
            
            // LocalDate
            pstmt.setObject(2, e.getUltimaAtualizacao(), java.sql.Types.DATE);
            pstmt.setLong(3, e.getCliente().getId());

            // Just for the update
            if (e.getId() != null) {
                pstmt.setLong(3, e.getId());
            }

        } catch (SQLException ex) {
            Logger.getLogger(ContratoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getFindByIdStatment() {
        return "select id, redacao, ultimaAtualizacao, id_cliente"
                + " from contrato where id = ?";
    }

    @Override
    public String getFindAllStatment() {
        return "select id, redacao, ultimaAtualizacao, id_cliente, excluido"
                + " from contrato"
                + " where exlcuido = false";
    }

    @Override
    public String getMoveToTrashStatement() {
        return "update " + TABLE + " set excluido = true"
                + " where id = ?";
    }

    @Override
    public String getRestoreFromTrashStatement() {
        return "update " + TABLE + " set excluido = false"
                + " where id = ?";
    }

    @Override
    public String getFindAllOnTrashStatement() {
        return "select * from " + TABLE + " where excluido = true";
    }

    @Override
    public Contrato extractObject(ResultSet resultSet) {

        Contrato contrato = null;

        try {
            contrato = new Contrato();
            contrato.setId(resultSet.getLong("id"));
            contrato.setRedacao(resultSet.getString("redacao"));
            contrato.setUltimaAtualizacao(resultSet.getObject("ultimaAtualizacao", LocalDate.class));
            contrato.setExcluded(resultSet.getBoolean("excluido"));
        } catch (SQLException ex) {
            Logger.getLogger(ContratoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return contrato;
    }

    @Override
    public void moveToTrash(Contrato e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void restoreFromTrash(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Contrato> findAllOnTrash() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}