/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.provap2;

import com.mycompany.provap2.backend.ContatoTelEmail;
import com.mycompany.provap2.backend.MenuBack;
import com.mycompany.provap2.backend.Paciente;
import com.mycompany.provap2.backend.Responsavel;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 *
 * @author marin
 */
public class ControllerCadResponsavel {

    @FXML
    public TextField txtNome;
    
    @FXML
    public TextField txtTelefone;
    
    @FXML
    public TextField txtCelular;
    
    @FXML
    public TextField txtEmail;
    
    @FXML
    private ChoiceBox<Paciente> rep;
    
    private List<Paciente> ListResponsavel = new ArrayList<>();
    
    
    private ObservableList<Paciente> obsResponsavel;
    
    public void carregarResponsavel() {
        for(Paciente paciente: MenuBack.listaDePaciente) {
        
        ListResponsavel.add(paciente);
        
        obsResponsavel = FXCollections.observableArrayList(ListResponsavel);
        
        rep.setItems(obsResponsavel);
       }
    }

    
    @FXML
    public void initialize() {
        carregarResponsavel();
    }
    
    
    @FXML
    public void saveResponsavel() {

       try {
            
           String nome = txtNome.getText();
        
           //Paciente opcaoSelecionada = rep.getValue();
            
           String telefone = txtTelefone.getText();
           long telefoneL = Long.parseLong(telefone);
           String celular = txtCelular.getText();
           long celularL = Long.parseLong(celular);
           String email = txtEmail.getText();
       
            ContatoTelEmail contato = new ContatoTelEmail(telefoneL, celularL, email);
            
            String teste = rep.toString();
            
            Paciente pacienteSelecionado = MenuBack.listaDePaciente.get(Integer.parseInt(teste));
        
            Responsavel responsavel = new Responsavel(nome, contato, pacienteSelecionado);

            MenuBack.adicionarResponsavel(responsavel);
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso");
            
        }catch(IndexOutOfBoundsException ex) {
            ex.getMessage();
            JOptionPane.showMessageDialog(null, "o contatoTelEmail deve ser cadastrado antes "
                    + "para conseguir cadastrar um responsavel");
        }catch(IllegalArgumentException exs) {
            exs.getMessage();
            JOptionPane.showMessageDialog(null, "o campo de nome do responsavel não pode ser vazio");
        }
    }
}
