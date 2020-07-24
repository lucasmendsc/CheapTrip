package model.implementacoes;

import java.util.List;
import model.entidades.Local;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import model.interfaces.LocaInterfacelDAO;

/**
 *
 * @author Mark IV
 */
public class LocalHibernateDAO implements LocaInterfacelDAO{
    private SessionFactory sessions;
    private static LocalHibernateDAO instance;

    public static LocalHibernateDAO getInstance() {
        if (instance == null) {
            instance = new LocalHibernateDAO();
        }
        return instance;
    }

    private LocalHibernateDAO() {
        Configuration cfg = new Configuration().configure();
        this.sessions = cfg.buildSessionFactory();
    }

    @Override
    public void cadastrar(Local local) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.persist(local);
            t.commit();
        } catch (Exception cadLocalError) {
            System.out.println(cadLocalError.getCause()
                    + "\nOcorreu um erro ao cadastrar um local");
        } finally {
            session.close();
        }
    }

    @Override
    public Local recuperar(int codigo) {
        Session session = this.sessions.openSession();

        try {
            return (Local) session.createQuery("From Local Where id_local=" + codigo).getResultList().get(0);
        } catch (Exception recLocalError) {
           return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void alterar(Local local) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(local);
            t.commit();
        } catch (Exception alteraLocalError) {
            System.out.println(alteraLocalError.getCause()
                    + "\nOcorreu um erro ao aterar um local");
        } finally {
            session.close();
        }
    }

    @Override
    public void deletar(Local local) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.delete(local);
            t.commit();
        } catch (Exception delLocalError) {
            System.out.println(delLocalError.getCause()
                    + "\nOcorreu um erro ao deletar um local");
        } finally {
            session.close();
        }
    }

    @Override
    public List<Local> recuperarTodos() {
        Session session = this.sessions.openSession();
        List<Local> locais = null;

        try {
            locais = (List) session.createQuery("From Local").getResultList();
        } catch (Exception recTodosLocaissError) {
            System.out.println(recTodosLocaissError.getCause()
                    + "\nOcorreu um erro ao recuperar todos os locais.");
        } finally {
            session.close();
            return locais;
        }
    }

}
