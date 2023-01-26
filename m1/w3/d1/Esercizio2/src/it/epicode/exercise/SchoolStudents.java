package it.epicode.exercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class SchoolStudents {
	
	private static Connection conn;

	public static void main(String[] args) {

		conn=connect();
		
		boolean ins=false;
		if(ins) {
			insertStudent(new Student("Mario", "Rossi", Gender.M, LocalDate.of(1990, 1, 5), 5.5, 4, 7));
			insertStudent(new Student("Antonello", "Venditti", Gender.M, LocalDate.of(1980, 1, 5), 6.0, 4, 8));
			insertStudent(new Student("Morena", "Bianchi", Gender.F, LocalDate.of(19940, 1, 5), 5.5, 4, 7));
			insertStudent(new Student("Marco", "Neri", Gender.M, LocalDate.of(1990, 6, 11), 6.5, 4, 8));
		}
		
		System.out.println("Ho fatto upgrade DB");
		updateStudent(1, new HashMap<String, Object>() {
			{
				put("name", "Luigi");
				put("lastname", "Blu");
				put("gender", Gender.M);
				put("birthdate", LocalDate.of(1965, 5, 5));
				put("avg", 7.0);
				put("min_vote", 6);
				put("max_vote", 8);
			}
		});
		
		boolean del=false;
		if(del) {
			deleteStudent(1);
		}
		System.out.println("Test studente migliore");
		System.out.println(getBest());
		System.out.println("Test studente range Voti");
		System.out.println(getVoteRange(4, 8));
		
		disconnect();

	}
	
	public static Connection connect() {
		String url="jdbc:postgresql://localhost:5432/m1w3d1?useSSL=false";
		String username="postgres";
		String password="CodAndrea";
		
		conn=null;
		try {
			System.out.println("Connessione al DB "+url);
			conn=DriverManager.getConnection(url, username, password);
			System.out.println("Connessione avvenuta");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void disconnect() {
		if(conn!=null) {
			try {
				conn.close();
				System.out.println("Disconnessione avvenuta");
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void insertStudent(Student s) {
		try {
			String sql="INSERT INTO school_students (name, lastname, gender, birthdate, avg, min_vote, max_vote) "+
		"Values (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, s.getName());
			ps.setString(2, s.getLastname());
			ps.setString(3, s.getGender().toString());
			ps.setObject(4, s.getBirthdate());
			ps.setDouble(5, s.getAvg());
			ps.setInt(6, s.getMinVote());
			ps.setInt(7, s.getMaxVote());
			ps.execute();
			
			System.out.println("Inserimento andato a buon fine");
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateStudent(int id, HashMap<String, Object> s) {
		try {
			String sql="UPDATE school_students "+"SET name = ?, lastname= ?, gender= ?, birthdate = ?, avg = ?, min_vote = ?, "
					+ "max_vote= ?"+ 
			" WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s.get("name").toString());
			ps.setString(2, s.get("lastname").toString());
			ps.setString(3, s.get("gender").toString());
			ps.setObject(4, s.get("birthdate"));
			ps.setDouble(5, (Double) s.get("avg"));
			ps.setInt(6, (Integer) s.get("min_vote"));
			ps.setInt(7, (Integer) s.get("max_vote"));
			ps.setInt(8, id);
			ps.execute();
			
			System.out.println("Modifica andata a buon fine");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteStudent(int id) {
		try {
			String sql = "DELETE FROM school_students WHERE id= ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate(sql);
			
			System.out.println("Cancellato con successo");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Student getBest() {
		Student best=null;
		try {
			String sql = "SELECT * FROM school_students WHERE avg = (SELECT MAX(avg) FROM school_students)";
			PreparedStatement stmt=conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				best= new Student(Integer.valueOf(rs.getString("id")), rs.getString("name"), rs.getString("lastname"),
						Gender.valueOf(rs.getString("gender")), LocalDate.parse(rs.getObject("birthdate").toString()), 
						rs.getDouble("avg"), rs.getInt("min_vote"), rs.getInt("max_vote"));
			}
			
			rs.close();
			stmt.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return best;
	}
	
	public static ArrayList<Student> getVoteRange(int min, int max){
		ArrayList<Student> students = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM school_students WHERE min_vote >= ? AND max_vote <= ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, min);
			stmt.setInt(2, max);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				students.add(new Student(Integer.valueOf(rs.getString("id")), rs.getString("name"), rs.getString("lastname"), 
						Gender.valueOf(rs.getString("gender")), LocalDate.parse(rs.getObject("birthdate").toString()), 
						rs.getDouble("avg"), rs.getInt("min_vote"), rs.getInt("max_vote")));
			}
			rs.close();
			stmt.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return students;
	}

}
