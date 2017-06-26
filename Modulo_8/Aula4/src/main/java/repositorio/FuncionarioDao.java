package repositorio;

import model.Funcionario;

/**
 *
 * @author Bruno
 */
public class FuncionarioDao extends GenericDao<Funcionario, Long>{
    public FuncionarioDao(EntityManager entityManager) {
        super(Funcionario.class, entityManager);
    }
}
