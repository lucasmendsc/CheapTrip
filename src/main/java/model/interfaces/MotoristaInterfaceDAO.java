package model.interfaces;

import model.entidades.Motorista;

/**
 *
 * @author Mark IV
 */
public interface MotoristaInterfaceDAO extends DAO<Motorista> {
    boolean login(String login,String senha);
}
