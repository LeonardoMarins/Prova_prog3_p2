package com.mycompany.provap2.ListController;

import com.mycompany.provap2.backend.Endereco;
import com.mycompany.provap2.backend.MenuBack;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControllerListEndereco {
    
    @FXML
    private TableView<Endereco> tableView;
    
    @FXML
    private TableColumn<Endereco, String> rua;
    
    @FXML
    private TableColumn<Endereco, Integer> numero;
    
    @FXML
    private TableColumn<Endereco, String> bairro;
    
    @FXML
    private TableColumn<Endereco, String> cidade;
    
    @FXML
    private TableColumn<Endereco, String> estado;
    
    @FXML
    private TableColumn<Endereco, Integer> cep;
    
    ObservableList<Endereco> list = FXCollections.observableArrayList(
        MenuBack.listaEndereco
    );

    @FXML
    public void initialize() {
        rua.setCellValueFactory(new PropertyValueFactory<>("rua"));
        numero.setCellValueFactory(new PropertyValueFactory<>("numero"));
        bairro.setCellValueFactory(new PropertyValueFactory<>("bairro"));
        cidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));
        estado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        cep.setCellValueFactory(new PropertyValueFactory<>("cep"));
      
        tableView.setItems(list);
    }
}
