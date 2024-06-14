/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.provap2;

import com.mycompany.provap2.backend.DadoPessoal;
import com.mycompany.provap2.backend.MenuBack;
import com.mycompany.provap2.backend.Responsavel;
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
public class ControllerListResponsavel {
    
     @FXML
    private TableView<Responsavel> tableView;
    
    @FXML
    private TableColumn<Responsavel, String> nome;
    
    @FXML
    private TableColumn<Responsavel, Integer> telefone;
    
    @FXML
    private TableColumn<Responsavel, String> celular;
    
    @FXML
    private TableColumn<Responsavel, String> email;
    
    @FXML
    private TableColumn<Responsavel, String> paciente;
    
    ObservableList<Responsavel> list = FXCollections.observableArrayList(
        MenuBack.responsavelList
    );

    @FXML
    public void initialize() {
        nome.setCellValueFactory(new PropertyValueFactory<>("nomeResponsavel"));
        telefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        celular.setCellValueFactory(new PropertyValueFactory<>("celular"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        paciente.setCellValueFactory(new PropertyValueFactory<>("paciente"));

        tableView.setItems(list);
    }
}
