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
import java.nio.file.Paths;
import java.nio.file.Files;

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
    
    //exporta apenas se tiver dados
    public static void exportToJSONConsulta(String filePath) throws IOException {
        if(!listaDeConsultaMedica.isEmpty()) {
            DataPersistenceJSON.exportToJSONConsulta(listaDeConsultaMedica, filePath);
        }
    }
    
    //exporta apenas se tiver dados
    public static void exportToJSONPaciente(String filePath) throws IOException {
        if(!listaDePaciente.isEmpty()) {
            DataPersistenceJSON.exportToJSONPaciente(listaDePaciente, filePath);
        }
    }
    
    //exporta apenas se tiver dados
    public static void exportToJSONMedico(String filePath) throws IOException {
        if(!listaDeMedicos.isEmpty()) {
             DataPersistenceJSON.exportToJSONMedico(listaDeMedicos, filePath);
        }
    }
    
    //exporta apenas se tiver dados
    public static void exportToJSONEnfermeiro(String filePath) throws IOException {
        if(!listaDeEnfermeiros.isEmpty()) {
             DataPersistenceJSON.exportToJSONEnfermeiro(listaDeEnfermeiros, filePath);
        }
    }

    //importa apenas para os arquivos que foram exportados com dados
    public static void importFromJSONConsulta(String filePath) throws IOException {
        if(Files.exists(Paths.get(filePath))) {
            listaDeConsultaMedica = (ArrayList<ConsultaMedica>) DataPersistenceJSON.importFromJSONConsulta(filePath);
        }
    }

    //importa apenas para os arquivos que foram exportados com dados    
    public static void importFromJSONMedico(String filePath) throws IOException {
        if(Files.exists(Paths.get(filePath))) {
            listaDeMedicos = (ArrayList<Medico>) DataPersistenceJSON.importFromJSONMedico(filePath);
        }
    }
    
    //importa apenas para os arquivos que foram exportados com dados
    public static void importFromJSONPaciente(String filePath) throws IOException {
        if(Files.exists(Paths.get(filePath))) {
            listaDePaciente = (ArrayList<Paciente>) DataPersistenceJSON.importFromJSONPaciente(filePath);
        }
    }
    
    //importa apenas para os arquivos que foram exportados com dados
    public static void importFromJSONEnfermeiro(String filePath) throws IOException {
        if(Files.exists(Paths.get(filePath))) {
            listaDeEnfermeiros = (ArrayList<Enfermeiro>) DataPersistenceJSON.importFromJSONEnfermeiro(filePath);
        }
    }

    //exporta apenas se tiver dados
    public static void exportToXMLConsulta(String filePath) throws JAXBException {
        if(!listaDeConsultaMedica.isEmpty()) {
             DataPersistenceXML.exportToXMLConsulta(listaDeConsultaMedica, filePath);
        }
    }
    
    //exporta apenas se tiver dados
    public static void exportToXMLPaciente(String filePath) throws JAXBException {
        if(!listaDePaciente.isEmpty()) {
            DataPersistenceXML.exportToXMLPaciente(listaDePaciente, filePath);
        }
    }
    
    //exporta apenas se tiver dados
    public static void exportToXMLMedico(String filePath) throws JAXBException {
        if(!listaDeMedicos.isEmpty()) {
            DataPersistenceXML.exportToXMLMedico(listaDeMedicos, filePath);
        }
    }
    
    //exporta apenas se tiver dados
    public static void exportToXMLEnfermeiro(String filePath) throws JAXBException {
        if(!listaDeEnfermeiros.isEmpty()) {
            DataPersistenceXML.exportToXMLEnfermeiro(listaDeEnfermeiros, filePath);
        }
    }
    
    //importa apenas para os arquivos que foram exportados com dados
    public static void importFromXMLConsulta(String filePath) throws JAXBException {
        if(Files.exists(Paths.get(filePath))) {
            listaDeConsultaMedica = (ArrayList<ConsultaMedica>) DataPersistenceXML.importFromXMLConsulta(filePath);
        }
    }
    
    //importa apenas para os arquivos que foram exportados com dados
    public static void importFromXMLMedico(String filePath) throws JAXBException {
        if(Files.exists(Paths.get(filePath))) {
            listaDeMedicos = (ArrayList<Medico>) DataPersistenceXML.importFromXMLMedico(filePath);
        }
    }
    
    //importa apenas para os arquivos que foram exportados com dados
    public static void importFromXMLEnfermeiro(String filePath) throws JAXBException {
        if(Files.exists(Paths.get(filePath))) {
            listaDeEnfermeiros = (ArrayList<Enfermeiro>) DataPersistenceXML.importFromXMLEnfermeiro(filePath);
        }
    }
    
    //importa apenas para os arquivos que foram exportados com dados
    public static void importFromXMLPaciente(String filePath) throws JAXBException {
        if(Files.exists(Paths.get(filePath))) {
            listaDePaciente = (ArrayList<Paciente>) DataPersistenceXML.importFromXMLPaciente(filePath);
        }
    }
     
     
    
    
}
