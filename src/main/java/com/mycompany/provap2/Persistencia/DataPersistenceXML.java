/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.provap2.Persistencia;

import com.mycompany.provap2.backend.ConsultaMedica;
import com.mycompany.provap2.backend.Enfermeiro;
import com.mycompany.provap2.backend.Medico;
import com.mycompany.provap2.backend.Paciente;
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
    
     public static void exportToXMLConsulta(List<ConsultaMedica> consultas, String filePath) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(ConsultasWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        ConsultasWrapper wrapper = new ConsultasWrapper();
        wrapper.setConsultas(consultas);

        marshaller.marshal(wrapper, new File(filePath));
    }
     
     public static void exportToXMLPaciente(List<Paciente> pacientes, String filePath) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(PacientesWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        PacientesWrapper wrapper = new PacientesWrapper();
        wrapper.setPacientes(pacientes);

        marshaller.marshal(wrapper, new File(filePath));
    }
     
     public static void exportToXMLMedico(List<Medico> medicos, String filePath) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(MedicosWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        MedicosWrapper wrapper = new MedicosWrapper();
        wrapper.setMedicos(medicos);

        marshaller.marshal(wrapper, new File(filePath));
    }
     
     public static void exportToXMLEnfermeiro(List<Enfermeiro> enfermeiros, String filePath) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(EnfermeirosWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        EnfermeirosWrapper wrapper = new EnfermeirosWrapper();
        wrapper.setEnfermeiros(enfermeiros);

        marshaller.marshal(wrapper, new File(filePath));
    }

    public static List<ConsultaMedica> importFromXMLConsulta(String filePath) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(ConsultasWrapper.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        ConsultasWrapper wrapper = (ConsultasWrapper) unmarshaller.unmarshal(new File(filePath));
        return wrapper.getConsultas();
    }
    
    public static List<Paciente> importFromXMLPaciente(String filePath) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(PacientesWrapper.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        PacientesWrapper wrapper = (PacientesWrapper) unmarshaller.unmarshal(new File(filePath));
        return wrapper.getPacientes();
    }

    public static List<Medico> importFromXMLMedico(String filePath) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(MedicosWrapper.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        MedicosWrapper wrapper = (MedicosWrapper) unmarshaller.unmarshal(new File(filePath));
        return wrapper.getMedicos();
    }
    
    public static List<Enfermeiro> importFromXMLEnfermeiro(String filePath) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(EnfermeirosWrapper.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        EnfermeirosWrapper wrapper = (EnfermeirosWrapper) unmarshaller.unmarshal(new File(filePath));
        return wrapper.getEnfermeiros();
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
    
    // Classe wrapper para contornar limitações do JAXB
    @XmlRootElement
    public static class PacientesWrapper {
        private List<Paciente> pacientes;

        public List<Paciente> getPacientes() {
            return pacientes;
        }

        public void setPacientes(List<Paciente> pacientes) {
            this.pacientes = pacientes;
        }
    }
    
    // Classe wrapper para contornar limitações do JAXB
    @XmlRootElement
    public static class EnfermeirosWrapper {
        private List<Enfermeiro> enfermeiros;

        public List<Enfermeiro> getEnfermeiros() {
            return enfermeiros;
        }

        public void setEnfermeiros(List<Enfermeiro> enfermeiros) {
            this.enfermeiros = enfermeiros;
        }
    }
    
    // Classe wrapper para contornar limitações do JAXB
    @XmlRootElement
    public static class MedicosWrapper {
        private List<Medico> medicos;

        public List<Medico> getMedicos() {
            return medicos;
        } 

        public void setMedicos(List<Medico> medicos) {
            this.medicos = medicos;
        }
    }
}
