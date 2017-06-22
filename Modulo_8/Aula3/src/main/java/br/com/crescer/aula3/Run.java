package br.com.crescer.aula3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author bruno.aguiar
 */
public class Run {
    public static void main(String[] args){
        
        
        // CONEXÃO COM BANCO E UM SELECT
        
        // Oracle Thin 
        // jdbc:oracle:thin:@<HOST>:<PORT>:<SID>
        // oracle.jdbc.driver.OracleDriver

        final String url = "jdbc:oracle:thin:@localhost:1521:xe";
        final String user = "JAVA";
        final String pass = "JAVA";

        final String query = "SELECT * FROM PAIS";
        
        try (final Connection connection = DriverManager.getConnection(url, user, pass)) {
            final Statement statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                System.out.println(resultSet.getString("NOME"));
            }
        } catch (SQLException e) {
          System.err.format("SQLException: %s", e);
        }
    }
}
