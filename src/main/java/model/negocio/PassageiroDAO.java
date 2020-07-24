package model.negocio;

import java.util.List;
import model.entidades.Passageiro;
import model.implementacoes.PassageiroHibernateDAO;
import model.interfaces.DAO;

/**
 *
 * @author Jarvis
 */
public class PassageiroDAO {

    private final DAO<Passageiro> dao;

    public PassageiroDAO() {
        this.dao = PassageiroHibernateDAO.getInstance();
    }
    
    public void cadastrar(Passageiro passageiro) {
        if (((PassageiroHibernateDAO) dao).recuperar(passageiro.getId_passageiro()) == null) {
            this.dao.cadastrar(passageiro);
        }
    }

    public void alterar(Passageiro passageiro) {
        if (((PassageiroHibernateDAO) dao).recuperar(passageiro.getId_passageiro()) != null) {
            this.dao.alterar(passageiro);
        }
    }
    
    public Passageiro recuperar(Integer codigo){
        if(codigo == null){
            return null;
        }
        
        return ((PassageiroHibernateDAO)dao).recuperar(codigo);
    }
    
    public void deletar(Passageiro passageiro){
        if(((PassageiroHibernateDAO)dao).recuperar(passageiro.getId_passageiro()) != null){
            this.dao.deletar(passageiro);
        }
    }
    
    public List<Passageiro> recuperarTodos(){
        return ((PassageiroHibernateDAO)dao).recuperarTodos();
    }
    
    public boolean login(String login,String senha){
        if(login == null || senha == null){
            return false;
        }
        
        return ((PassageiroHibernateDAO)dao).login(login, senha);
    }
}
