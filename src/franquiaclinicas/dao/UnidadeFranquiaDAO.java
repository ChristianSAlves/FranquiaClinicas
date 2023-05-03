 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package franquiaclinicas.dao;

import franquiaclinicas.model.Administrativo;
import franquiaclinicas.model.Franquia;
import franquiaclinicas.model.UnidadeFranquia;
import java.time.LocalDateTime;

/**
 *
 * @author canad
 */
public class UnidadeFranquiaDAO {
    
    public static UnidadeFranquia[] unidades = new UnidadeFranquia[5];

    public UnidadeFranquiaDAO(AdministrativoDAO admDAO, FranquiaDAO franquiaDAO) {
        Franquia franquiaEncontrada = franquiaDAO.buscaPorCNPJ("51616");
        Administrativo admEncontrado = admDAO.buscaPorID(1);
        UnidadeFranquia unidadeum = new UnidadeFranquia(franquiaEncontrada, "Uberaba", "Nene Sabino", 
                admEncontrado, LocalDateTime.now(), LocalDateTime.now());
        adicionaUF(unidadeum);
    }
    
    
    
    public boolean adicionaUF(UnidadeFranquia uf) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            unidades[proximaPosicaoLivre] = uf;
            return true;
        } else {
            return false;
        }

    }
    
    public UnidadeFranquia buscaPorID(int id) {
        for (UnidadeFranquia u : unidades) {
            if (u != null && u.getId()==(id)) {
                return u;
            }
        }
        return null;

    }

    public boolean ehVazio() {
        for (UnidadeFranquia unidadee : unidades) {
            if (unidadee != null) {
                return false;
            }
        }
        return true;

    }

    public void mostrarTodos() {
        boolean temUnidade = false;
        for (UnidadeFranquia uf : unidades) {
            if (uf != null) {
                System.out.println(uf);
                temUnidade = true;
            }
        }
        if (!temUnidade) {
            System.out.println("não existe pessoa cadastrada");
        }
    }


    public boolean alterarEndereco(String endereco, String novoEndereco) {
        for (UnidadeFranquia unidadee : unidades) {
            if (unidadee != null && unidadee.getEndereco().equals(endereco)) {
                unidadee.setEndereco(novoEndereco);
                return true;
            }
        }
        return false;

    }

    public UnidadeFranquia buscaPorEndereco(String endereco) {
        for (UnidadeFranquia uf : unidades) {
            if (uf != null && uf.getEndereco().equals(endereco)) {
                return uf;
            }
        }
        return null;

    }

    public boolean removerUnidade(String cidade, String Endereco) {
        for (int i = 0; i < unidades.length; i++) {
            if (unidades[i] != null && unidades[i].getCidade().equals(cidade) && unidades[i].getEndereco().equals(Endereco) ) {
                unidades[i] = null;
                return true;
            }
        }
        return false;

    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < unidades.length; i++) {
            if (unidades[i] == null) {
                return i;
            }

        }
        return -1;

    }
    
}
