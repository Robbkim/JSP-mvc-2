package student;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.dao.StudentDAO;
import student.dao.StudentDAOImpl;
import student.dto.StudentDTO;

public class ListCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		StudentDAO dao = new StudentDAOImpl();
		ArrayList<StudentDTO> list = dao.listStudent();
		req.setAttribute("listStudent", list);
		return "list.jsp";
	}

}
