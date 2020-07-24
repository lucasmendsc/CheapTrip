package controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.entidades.Passageiro;

/**
 *
 * @author Jarvis
 */
@ManagedBean(name = "loginPassageiro")
@SessionScoped
public class loginPassageiro {
    private Passageiro passageiroLogado = null;
    
    public loginPassageiro() {
    }

    public Passageiro getPassageiroLogado() {
        return (Passageiro) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("passageiroLogado");
    }

    public void setPassageiroLogado(Passageiro passageiroLogado) {
       FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("passageiroLogado", passageiroLogado);
    }
    
    public String login(String login,String senha){
        
        List<Passageiro> passageiros = new PassageiroController().recuperarTodos();
        
        for(Passageiro p : passageiros){
            if(p.getLogin().equals(p.getLogin())){
                if(p.getSenha().equals(senha)){
                    this.passageiroLogado = p;
                     FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("passageiroLogado", p);
                    return "menuPassageiro.xhtml";
                }
            }
        }
        
        return "";
    }
    
      public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        this.passageiroLogado = null;
        return "index.xhtml";
    }
    
}
