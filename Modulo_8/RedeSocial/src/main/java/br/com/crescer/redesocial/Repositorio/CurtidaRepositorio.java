/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redesocial.Repositorio;

import br.com.crescer.redesocial.Entity.Curtida;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Bruno
 */
public interface CurtidaRepositorio extends PagingAndSortingRepository<Curtida, Long>{
    
}
