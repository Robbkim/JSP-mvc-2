package student.dao;

import java.util.ArrayList;

import student.dto.StudentDTO;

public interface StudentDAO {
	public int insertStudent(StudentDTO dto);
	public int deleteStudent(String id);
	public ArrayList<StudentDTO> findStudent(String name);
	public ArrayList<StudentDTO> listStudent();
	

}
