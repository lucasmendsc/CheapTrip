package model.implementacoes;

import java.util.List;
import model.entidades.Motorista;
import model.entidades.Passageiro;
import model.entidades.Viagem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import model.interfaces.ViagemInterfaceDAO;

/**
 *
 * @author Mark IV
 */
public class ViagemHibernateDAO implements ViagemInterfaceDAO {

    private final SessionFactory sessions;
    private static ViagemHibernateDAO instance;

    public static ViagemHibernateDAO getInstance() {
        if (instance == null) {
            instance = new ViagemHibernateDAO();
        }
        return instance;
    }

    private ViagemHibernateDAO() {
        Configuration cfg = new Configuration().configure();
        this.sessions = cfg.buildSessionFactory();
    }

    @Override
    public void cadastrar(Viagem viagem) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.persist(viagem);
            t.commit();
        } catch (Exception cadViagemError) {
            System.out.println(cadViagemError.getCause()
                    + "\nOcorreu um erro ao cadastrar uma viagem");
        } finally {
            session.close();
        }
    }

    @Override
    public Viagem recuperar(int codigo) {
        Session session = this.sessions.openSession();

        try {
            return (Viagem) session.createQuery("From Viagem Where id_viagem=" + codigo).getResultList().get(0);
        } catch (Exception recViagemError) {
            System.out.println(recViagemError.getCause()
                    + "\nOcorreu um erro ao recuperar uma viagem");
        } finally {
            session.close();
        }
        return null;

    }

    @Override
    public void alterar(Viagem viagem) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(viagem);
            t.commit();
        } catch (Exception alteraViagemError) {
            System.out.println(alteraViagemError.getCause()
                    + "\nOcorreu um erro ao aterar uma viagem");
        } finally {
            session.close();
        }
    }

    @Override
    public void deletar(Viagem viagem) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.delete(viagem);
            t.commit();
        } catch (Exception delViagemError) {
            System.out.println(delViagemError.getCause()
                    + "\nOcorreu um erro ao deletar uma viagem");
        } finally {
            session.close();
        }
    }

    @Override
    public List<Viagem> recuperarTodos() {
        Session session = this.sessions.openSession();
        List<Viagem> viagem = null;

        try {
            viagem = (List) session.createQuery("From Viagem").getResultList();
        } catch (Exception recTodosLocaissError) {
            System.out.println(recTodosLocaissError.getCause()
                    + "\nOcorreu um erro ao recuperar todas viagens.");
        } finally {
            session.close();
            return viagem;
        }
    }
        @Override
       public List<Viagem> recuperarPorMotorista(Motorista motorista) {
        Session session = this.sessions.openSession();
        List<Viagem> viagem = null;

        try {
            viagem = (List) session.createQuery("From Viagem Where Cod_motorista=" + motorista.getId_motorista() ).getResultList();
        } catch (Exception recTodosLocaisMotoristaError) {
            System.out.println(recTodosLocaisMotoristaError.getCause()
                    + "\nOcorreu um erro ao recuperar todas viagens do motorista.");
        } finally {
            session.close();
            return viagem;
        }
    }
}
