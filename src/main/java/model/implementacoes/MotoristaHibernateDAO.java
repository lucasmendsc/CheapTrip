package model.implementacoes;

import java.util.List;
import model.entidades.Motorista;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import model.interfaces.MotoristaInterfaceDAO;

/**
 *
 * @author Mark IV
 */
public class MotoristaHibernateDAO implements MotoristaInterfaceDAO{
    private final SessionFactory sessions;
    private static MotoristaHibernateDAO myself;
    
    public static MotoristaHibernateDAO getInstance(){
        if(myself == null){
            myself = new MotoristaHibernateDAO();
        }
        return myself;
    }

    private MotoristaHibernateDAO() {
        Configuration cfg = new Configuration().configure();
        this.sessions = cfg.buildSessionFactory();
    }

    @Override
    public void cadastrar(Motorista motorista) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        
        try{
            session.persist(motorista);
            t.commit();
        }catch(Exception cadMotoristaError){
            System.out.println(cadMotoristaError.getCause()
                        + "\nOcorreu um erro ao cadastrar um motorista");
            t.rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public Motorista recuperar(int codigo) {
        Session session = this.sessions.openSession();
        try{
            return (Motorista) session.createQuery("From Motorista Where id_motorista=" + codigo).getResultList().get(0);
        }catch(Exception recMotoristaError){
            System.out.println(recMotoristaError.getCause()
                        + "\nOcorreu um erro ao recuperar um motorista");
        }finally{
            session.close();
        }
        return null;
    }

    @Override
    public void deletar(Motorista motorista) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        
        try{
            session.delete(motorista);
            t.commit();
        }catch(Exception delMotoristaError){
            System.out.println(delMotoristaError.getCause()
                        + "\nOcorreu um erro ao deletar um motorista");
            t.rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public void alterar(Motorista motorista) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        
        try{
            session.update(motorista);
            t.commit();
        }catch(Exception updMotoristaError){
            System.out.println(updMotoristaError.getCause()
                        + "\nOcorreu um erro ao alterar um motorista");
            t.rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public List<Motorista> recuperarTodos() {
        Session session = this.sessions.openSession();
        List<Motorista> motoristas = null;
        
        try{
            motoristas = (List) session.createQuery("From Motorista").getResultList();
        }catch(Exception recTodosMotoristas){
            System.out.println(recTodosMotoristas.getCause()
                    + "\nOcorreu um erro ao recuperar todos os motoristas");
        }finally{
            session.close();
            return motoristas;
        }
    }
    
    
    @Override
    public boolean login(String login, String senha) {
        List<Motorista> motoristas = this.recuperarTodos();
        
        for(Motorista moto : motoristas){
            if(moto.getLogin().equals(login)){
                if(moto.getSenha().equals(senha)){
                    return true;
                }
            }
        }
        return false;
    }
}
