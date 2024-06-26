/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.provap2.ListController;

import com.mycompany.provap2.EditController.EditMedicoController;
import com.mycompany.provap2.backend.Medico;
import com.mycompany.provap2.backend.MenuBack;
import java.io.IOException;
import java.util.UUID;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author marin
 */
public class ControllerListMedico {
    
    @FXML
    private TableView<Medico> tableView;
    
    @FXML
    private TextField txtPesquisa;
     
    @FXML
    private TableColumn<Medico, UUID> id;
    
    @FXML
    private TableColumn<Medico, String> numeroCrm;
    
    @FXML
    private TableColumn<Medico, String> areaEsp;
    
    @FXML
    private TableColumn<Medico, String> cirurgiao;
    
    @FXML
    private TableColumn<Medico, String> setor;
    
    @FXML
    private TableColumn<Medico, String> chSemanal;
    
    @FXML
    private TableColumn<Medico, String> nome;
    
    @FXML
    private TableColumn<Medico, String> dataDeNascimento;
    
    @FXML
    private TableColumn<Medico, String> endereco;
    
    @FXML
    private TableColumn<Medico, String> genero;
    
    @FXML
    private TableColumn<Medico, String> contato;
    
    @FXML
    private TableColumn<Medico, Void> editar;
    
    @FXML
    private TableColumn<Medico, Void> deletar;
    
    
    
    ObservableList<Medico> list = FXCollections.observableArrayList(
        MenuBack.listaDeMedicos
    );

    @FXML
    public void initialize() {
        id.setCellValueFactory(new PropertyValueFactory<>("idMedico"));
        numeroCrm.setCellValueFactory(new PropertyValueFactory<>("numeroCRM"));
        areaEsp.setCellValueFactory(new PropertyValueFactory<>("areasEspecialidade"));
        dataDeNascimento.setCellValueFactory(new PropertyValueFactory<>("dataNascimento"));
        genero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        cirurgiao.setCellValueFactory(new PropertyValueFactory<>("cirurgiao"));
        setor.setCellValueFactory(new PropertyValueFactory<>("setor"));
        chSemanal.setCellValueFactory(new PropertyValueFactory<>("chSemanal"));
        nome.setCellValueFactory(new PropertyValueFactory<>("nomePessoal"));
        
        // Customizando o valor da célula para endereço
    endereco.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Medico, String>, ObservableValue<String>>() {
        public ObservableValue<String> call(TableColumn.CellDataFeatures<Medico, String> p) {
            return new SimpleStringProperty(p.getValue().getEndereco().getRua());
        }
    });

    // Customizando o valor da célula para contato
    contato.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Medico, String>, ObservableValue<String>>() {
        public ObservableValue<String> call(TableColumn.CellDataFeatures<Medico, String> p) {
            return new SimpleStringProperty(p.getValue().getContato().getEmail());
        }
    });
    
    
        addButtonEditToTable();
        
        addButtonDeleteToTable();

        FilteredList<Medico> filteredData = new FilteredList<>(list, p -> true);
        tableView.setItems(filteredData);

        txtPesquisa.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(medico -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                return medico.getNomePessoal().toLowerCase().contains(lowerCaseFilter); // filtra por nome
            });
        });
    }
    
    
private void addButtonEditToTable() {
    Callback<TableColumn<Medico, Void>, TableCell<Medico, Void>> cellFactory = new Callback<TableColumn<Medico, Void>, TableCell<Medico, Void>>() {
        @Override
        public TableCell<Medico, Void> call(final TableColumn<Medico, Void> param) {
            final TableCell<Medico, Void> cell = new TableCell<Medico, Void>() {

                private final Button btn = new Button("Editar");

                {
                     btn.setOnAction((ActionEvent event) -> {
                        Medico data = getTableView().getItems().get(getIndex());
                        // Abrir uma nova janela e passar os dados da consulta
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mycompany/provap2/medico/EditMedico.fxml"));
                            Parent root = loader.load();
                            EditMedicoController controller = loader.getController();
                            controller.setConsultaData(data);

                            Stage stage = new Stage();
                            stage.setScene(new Scene(root));
                            stage.showAndWait();  // Esperar a janela ser fechada

                            // Após a janela de edição ser fechada, atualizar a tabela
                            tableView.refresh();

                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
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
    Callback<TableColumn<Medico, Void>, TableCell<Medico, Void>> cellFactory = new Callback<TableColumn<Medico, Void>, TableCell<Medico, Void>>() {
        @Override
        public TableCell<Medico, Void> call(final TableColumn<Medico, Void> param) {
            final TableCell<Medico, Void> cell = new TableCell<Medico, Void>() {

                private final Button btn = new Button("Deletar");

                {
                     btn.setOnAction((ActionEvent event) -> {
                        Medico data = getTableView().getItems().get(getIndex());
                        System.out.println("Deletar: " + data.getNomePessoal());
                        list.remove(data);
                        MenuBack.listaDeMedicos.remove(data);
                        tableView.refresh();
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
