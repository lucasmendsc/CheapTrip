package controller;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.entidades.Carro;
import model.negocio.CarroDAO;

/**
 *
 * @author Mark IV
 */
@ManagedBean
@SessionScoped
public class CarroController {

    private final CarroDAO carroDao;
    private Carro cadCarro;
    private Carro selectedCarro;

    public CarroController() {
        this.carroDao = new CarroDAO();
        this.cadCarro = new Carro();
    }

    public void cadastrar() {
        this.carroDao.cadastrar(this.cadCarro);

    }

    public String alterar(Carro carro) {
        this.selectedCarro = carro;
        this.carroDao.alterar(this.selectedCarro);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Carro alterado com sucesso!"));

        return "visualizaMotorista.xhtml";
    }

    public void deletar() {
        this.carroDao.deletar(this.selectedCarro);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O carro foi deletado."));
    }

    public List<Carro> recuperarTodos() {
        return this.carroDao.recuperarTodos();
    }

    public Carro getSelectedCarro() {
        return selectedCarro;
    }

    public void setSelectedCarro(Carro selectedCarro) {
        this.selectedCarro = selectedCarro;
    }

    public Carro getCadCarro() {
        return cadCarro;
    }

    public void setCadCarro(Carro cadCarro) {
        this.cadCarro = cadCarro;
    }

}
