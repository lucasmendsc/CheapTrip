package model.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Mark IV
 */
@Entity
public class Local implements Serializable {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id_local;
    @Column(length = 18, nullable = false)
    private String estado;
    @Column(length = 15,nullable = false)
    private String cidade;
    @Column(length = 8)
    private String cep;
    
    @Deprecated
    public Local() {
    }

    public Local(String estado, String cidade, String cep) {
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
    }

    public int getId_local() {
        return id_local;
    }

    public void setId_local(int id_local) {
        this.id_local = id_local;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.id_local;
        hash = 41 * hash + Objects.hashCode(this.estado);
        hash = 41 * hash + Objects.hashCode(this.cidade);
        hash = 41 * hash + Objects.hashCode(this.cep);
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
        final Local other = (Local) obj;
        if (this.id_local != other.id_local) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.cep, other.cep)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Local{" + "id_local=" + id_local + ", estado=" + estado + ", cidade=" + cidade + ", cep=" + cep + '}';
    }
    
    
}
