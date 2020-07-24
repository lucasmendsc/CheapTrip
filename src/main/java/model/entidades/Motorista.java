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
public class Motorista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_motorista;
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
    @OneToOne
    @JoinColumn(name = "cod_carro",referencedColumnName = "id_carro")
    private Carro carro;
    
    @Deprecated
    public Motorista() {
    }

    public Motorista(String nome, String cpf, String email, String login, String senha, Local local, Carro carro) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.local = local;
        this.carro = carro;
    }

    public int getId_motorista() {
        return id_motorista;
    }

    public void setId_motorista(int id_motorista) {
        this.id_motorista = id_motorista;
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

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
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
        final Motorista other = (Motorista) obj;
        if (this.id_motorista != other.id_motorista) {
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
        if (!Objects.equals(this.carro, other.carro)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Motorista{" + "id_motorista=" + id_motorista + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", login=" + login + ", senha=" + senha + ", local=" + local + ", carro=" + carro + '}';
    }

   
  
}
