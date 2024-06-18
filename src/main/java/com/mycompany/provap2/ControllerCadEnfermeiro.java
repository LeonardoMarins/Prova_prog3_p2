/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.provap2;

import com.mycompany.provap2.backend.AtendenteHospitalar;
import com.mycompany.provap2.backend.ContatoTelEmail;
import com.mycompany.provap2.backend.DadoPessoal;
import com.mycompany.provap2.backend.Endereco;
import com.mycompany.provap2.backend.Enfermeiro;
import com.mycompany.provap2.backend.Genero;
import com.mycompany.provap2.backend.MenuBack;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javax.swing.JOptionPane;

/**
 *
 * @author marin
 */
public class ControllerCadEnfermeiro {
    
    @FXML
    public TextField txtSetor;
    
    @FXML
    public TextField txtChSemanal;
    
    @FXML
    public CheckBox sim;
    
    @FXML
    public CheckBox nao;
    
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
    }

    
    @FXML
    public void initialize() {
        carregarPaciente();
    }
    
    
    @FXML
    public void saveEnfermeiro() {
        try {
       
       String setor = txtSetor.getText();
       String chsemanal = txtChSemanal.getText();
       String nome = txtNome.getText();
       
       SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
       String dataNascimento = txtDataDeNascimento.getText();
       Date dataNascimentoD = formatoData.parse(dataNascimento);
       
       Endereco enderecoSelecionado = txtEndereco.getValue();
            
       String telefone = txtTelefone.getText();
       long telefoneL = Long.parseLong(telefone);
       String celular = txtCelular.getText();
       long celularL = Long.parseLong(celular);
       String email = txtEmail.getText();
       
       ContatoTelEmail contato = new ContatoTelEmail(telefoneL, celularL, email);
            
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
       
       int chSemanalI = Integer.parseInt(chsemanal);
       
       boolean treinadoOPRX = sim.isSelected();
       boolean treinadoOPRX2 = nao.isSelected();
       
       boolean selectedRadio1;
       boolean selectedRadio2;
       
       DadoPessoal dado = new DadoPessoal(nome, dataNascimentoD, enderecoSelecionado, contato, opGenero);
       
       AtendenteHospitalar atendimento = new AtendenteHospitalar(setor, chSemanalI,dado);
       
       if (treinadoOPRX) {
            selectedRadio1 = true;
            Enfermeiro enfermeiro = new Enfermeiro(selectedRadio1, atendimento, dado);
            MenuBack.adicionarEnfermeiro(enfermeiro);
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso");
            System.out.println(enfermeiro.getGenero());
        } else if (treinadoOPRX2) {
            selectedRadio2 = true;
            Enfermeiro enfermeiro = new Enfermeiro(selectedRadio2, atendimento, dado);
            MenuBack.adicionarEnfermeiro(enfermeiro);
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso");
            System.out.println(enfermeiro.getGenero());
        } else {
            Enfermeiro enfermeiro = new Enfermeiro(false, atendimento, dado);
            MenuBack.adicionarEnfermeiro(enfermeiro);
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso");
            System.out.println(enfermeiro.getGenero());
        }
       }catch(ParseException ex) {
           JOptionPane.showMessageDialog(null, "A data de nascimento não pode ser vazia exemplo: 12/09/1998");
       }catch(NumberFormatException exs) {
           JOptionPane.showMessageDialog(null, "o chSemanal não podem ser vazios"
                   + " para o cadastro do enfermeiro");
           exs.getMessage();
       }catch(IndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "o contatoTelEmail, endereço e responsavel devem ser cadastrado antes "
                    + " em cadastros basicos para conseguir cadastrar um paciente");
       }catch(IllegalArgumentException ex) {
           JOptionPane.showMessageDialog(null, "o nome do enfermeiro não pode ser vazio");
       }catch(Exception ex) {
           ex.getMessage();
       }
    }
    
}

