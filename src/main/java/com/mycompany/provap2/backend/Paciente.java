/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.provap2.backend;

import com.mycompany.provap2.backend.DadoPessoal;
import com.mycompany.provap2.backend.ConsultaMedica;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author marin
 */
public class Paciente extends DadoPessoal {
    private UUID idPaciente;
    private int idade;
    private String dataCadastro; 
    private String obsGeral = "";
    private List<Responsavel> contatoResponsavel = new ArrayList<>();
    private List<ConsultaMedica> historicoConsultaMedica = new ArrayList();
    
    
    public Paciente(DadoPessoal pessoal, int idade, String dataCadastro, String obsGeral, Responsavel responsavel) {
        super(pessoal.nomePessoal,pessoal.dataNascimento,pessoal.endereco,pessoal.contato,pessoal.genero);
        this.idade = idade;
        this.dataCadastro = dataCadastro;
        this.obsGeral = obsGeral;
        this.contatoResponsavel.add(responsavel);
        this.idPaciente = UUID.randomUUID();
    }

    /**
     * @return the idPaciente
     */
    public UUID getIdPaciente() {
         return idPaciente;
    }

    /**
     * @param idPaciente the idPaciente to set
     */
    public void setIdPaciente(UUID idPacientes) {
        idPaciente = idPacientes;
    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * @return the dataCadastro
     */
    public String getDataCadastro() {
        return dataCadastro;
    }

    /**
     * @param dataCadastro the dataCadastro to set
     */
    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    /**
     * @return the obsGeral
     */
    public String getObsGeral() {
        return obsGeral;
    }

    /**
     * @param obsGeral the obsGeral to set
     */
    public void setObsGeral(String obsGeral) {
        this.obsGeral = obsGeral;
    }
    
    public void setContatoTelEmail(ContatoTelEmail contato) {
        this.contato = contato;
    }
    
}
