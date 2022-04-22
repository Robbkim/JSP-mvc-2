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
			msg = "�л� ���� ����!! �л� ��� �������� �̵��մϴ�.";
			url = "student.do?command=list";
		}else {
			msg = "�л� ���� ����!! �л� ���� �������� �̵��մϴ�.";
			url = "student.do?command=start";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";
		
	}

}
