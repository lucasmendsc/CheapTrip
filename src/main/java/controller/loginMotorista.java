package controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.entidades.Motorista;

/**
 *
 * @author Jarvis
 */
@ManagedBean(name = "loginMotorista")
@SessionScoped
public class loginMotorista {

    private Motorista motoristaLogado = null;

    public loginMotorista() {
    }

    public String realizarLogin(String login, String senha) {

        List<Motorista> motoristas = new MotoristaController().recuperarTodos();

        for (Motorista m : motoristas) {
            if (m.getLogin().equals(login)) {
                if (m.getSenha().equals(senha)) {
                    this.motoristaLogado = m;
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("motoristaLogado", m);
                    return "visualizaMotorista.xhtml";
                }
            }
        }

        return "";
    }

    public Motorista getMotoristaLogado() {
        return motoristaLogado;
    }

    public void setMotoristaLogado(Motorista motoristaLogado) {
        this.motoristaLogado = motoristaLogado;
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        this.motoristaLogado = null;
        return "index.xhtml";

    }

}
