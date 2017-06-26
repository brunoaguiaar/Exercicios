package repositorio;

import java.util.List;

/**
 *
 * @author Bruno
 */
public interface CrudDao<E, T> {
    E save(E e);
    void remove(E e);
    E loadById(T id);
    List<E> findAll(); 
}
