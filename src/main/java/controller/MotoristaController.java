package controller;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.entidades.Carro;
import model.entidades.Local;
import model.entidades.Motorista;
import model.negocio.MotoristaDAO;

/**
 *
 * @author Mark IV
 */
@ManagedBean
@SessionScoped
public class MotoristaController {

    private final MotoristaDAO motoristaHibernate;
    private Motorista cadMotorista;

    public MotoristaController() {
        this.motoristaHibernate = new MotoristaDAO();
        this.cadMotorista = new Motorista();
    }

    public String cadastrar(Local local, Carro carro) {
        this.cadMotorista.setLocal(local);
        this.cadMotorista.setCarro(carro);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Motorista cadastrado com sucesso!"));
        this.motoristaHibernate.cadastrar(this.cadMotorista);

        this.cadMotorista = new Motorista();


        return "loginMotorista.xhtml";
    }

    public String alterar(Motorista motorista) {
        this.motoristaHibernate.alterar(motorista);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Motorista alterado com sucesso!"));

        return "menuMotorista.xhtml";
    }

    public String deletar(Motorista motorista) {
        this.motoristaHibernate.deletar(motorista);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Motorista deletado com sucesso!"));

        return "index.xhtml";
    }


    public List<Motorista> recuperarTodos() {
        return this.motoristaHibernate.recuperarTodos();
    }

    public boolean login(String login,String senha) {
       return this.motoristaHibernate.login(login, senha);
    }

    public Motorista getCadMotorista() {
        return cadMotorista;
    }

    public void setCadMotorista(Motorista cadMotorista) {
        this.cadMotorista = cadMotorista;
    }

}
