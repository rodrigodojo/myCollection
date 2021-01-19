package aplication;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import util.*;

public class Program extends JFrame{
		
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private JScrollPane scroll;
		private JTextArea conteudo;
		private JMenuBar menuBar;
		private JMenu mFile,mAbout;
		private JMenuItem miInserir, miBuscar, miAlterar, miEliminar, mimostrarTodos, miSair,miSobreEquipe,miSobreSoftware;
		private JButton btnBuscar,btnSalvar,btnEliminar,btnLimpar,btnMostrar;
		private String nome ,console ,valor ,estado ,obs;
		
		public Program(){
			
			menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			
			mFile = new JMenu("Arquivo");
			menuBar.add(mFile);
			
			mAbout = new JMenu("Sobre");
			menuBar.add(mAbout);
			
			miInserir = new JMenuItem("  |  Inserir Games  ");
			mFile.add(miInserir);
			miInserir.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						inserirGames();
					}
				}
			);
			
			miBuscar = new JMenuItem("  |  Buscar Games  ");
			mFile.add(miBuscar);
			miBuscar.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						buscarGames();
					}
				}
			);
			
			miAlterar = new JMenuItem("  |  Alterar Games  ");
			mFile.add(miAlterar);
			miAlterar.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						alterarGames();
					}
				}
			);
			
			miEliminar = new JMenuItem("  |  Eliminar Games  ");
			mFile.add(miEliminar);
			miEliminar.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						eliminarGames();
					}
				}
			);
			
			mimostrarTodos = new JMenuItem("  |  Mostrar Lista Games  ");
			mFile.add(mimostrarTodos);
			mimostrarTodos.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						buscarGames();
					}
				}
			);
			
			miSair = new JMenuItem("  |  Sair  ");
			mFile.add(miSair);
			miSair.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						System.exit(0);
					}
				}
			);
			
			miSobreEquipe = new JMenuItem("  |  Sobre Equipe  ");
			mAbout.add(miSobreEquipe);
			miSobreEquipe.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						JOptionPane.showMessageDialog(null," Equipe Dojo Geek ");
					}
				}
			);
			
			miSobreSoftware = new JMenuItem("  |  Sobre Software  ");
			mAbout.add(miSobreSoftware);
			miSobreSoftware.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						JOptionPane.showMessageDialog(null," Software 0.0.7");
					}
				}
			);
			
			conteudo = new JTextArea();
			conteudo.setFont(new Font("Arial", Font.BOLD, 18));
			scroll = new JScrollPane(conteudo);
			scroll.setBounds(10,10,765,480);
			add(scroll);
			
			btnBuscar = new JButton("Buscar");
			btnBuscar.setBounds(10,500,100,25);
			add(btnBuscar);
			btnBuscar.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						buscarGames();
					}
				}
			);
			
			btnSalvar = new JButton("Salvar");
			btnSalvar.setBounds(120,500,100,25);
			add(btnSalvar);
			btnSalvar.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						alterarGames();
					}
				}
			);
			
			btnEliminar = new JButton("Eliminar");
			btnEliminar.setBounds(230,500,100,25);
			add(btnEliminar);
			btnEliminar.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						eliminarGames();
					}
				}
			);
			
			btnLimpar = new JButton("Limpar");
			btnLimpar.setBounds(340,500,100,25);
			add(btnLimpar);
			btnLimpar.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						limparGames();
					}
				}
			);
			
			btnMostrar = new JButton("Mostrar");
			btnMostrar.setBounds(450,500,100,25);
			add(btnMostrar);
			btnMostrar.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						buscarGames();
					}
				}
			);
			
		}
		
		public static void main(String args[]){
			
			Program form = new Program();
			form.setLayout(null);
			form.setBounds(0,0,800,600);
			form.setVisible(true);
			form.setResizable(false);
			form.setLocationRelativeTo(null);
			form.setDefaultCloseOperation(EXIT_ON_CLOSE);
			form.setTitle("myCollection Games");
			
		}
		
		public void inserirGames(){
			
			int res = JOptionPane.showConfirmDialog(null, "Deseja salvar o arquivo?" , "Salvar" , JOptionPane.YES_NO_OPTION);
						
						if(res == JOptionPane.YES_OPTION){
							try{
								File file = new File(Editor.folderPath + Editor.fileName);
								
								nome = conteudo.getText();
								console = conteudo.getText();
								valor = conteudo.getText();
								estado = conteudo.getText();
								obs = conteudo.getText();
								ControllerDB.inserirGames(nome ,console ,valor ,estado ,obs );
								
								if(file.exists()){
									Editor.conteudo = conteudo.getText();
									Editor.escritor(file.getAbsolutePath());
								}else{
									salvarGames();
								}
								
							}catch(IOException ex){}
						}
						
						conteudo.setText("");
						Editor.conteudo = "";
						Editor.folderPath = System.getProperty("user.home") + "\\Documents\\";
						Editor.fileName = "ListaDeGames.txt";
			
		}
		
		public void salvarGames(){
			Editor.conteudo = conteudo.getText();
			try{
				
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Salvar");
				fileChooser.setSelectedFile(new File(Editor.folderPath + Editor.fileName));
				int userSelection = fileChooser.showSaveDialog(this);
				if(userSelection == JFileChooser.APPROVE_OPTION){
					Editor.folderPath = fileChooser.getSelectedFile().getParent() + "/";
					Editor.escritor(fileChooser.getSelectedFile().getAbsolutePath());
				}
			}catch(IOException ex){
			}
		}
		
		public void buscarGames(){
			try{
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Abrir");
				fileChooser.setSelectedFile(new File(Editor.folderPath + Editor.fileName));
				int userSelection = fileChooser.showOpenDialog(null);
					if(userSelection == JFileChooser.APPROVE_OPTION){
						conteudo.setText("");
						Editor.conteudo = "";
						conteudo.setText(Editor.leitor(fileChooser.getSelectedFile().getAbsolutePath()));
						Editor.conteudo = conteudo.getText();
						Editor.folderPath = fileChooser.getSelectedFile().getParent() + "\\";
						Editor.fileName = fileChooser.getSelectedFile().getName();
					}
			}catch(IOException ex){			
			}	
		}
		
		public void eliminarGames(){
			
			conteudo.setText("");
			Editor.conteudo = "";
			Editor.folderPath = System.getProperty("user.home") + "\\Documents\\";
			Editor.fileName = "ListaDeGames.txt";
			
			int res = JOptionPane.showConfirmDialog(null, "Deseja eliminar as alteraçoes no arquivo?" , "Eliminar" , JOptionPane.YES_NO_OPTION);
						
						if(res == JOptionPane.YES_OPTION){
							try{
								File file = new File(Editor.folderPath + Editor.fileName);
								
								if(file.exists()){
									Editor.conteudo = conteudo.getText();
									Editor.escritor(file.getAbsolutePath());
								}else{
									salvarGames();
								}
								
							}catch(IOException ex){}
						}
		}
		
		public void alterarGames(){
			
			int res = JOptionPane.showConfirmDialog(null, "Deseja salvar as alteraçoes no arquivo?" , "Salvar" , JOptionPane.YES_NO_OPTION);
						
						if(res == JOptionPane.YES_OPTION){
							try{
								File file = new File(Editor.folderPath + Editor.fileName);
								
								nome = conteudo.getText();
								console = conteudo.getText();
								valor = conteudo.getText();
								estado = conteudo.getText();
								obs = conteudo.getText();
								ControllerDB.inserirGames(nome ,console ,valor ,estado ,obs );
								
								if(file.exists()){
									Editor.conteudo = conteudo.getText();
									Editor.escritor(file.getAbsolutePath());
								}else{
									salvarGames();
								}
								
							}catch(IOException ex){}
						}
						
						Editor.folderPath = System.getProperty("user.home") + "\\Documents\\";
						Editor.fileName = "ListaDeGames.txt";
		}
		
		public void limparGames(){
			conteudo.setText("");
		}
}
