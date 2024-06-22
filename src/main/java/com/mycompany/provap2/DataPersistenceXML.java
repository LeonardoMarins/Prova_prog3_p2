/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.provap2;

import com.mycompany.provap2.backend.ConsultaMedica;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;

/**
 *
 * @author marin
 */
public class DataPersistenceXML {
    
     public static void exportToXML(List<ConsultaMedica> consultas, String filePath) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(ConsultasWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        ConsultasWrapper wrapper = new ConsultasWrapper();
        wrapper.setConsultas(consultas);

        marshaller.marshal(wrapper, new File(filePath));
    }

    public static List<ConsultaMedica> importFromXML(String filePath) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(ConsultasWrapper.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        ConsultasWrapper wrapper = (ConsultasWrapper) unmarshaller.unmarshal(new File(filePath));
        return wrapper.getConsultas();
    }

    // Classe wrapper para contornar limitações do JAXB
    @XmlRootElement
    public static class ConsultasWrapper {
        private List<ConsultaMedica> consultas;

        public List<ConsultaMedica> getConsultas() {
            return consultas;
        }

        public void setConsultas(List<ConsultaMedica> consultas) {
            this.consultas = consultas;
        }
    }
}
