/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.provap2;

import com.mycompany.provap2.backend.Endereco;
import com.mycompany.provap2.backend.Genero;
import com.mycompany.provap2.backend.Medico;
import com.mycompany.provap2.backend.MenuBack;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 *
 * @author marin
 */
public class EditMedicoController {

    private Medico medico;
    
    @FXML
    public TextField txtCrm;
    
    @FXML
    public TextArea txtAreaEspecifica;
    
    @FXML
    public TextField txtSetor;
    
    @FXML
    public TextField txtChSemanal;
    
    @FXML
    public TextField txtNome;
    
    @FXML
    public TextField txtDataDeNascimento;
    
    @FXML
    public ComboBox<Endereco> txtEndereco;
    
    @FXML
    public ComboBox<Genero> txtGenero;
    
    @FXML
    public TextField txtTelefone;
    
    @FXML
    public CheckBox sim;
    
    @FXML
    public CheckBox nao;
    
    @FXML
    public TextField txtCelular;
    
    @FXML
    public TextField txtEmail;
    
     private List<Endereco> listEndereco = new ArrayList<>();
    
    private ObservableList<Endereco> obsEndereco;
    
    private List<Genero> listGenero = new ArrayList<>();
    
    private ObservableList<Genero> obsGenero;
    
     public void setConsultaData(Medico medico) {
        this.medico = medico;
        txtCrm.setText(String.valueOf(medico.getNumeroCRM()));
        txtAreaEspecifica.setText(medico.getAreasEspecialidade());
        txtSetor.setText(medico.getSetor());
        txtChSemanal.setText(String.valueOf(medico.getChSemanal()));
        txtNome.setText(medico.getNomePessoal()); 
        txtDataDeNascimento.setText(medico.getDataNascimento().toString());
        txtTelefone.setText(String.valueOf(medico.getContato().getTelefone())); 
        txtCelular.setText(String.valueOf(medico.getContato().getCelular()));
        txtEmail.setText(medico.getContato().getEmail());
         // Adiciona todos os endereços à lista
        listEndereco.addAll(MenuBack.listaEndereco);
        
        listGenero.add(Genero.M);
        listGenero.add(Genero.F);

        // Cria a ObservableList uma vez, após adicionar todos os endereços
        obsEndereco = FXCollections.observableArrayList(listEndereco);
        
        obsGenero = FXCollections.observableArrayList(listGenero);
        
        // Configura os itens do ComboBox
        txtEndereco.setItems(obsEndereco);
        
        txtGenero.setItems(obsGenero);
        

        // Definindo o conversor para exibir o nome da rua do endereço
        txtEndereco.setConverter(new StringConverter<Endereco>() {
            @Override
            public String toString(Endereco endereco) {
                return endereco != null ? endereco.getRua() : "";
            }

            @Override
            public Endereco fromString(String string) {
                return null;
            }
        });
        
        
        // Definindo o conversor para exibir o nome do Genero
        txtGenero.setConverter(new StringConverter<Genero>() {
            @Override
            public String toString(Genero genero) {
                return genero == Genero.M ? "Masculino" : "Feminino";
            }

            @Override
            public Genero fromString(String string) {
                return null;
            }
        }); 
        
        
    }

    @FXML
    public void saveConsultaEdit() {
        medico.setNumeroCRM(medico.getNumeroCRM());
        medico.setAreasEspecialidade(medico.getAreasEspecialidade());
        medico.setSetor(medico.getSetor());
        medico.setChSemanal(medico.getChSemanal());
        medico.setNomePessoal(medico.getNomePessoal()); 
        medico.setDataNascimento(medico.getDataNascimento());
        medico.setTelefone(medico.getContato().getTelefone());
        medico.setCelular(medico.getContato().getCelular());
        medico.setEmail(medico.getContato().getEmail());

        // Fechar a janela
        Stage stage = (Stage) txtCrm.getScene().getWindow();
        stage.close();
    }
}

