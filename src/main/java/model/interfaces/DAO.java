package model.interfaces;

import java.util.List;

/**
 *
 * @author Mark IV
 */
public interface DAO <T>{
    
    void cadastrar(T t);
    T recuperar(int codigo);
    void deletar(T t);
    void alterar(T t);
    List<T> recuperarTodos();
}
