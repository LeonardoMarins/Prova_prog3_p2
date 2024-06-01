/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.provap2.backend;


/**
 *
 * @author marin
 */
public class AtendenteHospitalar extends DadoPessoal {

    protected String setor;
    protected int chSemanal;
    
    public AtendenteHospitalar(String setor, int chSemanal, DadoPessoal pessoal) {
        super(pessoal.nomePessoal,pessoal.dataNascimento,pessoal.endereco,pessoal.contato,pessoal.genero);
        this.setor = setor;
        this.chSemanal = chSemanal;
        
    }
    
     /**
     * @return the setor
     */
    public String getSetor() {
        return setor;
    }

    /**
     * @param setor the setor to set
     */
    public void setSetor(String setor) {
        this.setor = setor;
    }

    /**
     * @return the chSemanal
     */
    public int getChSemanal() {
        return chSemanal;
    }

       /**
     * @param chSemanal the chSemanal to set
     */
    public void setChSemanal(int chSemanal) {
        this.chSemanal = chSemanal;
    }
}
