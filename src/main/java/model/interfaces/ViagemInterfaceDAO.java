package model.interfaces;

import java.util.List;
import model.entidades.Motorista;
import model.entidades.Passageiro;
import model.entidades.Viagem;

/**
 *
 * @author Mark IV
 */
public interface ViagemInterfaceDAO extends DAO<Viagem>{
    List<Viagem> recuperarPorMotorista(Motorista motorista);
}
