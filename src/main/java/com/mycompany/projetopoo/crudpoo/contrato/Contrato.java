/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo.crudpoo.contrato;

import com.mycompany.projetopoo.crudpoo.cliente.Cliente;
import com.mycompany.projetopoo.crudpoo.entity.Entity;
import java.time.LocalDate;

/**
 *
 * @author loren
 */
public class Contrato extends Entity {
    private String redacao;
    private LocalDate ultimaAtualizacao;
    private Cliente cliente; //Relacionamento N:1

    public Contrato() {
    }

    public Contrato(long id, String redacao, LocalDate ultimaAtualizacao) {
        setId(id);
        this.redacao = redacao;
        this.ultimaAtualizacao = ultimaAtualizacao;
        //this.cliente = cliente;
    }

    public String getRedacao() {
        return redacao;
    }

    public void setRedacao(String redacao) {
        if (redacao.length() > 100000) {
            throw new IllegalArgumentException("O nome deve ter no máximo 100000 caracteres");
        } else{
            this.redacao = redacao;
        }
    }

    public LocalDate getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(LocalDate ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Contrato{" 
                + "redacao=" + redacao 
                + ", ultimaAtualizacao=" + ultimaAtualizacao 
                + "}\n";
    }
    
    
}
