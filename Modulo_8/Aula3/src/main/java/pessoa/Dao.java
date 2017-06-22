package pessoa;

/**
 * @author bruno.aguiar
 */
public interface Dao<T> {
    
    void insert(T p);
    
    void delete(T p);
    
    void update(T p);
    
    T loadBy(Long id);
}
