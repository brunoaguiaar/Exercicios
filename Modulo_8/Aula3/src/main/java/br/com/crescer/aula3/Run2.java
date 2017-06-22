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
public class Run2 {
    
    private static final String DML = "CREATE TABLE TESTE(\n"
                + "  ID NUMBER(8) NOT NULL,\n"
                + "  NOME VARCHAR2(60) DEFAULT NULL, \n"
                + "  SIGLA VARCHAR2(10) DEFAULT NULL, \n"
                + "  CONSTRAINT TESTE_PK PRIMARY KEY (ID)  ENABLE \n"
                + ")";
    public static void main(String[] args){
        
        
        // CONEXÃO COM DLL BANCO E UM SELECT
        
        // Oracle Thin 
        // jdbc:oracle:thin:@<HOST>:<PORT>:<SID>
        // oracle.jdbc.driver.OracleDriver

        final String url = "jdbc:oracle:thin:@localhost:1521:xe";
        final String user = "JAVA";
        final String pass = "JAVA";
        
        try (final Connection connection = DriverManager.getConnection(url, user, pass)) {
            final Statement statement = connection.createStatement();
            statement.executeQuery(DML);
            
        } catch (SQLException e) {
          System.err.format("SQLException: %s", e);
        }
    }
}
