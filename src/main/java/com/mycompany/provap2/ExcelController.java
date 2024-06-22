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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author marin
 */
public class ExcelController {
    String name;
    
    public void exportExcel(String nomeDoExcel) throws IOException {
        String userHome = System.getProperty("user.home");
        String downloadsPath = userHome + "/Downloads/";

        String filePath = downloadsPath + nomeDoExcel + ".xlsx";

        try (Workbook workbook = new XSSFWorkbook()) {
            exportarPaciente(workbook);
            exportarMedico(workbook);
            exportarEnfermeiro(workbook);
            exportarConsulta(workbook);

            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }
        }
    }
    
    public void exportarPaciente(Workbook workbook) throws IOException {
         
        String userHome = System.getProperty("user.home");
        String downloadsPath = userHome + "/Downloads/";
        
        String filePath = downloadsPath + name + ".xlsx";
    
        Sheet sheet = workbook.createSheet("paciente");
        
        Row titleRow = sheet.createRow(0);
        Cell titleCell1 = titleRow.createCell(0);
        titleCell1.setCellValue("NOME");
        Cell titleCell2 = titleRow.createCell(2);
        titleCell2.setCellValue("DATA NASCIMENTO");
        Cell titleCell5 = titleRow.createCell(4);
        titleCell5.setCellValue("IDADE");
        Cell titleCell6 = titleRow.createCell(6);
        titleCell6.setCellValue("DATA CADASTRO");
        Cell titleCell7 = titleRow.createCell(8);
        titleCell7.setCellValue("OBS GERAL");
        Cell titleCell8 = titleRow.createCell(10);
        titleCell8.setCellValue("RESPONSAVEL");
        Cell titleCell9 = titleRow.createCell(12);
        titleCell9.setCellValue("RUA");
        Cell titleCell10 = titleRow.createCell(14);
        titleCell10.setCellValue("NUMERO");
        Cell titleCell11 = titleRow.createCell(16);
        titleCell11.setCellValue("ESTADO");
        Cell titleCell12 = titleRow.createCell(18);
        titleCell12.setCellValue("CIDADE");
        Cell titleCell13 = titleRow.createCell(20);
        titleCell13.setCellValue("CEP");
        Cell titleCell14 = titleRow.createCell(22);
        titleCell14.setCellValue("BAIRRO");
        Cell titleCell15 = titleRow.createCell(24);
        titleCell15.setCellValue("CELULAR");
        Cell titleCell16 = titleRow.createCell(26);
        titleCell16.setCellValue("TELEFONE");
        Cell titleCell17 = titleRow.createCell(28);
        titleCell17.setCellValue("EMAIL");

        int tamanho = MenuBack.listaDePaciente.size();
        for (int i = 0; i < tamanho; i++) {
            Row row = sheet.createRow(i + 1); 
            Cell cell1 = row.createCell(0);
            cell1.setCellValue(MenuBack.listaDePaciente.get(i).getNomePessoal());
            Cell cell2 = row.createCell(2); 
            cell2.setCellValue(MenuBack.listaDePaciente.get(i).getDataNascimento().toString());
            Cell cell5 = row.createCell(4); 
            cell5.setCellValue(MenuBack.listaDePaciente.get(i).getIdade());
            Cell cell6 = row.createCell(6); 
            cell6.setCellValue(MenuBack.listaDePaciente.get(i).getDataCadastro());
            Cell cell7 = row.createCell(8); 
            cell7.setCellValue(MenuBack.listaDePaciente.get(i).getObsGeral());
            Cell cell8 = row.createCell(10); 
            cell8.setCellValue(MenuBack.listaDePaciente.get(i).getResponsavel().getNomeResponsavel());
            Cell cell9 = row.createCell(12);
            cell9.setCellValue(MenuBack.listaDePaciente.get(i).getEndereco().getRua());
            Cell cell10 = row.createCell(14);
            cell10.setCellValue(MenuBack.listaDePaciente.get(i).getEndereco().getNumero());
            Cell cell11 = row.createCell(16);
            cell11.setCellValue(MenuBack.listaDePaciente.get(i).getEndereco().getEstado());
            Cell cell12 = row.createCell(18);
            cell12.setCellValue(MenuBack.listaDePaciente.get(i).getEndereco().getCidade());
            Cell cell13 = row.createCell(20);
            cell13.setCellValue(MenuBack.listaDePaciente.get(i).getEndereco().getCep());
            Cell cell14 = row.createCell(22);
            cell14.setCellValue(MenuBack.listaDePaciente.get(i).getEndereco().getBairro());
            Cell cell15 = row.createCell(24); 
            cell15.setCellValue(MenuBack.listaDePaciente.get(i).getContato().getCelular());
            Cell cell16 = row.createCell(26); 
            cell16.setCellValue(MenuBack.listaDePaciente.get(i).getContato().getTelefone());
            Cell cell17 = row.createCell(28); 
            cell17.setCellValue(MenuBack.listaDePaciente.get(i).getContato().getEmail());
        
        
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }
    }
}
     
     public void exportarMedico(Workbook workbook) throws IOException {
         
        String userHome = System.getProperty("user.home");
        String downloadsPath = userHome + "/Downloads/";
    
        
        String filePath = downloadsPath + name + ".xlsx";

        Sheet sheet = workbook.createSheet("Medico");
        
        
        Row titleRow = sheet.createRow(0);
        Cell titleCell1 = titleRow.createCell(0);
        titleCell1.setCellValue("NUMERO CRM");
        Cell titleCell2 = titleRow.createCell(1);
        titleCell2.setCellValue("AREA ESP");
        Cell titleCell3 = titleRow.createCell(4);
        titleCell3.setCellValue("CIRURGIÃO");
        Cell titleCell4 = titleRow.createCell(6);
        titleCell4.setCellValue("SETOR");
        Cell titleCell5 = titleRow.createCell(8);
        titleCell5.setCellValue("CHSEMANAL");
        Cell titleCell6 = titleRow.createCell(10);
        titleCell6.setCellValue("NOME");
        Cell titleCell7 = titleRow.createCell(12);
        titleCell7.setCellValue("DATA NASCIMENTO");
        Cell titleCell8 = titleRow.createCell(14);
        titleCell8.setCellValue("ENDEREÇO");
        Cell titleCell9 = titleRow.createCell(16);
        titleCell9.setCellValue("CONTATO");
        Cell titleCell10 = titleRow.createCell(18);
        titleCell10.setCellValue("GENERO");

        int tamanho = MenuBack.listaDeMedicos.size();
        for (int i = 0; i < tamanho; i++) {
            Row row = sheet.createRow(i + 1); 
            Cell cell1 = row.createCell(0);
            cell1.setCellValue(MenuBack.listaDeMedicos.get(i).getNumeroCRM());
            Cell cell2 = row.createCell(1); 
            cell2.setCellValue(MenuBack.listaDeMedicos.get(i).getAreasEspecialidade());
            Cell cell3 = row.createCell(4);
            cell3.setCellValue((boolean) MenuBack.listaDeMedicos.get(i).isCirurgiao());
            Cell cell4 = row.createCell(6); 
            cell4.setCellValue(MenuBack.listaDeMedicos.get(i).getSetor());
            Cell cell5 = row.createCell(8); 
            cell5.setCellValue(MenuBack.listaDeMedicos.get(i).getChSemanal());
            Cell cell6 = row.createCell(10); 
            cell6.setCellValue(MenuBack.listaDeMedicos.get(i).getNomePessoal());
            Cell cell7 = row.createCell(12); 
            cell7.setCellValue(MenuBack.listaDeMedicos.get(i).getDataNascimento().toString());
            Cell cell8 = row.createCell(14); 
            cell8.setCellValue(MenuBack.listaDeMedicos.get(i).getEndereco().getRua());
            Cell cell9 = row.createCell(16); 
            cell9.setCellValue(MenuBack.listaDeMedicos.get(i).getContato().getCelular());
            Cell cell10 = row.createCell(18); 
            cell10.setCellValue(MenuBack.listaDeMedicos.get(i).getGenero().name());
        
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }
    }
}
      public void exportarEnfermeiro(Workbook workbook) throws IOException {
        
        String userHome = System.getProperty("user.home");
        String downloadsPath = userHome + "/Downloads/";
    
        
        String filePath = downloadsPath + name + ".xlsx";

        Sheet sheet = workbook.createSheet("Enfermeiro");
        
        
        Row titleRow = sheet.createRow(0);
        Cell titleCell1 = titleRow.createCell(0);
        titleCell1.setCellValue("NOME");
        Cell titleCell2 = titleRow.createCell(2);
        titleCell2.setCellValue("DATA NASCIMENTO");
        Cell titleCell3 = titleRow.createCell(4);
        titleCell3.setCellValue("GENERO");
        Cell titleCell4 = titleRow.createCell(6);
        titleCell4.setCellValue("SETOR");
        Cell titleCell5 = titleRow.createCell(8);
        titleCell5.setCellValue("CHSEMANAL");
        Cell titleCell6 = titleRow.createCell(10);
        titleCell6.setCellValue("TREINADO_OPRX");
        Cell titleCell9 = titleRow.createCell(12);
        titleCell9.setCellValue("RUA");
        Cell titleCell10 = titleRow.createCell(14);
        titleCell10.setCellValue("NUMERO");
        Cell titleCell11 = titleRow.createCell(16);
        titleCell11.setCellValue("ESTADO");
        Cell titleCell12 = titleRow.createCell(18);
        titleCell12.setCellValue("CIDADE");
        Cell titleCell13 = titleRow.createCell(20);
        titleCell13.setCellValue("CEP");
        Cell titleCell14 = titleRow.createCell(22);
        titleCell14.setCellValue("BAIRRO");
        Cell titleCell15 = titleRow.createCell(24);
        titleCell15.setCellValue("CELULAR");
        Cell titleCell16 = titleRow.createCell(26);
        titleCell16.setCellValue("TELEFONE");
        Cell titleCell17 = titleRow.createCell(28);
        titleCell17.setCellValue("EMAIL");

        int tamanho = MenuBack.listaDeEnfermeiros.size();
        for (int i = 0; i < tamanho; i++) {
            Row row = sheet.createRow(i + 1); 
            Cell cell1 = row.createCell(0);
            cell1.setCellValue(MenuBack.listaDeEnfermeiros.get(i).getNomePessoal());
            Cell cell2 = row.createCell(2);
            cell2.setCellValue(MenuBack.listaDeEnfermeiros.get(i).getDataNascimento().toString());
            Cell cell3 = row.createCell(4); 
            cell3.setCellValue(MenuBack.listaDeEnfermeiros.get(i).getGenero().name());
            Cell cell4 = row.createCell(6); 
            cell4.setCellValue(MenuBack.listaDeEnfermeiros.get(i).getSetor());
            Cell cell5 = row.createCell(8); 
            cell5.setCellValue(MenuBack.listaDeEnfermeiros.get(i).getChSemanal());
            Cell cell6 = row.createCell(10); 
            cell6.setCellValue((boolean) MenuBack.listaDeEnfermeiros.get(i).isTreinadoOpRX());
            Cell cell9 = row.createCell(12);
            cell9.setCellValue(MenuBack.listaDePaciente.get(i).getEndereco().getRua());
            Cell cell10 = row.createCell(14);
            cell10.setCellValue(MenuBack.listaDePaciente.get(i).getEndereco().getNumero());
            Cell cell11 = row.createCell(16);
            cell11.setCellValue(MenuBack.listaDePaciente.get(i).getEndereco().getEstado());
            Cell cell12 = row.createCell(18);
            cell12.setCellValue(MenuBack.listaDePaciente.get(i).getEndereco().getCidade());
            Cell cell13 = row.createCell(20);
            cell13.setCellValue(MenuBack.listaDePaciente.get(i).getEndereco().getCep());
            Cell cell14 = row.createCell(22);
            cell14.setCellValue(MenuBack.listaDePaciente.get(i).getEndereco().getBairro());
            Cell cell15 = row.createCell(24); 
            cell15.setCellValue(MenuBack.listaDePaciente.get(i).getContato().getCelular());
            Cell cell16 = row.createCell(26); 
            cell16.setCellValue(MenuBack.listaDePaciente.get(i).getContato().getTelefone());
            Cell cell17 = row.createCell(28); 
            cell17.setCellValue(MenuBack.listaDePaciente.get(i).getContato().getEmail());
        
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }
    }
}
      public void exportarConsulta(Workbook workbook) throws IOException {
         
        String userHome = System.getProperty("user.home");
        String downloadsPath = userHome + "/Downloads/";
    
        
        String filePath = downloadsPath + name + ".xlsx";

        Sheet sheet = workbook.createSheet("Consulta Medica");
        
        
        Row titleRow = sheet.createRow(0);
        Cell titleCell1 = titleRow.createCell(0);
        titleCell1.setCellValue("ID PACIENTE");
        Cell titleCell2 = titleRow.createCell(2);
        titleCell2.setCellValue("ID MEDICO");
        Cell titleCell3 = titleRow.createCell(4);
        titleCell3.setCellValue("EXAME QUEIXA");
        Cell titleCell4 = titleRow.createCell(6);
        titleCell4.setCellValue("DIAGNOSTICO");
        Cell titleCell5 = titleRow.createCell(8);
        titleCell5.setCellValue("PRESCRIÇÃO");
        Cell titleCell6 = titleRow.createCell(10);
        titleCell6.setCellValue("INDICAÇÃO CIRURGICA");
        

        int tamanho = MenuBack.listaDeConsultaMedica.size();
        for (int i = 0; i < tamanho; i++) {
            Row row = sheet.createRow(i + 1); 
            Cell cell1 = row.createCell(0);
            cell1.setCellValue(MenuBack.listaDeConsultaMedica.get(i).getIdPaciente().toString());
            Cell cell3 = row.createCell(2);
            cell3.setCellValue(MenuBack.listaDeConsultaMedica.get(i).getIdMedico().toString());
            Cell cell4 = row.createCell(4); 
            cell4.setCellValue(MenuBack.listaDeConsultaMedica.get(i).getExameQueixa());
            Cell cell5 = row.createCell(6); 
            cell5.setCellValue(MenuBack.listaDeConsultaMedica.get(i).getDiagnostico());
            Cell cell7 = row.createCell(8); 
            cell7.setCellValue(MenuBack.listaDeConsultaMedica.get(i).getPrescricao());
            Cell cell8 = row.createCell(10); 
            cell8.setCellValue((boolean)MenuBack.listaDeConsultaMedica.get(i).isIndicacaoCirurgica());

        
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }
    }
}
      public void importarExcel() throws IOException {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Selecione o arquivo Excel");
    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivos Excel (*.xlsx)", "xlsx"));

    int result = fileChooser.showOpenDialog(null);
    if (result == JFileChooser.APPROVE_OPTION) {
        String filePath = fileChooser.getSelectedFile().getAbsolutePath();
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            
            Sheet sheet = workbook.getSheet("paciente");
            if (sheet != null) {
                
                for (Row row : sheet) {
                    
                    String nomePessoal = row.getCell(0).getStringCellValue();
                   String dataNascimentoStr = row.getCell(2).getStringCellValue();
                   Date dataNascimento = null;
                    Cell dataNascimentoCell = row.getCell(2);
            if (dataNascimentoCell != null && dataNascimentoCell.getCellType() == CellType.STRING) {
                    dataNascimentoStr = dataNascimentoCell.getStringCellValue();
            if (!dataNascimentoStr.isEmpty()) {
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    dataNascimento = sdf.parse(dataNascimentoStr);
                } catch (ParseException e) {
                    e.printStackTrace();
            }
        }
    }
                    String obsGeral = row.getCell(8).getStringCellValue();
                    String nomeResponsavel = row.getCell(10).getStringCellValue();
                    String rua = row.getCell(12).getStringCellValue();
                    String numero = row.getCell(14).getStringCellValue();
                    Cell numeroCell = row.getCell(14);
                    int numeroI = 0;
            if (numeroCell != null && numeroCell.getCellType() == CellType.STRING) {
                String numeroStr = numeroCell.getStringCellValue();
            if (!numeroStr.isEmpty()) {
                try {
                    numeroI = Integer.parseInt(numeroStr);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
            }
        }
    }
                    
                    String idade = row.getCell(4).getStringCellValue();
                    int idadeI = Integer.parseInt(idade);
                    String estado = row.getCell(16).getStringCellValue();
                    String cidade = row.getCell(18).getStringCellValue();
                    String cep = row.getCell(20).getStringCellValue();
                    int cepI = Integer.parseInt(cep);
                    String bairro = row.getCell(22).getStringCellValue();
                    String celular = row.getCell(24).getStringCellValue();
                    Long celularI = Long.valueOf(celular);
                    String telefone = row.getCell(26).getStringCellValue();
                    Long telefoneI = Long.valueOf(telefone);
                    String email = row.getCell(28).getStringCellValue();
                    
                    Endereco end = new Endereco(rua, numeroI, bairro, cidade, estado, cepI);
                    ContatoTelEmail cont = new ContatoTelEmail(telefoneI, celularI, email);
                    
                    Date dataAtual = new Date();
                    String dataCadastro = dataAtual.toGMTString();
                    
                    DadoPessoal dado = new DadoPessoal(nomePessoal, dataNascimento, end, cont, Genero.M);
                    Responsavel respo = new Responsavel(nomeResponsavel, cont);
                    
                    Paciente paciente = new Paciente(dado,idadeI,dataCadastro, "", respo);
                    

                    // Crie um novo objeto Paciente com os dados

                    // Adicione o paciente à lista de pacientes
                    MenuBack.listaDePaciente.add(paciente);
                }
            } else {
                
                JOptionPane.showMessageDialog(null, "A aba 'paciente' não foi encontrada no arquivo Excel.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
}
