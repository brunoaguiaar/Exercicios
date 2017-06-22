/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estado;

/**
 *
 * @author bruno.aguiar
 */
public interface Dao<T> {
    
    void insert(T p);
    
    void delete(T p);
    
    void update(T p);
    
    T loadBy(Long id);
}
