package model.negocio;

import java.util.List;
import model.entidades.Local;
import model.implementacoes.LocalHibernateDAO;
import model.interfaces.DAO;

/**
 *
 * @author Jarvis
 */
public class LocalDAO {
    private final DAO<Local> dao;

    public LocalDAO() {
        this.dao = LocalHibernateDAO.getInstance();
    }
        
    
    public void cadastrar(Local local){
        if(((LocalHibernateDAO)dao).recuperar(local.getId_local()) == null){
            this.dao.cadastrar(local);
        }
    }
    
    public void alterar(Local local){
      if(((LocalHibernateDAO)dao).recuperar(local.getId_local()) == null){
            this.dao.alterar(local);
        }
    }
    
    public void deletar(Local local){
        if(((LocalHibernateDAO)dao).recuperar(local.getId_local()) != null){
            this.dao.alterar(local);
        }
    }
    
    public Local recuperar(Integer codigo){
        if(codigo == null){
            return null;
        }
        
        return ((LocalHibernateDAO) dao).recuperar(codigo);
    }
    
    public List<Local> recuperarTodos(){
        return ((LocalHibernateDAO)dao).recuperarTodos();
    }
}
