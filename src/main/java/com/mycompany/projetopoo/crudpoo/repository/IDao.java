/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo.crudpoo.repository;

/**
 *
 * @author loren
 */

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * Interface IDao
 *
 * @author Luis Guisso &lt;luis dot guisso at ifnmg dot edu dot br&gt;
 * @version 0.1, 2022-10-24
 * @param <T> Data type
 */
public interface IDao<T> {

    // Save
    public String getSaveStatment();

    public String getUpdateStatment();

    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, T e);

    public Long saveOrUpdate(T e);

    // Get by ID
    public String getFindByIdStatment();

    public T findById(Long id);

    // Get all
    public String getFindAllStatment();

    public List<T> findAll();

    // Trash
    public String getMoveToTrashStatement();
    public void moveToTrash(T e);

    public String getRestoreFromTrashStatement();
    public void restoreFromTrash(Long id); // OU T e

    public String getFindAllOnTrashStatement();
    public List<T> findAllOnTrash();

    // Assembly objects
    public T extractObject(ResultSet resultSet);

    public List<T> extractObjects(ResultSet resultSet);

}
