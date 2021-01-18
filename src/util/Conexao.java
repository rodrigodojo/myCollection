package util;
import java.sql.*;

import java.sql.Connection;

public class Conexao {

	public static Connection conectar(){
		
		try{
			String con = "jdbc:mysql://localhost/mycollection_db?useTimezone=true&serverTimezone=UTC";
			String user = "root";
			String pass = "dojo1234";
			
			Connection conexao = DriverManager.getConnection(con,user,pass);
			
			//System.out.println("Conectado!!!");
			
			return conexao;
			
		}catch(SQLException ex){
			System.out.println("\nerro na conexao \n " + ex);
			
			return null;
		}
		
	}
}
