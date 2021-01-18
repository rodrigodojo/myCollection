package aplication;
import java.io.*;

public class Editor {

		
		public static String folderPath = System.getProperty("user.home") + "\\Documents\\";
		
		public static String fileName = "ListaDeGames.txt";
		
		public static String conteudo = "";
		
		public static boolean addConteudo = false;
		
		public static String leitor(String path) throws IOException{
			BufferedReader buffer = new BufferedReader(new FileReader(path));
			String linha = buffer.readLine();
			while(linha != null){
				conteudo += linha + "\n";
				linha = buffer.readLine();
			}
			buffer.close();
			return conteudo;
		}
		
		public static void escritor(String path) throws IOException{
			BufferedWriter buffer = new BufferedWriter(new FileWriter(path, addConteudo));
			buffer.append(conteudo);
			buffer.close();		
		}
		
		public static void incluirTexto()throws IOException {}
	}


