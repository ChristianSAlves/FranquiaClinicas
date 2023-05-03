     /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package franquiaclinicas.model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author canad
 */
public class UnidadeFranquia {
    
    private static long serial = 1;
    private long id;
    private Franquia fu;
    private String cidade;
    private String endereco;
    private Administrativo responsavel;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public static long getSerial() {
        return serial;
    }

    public static void setSerial(long serial) {
        UnidadeFranquia.serial = serial;
    }

    public long getId() {
        return id;
    } 

    public Franquia getFu() {
        return fu;
    }

    public void setFu(Franquia fu) {
        this.fu = fu;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Administrativo getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Administrativo responsavel) {
        this.responsavel = responsavel;
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

    public UnidadeFranquia(Franquia fu, String cidade, String endereco, Administrativo responsavel, LocalDateTime dataCriacao, LocalDateTime dataModificacao) {
        this.id = serial++;
        this.fu = fu;
        this.cidade = cidade;
        this.endereco = endereco;
        this.responsavel = responsavel;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
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
        final UnidadeFranquia other = (UnidadeFranquia) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.fu, other.fu)) {
            return false;
        }
        if (!Objects.equals(this.responsavel, other.responsavel)) {
            return false;
        }
        if (!Objects.equals(this.dataCriacao, other.dataCriacao)) {
            return false;
        }
        return Objects.equals(this.dataModificacao, other.dataModificacao);
    }

    @Override
    public String toString() {
        return "Unidade da Franquia:"
                + "\nID:" + id + 
                "\nUnidade da Franquia:" + fu + 
                "\nCidade:" + cidade + 
                "\nEndereço:" + endereco + 
                "\nResponsavel:" + responsavel.getPessoaadm()+ 
                "\nData de Criação:" + dataCriacao;
    }
    
    
    
    
    
    
}
