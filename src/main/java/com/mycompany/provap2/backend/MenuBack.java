/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.provap2.backend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author marin
 */
public class MenuBack {
    
    public static ArrayList<Endereco> listaEndereco = new ArrayList<>();
    public static ArrayList<ContatoTelEmail> contatoList = new ArrayList<>();
    public static ArrayList<Responsavel> responsavelList = new ArrayList<>();
    public static ArrayList<Paciente> listaDePaciente = new ArrayList<>();
    public static ArrayList<Medico> listaDeMedicos = new ArrayList<>();
    public static ArrayList<Enfermeiro> listaDeEnfermeiros = new ArrayList<>();
    public static ArrayList<ConsultaMedica> listaDeConsultaMedica = new ArrayList<>();
    
     
    public static void adicionarEndereco(Endereco endereco) {
    listaEndereco.add(endereco);
    }
    
    public static void adicionarContato(ContatoTelEmail contato) {
    contatoList.add(contato);
    }
    
    public static void adicionarResponsavel(Responsavel responsavel) {
    responsavelList.add(responsavel);
    }
    
    public static void adicionarPaciente(Paciente paciente) {
    listaDePaciente.add(paciente);
    }
    
    public static void adicionarMedico(Medico medico) {
    listaDeMedicos.add(medico);
    }
    
    public static void adicionarEnfermeiro(Enfermeiro enfermeiro) {
    listaDeEnfermeiros.add(enfermeiro);
    }
    
    public static void adicionarConsultaMedica(ConsultaMedica consulta) {
    listaDeConsultaMedica.add(consulta);
    }
    
     public static void atualizarPaciente(Paciente pacienteAtualizado, UUID idPaciente) {
        // Encontra o paciente com base no UUID fornecido e atualiza seus dados
        for (int i = 0; i < listaDePaciente.size(); i++) {
            Paciente paciente = listaDePaciente.get(i);
            if (paciente.getIdPaciente().equals(idPaciente)) {
                listaDePaciente.set(i, pacienteAtualizado);
                break;
            }
        }
    }
    
    public static void atualizarMedico(Medico medicoParaAtualizar, UUID idMedico) {
        // Encontra o paciente com base no UUID fornecido e atualiza seus dados
        for (int i = 0; i < listaDeMedicos.size(); i++) {
            Medico medico = listaDeMedicos.get(i);
            if (medico.getIdMedico().equals(idMedico)) {
                listaDeMedicos.set(i, medicoParaAtualizar);
                break;
            }
        }
    
    }
    
    public static void atualizarEnfermeiro(Enfermeiro enfermeiroParaAtualizar,  UUID idEnfermeiro) {
        // Encontra o paciente com base no UUID fornecido e atualiza seus dados
        for (int i = 0; i < listaDeEnfermeiros.size(); i++) {
            Enfermeiro enfermeiro = listaDeEnfermeiros.get(i);
            if (enfermeiro.getIdEnfermeiro().equals(idEnfermeiro)) {
                listaDeEnfermeiros.set(i, enfermeiroParaAtualizar);
                break;
            } 
        }
    
    }
    
    public static void atualizarConsulta(ConsultaMedica consultaParaAtualizar, UUID idConsulta) {
        // Encontra o paciente com base no UUID fornecido e atualiza seus dados
        for (int i = 0; i < listaDeConsultaMedica.size(); i++) {
            ConsultaMedica consulta = listaDeConsultaMedica.get(i);
            if (consulta.getIdConsulta().equals(idConsulta)) {
                listaDeConsultaMedica.set(i, consultaParaAtualizar);
                break;
            }
        }
    
    }
    
    public static void excluirPaciente(UUID idPaciente) {
        // Encontra o paciente com base no UUID fornecido e o remove da lista
        Paciente pacienteParaExcluir = null;
        for (Paciente paciente : listaDePaciente) {
            if (paciente.getIdPaciente().equals(idPaciente)) {
                pacienteParaExcluir = paciente;
                break;
            }
        }
        if (pacienteParaExcluir != null) {
            listaDePaciente.remove(pacienteParaExcluir);
        }
    }
    
    public static void excluirMedico(UUID idMedico) {
    // Encontra o paciente com base no UUID fornecido e o remove da lista
        Medico medicoParaExcluir = null;
        for (Medico medico : listaDeMedicos) {
            if (medico.getIdMedico().equals(idMedico)) {
                medicoParaExcluir = medico;
                break;
            }
        }
        if (medicoParaExcluir != null) {
            listaDeMedicos.remove(medicoParaExcluir);
        }
    
    }
    
    public static void excluirEnfermeiro(UUID idEnfermeiro) {
        // Encontra o paciente com base no UUID fornecido e o remove da lista
        Enfermeiro enfermeiroParaExcluir = null;
        for (Enfermeiro enfermeiro : listaDeEnfermeiros) {
            if (enfermeiro.getIdEnfermeiro().equals(idEnfermeiro)) {
                enfermeiroParaExcluir = enfermeiro;
                break;
            }
        }
        if (enfermeiroParaExcluir != null) {
            listaDeEnfermeiros.remove(enfermeiroParaExcluir);
        }
    
    }
    
    public static void excluirConsulta(UUID idConsulta) {
       // Encontra o paciente com base no UUID fornecido e o remove da lista
        ConsultaMedica ConsultaParaExcluir = null;
        for (ConsultaMedica consulta : listaDeConsultaMedica) {
            if (consulta.getIdConsulta().equals(idConsulta)) {
                ConsultaParaExcluir = consulta;
                break;
            }
        }
        if (ConsultaParaExcluir != null) {
            listaDeConsultaMedica.remove(ConsultaParaExcluir);
        } 
    
    }
    
    public ArrayList<Endereco> getLista() {
        return this.listaEndereco;
    }
    
    public ArrayList<Paciente> getListaPaciente() {
        return this.listaDePaciente;
    }
    
    public ArrayList<Medico> getListaMedicos() {
        return this.listaDeMedicos;
    }
    
    public ArrayList<Enfermeiro> getListaEnfermeiro() {
        return this.listaDeEnfermeiros;
    }
    
    public ArrayList<ConsultaMedica> getListaConsultaMedicas() {
        return this.listaDeConsultaMedica;
    }
    
    public ArrayList<ContatoTelEmail> getListaContato() {
        return this.contatoList;
    }
    
    public ArrayList<Responsavel> getListaResponsavel() {
        return this.responsavelList;
    }
    
}
