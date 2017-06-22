package cidade;

import br.com.crescer.aula3.ConnectionUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author bruno.aguiar
 */
public class CidadeDaoImpl implements CidadeDao{

    private static final String INSERT_CIDADAE = " INSERT INTO CIDADE (ID, NOME) VALUES (?,?)";
    private static final String UPDATE_CIDADE = " UPDATE CIDADE SET NOME = ? WHERE ID = ?";
    private static final String DELETE_CIDADE = " DELETE INTO CIDADE WHERE ID = ?";
    private static final String LOAD_CIDADE = "SELECT * FROM CIDADE WHERE ID = ?";
    
    @Override
    public void insert(Cidade cidade) {
        try (final PreparedStatement preparedStatement 
                = ConnectionUtils.getConnection().prepareStatement(INSERT_CIDADAE)) {
            
            preparedStatement.setLong(1, cidade.getId());
            preparedStatement.setString(2, cidade.getNome());
            preparedStatement.executeUpdate();
        
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public void delete(Cidade cidade) {
        try (final PreparedStatement preparedStatement 
                = ConnectionUtils.getConnection().prepareStatement(DELETE_CIDADE)) {
            
            preparedStatement.setLong(1, cidade.getId());
            preparedStatement.executeUpdate();
        
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public void update(Cidade cidade) {
        try (final PreparedStatement preparedStatement 
                = ConnectionUtils.getConnection().prepareStatement(UPDATE_CIDADE)) {
            
            preparedStatement.setString(1, cidade.getNome());
            preparedStatement.setLong(2, cidade.getId());
            preparedStatement.executeUpdate();
        
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public Cidade loadBy(Long id) {
        final Cidade cidade = new Cidade();
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.getConnection().prepareStatement(LOAD_CIDADE)) {
            preparedStatement.setLong(1, id);
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    cidade.setId(resultSet.getLong("ID"));
                    cidade.setNome(resultSet.getString("NOME"));
                }
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return cidade;
    }
    
}
