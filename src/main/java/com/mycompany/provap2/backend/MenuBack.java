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
    
    public static void exportToJSONConsulta(String filePath) throws IOException {
        DataPersistenceJSON.exportToJSONConsulta(listaDeConsultaMedica, filePath);
    }
    
    public static void exportToJSONPaciente(String filePath) throws IOException {
        DataPersistenceJSON.exportToJSONPaciente(listaDePaciente, filePath);
    }
    
    public static void exportToJSONMedico(String filePath) throws IOException {
        DataPersistenceJSON.exportToJSONMedico(listaDeMedicos, filePath);
    }
    
    public static void exportToJSONEnfermeiro(String filePath) throws IOException {
        DataPersistenceJSON.exportToJSONEnfermeiro(listaDeEnfermeiros, filePath);
    }

    public static void importFromJSONConsulta(String filePath) throws IOException {
        listaDeConsultaMedica = (ArrayList<ConsultaMedica>) DataPersistenceJSON.importFromJSONConsulta(filePath);
    }
    
    public static void importFromJSONMedico(String filePath) throws IOException {
        listaDeMedicos = (ArrayList<Medico>) DataPersistenceJSON.importFromJSONMedico(filePath);
    }
    
    public static void importFromJSONPaciente(String filePath) throws IOException {
        listaDePaciente = (ArrayList<Paciente>) DataPersistenceJSON.importFromJSONPaciente(filePath);
    }
    
    public static void importFromJSONEnfermeiro(String filePath) throws IOException {
        listaDeEnfermeiros = (ArrayList<Enfermeiro>) DataPersistenceJSON.importFromJSONEnfermeiro(filePath);
    }

    public static void exportToXMLConsulta(String filePath) throws JAXBException {
        DataPersistenceXML.exportToXMLConsulta(listaDeConsultaMedica, filePath);
    }
    
    public static void exportToXMLPaciente(String filePath) throws JAXBException {
        DataPersistenceXML.exportToXMLPaciente(listaDePaciente, filePath);
    }
    
    public static void exportToXMLMedico(String filePath) throws JAXBException {
        DataPersistenceXML.exportToXMLMedico(listaDeMedicos, filePath);
    }
    
    public static void exportToXMLEnfermeiro(String filePath) throws JAXBException {
        DataPersistenceXML.exportToXMLEnfermeiro(listaDeEnfermeiros, filePath);
    }
    
    public static void importFromXMLConsulta(String filePath) throws JAXBException {
        listaDeConsultaMedica = (ArrayList<ConsultaMedica>) DataPersistenceXML.importFromXMLConsulta(filePath);
    }
    
    public static void importFromXMLMedico(String filePath) throws JAXBException {
        listaDeMedicos = (ArrayList<Medico>) DataPersistenceXML.importFromXMLMedico(filePath);
    }
    
    public static void importFromXMLEnfermeiro(String filePath) throws JAXBException {
        listaDeEnfermeiros = (ArrayList<Enfermeiro>) DataPersistenceXML.importFromXMLEnfermeiro(filePath);
    }
    
    public static void importFromXMLPaciente(String filePath) throws JAXBException {
        listaDePaciente = (ArrayList<Paciente>) DataPersistenceXML.importFromXMLPaciente(filePath);
    }
     
     
    
    
}
