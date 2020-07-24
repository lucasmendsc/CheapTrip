package model.entidades;

import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Mark IV
 */
@Entity
@ManagedBean
@RequestScoped
public class Passageiro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_passageiro;
    @Column(length = 35,nullable = false)
    private String nome;
    @Column(length = 11,nullable = false,unique = true)
    private String cpf;
    @Column(length = 45)
    private String email;
    @Column(length = 25,nullable = false,unique = true)
    private String login;
    @Column(length = 17,nullable = false)
    private String senha;
    @OneToOne
    @JoinColumn(name = "cod_local",referencedColumnName = "id_local")
    private Local local;
    
    @Deprecated
    public Passageiro() {
    }

    public Passageiro(String nome, String cpf, String email, String login, String senha, Local local) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.local = local;
    }

    public int getId_passageiro() {
        return id_passageiro;
    }

    public void setId_passageiro(int id_passageiro) {
        this.id_passageiro = id_passageiro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Passageiro other = (Passageiro) obj;
        if (this.id_passageiro != other.id_passageiro) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.local, other.local)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Passageiro{" + "id_passageiro=" + id_passageiro + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", login=" + login + ", senha=" + senha + ", local=" + local + '}';
    }

    
}
