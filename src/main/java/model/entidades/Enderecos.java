package model.entidades;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Jarvis
 */
@ManagedBean(name = "enderecos")
public class Enderecos {
    private List<String> estados = new ArrayList<>();
    private List<String> cidades = new ArrayList<>();
    
    
    public Enderecos() {
    }

    public List<String> getEstados() {
        return estados;
    }

    public void setEstados(List<String> estados) {
        this.estados = estados;
    }

    public List<String> getCidades() {
        return cidades;
    }

    public void setCidades(List<String> cidades) {
        this.cidades = cidades;
    }
    
    public void estados(){
        
    }
    
    public void cidadesPernambuco(){
        
    }
    
}
