/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import model.Cliente;

/**
 *
 * @author Bruno
 */
public class ClienteDao extends GenericDao<Cliente, Long>{
    public ClienteDao(EntityManager entityManager) {
        super(Cliente.class, entityManager);
    }
}
