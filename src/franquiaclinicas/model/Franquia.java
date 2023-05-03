/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package franquiaclinicas.model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author Alunos
 */
public class Franquia {
    private static long serial = 1;
    long id;
    String cidade;
    String endereco;
    String nome;
    String cnpj;
    Pessoa dono;
    LocalDateTime dataCriacao;
    LocalDateTime dataModificacao;

    public Franquia(String cnpj,String nome, String cidade, String endereco, Pessoa p, LocalDateTime dataCriacao) {
        this.id = serial++;
        this.cnpj = cnpj;
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
        this.dono = p;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereço() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Pessoa getP() {
        return dono;
    }

    public void setP(Pessoa p) {
        this.dono = p;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDateTime dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Franquia other = (Franquia) obj;
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.dono, other.dono)) {
            return false;
        }
        if (!Objects.equals(this.dataCriacao, other.dataCriacao)) {
            return false;
        }
        return Objects.equals(this.dataModificacao, other.dataModificacao);
    }

    @Override
    public String toString() {
        return "Franquia \nNome:" + nome + 
                "\nCNPJ:" + cnpj + 
                "\nCidade:" + cidade + 
                "\nEndereço:" + endereco + 
                "\nDono:" + dono.getNome() + "\nCPF:" + dono.getCpf() + 
                "\nData de Criacao:" + dataCriacao + 
                "\nData de Modificação:" + dataModificacao;
    }
    
    
    
}
