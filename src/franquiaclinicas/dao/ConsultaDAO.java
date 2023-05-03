/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package franquiaclinicas.dao;

import franquiaclinicas.model.Consulta;
import franquiaclinicas.model.Medico;
import franquiaclinicas.model.Pessoa;
import franquiaclinicas.model.UnidadeFranquia;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author canad
 */
public class ConsultaDAO {
    
    Consulta[] consultas = new Consulta[15];
   

    public ConsultaDAO(PessoaDAO pessoaDAO, MedicoDAO medicoDAO, UnidadeFranquiaDAO unidadeDAO) {

        Pessoa buscaPaciente = pessoaDAO.buscaPorNome("Fabricia");
        Medico buscaMedico = medicoDAO.buscaPorCRM("211407");
        UnidadeFranquia uf = unidadeDAO.buscaPorEndereco("Nene Sabino");
        String dataString = "20/05/2023";
        LocalDate data = LocalDate.parse(dataString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String horaString = "15:30";
        LocalTime hora = LocalTime.parse(horaString, DateTimeFormatter.ofPattern("HH:mm"));
        Consulta consulta = new Consulta(data, hora, "Agendada", buscaMedico, buscaPaciente, 300.5, uf,
                LocalDateTime.now(), LocalDateTime.now());
        adicionaConsulta(consulta);
        
        Pessoa buscaPaciente1 = pessoaDAO.buscaPorNome("Fabricia");
        Medico buscaMedico1 = medicoDAO.buscaPorCRM("161616");
        UnidadeFranquia uf1 = unidadeDAO.buscaPorEndereco("Nene Sabino");
        String dataString1 = "25/05/2023";
        LocalDate data1 = LocalDate.parse(dataString1, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String horaString1 = "16:30";
        LocalTime hora1 = LocalTime.parse(horaString1, DateTimeFormatter.ofPattern("HH:mm"));
        Consulta consulta1 = new Consulta(data1, hora, "Agendada", buscaMedico1, buscaPaciente1, 500.90, uf,
                LocalDateTime.now(), LocalDateTime.now());
        adicionaConsulta(consulta1);
    }

    public boolean adicionaConsulta(Consulta c) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            consultas[proximaPosicaoLivre] = c;
            return true;
        } else {
            return false;
        }

    }

    public boolean ehVazio() {
        for (Consulta consultae : consultas) {
            if (consultae != null) {
                return false;
            }
        }
        return true;

    }

    public void mostrarTodasConsultas() {
        boolean temUnidade = false;
        for (Consulta c : consultas) {
            if (c != null) {
                System.out.println(c);
                temUnidade = true;
            }
        }
        if (!temUnidade) {
            System.out.println("não nenhuma consulta");
        }
    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < consultas.length; i++) {
            if (consultas[i] == null) {
                return i;
            }
        }
        return -1;

    }
    
    public Consulta buscaPorConsulta(int id) {
        for (Consulta c : consultas) {
            if (c != null && c.getId()==(id)) {
                return c;
            }
        }
        return null;

    }

    public Consulta[] buscarConsultasPorPaciente(Pessoa paciente, Consulta[] consultas) {
    Consulta[] consultasDoPaciente = new Consulta[consultas.length];
    int i = 0;
    for (Consulta consulta : consultas) {
        if (consulta.getP().equals(paciente)) {
            consultasDoPaciente[i] = consulta;
            i++;
        }
    }
    // caso não tenha encontrado nenhuma consulta para o paciente, retorna null
    if (i == 0) {
        return null;
    }
    // cria um novo vetor com tamanho igual ao número de consultas encontradas
    Consulta[] resultado = new Consulta[i];
    for (int j = 0; j < i; j++) {
        resultado[j] = consultasDoPaciente[j];
    }
    return resultado;
}
    
}
