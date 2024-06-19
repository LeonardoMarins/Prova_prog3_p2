/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.provap2;

import com.mycompany.provap2.backend.ConsultaMedica;
import com.mycompany.provap2.backend.Medico;
import com.mycompany.provap2.backend.Paciente;
import java.util.UUID;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    
     public void setConsultaData(ConsultaMedica consulta) {
        this.consulta = consulta;
        txtQueixaEdit.setText(consulta.getExameQueixa());
        txtDiagnosticoEdit.setText(consulta.getDiagnostico());
        txtPrescricaoEdit.setText(consulta.getPrescricao());
        
    }

    @FXML
    public void saveConsultaEdit() {
        consulta.setExameQueixa(txtQueixaEdit.getText());
        consulta.setDiagnostico(txtDiagnosticoEdit.getText());
        consulta.setPrescricao(txtPrescricaoEdit.getText());

        // Fechar a janela
        Stage stage = (Stage) txtQueixaEdit.getScene().getWindow();
        stage.close();
    }
}
