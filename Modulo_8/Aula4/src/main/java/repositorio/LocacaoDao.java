package repositorio;

import model.Locacao;

/**
 *
 * @author Bruno
 */
public class LocacaoDao extends GenericDao<Locacao, Long>{
    public LocacaoDao(EntityManager entityManager) {
        super(Locacao.class, entityManager);
    }
}
