package student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.dao.StudentDAO;
import student.dao.StudentDAOImpl;

public class DeleteCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		StudentDAO dao = new StudentDAOImpl();
		int res = dao.deleteStudent(id);
		String msg = null, url = null;
		if(res>0) {
			msg = "학생 삭제 성공!! 학생 목록 페이지로 이동합니다.";
			url = "student.do?command=list";
		}else {
			msg = "학생 삭제 실패!! 학생 관리 페이지로 이동합니다.";
			url = "student.do?command=start";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";
		
	}

}
