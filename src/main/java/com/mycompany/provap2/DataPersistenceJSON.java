/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.provap2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.provap2.backend.ConsultaMedica;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author marin
 */
public class DataPersistenceJSON {
    
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void exportToJSON(List<ConsultaMedica> consultas, String filePath) throws IOException {
        objectMapper.writeValue(new File(filePath), consultas);
    }

    public static List<ConsultaMedica> importFromJSON(String filePath) throws IOException {
        return objectMapper.readValue(new File(filePath),
                objectMapper.getTypeFactory().constructCollectionType(List.class, ConsultaMedica.class));
    }
}
