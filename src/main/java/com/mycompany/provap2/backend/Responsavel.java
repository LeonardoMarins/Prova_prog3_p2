/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.provap2.backend;

import com.mycompany.provap2.backend.Paciente;



/**
 *
 * @author marin
 */
public class Responsavel extends ContatoTelEmail {

   protected static Long idResponsavel = 0l;
   protected String nomeResponsavel;
    private ContatoTelEmail contato;
    protected Paciente paciente;

    public Responsavel(String nomeResponsavel, ContatoTelEmail contato, Paciente paciente) {
        super(contato.telefone, contato.celular, contato.email);
        this.contato = contato;
        this.nomeResponsavel = nomeResponsavel;
        this.paciente = paciente;
        Responsavel.idResponsavel++;
        
        if (nomeResponsavel == null || nomeResponsavel.isEmpty()) {
            throw new IllegalArgumentException("O nome do paciente não pode estar vazio");
        }
    }
    
    public Long getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(Long idResponsavel) {
        Responsavel.idResponsavel = idResponsavel;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    /**
     * @return the paciente
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * @param paciente the paciente to set
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
