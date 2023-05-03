/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package franquiaclinicas.dao;

import franquiaclinicas.model.Administrativo;
import franquiaclinicas.model.Pessoa;
import java.time.LocalDateTime;

/**
 *
 * @author Alunos
 */
public class AdministrativoDAO {
    
        Administrativo[] administrativos = new Administrativo[5];
        
        public AdministrativoDAO(PessoaDAO pessoaDAO) {
        Pessoa pessoaencontrada = pessoaDAO.buscaPorNome("Kaio");
        Pessoa pessoaADM = new Pessoa(pessoaencontrada.getNome(), pessoaencontrada.getEndereco(),
                                pessoaencontrada.getCpf(), pessoaencontrada.getTelefone(), "kaioadm", "123", 
                                "Administrativo", "Ativo", 
                                LocalDateTime.now());
        pessoaDAO.adicionaPessoa(pessoaADM);
        Administrativo adm = new Administrativo(pessoaADM);
        adicionaADM(adm);
    }


   boolean adicionaADM(Administrativo a) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            administrativos[proximaPosicaoLivre] = a;
            return true;
        } else {
            return false;
        }

    }
   
    public Administrativo buscaPorID(int id) {
        for (Administrativo a : administrativos) {
            if (a != null && a.getId()==(id)) {
                return a;
            }
        }
        return null;

    }

    public boolean ehVazio() {
        for (Administrativo administrativoe : administrativos) {
            if (administrativoe != null) {
                return false;
            }
        }
        return true;

    }

    public void mostrarTodos() {
        boolean temADM = false;
        for (Administrativo a : administrativos) {
            if (a != null) {
                System.out.println(a);
                temADM = true;
            }
        }
        if (!temADM) {
            System.out.println("não existe funcionario administrativo cadastrado cadastrado");
        }
    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < administrativos.length; i++) {
            if (administrativos[i] == null) {
                return i;
            }

        }
        return -1;

    }
    
}
