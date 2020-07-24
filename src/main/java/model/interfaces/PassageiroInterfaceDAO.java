package model.interfaces;

import model.entidades.Passageiro;

/**
 *
 * @author Mark IV
 */
public interface PassageiroInterfaceDAO extends DAO<Passageiro> {
    boolean login(String login,String senha);
}
