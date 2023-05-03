/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package franquiaclinicas.model;

import java.util.Objects;

/**
 *
 * @author christian
 */
public class Administrativo {
    
    private static long serial = 1;
    private final long id;
    private Pessoa pessoaadm;

    public Administrativo(Pessoa pessoaadm) {
        this.id = serial++;
        this.pessoaadm = pessoaadm;
    }

    public long getId() {
        return id;
    }
    

    public Pessoa getPessoaadm() {
        return pessoaadm;
    }

    public void setPessoaadm(Pessoa pessoaadm) {
        this.pessoaadm = pessoaadm;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 97 * hash + Objects.hashCode(this.pessoaadm);
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
        final Administrativo other = (Administrativo) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.pessoaadm, other.pessoaadm);
    }

    @Override
    public String toString() {
        return "Administrativo{" + "id=" + id + ", pessoaadm=" + pessoaadm + '}';
    }



    
    
    
}
