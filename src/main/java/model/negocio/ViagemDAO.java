package model.negocio;

import java.util.List;
import model.entidades.Motorista;
import model.entidades.Passageiro;
import model.entidades.Viagem;
import model.implementacoes.ViagemHibernateDAO;
import model.interfaces.DAO;

/**
 *
 * @author Jarvis
 */
public class ViagemDAO {
    private final DAO<Viagem> dao;
    
    public ViagemDAO(){
        this.dao = ViagemHibernateDAO.getInstance();
    }
    
    public void cadastrar(Viagem viagem){
        if(((ViagemHibernateDAO)dao).recuperar(viagem.getId_viagem()) == null){
            this.dao.cadastrar(viagem);
        }
    }
    
    public Viagem recuperar(Integer codigo){
        if(codigo == null){
            return null;
        }
        
       return ((ViagemHibernateDAO)dao).recuperar(codigo);
    }
    
    public void deletar(Viagem viagem){
        if(((ViagemHibernateDAO)dao).recuperar(viagem.getId_viagem()) != null){
            this.dao.deletar(viagem);
        }
    }
    
    public void alterar(Viagem viagem){
      if(((ViagemHibernateDAO)dao).recuperar(viagem.getId_viagem()) != null){
            this.dao.alterar(viagem);
      }
    }
    
    public List<Viagem> recuperarTodos(){
        return ((ViagemHibernateDAO)dao).recuperarTodos();
    }
    
    public List<Viagem> recuperarPorMotorista(Motorista motorista){
         return ((ViagemHibernateDAO)dao).recuperarPorMotorista(motorista);
    }
}
