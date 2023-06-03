/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo.crudpoo.repository;

/**
 *
 * @author loren
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class DbConnection
 *
 * @author Luis Guisso &lt;luis dot guisso at ifnmg dot edu dot br&gt;
 * @version 0.1, 2022-10-24
 */
public class DbConnection {

    // Retains the established connection to the database during system operation
    private static Connection connection;

    /**
     * URL database connection
     * (protocol/sgbd/ip/port/database/parameters)
     */
    public static final String URL;

    // Database user
    private static final String USER;

    // Database password
    private static final String PASSWORD;

    // Static initialization
    static {
        // Local server
        URL = "jdbc:mysql://localhost:3306/" + Dao.DB
                + "?useUnicode=true"
                + "&useJDBCCompliantTimezoneShift=true"
                + "&serverTimezone=UTC"
                + "&autoReconnect=true";
        USER = "root";
        PASSWORD = "root";
    }

    //<editor-fold defaultstate="collapsed" desc="Construtor privado">
    /*
     * Private constructor to force access to the connection by the 
     * static member getConnection() without requiring the generation of 
     * new objects ConexaoBd ConexaoBd
     */
    private DbConnection() {
    }
    //</editor-fold>

    /**
     * Establishes and generates database connection retention
     *
     * @return Dabatase connection
     */
    public static Connection getConnection() {

        // If there is no connection established...
        if (connection == null) {
            // ... try ...
            try {
                System.out.println(">> New database connection");
                // ... establish and retain the connection 
                //     from the provided URL, username and password
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException ex) {
                // TODO Rever procedimento e encerrar o programa em caso de falha
                // Log failure
                Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
                // System.exit(-1);
            }
        }

        // Returns the established connection
        return connection;
    }
}
