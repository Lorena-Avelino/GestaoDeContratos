/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo.crudpoo.cliente;

/**
 *
 * @author loren
 */

import com.mycompany.projetopoo.crudpoo.repository.Dao;
import com.mycompany.projetopoo.crudpoo.repository.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDao extends Dao<Cliente> {
    private static ClienteDao conexao;
    
    private ClienteDao(){
        
    }
    
    public static ClienteDao conectar(){
        if(conexao==null) return conexao = new ClienteDao();
        else return conexao;
    }
    
    public static final String TABLE = "cliente";

    @Override
    public String getSaveStatment() {
        return "insert into " + TABLE + "(cpf, nome)  values (?, ?)";
    }

    @Override
    public String getUpdateStatment() {
        return "update " + TABLE + " set cpf = ?, nome = ? where id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Cliente e) {
        try {
            pstmt.setLong(1, e.getCpf());
            // OR
            // pstmt.setObject(1, e.getDescription(), java.sql.Types.VARCHAR);

            // Null values
            // NOT! pstmt.setByte(2, e.getProgress());
            pstmt.setString(2, e.getNome());

            // Just for the update
            if (e.getId() != null) {
                pstmt.setLong(3, e.getId());
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getFindByIdStatment() {
        return "select id, cpf, nome"
                + " from cliente where id = ?";
    }

    @Override
    public String getFindAllStatment() {
        return "select id, cpf, nome, excluido"
                + " from cliente"
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
    public Cliente extractObject(ResultSet resultSet) {

        Cliente cliente = null;

        try {
            cliente = new Cliente();
            cliente.setId(resultSet.getLong("id"));
            cliente.setCpf(resultSet.getLong("cpf"));
            cliente.setNome(resultSet.getString("nome"));
            cliente.setExcluded(resultSet.getBoolean("excluido"));
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cliente;
    }

    @Override
    public void moveToTrash(Cliente e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void restoreFromTrash(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Cliente> findAllOnTrash() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
