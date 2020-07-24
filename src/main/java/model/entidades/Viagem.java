package model.entidades;

import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Mark IV
 */
@Entity
public class Viagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_viagem;
    @OneToOne
    @JoinColumn(name = "cod_motorista",referencedColumnName = "id_motorista")
    private Motorista motorista;
    @OneToOne
    @JoinColumn(name = "cod_local",referencedColumnName = "id_local")
    private Local local;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Passageiro> passageiros;

    @Deprecated
    public Viagem() {
    }

    public Viagem(Motorista motorista, Local local, List<Passageiro> passageiros) {
        this.motorista = motorista;
        this.local = local;
        this.passageiros = passageiros;
    }

    public int getId_viagem() {
        return id_viagem;
    }

    public void setId_viagem(int id_viagem) {
        this.id_viagem = id_viagem;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public List<Passageiro> getPassageiros() {
        return passageiros;
    }

    public void setPassageiros(List<Passageiro> passageiros) {
        this.passageiros = passageiros;
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
        final Viagem other = (Viagem) obj;
        if (this.id_viagem != other.id_viagem) {
            return false;
        }
        if (!Objects.equals(this.motorista, other.motorista)) {
            return false;
        }
        if (!Objects.equals(this.local, other.local)) {
            return false;
        }
        if (!Objects.equals(this.passageiros, other.passageiros)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Viagem{" + "id_viagem=" + id_viagem + ", motorista=" + motorista + ", local=" + local + ", passageiros=" + passageiros + '}';
    }
    
}
