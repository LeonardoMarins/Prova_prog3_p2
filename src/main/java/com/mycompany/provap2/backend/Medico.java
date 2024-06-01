/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.provap2.backend;

import com.mycompany.provap2.backend.DadoPessoal;
import com.mycompany.provap2.backend.AtendenteHospitalar;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author marin
 */
public class Medico extends AtendenteHospitalar {

   private UUID idMedico;
   protected int numeroCRM;
   protected String areasEspecialidade;
   protected boolean cirurgiao;
   protected AtendenteHospitalar atendente;
   
   public Medico(DadoPessoal pessoal, int numeroCRM, 
           String areaEspciealidade, boolean cirurgiao, AtendenteHospitalar atendente) {
       super(atendente.setor, atendente.chSemanal, pessoal);
       this.nomePessoal = pessoal.nomePessoal;
       this.dataNascimento = pessoal.dataNascimento;
       this.endereco = pessoal.endereco;
       this.contato = pessoal.contato;
       this.genero = pessoal.genero;
       this.numeroCRM = numeroCRM;
       this.areasEspecialidade = areaEspciealidade;
       this.cirurgiao = cirurgiao;
        this.idMedico = UUID.randomUUID();
   }
   
   /**
     * @return the idMedico
     */
    public UUID getIdMedico() {
        return idMedico;
    }

    /**
     * @return the numeroCRM
     */
    public int getNumeroCRM() {
        return numeroCRM;
    }

    /**
     * @param numeroCRM the numeroCRM to set
     */
    public void setNumeroCRM(int numeroCRM) {
        this.numeroCRM = numeroCRM;
    }

    /**
     * @return the areasEspecialidade
     */
    public String getAreasEspecialidade() {
        return areasEspecialidade;
    }

    /**
     * @param areasEspecialidade the areasEspecialidade to set
     */
    public void setAreasEspecialidade(String areasEspecialidade) {
        this.areasEspecialidade = areasEspecialidade;
    }

    /**
     * @return the cirurgiao
     */
    public boolean isCirurgiao() {
        return cirurgiao;
    }

    /**
     * @param cirurgiao the cirurgiao to set
     */
    public void setCirurgiao(boolean cirurgiao) {
        this.cirurgiao = cirurgiao;
    }

    /**
     * @return the atendente
     */
    public AtendenteHospitalar getAtendente() {
        return atendente;
    }

    /**
     * @param atendente the atendente to set
     */
    public void setAtendente(AtendenteHospitalar atendente) {
        this.atendente = atendente;
    }
    
    public void setContatoTelEmail(ContatoTelEmail contato) {
        this.contato = contato;
    }
   
   
}
