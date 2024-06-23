/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.provap2.ListController;

import com.mycompany.provap2.EditController.EditPacienteController;
import com.mycompany.provap2.backend.MenuBack;
import com.mycompany.provap2.backend.Paciente;
import java.io.IOException;
import java.text.ParseException;
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
public class ControllerListPaciente {
    
    @FXML
    private TextField txtPesquisa;
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
    private TableColumn<Paciente, String> responsavel;
    
    @FXML
    private TableColumn<Paciente, String> obsGeral;
    
    @FXML
    private TableColumn<Paciente, Void> editar;
    
    @FXML
    private TableColumn<Paciente, Void> deletar;
    
    ObservableList<Paciente> list = FXCollections.observableArrayList(
        MenuBack.listaDePaciente
    );

    @FXML
    public void initialize() {
        id.setCellValueFactory(new PropertyValueFactory<>("idPaciente"));
        nome.setCellValueFactory(new PropertyValueFactory<>("nomePessoal"));
        dataDeCadastro.setCellValueFactory(new PropertyValueFactory<>("dataCadastro"));
        dataDeNascimento.setCellValueFactory(new PropertyValueFactory<>("dataNascimento"));
        genero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        idade.setCellValueFactory(new PropertyValueFactory<>("idade"));
        obsGeral.setCellValueFactory(new PropertyValueFactory<>("obsGeral"));
        responsavel.setCellValueFactory(new PropertyValueFactory<>("responsavel"));
        
        // Customizando o valor da célula para endereço
    endereco.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Paciente, String>, ObservableValue<String>>() {
        public ObservableValue<String> call(TableColumn.CellDataFeatures<Paciente, String> p) {
            return new SimpleStringProperty(p.getValue().getEndereco().getRua());
        }
    });

    // Customizando o valor da célula para contato
    contato.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Paciente, String>, ObservableValue<String>>() {
        public ObservableValue<String> call(TableColumn.CellDataFeatures<Paciente, String> p) {
            return new SimpleStringProperty(p.getValue().getContato().getEmail());
        }
    });
    
    // Customizando o valor da célula para contato
    responsavel.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Paciente, String>, ObservableValue<String>>() {
        public ObservableValue<String> call(TableColumn.CellDataFeatures<Paciente, String> p) {
            return new SimpleStringProperty(p.getValue().getResponsavelNome());
        }
    });
    
        addButtonEditToTable();
        
        addButtonDeleteToTable();

        FilteredList<Paciente> filteredData = new FilteredList<>(list, p -> true);
        tableView.setItems(filteredData);

        txtPesquisa.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(paciente -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                return paciente.getNomePessoal().toLowerCase().contains(lowerCaseFilter); // filtra por nome
            });
        });
    }
    
    
private void addButtonEditToTable() {
    Callback<TableColumn<Paciente, Void>, TableCell<Paciente, Void>> cellFactory = new Callback<TableColumn<Paciente, Void>, TableCell<Paciente, Void>>() {
        @Override
        public TableCell<Paciente, Void> call(final TableColumn<Paciente, Void> param) {
            final TableCell<Paciente, Void> cell = new TableCell<Paciente, Void>() {

                private final Button btn = new Button("Editar");

                {
                    btn.setOnAction((ActionEvent event) -> {
                        Paciente data = getTableView().getItems().get(getIndex());
                        // Abrir uma nova janela e passar os dados da consulta
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mycompany/provap2/paciente/EditPaciente.fxml"));
                            Parent root = loader.load();
                            EditPacienteController controller = loader.getController();
                            controller.setConsultaData(data);

                            Stage stage = new Stage();
                            stage.setScene(new Scene(root));
                            stage.showAndWait();  // Esperar a janela ser fechada

                            // Após a janela de edição ser fechada, atualizar a tabela
                            tableView.refresh();

                        } catch (IOException ex) {
                            ex.printStackTrace();
                        } catch (ParseException ex) {
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
    Callback<TableColumn<Paciente, Void>, TableCell<Paciente, Void>> cellFactory = new Callback<TableColumn<Paciente, Void>, TableCell<Paciente, Void>>() {
        @Override
        public TableCell<Paciente, Void> call(final TableColumn<Paciente, Void> param) {
            final TableCell<Paciente, Void> cell = new TableCell<Paciente, Void>() {

                private final Button btn = new Button("Deletar");

                {
                    btn.setOnAction((ActionEvent event) -> {
                        Paciente data = getTableView().getItems().get(getIndex());
                        System.out.println("Deletar: " + data.getResponsavelNome());
                         MenuBack.listaDePaciente.remove(data);  // Remover a instância de ConsultaMedica diretamente
                        tableView.getItems().remove(data);  // Atualizar a TableView
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


