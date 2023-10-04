
package bd;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {
    
        private static final String USER = "root";
        private static final String SENHA = "";
        private static final String URL = "jdbc:mysql://localhost:3306/steam";
        
        public static Connection criarConexao() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(URL, USER,SENHA);
                
         return conn;
        }
        
        public static void main(String[] args) throws Exception {
        Connection c = criarConexao();
        
        if(c != null){
            System.out.println("Conexao com sucesso!");
        }else{
            System.out.println("Conexao nula!");
        }
    }
        
    
}
