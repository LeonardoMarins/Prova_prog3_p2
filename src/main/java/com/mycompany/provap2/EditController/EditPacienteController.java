/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.provap2.EditController;

import com.mycompany.provap2.backend.Endereco;
import com.mycompany.provap2.backend.Genero;
import com.mycompany.provap2.backend.MenuBack;
import com.mycompany.provap2.backend.Paciente;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javax.swing.JOptionPane;

/**
 *
 * @author marin
 */
public class EditPacienteController {
    private Paciente paciente;
    
    @FXML
    public TextField txtNome;
    
    @FXML
    public TextField txtNomeResponsavel;
    
    @FXML
    public TextField txtTelefoneResponsavel;
    
    @FXML
    public TextField txtCelularResponsavel;
    
    @FXML
    public TextField txtEmailDoResponsavel;

    @FXML
    public TextField txtDataDeNascimento;
    
    @FXML
    private ComboBox<Endereco> txtEndereco;
    
    @FXML
    private ComboBox<Genero> txtGenero;
    
    @FXML
    public TextField txtIdade;
    
    @FXML
    public TextField txtDataDeCadastro;
    
    @FXML
    public TextArea txtObsGeral;
    
    @FXML
    public TextField txtTelefone;
    
    @FXML
    public TextField txtCelular;
    
    @FXML
    public TextField txtEmail;
    
     private List<Endereco> listEndereco = new ArrayList<>();
    
    private ObservableList<Endereco> obsEndereco;
    
    private List<Genero> listGenero = new ArrayList<>();
    
    private ObservableList<Genero> obsGenero;
    
     public void setConsultaData(Paciente paciente) throws ParseException {
        this.paciente = paciente;
        SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
        
        txtNome.setText(paciente.getNomePessoal());
        txtNomeResponsavel.setText(paciente.getResponsavelNome());
        txtTelefoneResponsavel.setText(String.valueOf(paciente.getResponsavel().getTelefone()));
        txtCelularResponsavel.setText(String.valueOf(paciente.getResponsavel().getCelular()));
        txtEmailDoResponsavel.setText(paciente.getResponsavel().getEmail()); 
        txtDataDeNascimento.setText(formata.format(paciente.getDataNascimento()));
        txtIdade.setText(String.valueOf(paciente.getIdade())); 
        txtDataDeCadastro.setText(paciente.getDataCadastro());
        txtObsGeral.setText(paciente.getObsGeral());
        txtTelefone.setText(String.valueOf(paciente.getContato().getTelefone()));
        txtCelular.setText(String.valueOf(paciente.getContato().getTelefone()));
        txtEmail.setText(paciente.getContato().getEmail());
        
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
        
        if (!listEndereco.isEmpty()) {
            Endereco enderecoParaEditar = null;
            for (Endereco endereco : MenuBack.listaEndereco) {
            if (endereco.getRua().equals(paciente.getEndereco().getRua())) {
                enderecoParaEditar = endereco;
            }
            
           }
            txtEndereco.setValue(enderecoParaEditar);
           
         }
    }

    @FXML
    public void savePacienteEdit() throws ParseException {
        try {
            paciente.setNomePessoal(txtNome.getText());
            paciente.setIdade(Integer.parseInt(txtIdade.getText()));
            paciente.setObsGeral(txtObsGeral.getText());
            paciente.setResponsavelNome(txtNomeResponsavel.getText());
            paciente.setTelefoneResponsavel(Long.valueOf(txtTelefoneResponsavel.getText()));
            paciente.setCelularResponsavel(Long.valueOf(txtCelularResponsavel.getText()));
            paciente.setEmailResponsavel(txtEmailDoResponsavel.getText()); 
            SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");  
            paciente.setDataNascimento(formata.parse(txtDataDeNascimento.getText()));
            paciente.setTelefone(Long.valueOf(txtTelefone.getText()));
            paciente.setCelular(Long.valueOf(txtCelular.getText()));
            paciente.setEmail(txtEmail.getText());
            }catch(ParseException e ) {
                JOptionPane.showMessageDialog(null, "o formato da data deve ser ex: 12/12/2002");
            }catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "o número do CRM ultrapassou o limite de caracter");
            }catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro tente denovo");
            }

            // Fechar a janela
            Stage stage = (Stage) txtNome.getScene().getWindow();
            stage.close();
    }
}
