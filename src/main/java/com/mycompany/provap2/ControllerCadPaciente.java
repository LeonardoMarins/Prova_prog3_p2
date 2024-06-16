/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.provap2;

import com.mycompany.provap2.backend.ContatoTelEmail;
import com.mycompany.provap2.backend.DadoPessoal;
import com.mycompany.provap2.backend.Endereco;
import com.mycompany.provap2.backend.Genero;
import com.mycompany.provap2.backend.MenuBack;
import com.mycompany.provap2.backend.Paciente;
import com.mycompany.provap2.backend.Responsavel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javax.swing.JOptionPane;

/**
 *
 * @author marin
 */
public class ControllerCadPaciente {
    
    Date dataAtual = new Date();
    String dataCadastro = dataAtual.toGMTString();
    
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
    
    
    public void carregarPaciente() {
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
        
        
        txtDataDeCadastro.setText(dataCadastro);       
    }

    
    @FXML
    public void initialize() {
        carregarPaciente();
    }
    
    
    @FXML
    public void savePaciente() throws ParseException {

       try {
            
           String nome = txtNome.getText();
           
           SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
           String dataNascimento = txtDataDeNascimento.getText();
           Date dataNascimentoD = formatoData.parse(dataNascimento);
            
           String telefone = txtTelefone.getText();
           long telefoneL = Long.parseLong(telefone);
           String celular = txtCelular.getText();
           long celularL = Long.parseLong(celular);
           String email = txtEmail.getText();
           
           Genero generoSelecionado = txtGenero.getValue();
           
           Genero opGenero = null;
                      
           if(generoSelecionado == null) {
               opGenero = Genero.F;
           }
                    
           if (Genero.M.equals(generoSelecionado)) {
               opGenero = Genero.M;
           } else if (Genero.F.equals(generoSelecionado)) {
               opGenero = Genero.F;
           }
           

                   
           String telefoneResponsavel = txtTelefoneResponsavel.getText();
           long telefoneLResponsavel = Long.parseLong(telefoneResponsavel);
           String celularResponsavel = txtCelularResponsavel.getText();
           long celularLResponsavel = Long.parseLong(celularResponsavel);
           String emailResponsavel = txtEmailDoResponsavel.getText();
           String nomeResponsavel = txtNomeResponsavel.getText();
            
            String idade = txtIdade.getText();
            int idadeI = Integer.parseInt(idade);
            String obsGeral = txtObsGeral.getText();
       
            ContatoTelEmail contatoPaciente = new ContatoTelEmail(telefoneL, celularL, email);
            
             ContatoTelEmail contatoResponsavel = new ContatoTelEmail(telefoneLResponsavel, celularLResponsavel, emailResponsavel);
            
            Responsavel responsavel = new Responsavel(nomeResponsavel, contatoResponsavel);
            
            var enderecoSelecionado = txtEndereco.getValue();
            
            DadoPessoal dado = new DadoPessoal(nome,dataNascimentoD,enderecoSelecionado,
            contatoPaciente, opGenero);
        
            Paciente paciente = new Paciente(dado, idadeI,
                    dataCadastro, obsGeral, responsavel);

            MenuBack.adicionarPaciente(paciente);
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
