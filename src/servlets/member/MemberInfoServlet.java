package servlets.member;

import dao.MemberDao;
import vo.Member;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/member/info")
public class MemberInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ServletContext servletContext = this.getServletContext();

			MemberDao memberDao = (MemberDao) servletContext.getAttribute("memberDao");

			Member member = memberDao.selectOne(Integer.parseInt(request.getParameter("m_no")));
			request.setAttribute("member", member);
			response.setContentType("text/html; charset=UTF-8;");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/member/MemberInfo.jsp");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
	}
}
