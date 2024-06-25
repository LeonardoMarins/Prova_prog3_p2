/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.provap2.Persistencia;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.provap2.backend.ConsultaMedica;
import com.mycompany.provap2.backend.Enfermeiro;
import com.mycompany.provap2.backend.Medico;
import com.mycompany.provap2.backend.Paciente;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author marin
 */
public class DataPersistenceJSON {
    
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void exportToJSONConsulta(List<ConsultaMedica> consultas, String filePath) throws IOException {
        objectMapper.writeValue(new File(filePath), consultas);
    }
    
    public static void exportToJSONPaciente(List<Paciente> pacientes, String filePath) throws IOException {
        objectMapper.writeValue(new File(filePath), pacientes);
    }
    
    public static void exportToJSONMedico(List<Medico> medicos, String filePath) throws IOException {
        objectMapper.writeValue(new File(filePath), medicos);
    }
    
    public static void exportToJSONEnfermeiro(List<Enfermeiro> enfermeiros, String filePath) throws IOException {
        objectMapper.writeValue(new File(filePath), enfermeiros);
    }

    public static List<ConsultaMedica> importFromJSONConsulta(String filePath) throws IOException {
        return objectMapper.readValue(new File(filePath),
                objectMapper.getTypeFactory().constructCollectionType(List.class, ConsultaMedica.class));
    }
    
    public static List<Medico> importFromJSONMedico(String filePath) throws IOException {
        return objectMapper.readValue(new File(filePath),
                objectMapper.getTypeFactory().constructCollectionType(List.class, Medico.class));
    }
    
    public static List<Paciente> importFromJSONPaciente(String filePath) throws IOException {
        return objectMapper.readValue(new File(filePath),
                objectMapper.getTypeFactory().constructCollectionType(List.class, Paciente.class));
    }
    
    public static List<Enfermeiro> importFromJSONEnfermeiro(String filePath) throws IOException {
        return objectMapper.readValue(new File(filePath),
                objectMapper.getTypeFactory().constructCollectionType(List.class, Enfermeiro.class));
    }
}
