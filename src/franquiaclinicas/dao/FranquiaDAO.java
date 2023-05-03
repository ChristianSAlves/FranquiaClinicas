/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package franquiaclinicas.dao;

import franquiaclinicas.model.Franquia;
import franquiaclinicas.model.Pessoa;
import java.time.LocalDateTime;

/**
 *
 * @author Alunos
 */
public class FranquiaDAO {

    Franquia[] franquias = new Franquia[3];

    public FranquiaDAO(PessoaDAO pessoaDAO) {

        //Criaçao da franquia
        Pessoa pessoaencontrada = pessoaDAO.buscaPorNome("Eduardo");

        Pessoa pessoadono = new Pessoa(pessoaencontrada.getNome(), pessoaencontrada.getEndereco(),
                pessoaencontrada.getCpf(), pessoaencontrada.getTelefone(), "dududono", "123",
                "Dono Franquia", "Ativo",
                LocalDateTime.now());

        //Adicionando Pessoa com status de dono no sistema
        pessoaDAO.adicionaPessoa(pessoadono);

        Franquia donofranquia = new Franquia("51616", "TrataMED", "Uberaba",
                "Av. Dr. Florestan Fernandes", pessoadono, LocalDateTime.now());

        adiciona(donofranquia);

    }

    public boolean adiciona(Franquia f) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            franquias[proximaPosicaoLivre] = f;
            return true;
        } else {
            return false;
        }

    }

    public boolean ehVazio() {
        for (Franquia franquiae : franquias) {
            if (franquiae != null) {
                return false;
            }
        }
        return true;

    }

    public void mostrarTodos() {
        boolean temFranquia = false;
        for (Franquia f : franquias) {
            if (f != null) {
                System.out.println(f);
                temFranquia = true;
            }
        }
        if (!temFranquia) {
            System.out.println("não existe franquia cadastrada");
        }
    }

    public boolean remover(String endereco) {
        for (int i = 0; i < franquias.length; i++) {
            if (franquias[i] != null && franquias[i].getEndereço().equals(endereco)) {
                franquias[i] = null;
                return true;
            }
        }
        return false;

    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < franquias.length; i++) {
            if (franquias[i] == null) {
                return i;
            }

        }
        return -1;

    }
    
    public Franquia buscaPorCNPJ(String cnpj) {
        for (Franquia f : franquias) {
            if (f != null && f.getCnpj().equals(cnpj)) {
                return f;
            }
        }
        return null;

    }

}
