/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.provap2;

import com.mycompany.provap2.backend.MenuBack;
import jakarta.xml.bind.JAXBException;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
/**
 *
 * @author marin
 */
public class ControllerMenu {
     String name;
    
    @FXML
    public void openCadastroEndereco() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("endereco/CadEndereco.fxml"));
        Parent root = fxmlLoader.load();
        
        Stage stage = new Stage();
        stage.setTitle("Cadastro Endereco");
        stage.setScene(new Scene(root));
        stage.show();
    }
    
    @FXML
    public void openListEndereco() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("endereco/ListEndereco.fxml"));
        Parent root = fxmlLoader.load();
        
        Stage stage = new Stage();
        stage.setTitle("Lista de Endereco");
        stage.setScene(new Scene(root));
        stage.show(); 
    }
    
    @FXML
    public void openCadastraPaciente() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("paciente/CadPaciente.fxml"));
        Parent root = fxmlLoader.load();
        
        Stage stage = new Stage();
        stage.setTitle("Cadastra Paciente");
        stage.setScene(new Scene(root));
        stage.show(); 
    }
    
    @FXML
    public void openListPaciente() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("paciente/ListPaciente.fxml"));
        Parent root = fxmlLoader.load();

        Stage stage = new Stage();
        stage.setTitle("Lista Paciente");
        stage.setScene(new Scene(root));
        stage.show();
    }
    
    @FXML
    public void openCadastraMedico() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("medico/CadMedico.fxml"));
        Parent root = fxmlLoader.load();
        
        Stage stage = new Stage();
        stage.setTitle("Cadastra Medico");
        stage.setScene(new Scene(root));
        stage.show(); 
    }
    
    @FXML
    public void openListMedico() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("medico/ListMedico.fxml"));
        Parent root = fxmlLoader.load();
        
        Stage stage = new Stage();
        stage.setTitle("Lista medico");
        stage.setScene(new Scene(root));
        stage.show(); 
    }
    
    @FXML
    public void openCadastraEnfermeiro() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("enfermeiro/CadEnfermeiro.fxml"));
        Parent root = fxmlLoader.load();
        
        Stage stage = new Stage();
        stage.setTitle("Cadastra enfermeiro");
        stage.setScene(new Scene(root));
        stage.show(); 
    }
    
    @FXML
    public void openListEnfermeiro() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("enfermeiro/ListEnfermeiro.fxml"));
        Parent root = fxmlLoader.load();
        
        Stage stage = new Stage();
        stage.setTitle("Lista Medico");
        stage.setScene(new Scene(root));
        stage.show(); 
    }
    
    @FXML
    public void openCadastraConsulta() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("consulta/CadConsulta.fxml"));
        Parent root = fxmlLoader.load();
        
        Stage stage = new Stage();
        stage.setTitle("Cadastra consulta");
        stage.setScene(new Scene(root));
        stage.show(); 
    }
    
    @FXML
    public void openListConsulta() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("consulta/ListConsulta.fxml"));
        Parent root = fxmlLoader.load();
        
        Stage stage = new Stage();
        stage.setTitle("Lista Consulta");
        stage.setScene(new Scene(root));
        stage.show(); 
    }
    
    @FXML
    public void exportarExcel() throws IOException {
        ExcelController excel = new ExcelController();
         name = JOptionPane.showInputDialog("qual o nome do excel ?");
        try {
            excel.exportExcel(name);
        } catch (IOException ex) {
            ex.getMessage();
        }
    }
    
    @FXML
    public void importarExcel() throws IOException {
        ExcelController excel = new ExcelController();
        try {
            excel.importarExcel();
        } catch (IOException ex) {
            ex.getMessage();
        }
    }
    
    @FXML
    public void exportarJSON() {
        try {
            if(MenuBack.listaDeConsultaMedica.size() >= 1 || MenuBack.listaDeEnfermeiros.size() >= 1 ||
                MenuBack.listaDeMedicos.size() >= 1 || MenuBack.listaDePaciente.size() >= 1) {
                MenuBack.exportToJSONConsulta("consultas.json");
                MenuBack.exportToJSONPaciente("pacientes.json");
                MenuBack.exportToJSONEnfermeiro("enfermeiros.json"); 
                MenuBack.exportToJSONMedico("medicos.json");
                javax.swing.JOptionPane.showMessageDialog(null, "Exportado para JSON com sucesso");               
            }else {
                javax.swing.JOptionPane.showMessageDialog(null, "Não tem dados de consulta, enfermeiros, medicos ou pacientes para serem exportados.");
            }
            
        } catch (IOException e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao exportar para JSON");
        }
    }

    @FXML
    public void importarJSON() {
        try {
            MenuBack.importFromJSONConsulta("consultas.json");
            MenuBack.importFromJSONEnfermeiro("enfermeiros.json");
            MenuBack.importFromJSONMedico("medicos.json");
            MenuBack.importFromJSONPaciente("pacientes.json");
            javax.swing.JOptionPane.showMessageDialog(null, "Importado de JSON com sucesso");
        } catch (IOException e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao importar de JSON");
        }
    }

    @FXML
    public void exportarXML() {
        try {
            if(MenuBack.listaDeConsultaMedica.size() >= 1 || MenuBack.listaDeEnfermeiros.size() >= 1 ||
            MenuBack.listaDeMedicos.size() >= 1 || MenuBack.listaDePaciente.size() >= 1) {
                MenuBack.exportToXMLConsulta("consultas.xml");
                MenuBack.exportToXMLPaciente("pacientes.xml");
                MenuBack.exportToXMLMedico("medicos.xml");
                MenuBack.exportToXMLEnfermeiro("enfermeiros.xml");
                javax.swing.JOptionPane.showMessageDialog(null, "Exportado para XML com sucesso");               
            }else {
                javax.swing.JOptionPane.showMessageDialog(null, "Não tem dados de consulta, enfermeiros, medicos ou pacientes para serem exportados.");
            }
        } catch (JAXBException e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao exportar para XML");
        }
    }

    @FXML
    public void importarXML() {
        try {
            MenuBack.importFromXMLConsulta("consultas.xml");
            MenuBack.importFromXMLPaciente("pacientes.xml");
            MenuBack.importFromXMLEnfermeiro("enfermeiros.xml");
            MenuBack.importFromXMLMedico("medicos.xml");
            javax.swing.JOptionPane.showMessageDialog(null, "Importado de XML com sucesso");
        } catch (JAXBException e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao importar de XML");
        }

    }
    
}
