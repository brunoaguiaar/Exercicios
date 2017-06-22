/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estado;

import br.com.crescer.aula3.ConnectionUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author bruno.aguiar
 */
public class EstadoDaoImpl implements EstadoDao{
    
    private static final String INSERT_ESTADO = " INSERT INTO ESTADO (ID, NOME, UF) VALUES (?,?,?)";
    private static final String UPDATE_ESTADO = " UPDATE ESTADO SET NOME = ? AND UF = ? WHERE ID = ?";
    private static final String DELETE_ESTADO = " DELETE INTO ESTADO WHERE ID = ?";
    private static final String LOAD_ESTADO = "SELECT * FROM ESTADO WHERE ID = ?";

    @Override
    public void insert(Estado estado) {
        try (final PreparedStatement preparedStatement 
                = ConnectionUtils.getConnection().prepareStatement(INSERT_ESTADO)) {
            
            preparedStatement.setLong(1, estado.getId());
            preparedStatement.setString(2, estado.getNome());
            preparedStatement.setString(3, estado.getUF());
            preparedStatement.executeUpdate();
        
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public void delete(Estado estado) {
        try (final PreparedStatement preparedStatement 
                = ConnectionUtils.getConnection().prepareStatement(DELETE_ESTADO)) {
            
            preparedStatement.setLong(1, estado.getId());
            preparedStatement.executeUpdate();
        
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public void update(Estado estado) {
        try (final PreparedStatement preparedStatement 
                = ConnectionUtils.getConnection().prepareStatement(UPDATE_ESTADO)) {
            
            preparedStatement.setString(1, estado.getUF());
            preparedStatement.setString(2, estado.getNome());
            preparedStatement.setLong(3, estado.getId());
            preparedStatement.executeUpdate();
        
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public Estado loadBy(Long id) {
        final Estado estado = new Estado();
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.getConnection().prepareStatement(LOAD_ESTADO)) {
            preparedStatement.setLong(1, id);
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    estado.setId(resultSet.getLong("ID"));
                    estado.setNome(resultSet.getString("NOME"));
                    estado.setNome(resultSet.getString("UF"));
                }
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return estado;
    }
    
}
