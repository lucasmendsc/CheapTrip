package controller;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.entidades.Local;
import model.negocio.LocalDAO;

/**
 *
 * @author Jarvis
 */
@ManagedBean
@SessionScoped
public class LocalController{

    private final LocalDAO localHibernate;
    private Local cadLocal;

    public LocalController() {
        this.localHibernate = new LocalDAO();
        this.cadLocal = new Local();
    }

    public void cadastrar() {
        this.localHibernate.cadastrar(this.cadLocal);
    }

    public Local getCadLocal() {
        return cadLocal;
    }

    public void setCadLocal(Local cadLocal) {
        this.cadLocal = cadLocal;
    }

    public String alterarLocalMotorista(Local local) {
        this.localHibernate.alterar(local);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Local alterado com sucesso!"));
        
        return "visualizaMotorista.xhtml";
    }
    
       public String alterarLocalPassageiro(Local local) {
        this.localHibernate.alterar(local);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Local alterado com sucesso!"));
        
        return "visualizaPassageiro.xhtml";
    }

    public void deletar(Local local) {
        this.localHibernate.deletar(local);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Um local foi deletado."));
    }

    public List<Local> recuperarTodos() {
        return this.localHibernate.recuperarTodos();
    }


}
