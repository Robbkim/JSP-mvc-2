package student.dao;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import student.dto.StudentDTO;

public class StudentDAOImpl implements StudentDAO {
	
	Connection con;  			// 오라클과 자바연결을 위해 사용하는 클래스
	PreparedStatement ps;		// 동적쿼리를 사용하기 위한 클래스
	ResultSet rs;					// select쿼리시 결과를 받기 위한 클래스
	static DataSource ds;
	static {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:comp/env");
			ds = (DataSource)envContext.lookup("jdbc/oracle");
		}catch(NamingException e) {
			System.err.println("Connection 설정시 오류 발생!!");
			e.printStackTrace();
		}
	}
	
	public StudentDAOImpl() {
		/*
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			System.err.println("드라이버 검색 실패");
			e.printStackTrace();
		}
		*/ 
	}
	@Override
	public int insertStudent(StudentDTO dto) {
		try {
		con = ds.getConnection(); //resource 에서 등록된 connection을 받아온다
				//DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "spring10", "spring10");
		String sql = "insert into student values(?, ?, ?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, dto.getId());
		ps.setString(2, dto.getName());
		ps.setString(3, dto.getCname());
		int res = ps.executeUpdate();
		return res;
	}catch(SQLException e) {
		System.err.println("insert 실행 중 오류 발생");
		e.printStackTrace();
	}finally {
		try {
			if(ps != null) ps.close();
			if(con != null) con.close();
		}catch(SQLException e) {}
	}
		return 0;
	}
	
	@Override
	public int deleteStudent(String id) {
		try {
			con = ds.getConnection();
			String sql = "delete from student where id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			int res = ps.executeUpdate();
			return res;
		}catch(SQLException e) {
			System.err.println("delete 실행 중 오류 발생!");
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch(SQLException e) {}
		}
		return 0;
	}
	protected ArrayList<StudentDTO> makeArrayList(ResultSet rs) throws SQLException{
		ArrayList<StudentDTO> list = new ArrayList<>();
		while(rs.next()) {
			StudentDTO dto = new StudentDTO();
			dto.setId(rs.getString("id"));
			dto.setName(rs.getString("name"));
			dto.setCname(rs.getString("cname"));
			list.add(dto);
		}
		return list;
	}
	@Override
	public ArrayList<StudentDTO> findStudent(String name) {
		try {
			con = ds.getConnection();
			String sql = "select * from student where name = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			ArrayList<StudentDTO> list = makeArrayList(rs);
			return list;
		}catch(SQLException e) {
			System.err.println("find 실행 중 오류발생!");
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch(SQLException e) {}
		}
		return null;
	}	
	
	@Override
	public ArrayList<StudentDTO> listStudent() {
		try {
			con = ds.getConnection();
			String sql = "select * from student";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			ArrayList<StudentDTO> list = makeArrayList(rs);
			return list;
		}catch(SQLException e) {
			System.err.println("list 실행 중 오류발생!");
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch(SQLException e) {}
		}
		return null;
	}

}
