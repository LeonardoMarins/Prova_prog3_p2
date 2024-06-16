/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.provap2;

import com.mycompany.provap2.backend.AtendenteHospitalar;
import com.mycompany.provap2.backend.ContatoTelEmail;
import com.mycompany.provap2.backend.DadoPessoal;
import com.mycompany.provap2.backend.Endereco;
import com.mycompany.provap2.backend.Genero;
import com.mycompany.provap2.backend.Medico;
import com.mycompany.provap2.backend.MenuBack;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
    public TextField txtChSemanl;
    
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
   
    
    
    
    @FXML
    public void saveMedico() {
       try {
        String numeroCRM = txtCrm.getText();
       int numeroCRMI = Integer.parseInt(numeroCRM);
       
       String areaEspecialidade = txtAreaEspecifica.getText();
       
       
       String setor = txtSetor.getText();
       String chsemanal = txtChSemanl.getText();
       
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
            
       if ("Masculino".equals(generoSelecionado)) {
            opGenero = Genero.M;
       } else if ("Feminino".equals(generoSelecionado)) {
            opGenero = Genero.F;
       }
       
       boolean cirurgiaoSelecionado = true;
       boolean outroRadioButtonSelecionado = false;
       
       boolean selectedRadio1;
       boolean selectedRadio2;
       
       
       int chSemanalI = Integer.parseInt(chsemanal);
       
       DadoPessoal dado = new DadoPessoal(nome, dataNascimentoD, enderecoSelecionado, contato, opGenero);
       
       AtendenteHospitalar atendimento = new AtendenteHospitalar(setor, chSemanalI,dado);
       
       if (cirurgiaoSelecionado) {
            selectedRadio1 = true;
            
             Medico medico = new Medico(dado,numeroCRMI,areaEspecialidade,selectedRadio1,atendimento);
             MenuBack.adicionarMedico(medico);
             JOptionPane.showMessageDialog(null, "Registro salvo com sucesso");
             
             System.out.println(medico.getIdMedico());
        } else if (outroRadioButtonSelecionado) {
            selectedRadio2 = true;
            
            Medico medico = new Medico(dado, numeroCRMI,areaEspecialidade,selectedRadio2,atendimento);
            MenuBack.adicionarMedico(medico);
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso");

            System.out.println(medico.getIdMedico());
        } else {
            Medico medico = new Medico(dado, numeroCRMI,areaEspecialidade,false,atendimento);
            MenuBack.adicionarMedico(medico);
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso");

            System.out.println(medico.getIdMedico());
        }
       }catch(ParseException ex) {
           JOptionPane.showMessageDialog(null, "A data de nascimento não pode ser vazia exemplo: 12/09/1998");
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
