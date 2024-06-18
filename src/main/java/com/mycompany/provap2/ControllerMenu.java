/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.provap2;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author marin
 */
public class ControllerMenu {
    
    @FXML
    public void openCadastroEndereco() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CadEndereco.fxml"));
        Parent root = fxmlLoader.load();
        
        Stage stage = new Stage();
        stage.setTitle("Cadastro Endereco");
        stage.setScene(new Scene(root));
        stage.show();
    }
    
    @FXML
    public void openListEndereco() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ListEndereco.fxml"));
        Parent root = fxmlLoader.load();
        
        Stage stage = new Stage();
        stage.setTitle("Lista de Endereco");
        stage.setScene(new Scene(root));
        stage.show(); 
    }
    
    @FXML
    public void openCadastraResponsavel() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CadResponsavel.fxml"));
        Parent root = fxmlLoader.load();
        
        Stage stage = new Stage();
        stage.setTitle("Cadastra Responsavel");
        stage.setScene(new Scene(root));
        stage.show(); 
    }
    
    @FXML
    public void openListResponsavel() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ListResponsavel.fxml"));
        Parent root = fxmlLoader.load();
        
        Stage stage = new Stage();
        stage.setTitle("Lista Responsavel");
        stage.setScene(new Scene(root));
        stage.show(); 
    }
    
    @FXML
    public void openCadastraPaciente() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CadPaciente.fxml"));
        Parent root = fxmlLoader.load();
        
        Stage stage = new Stage();
        stage.setTitle("Cadastra Paciente");
        stage.setScene(new Scene(root));
        stage.show(); 
    }
    
    @FXML
    public void openListPaciente() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ListPaciente.fxml"));
        Parent root = fxmlLoader.load();
        
        Stage stage = new Stage();
        stage.setTitle("Lista Paciente");
        stage.setScene(new Scene(root));
        stage.show(); 
    }
    
    @FXML
    public void openCadastraMedico() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CadMedico.fxml"));
        Parent root = fxmlLoader.load();
        
        Stage stage = new Stage();
        stage.setTitle("Cadastra Medico");
        stage.setScene(new Scene(root));
        stage.show(); 
    }
    
    @FXML
    public void openListMedico() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ListMedico.fxml"));
        Parent root = fxmlLoader.load();
        
        Stage stage = new Stage();
        stage.setTitle("Lista medico");
        stage.setScene(new Scene(root));
        stage.show(); 
    }
    
    @FXML
    public void openCadastraEnfermeiro() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CadEnfermeiro.fxml"));
        Parent root = fxmlLoader.load();
        
        Stage stage = new Stage();
        stage.setTitle("Cadastra enfermeiro");
        stage.setScene(new Scene(root));
        stage.show(); 
    }
    
    @FXML
    public void openListEnfermeiro() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ListEnfermeiro.fxml"));
        Parent root = fxmlLoader.load();
        
        Stage stage = new Stage();
        stage.setTitle("Lista Medico");
        stage.setScene(new Scene(root));
        stage.show(); 
    }
    
    @FXML
    public void openCadastraConsulta() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CadConsulta.fxml"));
        Parent root = fxmlLoader.load();
        
        Stage stage = new Stage();
        stage.setTitle("Cadastra consulta");
        stage.setScene(new Scene(root));
        stage.show(); 
    }
    
    @FXML
    public void openListConsulta() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ListConsulta.fxml"));
        Parent root = fxmlLoader.load();
        
        Stage stage = new Stage();
        stage.setTitle("Lista Consulta");
        stage.setScene(new Scene(root));
        stage.show(); 
    }
    
    
}
