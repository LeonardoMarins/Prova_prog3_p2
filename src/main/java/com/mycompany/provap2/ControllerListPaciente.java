/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.provap2;

import com.mycompany.provap2.backend.MenuBack;
import com.mycompany.provap2.backend.Paciente;
import java.util.UUID;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author marin
 */
public class ControllerListPaciente {
    
    @FXML
    private TableView<Paciente> tableView;
     
    @FXML
    private TableColumn<Paciente, UUID> id;
    
    @FXML
    private TableColumn<Paciente, String> nome;
    
    @FXML
    private TableColumn<Paciente, String> dataDeCadastro;
    
    @FXML
    private TableColumn<Paciente, String> dataDeNascimento;
    
    @FXML
    private TableColumn<Paciente, String> endereco;
    
    @FXML
    private TableColumn<Paciente, String> genero;
    
    @FXML
    private TableColumn<Paciente, String> contato;
    
    @FXML
    private TableColumn<Paciente, String> idade;
    
    @FXML
    private TableColumn<Paciente, String> obsGeral;
    
    ObservableList<Paciente> list = FXCollections.observableArrayList(
        MenuBack.listaDePaciente
    );

    @FXML
    public void initialize() {
        id.setCellValueFactory(new PropertyValueFactory<>("idPaciente"));
        nome.setCellValueFactory(new PropertyValueFactory<>("nomePessoal"));
        dataDeCadastro.setCellValueFactory(new PropertyValueFactory<>("dataCadastro"));
        dataDeNascimento.setCellValueFactory(new PropertyValueFactory<>("dataNascimento"));
        endereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        genero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        contato.setCellValueFactory(new PropertyValueFactory<>("contato"));
        idade.setCellValueFactory(new PropertyValueFactory<>("idade"));
        obsGeral.setCellValueFactory(new PropertyValueFactory<>("obsGeral"));

        tableView.setItems(list);
    }
}
