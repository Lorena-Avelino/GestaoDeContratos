/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo.crudpoo.cliente;

import com.mycompany.projetopoo.crudpoo.contrato.Contrato;
import com.mycompany.projetopoo.crudpoo.entity.Entity;
import java.util.ArrayList;

/**
 *
 * @author loren
 */
public class Cliente extends Entity {
    private Long cpf;
    private String nome;
    private ArrayList<Contrato> contratos; //Relacionamento 1:N

    public Cliente() {
        contratos = new ArrayList<>();
    }

    public Cliente(Long id, Long cpf, String nome) {
        setId(id);
        //this.id = id;
        setCpf(cpf);
        //this.cpf = cpf;
        setNome(nome);
        //this.nome = nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.length() > 45) {
            throw new IllegalArgumentException("O nome deve ter no máximo 45 caracteres");
        } else{
            this.nome = nome;
        }
    }

    public ArrayList<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(ArrayList<Contrato> contratos) {
        this.contratos = contratos;
    }
    
    public void addContrato(Contrato contrato) {
        contratos.add(contrato);
        contrato.setCliente(this);
    }

    public void removeContrato(Contrato contrato) {
        contratos.remove(contrato);
    }

    @Override
    public String toString() {
        return "Cliente{" 
                + "id=" + getId() 
                + ", cpf=" + cpf 
                + ", nome=" + nome 
                + ", contratos=\n" + contratos.toString()
                + '}';
    }

    public void setId(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
