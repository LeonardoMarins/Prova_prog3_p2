/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.provap2;

import com.mycompany.provap2.backend.Endereco;
import com.mycompany.provap2.backend.Enfermeiro;
import com.mycompany.provap2.backend.Genero;
import com.mycompany.provap2.backend.Medico;
import com.mycompany.provap2.backend.MenuBack;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class EditEnfermeiroController {
    
     private Enfermeiro enfermeiro;
    
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
    
     public void setConsultaData(Enfermeiro enfermeiro) {
        this.enfermeiro = enfermeiro;
        
        txtSetor.setText(enfermeiro.getSetor());
        txtChSemanal.setText(String.valueOf(enfermeiro.getChSemanal()));
        txtNome.setText(enfermeiro.getNomePessoal()); 
        txtDataDeNascimento.setText(enfermeiro.getDataNascimento().toString());
        txtTelefone.setText(String.valueOf(enfermeiro.getContato().getTelefone())); 
        txtCelular.setText(String.valueOf(enfermeiro.getContato().getCelular()));
        txtEmail.setText(enfermeiro.getContato().getEmail());
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
    public void saveEnfermeiroEdit() throws ParseException {
        try {

        enfermeiro.setSetor(txtSetor.getText());
        enfermeiro.setChSemanal(Integer.parseInt(txtChSemanal.getText()));
        enfermeiro.setNomePessoal(txtNome.getText()); 
        SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");  
        enfermeiro.setDataNascimento(formata.parse(txtDataDeNascimento.getText()));
        enfermeiro.setTelefone(Long.valueOf(txtTelefone.getText()));
        enfermeiro.setCelular(Long.valueOf(txtCelular.getText()));
        enfermeiro.setEmail(txtEmail.getText());
        }catch(ParseException e ) {
            JOptionPane.showMessageDialog(null, "o formato da data deve ser ex: 12/12/2002");
        }catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "o número do CRM ultrapassou o limite de caracter");
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro tente denovo");
        }

        // Fechar a janela
        Stage stage = (Stage) txtSetor.getScene().getWindow();
        stage.close();
    }
}
