/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.projetopoo.crudpoo;

import java.util.ArrayList;
import com.mycompany.projetopoo.crudpoo.cliente.Cliente;
import com.mycompany.projetopoo.crudpoo.cliente.ClienteDao;
import com.mycompany.projetopoo.crudpoo.contrato.Contrato;
import com.mycompany.projetopoo.crudpoo.contrato.ContratoDao;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author loren
 */
public class Crudpoo {

    public static void main(String[] args) {
        // Criando um objeto Cliente Ana Zaira
        Cliente cliente1 = new Cliente();
        cliente1.setCpf(11929826303L);
        try
        {
            cliente1.setNome("Ana Zaira");
        } catch (Exception ex)
        {
            Logger.getLogger(Crudpoo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Criando contratos da cliente Ana Zaira
        Contrato contrato1 = new Contrato();
        
        contrato1.setRedacao("Contrato por tempo determinado");
        contrato1.setUltimaAtualizacao(LocalDate.parse("21/05/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        
        Contrato contrato2 = new Contrato();
        
        contrato2.setRedacao("Contrato por tempo determinado");
        contrato2.setUltimaAtualizacao(LocalDate.parse("01/05/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        
        Contrato contrato3 = new Contrato();
        
        contrato3.setRedacao("Contrato de trabalho eventual");
        contrato3.setUltimaAtualizacao(LocalDate.parse("26/05/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

       // Criando um objeto Cliente Beatriz Yana
        Cliente cliente2 = new Cliente();
        cliente2.setCpf(26752965030L);
        try
        {
            cliente2.setNome("Beatriz Yana");
        } catch (Exception ex)
        {
            Logger.getLogger(Crudpoo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Criando contratos da cliente Beatriz Yana
        Contrato contrato4 = new Contrato();
        
        contrato4.setRedacao("Contrato de estágio");
        contrato4.setUltimaAtualizacao(LocalDate.parse("15/10/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
     
        Contrato contrato5 = new Contrato();
        
        contrato5.setRedacao("Contrato de experiência");
        contrato5.setUltimaAtualizacao(LocalDate.parse("16/09/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        
        Contrato contrato6 = new Contrato();
        
        contrato6.setRedacao("Contrato de teletrabalho");
        contrato6.setUltimaAtualizacao(LocalDate.parse("17/08/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        
        Contrato contrato7 = new Contrato();
        
        contrato7.setRedacao("Contrato intermitente");
        contrato7.setUltimaAtualizacao(LocalDate.parse("15/07/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        
        
        Long idCliente1 = ClienteDao.conectar().saveOrUpdate(cliente1);
        Long idCliente2 = ClienteDao.conectar().saveOrUpdate(cliente2);
        
        cliente1.setId(idCliente1);
        cliente2.setId(idCliente2);
        
        
        cliente1.addContrato(contrato1);
        cliente1.addContrato(contrato2);
        cliente1.addContrato(contrato3);
        
        cliente2.addContrato(contrato4);
        cliente2.addContrato(contrato5);
        cliente2.addContrato(contrato6);
        cliente2.addContrato(contrato7);
        
        System.out.println(cliente1);
        System.out.println("\n");
        System.out.println(cliente2);
        
        
        
        ContratoDao.conectar().saveOrUpdate(contrato1);
        ContratoDao.conectar().saveOrUpdate(contrato2);
        ContratoDao.conectar().saveOrUpdate(contrato3);
        ContratoDao.conectar().saveOrUpdate(contrato4);
        ContratoDao.conectar().saveOrUpdate(contrato5);
        ContratoDao.conectar().saveOrUpdate(contrato6);
        ContratoDao.conectar().saveOrUpdate(contrato7);
        
        
    }
}
