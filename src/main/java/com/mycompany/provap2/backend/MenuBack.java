/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.provap2.backend;

import com.mycompany.provap2.DataPersistenceJSON;
import com.mycompany.provap2.DataPersistenceXML;
import jakarta.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;

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
    
     public static void exportarParaJSON(String filePath) throws IOException {
        DataPersistenceJSON.exportToJSON(listaDeConsultaMedica, filePath);
    }

    public static void importarDeJSON(String filePath) throws IOException {
        listaDeConsultaMedica = (ArrayList<ConsultaMedica>) DataPersistenceJSON.importFromJSON(filePath);
    }

    public static void exportarParaXML(String filePath) throws JAXBException {
        DataPersistenceXML.exportToXML(listaDeConsultaMedica, filePath);
    }

    public static void importarDeXML(String filePath) throws JAXBException {
        listaDeConsultaMedica = (ArrayList<ConsultaMedica>) DataPersistenceXML.importFromXML(filePath);
    }
    
    
}
