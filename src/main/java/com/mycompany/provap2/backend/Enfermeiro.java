/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.provap2.backend;

import com.mycompany.provap2.backend.DadoPessoal;
import com.mycompany.provap2.backend.AtendenteHospitalar;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.UUID;

/**
 *
 * @author marin
 */
@XmlRootElement
public class Enfermeiro extends AtendenteHospitalar {
    protected UUID idEnfermeiro;
    protected boolean treinadoOpRX;
    protected AtendenteHospitalar atendete;
    
    public Enfermeiro(boolean treinadoOpRX, AtendenteHospitalar atendente, DadoPessoal pessoal) {
        super(atendente.setor, atendente.chSemanal, pessoal);
        this.treinadoOpRX = treinadoOpRX;
        this.nomePessoal = pessoal.nomePessoal;
        this.dataNascimento = pessoal.dataNascimento;
        this.endereco = pessoal.endereco;
        this.contato = pessoal.contato;
        this.genero = pessoal.genero;
        this.idEnfermeiro = UUID.randomUUID();
    }
    
    public Enfermeiro() {
        
    }
    
     /**
     * @return the idEnfermeiro
     */
    @XmlElement
    public UUID getIdEnfermeiro() {
        return idEnfermeiro;
    }

    /**
     * @param idEnfermeiro the idEnfermeiro to set
     */
    public void setIdEnfermeiro(UUID idEnfermeiro) {
        this.idEnfermeiro = idEnfermeiro;
    }

    /**
     * @return the treinadoOpRX
     */
    @XmlElement
    public boolean isTreinadoOpRX() {
        return treinadoOpRX;
    }

    /**
     * @param treinadoOpRX the treinadoOpRX to set
     */
    public void setTreinadoOpRX(boolean treinadoOpRX) {
        this.treinadoOpRX = treinadoOpRX;
    }

    /**
     * @return the atendete
     */
    @XmlElement
    public AtendenteHospitalar getAtendete() {
        return atendete;
    }

    /**
     * @param atendete the atendete to set
     */
       
    public void setAtendete(AtendenteHospitalar atendete) {
        this.atendete = atendete;
    }

    public void setContatoTelEmail(ContatoTelEmail contato) {
        this.contato = contato; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
     public void setTelefone(Long telefone) {
        this.contato.setTelefone(telefone);
    }
    
    public void setCelular(Long celular) {
        this.contato.setCelular(celular);
    }
    
    public void setEmail(String email) {
        this.contato.setEmail(email);
    }
}
