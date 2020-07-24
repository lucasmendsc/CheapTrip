package model.implementacoes;

import java.util.List;
import model.entidades.Passageiro;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import model.interfaces.PassageiroInterfaceDAO;

/**
 *
 * @author Mark IV
 */
public class PassageiroHibernateDAO implements PassageiroInterfaceDAO {
    private SessionFactory sessions;
    private static PassageiroHibernateDAO instance;
    
    public static PassageiroHibernateDAO getInstance(){
        if(instance == null){
            instance = new PassageiroHibernateDAO();
        }
        return instance;
    }

    private PassageiroHibernateDAO() {
        Configuration cfg = new Configuration().configure();
        this.sessions = cfg.buildSessionFactory();
    }

    @Override
    public void cadastrar(Passageiro passageiro){
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        try{
            session.persist(passageiro);
            t.commit();
        }catch(Exception cadPassageiroError){
            System.out.println(cadPassageiroError.getCause() +
                    "\nOcorreu um erro ao cadastrar um passageiro");
        }finally{
            session.close();
        }
    }
    
    @Override
    public Passageiro recuperar(int codigo){
       Session session = this.sessions.openSession();
        
        try{
            return (Passageiro) session.createQuery("From Passageiro Where id_passageiro=" + codigo).getResultList().get(0);
        }catch(Exception recPassageiroError){
            System.out.println(recPassageiroError.getCause()
            + "\nOcorreu um erro ao recuperar um passageiro");
        }finally{
            session.close();
        }
        return null;

    }
         @Override
    public void alterar(Passageiro passageiro) {
      Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        try{
            session.update(passageiro);
            t.commit();
        }catch(Exception alteraPassageiroError){
            System.out.println(alteraPassageiroError.getCause() +
                    "\nOcorreu um erro ao aterar um passageiro");
        }finally{
            session.close();
        }
    }
    @Override
    public void deletar(Passageiro passageiro){
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        try{
            session.delete(passageiro);
            t.commit();
        }catch(Exception delPassageiroError){
            System.out.println(delPassageiroError.getCause() +
                    "\nOcorreu um erro ao deletar um passageiro");
        }finally{
            session.close();
        }
    }

    @Override
    public List<Passageiro> recuperarTodos() {
        Session session = this.sessions.openSession();
        List<Passageiro> passageiros = null;
        
        try{
            passageiros = (List) session.createQuery("From Passageiro").getResultList();
        }catch(Exception recTodosPassageirosError){
            System.out.println(recTodosPassageirosError.getCause()
            + "\nOcorreu um erro ao recuperar todos os passageiros.");
        }finally{
            session.close();
            return passageiros;
        }
    }
      @Override
    public boolean login(String login, String senha) {
        List<Passageiro> passageiros = this.recuperarTodos();
        
        for(Passageiro p : passageiros){
            if(p.getLogin().equals(login)){
                if(p.getSenha().equals(senha)){
                    return true;
                }
            }
        }
        return false;
    }
}
