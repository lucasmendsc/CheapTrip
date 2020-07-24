package controller;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.entidades.Local;
import model.entidades.Passageiro;
import model.negocio.PassageiroDAO;

/**
 *
 * @author Jarvis
 */
@ManagedBean
@SessionScoped
public class PassageiroController {
    private final PassageiroDAO passageiroHibernate;
    private Passageiro cadPassageiro;
    private Passageiro selectedPassageiro = (Passageiro)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("passageiroLogado");

    public PassageiroController() {
        this.passageiroHibernate = new PassageiroDAO();
        this.cadPassageiro = new Passageiro();
    }
    
    public String cadastrar(Local local){
        this.cadPassageiro.setLocal(local);
        this.passageiroHibernate.cadastrar(this.cadPassageiro);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastro realizado com sucesso!"));
        this.cadPassageiro = new Passageiro();
        return "loginPassageiro.xhtml";
    }
    
    public String alterar(Passageiro passageiro){
        this.passageiroHibernate.alterar(passageiro);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Passageiro " + this.selectedPassageiro.getNome() + " alterado com sucesso"));
        
        return "visualizaPassageiro.xhtml";
    }
    
    public String deletar(Passageiro passageiro){
        this.passageiroHibernate.deletar(passageiro);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O passageiro  foi deletado"));

        return "index.xhtml";
    }
    
    public List<Passageiro> recuperarTodos(){
        return this.passageiroHibernate.recuperarTodos();
    }

    public Passageiro getCadPassageiro() {
        return cadPassageiro;
    }

    public void setCadPassageiro(Passageiro cadPassageiro) {
        this.cadPassageiro = cadPassageiro;
    }

    public Passageiro getSelectedPassageiro() {
        return selectedPassageiro;
    }

    public void setSelectedPassageiro(Passageiro selectedPassageiro) {
        this.selectedPassageiro = selectedPassageiro;
    }
    
    
}
