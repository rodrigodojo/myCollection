package util;

import java.sql.PreparedStatement;
import java.sql.*;

public class ControllerDB {
public static void inserirGames(String nome ,String console ,String valor ,String estado ,String obs ){
		
		try{
			
			String sqlQuery = "INSERT INTO games VALUES (?,?,?,?,?,?)";
			
			PreparedStatement pst = Conexao.conectar().prepareStatement(sqlQuery);
			
			pst.setString(1,"0");
			pst.setString(2,nome);
			pst.setString(3,console);
			pst.setString(4,valor);
			pst.setString(5,estado);
			pst.setString(6,obs);
			
			pst.executeUpdate();
			
			System.out.println(" Registro realizado com sucesso ");
			
		}catch(SQLException ex){
			System.out.println("Erro:\n " + ex);
			
		}
		
	}
	/*
	public static void buscarGames(String pesquisar){
		
		try{
			
			String sqlQuery = "SELECT * FROM games WHERE id = ?";
			
			PreparedStatement pst = Conexao.conectar().prepareStatement(sqlQuery);
			
			pst.setString(1, pesquisar);
			
			ResultSet resultado = pst.executeQuery();
			
			if(resultado.next()){
				
				System.out.println("resultado da pesquisa.");
				System.out.println("Nome :" + resultado.getString("nome"));
				System.out.println("Matricula :" + resultado.getString("matricula"));
				System.out.println("##################");
				
			}else{
				System.out.println("registro nao encontrado.");
			}
			
			
		}catch(SQLException ex){
			System.out.println("Erro:\n " + ex);
			
		}
		
	}
	public static void alterarGames(){
		
		try{
			
			String sqlQuery = "UPDATE games SET nome = ?, matricula = ? WHERE id = " + id;
			
			PreparedStatement pst = Conexao.conectar().prepareStatement(sqlQuery);
			
			pst.setString(1,nome);
			pst.setString(2,matricula);
			
			int resultado = pst.executeUpdate();
			
			if(resultado > 0){
				System.out.println("registro alterado com sucesso.");
			}else{
				System.out.println("registro nao alterado.");
			}
			
		}catch(SQLException ex){
			System.out.println("Erro:\n " + ex);
			
		}
		
		
	}
	public static void eliminarGames(){
		
		try{
			
			String sqlQuery = "DELETE FROM games WHERE id = ? ";
			
			PreparedStatement pst = Conexao.conectar().prepareStatement(sqlQuery);
			
			pst.setString(1,id);
			
			int resultado = pst.executeUpdate();
			
			if(resultado > 0){
				System.out.println("registro eliminado com sucesso.");
			}else{
				System.out.println("registro nao eliminado.");
			}
			
		}catch(SQLException ex){
			System.out.println("Erro:\n " + ex);
			
		}
		
	}
	public static void mostrarTodosGames(){
		
		try{
			
			String sqlQuery = "SELECT * FROM games ";
			
			PreparedStatement pst = Conexao.conectar().prepareStatement(sqlQuery);
			
			ResultSet resultado = pst.executeQuery();
			
			
			while(resultado.next()){
				
				System.out.println("Nome :" + resultado.getString("nome"));
				System.out.println("Matricula :" + resultado.getString("matricula"));
				System.out.println("-------------------------------");
			}
			
		}catch(SQLException ex){
			System.out.println("Erro:\n " + ex);
			
		}
		
	}
	*/
	
}
