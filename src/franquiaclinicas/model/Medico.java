/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package franquiaclinicas.model;

import java.util.Objects;

/**
 *
 * @author canad
 */
public class Medico {
    
    private static long serial = 1;
    private long id;
    private String CRM;
    private String especialidade;
    private Pessoa p;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public String getEspecialiadade() {
        return especialidade;
    }

    public void setEspecialiadade(String especialiadade) {
        this.especialidade = especialiadade;
    }

    public Pessoa getP() {
        return p;
    }

    public void setP(Pessoa p) {
        this.p = p;
    }

    public Medico(String CRM, String especialiadade, Pessoa p) {
        this.id = serial++;
        this.CRM = CRM;
        this.especialidade = especialiadade;
        this.p = p;
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
        final Medico other = (Medico) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.CRM, other.CRM)) {
            return false;
        }
        if (!Objects.equals(this.especialidade, other.especialidade)) {
            return false;
        }
        return Objects.equals(this.p, other.p);
    }

    @Override
    public String toString() {
        return "Medico" + "Id:" + id + "\nCRM:" + CRM + "\nEspecialiadade:" + especialidade + "\n Nome:" + p.getNome();
    }

    

    
    
    
}
