/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.provap2.ListController;

import com.mycompany.provap2.EditController.EditConsultaController;
import com.mycompany.provap2.backend.ConsultaMedica;
import com.mycompany.provap2.backend.MenuBack;
import java.io.IOException;
import java.util.UUID;
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
public class ControllerListConsulta {
    
    @FXML
    private TableView<ConsultaMedica> tableView;
    
    @FXML
    private TextField txtPesquisa;
     
    @FXML
    private TableColumn<ConsultaMedica, UUID> idPaciente;
    
    @FXML
    private TableColumn<ConsultaMedica, UUID> id;
    
    @FXML
    private TableColumn<ConsultaMedica, UUID> idMedico;
    
    @FXML
    private TableColumn<ConsultaMedica, String> exameQueixa;
    
    @FXML
    private TableColumn<ConsultaMedica, String> diagnostico;
    
    @FXML
    private TableColumn<ConsultaMedica, String> prescricao;
    
    @FXML
    private TableColumn<ConsultaMedica, String> indicacao;
    
    @FXML
    private TableColumn<ConsultaMedica, Void> editar;
    
    @FXML
    private TableColumn<ConsultaMedica, Void> deletar;
    
    ObservableList<ConsultaMedica> list = FXCollections.observableArrayList(
        MenuBack.listaDeConsultaMedica
    );

    @FXML
    public void initialize() {
        id.setCellValueFactory(new PropertyValueFactory<>("idConsulta"));
        idPaciente.setCellValueFactory(new PropertyValueFactory<>("idPaciente"));
        idMedico.setCellValueFactory(new PropertyValueFactory<>("idMedico"));
        exameQueixa.setCellValueFactory(new PropertyValueFactory<>("exameQueixa"));
        diagnostico.setCellValueFactory(new PropertyValueFactory<>("diagnostico"));
        prescricao.setCellValueFactory(new PropertyValueFactory<>("prescricao"));
        indicacao.setCellValueFactory(new PropertyValueFactory<>("indicacaoCirurgica"));
    
        addButtonEditToTable();
        
        addButtonDeleteToTable();

         FilteredList<ConsultaMedica> filteredData = new FilteredList<>(list, p -> true);
        tableView.setItems(filteredData);

        txtPesquisa.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(consulta -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                return consulta.getDiagnostico().toLowerCase().contains(lowerCaseFilter); // filtra por nome
            });
        });
    }
    
    
private void addButtonEditToTable() {
    Callback<TableColumn<ConsultaMedica, Void>, TableCell<ConsultaMedica, Void>> cellFactory = new Callback<TableColumn<ConsultaMedica, Void>, TableCell<ConsultaMedica, Void>>() {
        @Override
        public TableCell<ConsultaMedica, Void> call(final TableColumn<ConsultaMedica, Void> param) {
            final TableCell<ConsultaMedica, Void> cell = new TableCell<ConsultaMedica, Void>() {

                private final Button btn = new Button("Editar");

                {
                    btn.setOnAction((ActionEvent event) -> {
                        ConsultaMedica data = getTableView().getItems().get(getIndex());
                        // Abrir uma nova janela e passar os dados da consulta
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mycompany/provap2/consulta/EditConsulta.fxml"));
                            Parent root = loader.load();
                            EditConsultaController controller = loader.getController();
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
    Callback<TableColumn<ConsultaMedica, Void>, TableCell<ConsultaMedica, Void>> cellFactory = new Callback<TableColumn<ConsultaMedica, Void>, TableCell<ConsultaMedica, Void>>() {
        @Override
        public TableCell<ConsultaMedica, Void> call(final TableColumn<ConsultaMedica, Void> param) {
            final TableCell<ConsultaMedica, Void> cell = new TableCell<ConsultaMedica, Void>() {

                private final Button btn = new Button("Deletar");

                {
                    btn.setOnAction((ActionEvent event) -> {
                        ConsultaMedica data = getTableView().getItems().get(getIndex());
                        System.out.println("Deletar: " + data.getDiagnostico());
                        list.remove(data);
                        MenuBack.listaDeConsultaMedica.remove(data);
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
    @FXML
    public void saveConsultaEdit() {
        
    }
}
