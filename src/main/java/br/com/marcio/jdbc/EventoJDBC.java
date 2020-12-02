package br.com.marcio.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.marcio.model.Evento;
public class EventoJDBC {
	
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://127.0.0.1:3306/desafio?useTimezone=true&serverTimezone=UTC";
	private static String username = "root";
	private static String password = "542106";
	
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			System.out.println("SUCESSO!");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public List<Evento> listEventos(){
		List<Evento> eventos = new ArrayList<Evento>();
		
		try{
			Connection conn = getConnection();
			PreparedStatement prst =  conn.prepareStatement("SELECT * FROM eventos");
			
			ResultSet rs = prst.executeQuery();
			
			while( rs.next() ) {
				Evento ev = new Evento(rs.getString("nome"));
				eventos.add(ev);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return eventos;
	}

	public void adicionarEvento(Evento ev) {
        try{
        	Connection conn = getConnection();
        	
            String sql = "INSERT INTO eventos(nome) VALUES(?)";


            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1 , ev.getNome());


            int rowsAffected = stmt.executeUpdate();

            System.out.println("Inserção BEM SUCEDIDA!. Foi adicionada " + rowsAffected + " linha");
        } catch (Exception e) {
            System.out.println("Inserção FALHOU!");
            e.printStackTrace();
        }		
	}
	
	public void deletarEvento(Evento ev) {
		System.out.println("Evento deletado foi" + ev.getNome());
        try{
        	Connection conn = getConnection();

            String sql = "DELETE FROM eventos WHERE nome = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1 , ev.getNome());

            int rowsAffected = stmt.executeUpdate();

            System.out.println("Delete BEM SUCEDIDA! Foi deletada " + rowsAffected + " linha");
        } catch (Exception e) {
            System.out.println("Delete FALHOU!");
            e.printStackTrace();
        }		
	}
	
	public void atualizarEvento(Evento ev) {
        try{
        	Connection conn = getConnection();
        	
            String sql = "UPDATE eventos SET nome = ? WHERE nome = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, ev.getNome());

            int rowsAffected = stmt.executeUpdate();

            System.out.println("Atualização BEM SUCEDIDA! Foi atualizada: " + rowsAffected + " linha");
        } catch (Exception e) {
            System.out.println("Atualização FALHOU!");
            e.printStackTrace();
        }		
	}
	
}
