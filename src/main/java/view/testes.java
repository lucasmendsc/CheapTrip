package view;

import java.util.ArrayList;
import java.util.List;
import model.entidades.Carro;
import model.entidades.Local;
import model.entidades.Motorista;
import model.entidades.Passageiro;
import model.entidades.Viagem;
import model.implementacoes.CarroHibernateDAO;
import model.implementacoes.LocalHibernateDAO;
import model.implementacoes.MotoristaHibernateDAO;
import model.implementacoes.PassageiroHibernateDAO;
import model.implementacoes.ViagemHibernateDAO;

/**
 *
 * @author Jarvis
 */
public class testes {

    public static void main(String args[]) {
        /*Local local = new Local("estado", "cidade", "cep");

        LocalHibernateDAO lhd = new LocalHibernateDAO();

        lhd.cadastrar(local);

        Carro carro = new Carro("fiat", 2, "placa");

        CarroHibernateDAO chd = new CarroHibernateDAO();

        chd.cadastrar(carro);

        Motorista motorista = new Motorista("nome", "cpf", "email", "login", "senha", local, carro);

        MotoristaHibernateDAO mthd = new MotoristaHibernateDAO();

        mthd.cadastrar(motorista);

        PassageiroHibernateDAO phd = new PassageiroHibernateDAO();

        Passageiro p = new Passageiro("nome", "cpf", "email", "login", "senha", local);
        Passageiro p1 = new Passageiro("nome1", "cpf1", "email1", "login1", "senha1", local);

        phd.cadastrar(p);
        phd.cadastrar(p1);
        
        List<Passageiro> passageiros = new ArrayList();

        passageiros.add(p);
        passageiros.add(p1);

        Viagem viagem = new Viagem(motorista, local, passageiros);

        ViagemHibernateDAO vhd = new ViagemHibernateDAO();

        vhd.cadastrar(viagem);*/

    }
}
