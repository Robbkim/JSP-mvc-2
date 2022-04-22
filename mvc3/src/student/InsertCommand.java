package student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.dao.StudentDAO;
import student.dao.StudentDAOImpl;
import student.dto.StudentDTO;

public class InsertCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		StudentDTO dto = new StudentDTO();
		dto.setId(req.getParameter("id"));
		dto.setName(req.getParameter("name"));
		dto.setCname(req.getParameter("cname"));
		StudentDAO dao = new StudentDAOImpl();		
		int res = dao.insertStudent(dto);
		String msg = null, url = null;
		if(res>0) {
			msg = "학생 등록 성공!! 학생 목록 페이지로 이동합니다.";
			url = "student.do?command=list";
		}else {
			msg = "학생 등록 실패!! 학생 관리 페이지로 이동합니다.";
			url = "student.do?command=start";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";
	}

}
