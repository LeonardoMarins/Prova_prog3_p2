/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.provap2.ListController;

import com.mycompany.provap2.EditController.EditEnfermeiroController;
import com.mycompany.provap2.backend.Enfermeiro;
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
public class ControllerListEnfermeiro {
    
    @FXML
    private TableView<Enfermeiro> tableView;
     
    @FXML
    private TextField txtPesquisa;
     
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

        FilteredList<Enfermeiro> filteredData = new FilteredList<>(list, p -> true);
        tableView.setItems(filteredData);

        txtPesquisa.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(enfermeiro -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                return enfermeiro.getNomePessoal().toLowerCase().contains(lowerCaseFilter); // filtra por nome
            });
        });
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
                        // Abrir uma nova janela e passar os dados da consulta
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mycompany/provap2/enfermeiro/EditEnfermeiro.fxml"));
                            Parent root = loader.load();
                            EditEnfermeiroController controller = loader.getController();
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
    Callback<TableColumn<Enfermeiro, Void>, TableCell<Enfermeiro, Void>> cellFactory = new Callback<TableColumn<Enfermeiro, Void>, TableCell<Enfermeiro, Void>>() {
        @Override
        public TableCell<Enfermeiro, Void> call(final TableColumn<Enfermeiro, Void> param) {
            final TableCell<Enfermeiro, Void> cell = new TableCell<Enfermeiro, Void>() {

                private final Button btn = new Button("Deletar");

                {
                    btn.setOnAction((ActionEvent event) -> {
                        Enfermeiro data = getTableView().getItems().get(getIndex());
                        System.out.println("Deletar: " + data.getNomePessoal());
                        list.remove(data);
                        MenuBack.listaDeEnfermeiros.remove(data);
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
