/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package franquiaclinicas.dao;

import franquiaclinicas.model.Pessoa;
import java.time.LocalDateTime;

public class PessoaDAO {

    public static Pessoa[] pessoas = new Pessoa[25];

    public PessoaDAO() {
        Pessoa pessoa = new Pessoa("Cleiton", "Ruas dos marajos", "123", "98484981", 
                "cleitin", "123", "Paciente", "Ativo", LocalDateTime.now());
        adicionaPessoa(pessoa);
        
        Pessoa p = new Pessoa("Christian", "Marcos xerem", "321", "998484894", 
                "chris17", "123", "Paciente", "Ativo", LocalDateTime.now());
        adicionaPessoa(p);  
        
        Pessoa pa = new Pessoa("Geraldo", "Ruas dos marajos", "123", "98484981", 
                "Gerardo", "123", "Paciente", "Ativo", LocalDateTime.now());
        adicionaPessoa(pa);
        
        Pessoa pdono = new Pessoa("Eduardo", "Ruas dos carneiros", "123", "9486951895", 
                "dudu", "123", "Paciente", "Ativo", LocalDateTime.now());
        adicionaPessoa(pdono);
        
        Pessoa kaio = new Pessoa("Kaio", "Rua Marechal Davi Bizinoto", "456", "4941919", 
                "kaiozera", "123", "Paciente", "Ativo", LocalDateTime.now());
        adicionaPessoa(kaio);
        
        Pessoa petim = new Pessoa("Peterson", "Rua Sei la", "666666666", "9419191591",
               "petin", "123", "Paciente", "Ativo", LocalDateTime.now());
        adicionaPessoa(petim);
        
        Pessoa fafa = new Pessoa("Fabricia", "Caricio Afonso de Almeida", "5619191", "984201415", 
                "fafa", "123", "Paciente", "Ativo", LocalDateTime.now());
        adicionaPessoa(fafa);
    }

    public boolean adicionaPessoa(Pessoa p) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            pessoas[proximaPosicaoLivre] = p;
            return true;
        } else {
            return false;
        }

    }

    public boolean ehVazio() {
        for (Pessoa pessoae : pessoas) {
            if (pessoae != null) {
                return false;
            }
        }
        return true;

    }

    public void mostrarTodos() {
        boolean temPessoa = false;
        for (Pessoa p : pessoas) {
            if (p != null) {
                System.out.println(p);
                temPessoa = true;
            }
        }
        if (!temPessoa) {
            System.out.println("não existe pessoa cadastrada");
        }
    }

    public boolean alterarNome(String nome, String novoNome, String cpf) {
        for (Pessoa pessoae : pessoas) {
            if (pessoae != null && pessoae.getNome().equals(nome) && pessoae.getCpf().equals(cpf)) {
                pessoae.setNome(novoNome);
                return true;
            }
        }
        return false;

    }

    public boolean alterarTelefone(String nome, String novoTelefone) {
        for (Pessoa pessoae : pessoas) {
            if (pessoae != null && pessoae.getNome().equals(nome)) {
                pessoae.setTelefone(novoTelefone);
                return true;
            }
        }
        return false;

    }

    public boolean alterarEndereco(String nome, String novoEndereco) {
        for (Pessoa pessoae : pessoas) {
            if (pessoae != null && pessoae.getNome().equals(nome)) {
                pessoae.setTelefone(novoEndereco);
                return true;
            }
        }
        return false;

    }

    public boolean alterarStatus(String nome) {
        for (Pessoa pessoae : pessoas) {
            if (pessoae != null && pessoae.getNome().equals(nome)) {
                if (pessoae.getStatus().equals("Ativo")) {
                    pessoae.setStatus("Inativo");
                    return true;
                } else {
                    pessoae.setStatus("Ativo");
                    return true;
                }
            }
        }
        return false;

    }

    public Pessoa buscaPorNome(String nome) {
        for (Pessoa p : pessoas) {
            if (p != null && p.getNome().equals(nome)) {
                return p;
            }
        }
        return null;

    }

    public boolean remover(String nome) {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null && pessoas[i].getNome().equals(nome)) {
                pessoas[i] = null;
                return true;
            }
        }
        return false;

    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] == null) {
                return i;
            }

        }
        return -1;

    }

    public Pessoa Login(String login, String senha) {

        for (Pessoa pessoa : pessoas) {
            if (pessoa != null && pessoa.getLogin().equals(login) && pessoa.getSenha().equals(senha)) {
                return pessoa;
            }
        }
        return null;
    }

    

}
