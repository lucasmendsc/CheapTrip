package model.negocio;

import java.util.List;
import model.entidades.Carro;
import model.implementacoes.CarroHibernateDAO;
import model.interfaces.DAO;

/**
 *
 * @author Jarvis
 */
public class CarroDAO {
    private final DAO<Carro> dao;

    public CarroDAO() {
        dao = CarroHibernateDAO.getInstance();
    }
    public void cadastrar(Carro carro){
      
            this.dao.cadastrar(carro);
       
    }
    
    public void alterar(Carro carro){
        if(((CarroHibernateDAO)dao).getInstance().recuperar(carro.getId_carro()) != null){
            this.dao.alterar(carro);
        }
    }
    
     public void deletar(Carro carro){
        if(((CarroHibernateDAO)dao).getInstance().recuperar(carro.getId_carro()) != null){
            this.dao.deletar(carro);
        }
    }
     
      public Carro recuperar(Integer codigo){
        if(codigo == null){
            return null;
        }
        return ((CarroHibernateDAO)dao).recuperar(codigo);
    }
      
      public List<Carro> recuperarTodos(){
          return ((CarroHibernateDAO)dao).getInstance().recuperarTodos();
      }
}
