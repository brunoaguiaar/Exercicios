package repositorio;

import model.Genero;

/**
 *
 * @author Bruno
 */
public class GeneroDao extends GenericDao<Genero, Long>{
    public GeneroDao(EntityManager entityManager) {
        super(Genero.class, entityManager);
    }
}
