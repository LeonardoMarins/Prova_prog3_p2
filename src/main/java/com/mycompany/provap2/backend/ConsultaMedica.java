/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.provap2.backend;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.UUID;

/**
 *
 * @author marin
 */
@XmlRootElement
public class ConsultaMedica {
    protected UUID idConsulta;
    protected UUID idPaciente; 
    protected UUID idMedico;
    protected String exameQueixa;
    protected String diagnostico;
    protected String prescricao;
    protected boolean indicacaoCirurgica;
    
    public ConsultaMedica(Paciente paciente, Medico medico, String exame,
            String diagnostico, String prescricao, boolean indicacaoCirurgica) {
        this.idPaciente = paciente.getIdPaciente();
        this.idMedico = medico.getIdMedico();
        this.exameQueixa = exame;
        this.diagnostico = diagnostico;
        this.prescricao = prescricao;
        this.indicacaoCirurgica = indicacaoCirurgica;
        this.idConsulta = UUID.randomUUID();
        
        if (exame == null || exame.isEmpty()) {
            throw new IllegalArgumentException("A queixa do paciente não pode ficar vazia");
        }
    }
    
    public ConsultaMedica() {
        // Construtor no-arg default
    }
    /**
     * @return the idConsulta
     */
    @XmlElement
    public UUID getIdConsulta() {
        return idConsulta;
    }

    /**
     * @param aIdConsulta the idConsulta to set
     */
    public void setIdConsulta(UUID aIdConsulta) {
        idConsulta = aIdConsulta;
    }

    /**
     * @return the idPaciente
     */
    @XmlElement
    public UUID getIdPaciente() {
        return idPaciente;
    }

    /**
     * @param idPaciente the idPaciente to set
     */
    public void setIdPaciente(UUID idPaciente) {
        this.idPaciente = idPaciente;
    }

    /**
     * @return the idMedico
     */
    @XmlElement
    public UUID getIdMedico() {
        return idMedico;
    }

    /**
     * @param idMedico the idMedico to set
     */
    public void setIdMedico(UUID idMedico) {
        this.idMedico = idMedico;
    }

    /**
     * @return the exameQueixa
     */
    @XmlElement
    public String getExameQueixa() {
        return exameQueixa;
    }

    /**
     * @param exameQueixa the exameQueixa to set
     */
    public void setExameQueixa(String exameQueixa) {
        this.exameQueixa = exameQueixa;
    }

    /**
     * @return the diagnostico
     */
    @XmlElement
    public String getDiagnostico() {
        return diagnostico;
    }

    /**
     * @param diagnostico the diagnostico to set
     */
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    /**
     * @return the prescricao
     */
    @XmlElement
    public String getPrescricao() {
        return prescricao;
    }

    /**
     * @param prescricao the prescricao to set
     */
    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }

    /**
     * @return the indicacaoCirurgica
     */
    @XmlElement
    public boolean isIndicacaoCirurgica() {
        return indicacaoCirurgica;
    }

    /**
     * @param indicacaoCirurgica the indicacaoCirurgica to set
     */
    public void setIndicacaoCirurgica(boolean indicacaoCirurgica) {
        this.indicacaoCirurgica = indicacaoCirurgica;
    }
}
