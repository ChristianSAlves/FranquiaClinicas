/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package franquiaclinicas.dao;

import franquiaclinicas.model.Medico;
import franquiaclinicas.model.Pessoa;
import java.time.LocalDateTime;

/**
 *
 * @author Alunos
 */
public class MedicoDAO {

    public static Medico[] medicos = new Medico[5];

    public MedicoDAO(PessoaDAO pessoaDAO) {
        Pessoa pessoaencontrada = pessoaDAO.buscaPorNome("Geraldo");
        Medico medico = new Medico("161616", "Urologista", pessoaencontrada);
        Pessoa pessoamedi = new Pessoa(pessoaencontrada.getNome(), pessoaencontrada.getEndereco(),
                                pessoaencontrada.getCpf(), pessoaencontrada.getTelefone(), "Geraldin", "123", 
                                "Medico", "Ativo", 
                                LocalDateTime.now());
                        
                        pessoaDAO.adicionaPessoa(pessoamedi);
        adicionaMedico(medico);

        Pessoa pessoaachada = pessoaDAO.buscaPorNome("Peterson");
        Medico medicopetin = new Medico("211407", "Cirurgião", pessoaachada);
        Pessoa pessoamed = new Pessoa(pessoaencontrada.getNome(), pessoaencontrada.getEndereco(),
                pessoaencontrada.getCpf(), pessoaencontrada.getTelefone(), "petindoutor", "123",
                "Medico", "Ativo",
                LocalDateTime.now());

        pessoaDAO.adicionaPessoa(pessoamed);
        adicionaMedico(medicopetin);
    }

    public boolean adicionaMedico(Medico m) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            medicos[proximaPosicaoLivre] = m;
            return true;
        } else {
            return false;
        }

    }

    public boolean ehVazio() {
        for (Medico medicoe : medicos) {
            if (medicoe != null) {
                return false;
            }
        }
        return true;

    }

    public void mostrarTodos() {
        boolean temMedico = false;
        for (Medico m : medicos) {
            if (m != null) {
                System.out.println(m);
                temMedico = true;
            }
        }
        if (!temMedico) {
            System.out.println("não existe medico cadastrado");
        }
    }

    public boolean alterarCRM(String CRM, String novoCRM) {
        for (Medico medicoe : medicos) {
            if (medicoe != null && medicoe.getCRM().equals(CRM)) {
                medicoe.setCRM(novoCRM);
                return true;
            }
        }
        return false;

    }

    public boolean alterarEspecialidade(String CRM, String novaEspecialidade) {
        for (Medico medicoe : medicos) {
            if (medicoe != null && medicoe.getCRM().equals(CRM)) {
                medicoe.setEspecialiadade(novaEspecialidade);
                return true;
            }
        }
        return false;

    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < medicos.length; i++) {
            if (medicos[i] == null) {
                return i;
            }

        }
        return -1;

    }
    
    public Medico buscaPorCRM(String crm) {
        for (Medico m : medicos) {
            if (m != null && m.getCRM().equals(crm)) {
                return m;
            }
        }
        return null;

    }

}
