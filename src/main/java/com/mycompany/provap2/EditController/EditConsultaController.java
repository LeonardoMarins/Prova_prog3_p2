/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.provap2.EditController;

import com.mycompany.provap2.backend.ConsultaMedica;
import com.mycompany.provap2.backend.Medico;
import com.mycompany.provap2.backend.MenuBack;
import com.mycompany.provap2.backend.Paciente;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 *
 * @author marin
 */
public class EditConsultaController {
    
    private ConsultaMedica consulta;
    
    @FXML
    public ComboBox<Paciente> txtPacienteEdit;
    
    @FXML
    public ComboBox<Medico> txtMedicoEdit;
    
    @FXML
    public TextField txtQueixaEdit;
    
    @FXML
    public TextField txtDiagnosticoEdit;
    
    @FXML
    public TextField txtPrescricaoEdit;
    
    @FXML
    public CheckBox sim;
    
    @FXML
    public CheckBox nao;
    
    private List<Paciente> listPaciente = new ArrayList<>();
    
    private ObservableList<Paciente> obsPaciente;
    
    private List<Medico> listMedico = new ArrayList<>();
    
    private ObservableList<Medico> obsMedico;
    
     public void setConsultaData(ConsultaMedica consulta) {
        this.consulta = consulta;
        txtQueixaEdit.setText(consulta.getExameQueixa());
        txtDiagnosticoEdit.setText(consulta.getDiagnostico());
        txtPrescricaoEdit.setText(consulta.getPrescricao());
        
         // Adiciona todos os endereços à lista
        listPaciente.addAll(MenuBack.listaDePaciente);
        
        listMedico.addAll(MenuBack.listaDeMedicos);

        // Cria a ObservableList uma vez, após adicionar todos os endereços
        obsPaciente = FXCollections.observableArrayList(listPaciente);
        
        obsMedico = FXCollections.observableArrayList(listMedico);
        
        // Configura os itens do ComboBox
        txtPacienteEdit.setItems(obsPaciente);
        
        txtMedicoEdit.setItems(obsMedico);
        

        // Definindo o conversor para exibir o nome da rua do endereço
        txtPacienteEdit.setConverter(new StringConverter<Paciente>() {
            @Override
            public String toString(Paciente paciente) {
                return paciente != null ? paciente.getNomePessoal() : "";
            }

            @Override
            public Paciente fromString(String string) {
                return null;
            }
        });
        
        
        // Definindo o conversor para exibir o nome do Genero
        txtMedicoEdit.setConverter(new StringConverter<Medico>() {
            @Override
            public String toString(Medico medico) {
                return medico != null ? medico.getNomePessoal() : "";
            }

            @Override
            public Medico fromString(String string) {
                return null;
            }
        });
        
        // Seleciona o paciente cadastrado
        if (!listPaciente.isEmpty()) {
            Paciente pacienteParaEditar = null;
            for (Paciente paciente : MenuBack.listaDePaciente) {
            if (paciente.getIdPaciente().equals(consulta.getIdPaciente())) {
                pacienteParaEditar = paciente;
            }
            
           }
            txtPacienteEdit.setValue(pacienteParaEditar);
        }
        
        if (!listMedico.isEmpty()) {
            Medico MedicoParaEditar = null;
            for (Medico medico : MenuBack.listaDeMedicos) {
            if (medico.getIdMedico().equals(consulta.getIdMedico())) {
                MedicoParaEditar = medico;
            }
            
           }
            txtMedicoEdit.setValue(MedicoParaEditar);
        }
        
    }

    @FXML
    public void saveConsultaEdit() {
        consulta.setExameQueixa(txtQueixaEdit.getText());
        consulta.setDiagnostico(txtDiagnosticoEdit.getText());
        consulta.setPrescricao(txtPrescricaoEdit.getText());

        consulta.setIdMedico(txtMedicoEdit.getValue().getIdMedico());
        
        consulta.setIdPaciente(txtPacienteEdit.getValue().getIdPaciente());

        // Fechar a janela
        Stage stage = (Stage) txtQueixaEdit.getScene().getWindow();
        stage.close();
    }
}
