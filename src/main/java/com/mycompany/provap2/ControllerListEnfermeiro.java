/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.provap2;

import com.mycompany.provap2.backend.Enfermeiro;
import com.mycompany.provap2.backend.Medico;
import com.mycompany.provap2.backend.MenuBack;
import java.util.UUID;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

/**
 *
 * @author marin
 */
public class ControllerListEnfermeiro {
    
     @FXML
    private TableView<Enfermeiro> tableView;
     
    @FXML
    private TableColumn<Enfermeiro, UUID> id;
    
    @FXML
    private TableColumn<Enfermeiro, String> oprx;
    
    @FXML
    private TableColumn<Enfermeiro, String> setor;
    
    @FXML
    private TableColumn<Enfermeiro, String> chSemanal;
    
    @FXML
    private TableColumn<Enfermeiro, String> nome;
    
    @FXML
    private TableColumn<Enfermeiro, String> dataDeNascimento;
    
    @FXML
    private TableColumn<Enfermeiro, String> endereco;
    
    @FXML
    private TableColumn<Enfermeiro, String> genero;
    
    @FXML
    private TableColumn<Enfermeiro, String> contato;
    
    @FXML
    private TableColumn<Enfermeiro, Void> editar;
    
    @FXML
    private TableColumn<Enfermeiro, Void> deletar;
    
    
    
    ObservableList<Enfermeiro> list = FXCollections.observableArrayList(
        MenuBack.listaDeEnfermeiros
    );

    @FXML
    public void initialize() {
        id.setCellValueFactory(new PropertyValueFactory<>("idEnfermeiro"));
        dataDeNascimento.setCellValueFactory(new PropertyValueFactory<>("dataNascimento"));
        genero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        oprx.setCellValueFactory(new PropertyValueFactory<>("treinadoOpRX"));
        setor.setCellValueFactory(new PropertyValueFactory<>("setor"));
        chSemanal.setCellValueFactory(new PropertyValueFactory<>("chSemanal"));
        nome.setCellValueFactory(new PropertyValueFactory<>("nomePessoal"));
        
        // Customizando o valor da célula para endereço
    endereco.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Enfermeiro, String>, ObservableValue<String>>() {
        public ObservableValue<String> call(TableColumn.CellDataFeatures<Enfermeiro, String> p) {
            return new SimpleStringProperty(p.getValue().getEndereco().getRua());
        }
    });

    // Customizando o valor da célula para contato
    contato.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Enfermeiro, String>, ObservableValue<String>>() {
        public ObservableValue<String> call(TableColumn.CellDataFeatures<Enfermeiro, String> p) {
            return new SimpleStringProperty(p.getValue().getContato().getEmail());
        }
    });
    
    
        addButtonEditToTable();
        
        addButtonDeleteToTable();

        tableView.setItems(list);
    }
    
    
private void addButtonEditToTable() {
    Callback<TableColumn<Enfermeiro, Void>, TableCell<Enfermeiro, Void>> cellFactory = new Callback<TableColumn<Enfermeiro, Void>, TableCell<Enfermeiro, Void>>() {
        @Override
        public TableCell<Enfermeiro, Void> call(final TableColumn<Enfermeiro, Void> param) {
            final TableCell<Enfermeiro, Void> cell = new TableCell<Enfermeiro, Void>() {

                private final Button btn = new Button("Editar");

                {
                    btn.setOnAction((ActionEvent event) -> {
                        Enfermeiro data = getTableView().getItems().get(getIndex());
                        // Aqui você pode abrir uma nova janela ou realizar a ação de edição
                        System.out.println("Editar: " + data.getNomePessoal());
                    });
                }

                @Override
                public void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(btn);
                    }
                }
            };
            return cell;
        }
    };

    editar.setCellFactory(cellFactory);
}

private void addButtonDeleteToTable() {
    Callback<TableColumn<Enfermeiro, Void>, TableCell<Enfermeiro, Void>> cellFactory = new Callback<TableColumn<Enfermeiro, Void>, TableCell<Enfermeiro, Void>>() {
        @Override
        public TableCell<Enfermeiro, Void> call(final TableColumn<Enfermeiro, Void> param) {
            final TableCell<Enfermeiro, Void> cell = new TableCell<Enfermeiro, Void>() {

                private final Button btn = new Button("Deletar");

                {
                    btn.setOnAction((ActionEvent event) -> {
                        Enfermeiro data = getTableView().getItems().get(getIndex());
                        // Aqui você pode abrir uma nova janela ou realizar a ação de edição
                        System.out.println("Deletar: " + data.getNomePessoal());
                    });
                }

                @Override
                public void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(btn);
                    }
                }
            };
            return cell;
        }
    };

    deletar.setCellFactory(cellFactory);
}
}
