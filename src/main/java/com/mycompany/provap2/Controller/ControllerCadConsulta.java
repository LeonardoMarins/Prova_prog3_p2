/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.provap2.Controller;

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
import javax.swing.JOptionPane;

/**
 *
 * @author marin
 */
public class ControllerCadConsulta {
    
    @FXML
    public ComboBox<Paciente> txtPaciente;
    
    @FXML
    public ComboBox<Medico> txtMedico;
    
    @FXML
    public TextField txtQueixa;
    
    @FXML
    public TextField txtDiagnostico;
    
    @FXML
    public TextField txtPrescricao;
    
    @FXML
    public CheckBox sim;
    
    @FXML
    public CheckBox nao;
    
    private List<Paciente> listPaciente = new ArrayList<>();
    
    private ObservableList<Paciente> obsPaciente;
    
    private List<Medico> listMedico = new ArrayList<>();
    
    private ObservableList<Medico> obsMedico;
    
    
    public void carregarPaciente() {
        // Adiciona todos os endereços à lista
        listPaciente.addAll(MenuBack.listaDePaciente);
        
        listMedico.addAll(MenuBack.listaDeMedicos);

        // Cria a ObservableList uma vez, após adicionar todos os endereços
        obsPaciente = FXCollections.observableArrayList(listPaciente);
        
        obsMedico = FXCollections.observableArrayList(listMedico);
        
        // Configura os itens do ComboBox
        txtPaciente.setItems(obsPaciente);
        
        txtMedico.setItems(obsMedico);
        

        // Definindo o conversor para exibir o nome da rua do endereço
        txtPaciente.setConverter(new StringConverter<Paciente>() {
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
        txtMedico.setConverter(new StringConverter<Medico>() {
            @Override
            public String toString(Medico medico) {
                return medico != null ? medico.getNomePessoal() : "";
            }

            @Override
            public Medico fromString(String string) {
                return null;
            }
        });
        
        // Definir valor padrão para ComboBox de paciente (o primeiro item da lista, se disponível)
        if (!listPaciente.isEmpty()) {
            txtPaciente.setValue(listPaciente.get(0));
        }
        
        // Definir valor padrão para ComboBox de Medico (o primeiro item da lista, se disponível)
        if (!listMedico.isEmpty()) {
            txtMedico.setValue(listMedico.get(0));
        }
        
    }

    
    @FXML
    public void initialize() {
        carregarPaciente();
    }
    
    
    @FXML
    public void saveConsulta() {
    
        try {
             
        Paciente paciente = txtPaciente.getValue();
        Medico medico = txtMedico.getValue();
        
        String exameDeQueixa = txtQueixa.getText();
        String diagnostico = txtDiagnostico.getText();
        String prescricao = txtPrescricao.getText();
        
         
       boolean indicacao = sim.isSelected();
       boolean indicacao2 = nao.isSelected();
       
       
        if (indicacao) {

            ConsultaMedica consulta = new ConsultaMedica(paciente, medico, 
                    exameDeQueixa, diagnostico, prescricao, indicacao);
            MenuBack.adicionarConsultaMedica(consulta);
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso");
            Stage stage = (Stage) txtQueixa.getScene().getWindow();
            stage.close();
            System.out.println(consulta.getIdConsulta());
        } else if (indicacao2) {

             ConsultaMedica consulta = new ConsultaMedica(paciente, medico, 
                    exameDeQueixa, diagnostico, prescricao, indicacao2);
             MenuBack.adicionarConsultaMedica(consulta);
             JOptionPane.showMessageDialog(null, "Registro salvo com sucesso");
             Stage stage = (Stage) txtQueixa.getScene().getWindow();
             stage.close();
             System.out.println(consulta.getIdConsulta());
        } else {
            ConsultaMedica consulta = new ConsultaMedica(paciente, medico, 
                    exameDeQueixa, diagnostico, prescricao, false);
            MenuBack.adicionarConsultaMedica(consulta);
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso");
            Stage stage = (Stage) txtQueixa.getScene().getWindow();
            stage.close();
            System.out.println(consulta.getIdConsulta());
        }
      }catch(IndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "o paciente e o medico devem ser cadastrado antes "
            + " em cadastros especificos para conseguir cadastrar uma consulta");
       }catch(IllegalArgumentException exs) {
           JOptionPane.showMessageDialog(null, "a queixa do paciente não pode ficar vazia");
           exs.getMessage();
       }catch(Exception exs) {
           exs.getMessage();
       }
    }
    
    @FXML
    public void clear() {
        
        txtQueixa.setText("");
        txtDiagnostico.setText("");
        txtPrescricao.setText("");
 
    }
}
