package controller;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.entidades.Local;
import model.entidades.Motorista;
import model.entidades.Passageiro;
import model.entidades.Viagem;
import model.negocio.ViagemDAO;

/**
 *
 * @author Jarvis
 */
@ManagedBean
@SessionScoped
public class ViagemController {

    private final ViagemDAO viagemHibernate;
    private Viagem cadViagem;
    private Viagem selectedViagem;

    public ViagemController() {
        this.viagemHibernate = new ViagemDAO();
        this.cadViagem = new Viagem();
    }

    public void cadastrar(Local local) {
        Motorista motorista = (Motorista)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("motoristaLogado");
        this.cadViagem.setLocal(local);
        this.cadViagem.setMotorista(motorista);

        this.viagemHibernate.cadastrar(this.cadViagem);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Viagem adicionada com sucesso"));
        this.cadViagem = new Viagem();
    }

    public void alterar() {
        Passageiro passageiro = (Passageiro)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("passageiroLogado");
        this.selectedViagem.getPassageiros().add(passageiro);
        this.viagemHibernate.alterar(this.selectedViagem);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("A viagem alterada"));
    }

    public void deletar() {
        this.viagemHibernate.deletar(this.selectedViagem);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Viagem deletada!"));
    }

    public List<Viagem> recuperarTodas() {
        return this.viagemHibernate.recuperarTodos();
    }
    
    public List<Viagem> recuperarPorMotorista(Motorista motorista){
        return this.viagemHibernate.recuperarPorMotorista(motorista);
    }
    
    public Viagem getCadViagem() {
        return cadViagem;
    }

    public void setCadViagem(Viagem cadViagem) {
        this.cadViagem = cadViagem;
    }

    public Viagem getSelectedViagem() {
        return selectedViagem;
    }

    public void setSelectedViagem(Viagem selectedViagem) {
        this.selectedViagem = selectedViagem;
    }

}
