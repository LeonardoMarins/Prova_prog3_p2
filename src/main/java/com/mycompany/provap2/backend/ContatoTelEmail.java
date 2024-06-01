/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.provap2.backend;

/**
 *
 * @author marin
 */
public class ContatoTelEmail {
    
    protected Long telefone;
    protected Long celular;
    protected String email;
    
    public ContatoTelEmail(Long telefone, Long celular, String email) {
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
        
        if (celular == 0 || telefone == 0) {
            throw new IllegalArgumentException("O celular e o telefone não pode ser nulo");
        }
    }
    
    public Long getTelefone() {
        return this.telefone;
    }
    
    public Long getCelular() {
        return this.celular;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
