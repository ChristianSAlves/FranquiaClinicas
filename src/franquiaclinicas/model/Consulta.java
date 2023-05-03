/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package franquiaclinicas.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 *
 * @author canad
 */
public class Consulta {

    private static long serial = 1; 
    private long id;
    private LocalDate dia;
    private LocalTime horario;
    private String estado;
    private Medico m;
    private Pessoa p;
    private double valor;
    private UnidadeFranquia uf;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public Consulta(LocalDate dia, LocalTime horário, String estado, Medico m, Pessoa p, double valor, UnidadeFranquia uf, LocalDateTime dataCriacao, LocalDateTime dataModificacao) {
        this.id = serial++;
        this.dia = dia;
        this.horario = horário;
        this.estado = estado;
        this.m = m;
        this.p = p;
        this.valor = valor;
        this.uf = uf;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
    }

    public long getId() {
        return id;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public LocalTime getHorário() {
        return horario;
    }

    public void setHorário(LocalTime horário) {
        this.horario = horário;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Medico getM() {
        return m;
    }

    public void setM(Medico m) {
        this.m = m;
    }

    public Pessoa getP() {
        return p;
    }

    public void setP(Pessoa p) {
        this.p = p;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public UnidadeFranquia getUf() {
        return uf;
    }

    public void setUf(UnidadeFranquia uf) {
        this.uf = uf;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.dia);
        hash = 43 * hash + Objects.hashCode(this.horario);
        hash = 43 * hash + Objects.hashCode(this.estado);
        hash = 43 * hash + Objects.hashCode(this.m);
        hash = 43 * hash + Objects.hashCode(this.p);
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.valor) ^ (Double.doubleToLongBits(this.valor) >>> 32));
        hash = 43 * hash + Objects.hashCode(this.uf);
        hash = 43 * hash + Objects.hashCode(this.dataCriacao);
        hash = 43 * hash + Objects.hashCode(this.dataModificacao);
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
        final Consulta other = (Consulta) obj;
        if (this.valor != other.valor) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.dia, other.dia)) {
            return false;
        }
        if (!Objects.equals(this.horario, other.horario)) {
            return false;
        }
        if (!Objects.equals(this.m, other.m)) {
            return false;
        }
        if (!Objects.equals(this.p, other.p)) {
            return false;
        }
        if (!Objects.equals(this.uf, other.uf)) {
            return false;
        }
        if (!Objects.equals(this.dataCriacao, other.dataCriacao)) {
            return false;
        }
        return Objects.equals(this.dataModificacao, other.dataModificacao);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatadata = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        DateTimeFormatter formatadata1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatadata2 = DateTimeFormatter.ofPattern("HH:mm");

        return "\nConsulta:  ID: " + id + "\nDia:" + formatadata1.format(this.dia) + "    Horario:" +formatadata2.format(this.horario) + 
                "\nEstado:" + estado + "\nMedico: Dr. "
                + m.getP().getNome() + "\nPaciente" + p.getNome() + "\nValor" + valor + "\nUnidade Franquia " + uf.getId()
                + "\nData de Criacao:" + formatadata.format(this.dataCriacao)
                + "  Data de Modificacao:" + formatadata.format(this.dataModificacao);
    }

}
