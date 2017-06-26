package repositorio;

import java.util.List;

/**
 *
 * @author Bruno
 */
public abstract class GenericDao<E, T>  implements CrudDao<E, T> {
    protected EntityManager entityManager;  
    private Class<E> persistedEntity;
    
    public GenericDao(Class<E> persistedEntity, EntityManager entityManager) {
        this.persistedEntity = persistedEntity;
        this.entityManager = entityManager;
    }
    
    @Override
    public E save(E e) {
        entityManager.getTransaction().begin();
        entityManager.merge(e);
        entityManager.flush();
        entityManager.getTransaction().commit();
        return e;
    }

    @Override
    public void remove(E e) {
        entityManager.getTransaction().begin();
        entityManager.remove(e);
        entityManager.getTransaction().commit();
    }

    @Override
    public E loadById(T id) {
        return entityManager.find(persistedEntity, id);
    }

    @Override
    public List<E> findAll() {
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(persistedEntity);
        return criteria.list();
    } 
}
