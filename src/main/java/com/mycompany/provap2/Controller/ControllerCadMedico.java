/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.provap2.Controller;

import com.mycompany.provap2.backend.AtendenteHospitalar;
import com.mycompany.provap2.backend.ContatoTelEmail;
import com.mycompany.provap2.backend.DadoPessoal;
import com.mycompany.provap2.backend.Endereco;
import com.mycompany.provap2.backend.Genero;
import com.mycompany.provap2.backend.Medico;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javax.swing.JOptionPane;

/**
 *
 * @author marin
 */
public class ControllerCadMedico {
    
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
        
        // Definir valor padrão para ComboBox de Endereço (o primeiro item da lista, se disponível)
        if (!listEndereco.isEmpty()) {
            txtEndereco.setValue(listEndereco.get(0));
        }
    }

    
    @FXML
    public void initialize() {
        carregarPaciente();
    }
   
    
    
    
    @FXML
    public void saveMedico() {
       try {
        String numeroCRM = txtCrm.getText();
       int numeroCRMI = Integer.parseInt(numeroCRM);
       
       String areaEspecialidade = txtAreaEspecifica.getText();
       
       
       String setor = txtSetor.getText();
       String chsemanal = txtChSemanal.getText();
       
       String nome = txtNome.getText();

       String dataNascimentoD = txtDataDeNascimento.getText();
       
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
       
       boolean eCirurgiao = sim.isSelected();
       boolean naoECirurgiao = nao.isSelected();
       
       int chSemanalI = Integer.parseInt(chsemanal);
       
       DadoPessoal dado = new DadoPessoal(nome, dataNascimentoD, enderecoSelecionado, contato, opGenero);
       
       AtendenteHospitalar atendimento = new AtendenteHospitalar(setor, chSemanalI,dado);
       
       if (eCirurgiao) {
            
             Medico medico = new Medico(dado,numeroCRMI,areaEspecialidade,eCirurgiao,atendimento);
             MenuBack.adicionarMedico(medico);
             JOptionPane.showMessageDialog(null, "Registro salvo com sucesso");
             Stage stage = (Stage) txtCrm.getScene().getWindow();
             stage.close();
             
             System.out.println(medico.getIdMedico());
        } else if (naoECirurgiao) {
            
            Medico medico = new Medico(dado, numeroCRMI,areaEspecialidade,naoECirurgiao,atendimento);
            MenuBack.adicionarMedico(medico);
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso");
            Stage stage = (Stage) txtCrm.getScene().getWindow();
            stage.close();

            System.out.println(medico.getIdMedico());
        } else {
            Medico medico = new Medico(dado, numeroCRMI,areaEspecialidade,false,atendimento);
            MenuBack.adicionarMedico(medico);
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso");
            Stage stage = (Stage) txtCrm.getScene().getWindow();
            stage.close();

            System.out.println(medico.getIdMedico());
        }
       }catch(NumberFormatException exs) {
           JOptionPane.showMessageDialog(null, "o numero de CRM e o chSemanal não podem ser vazios"
                   + " para o cadastro do medico e não devem conter letras");
           exs.getMessage();
       }catch(IndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "o contatoTelEmail, endereço e responsavel devem ser cadastrado antes "
                    + " em cadastros basicos para conseguir cadastrar um paciente");
       }catch(IllegalArgumentException ex) {
           JOptionPane.showMessageDialog(null, "o nome do medico não pode ser vazio");
       }catch(Exception ex) {
           ex.getMessage();
       }
    }
}
