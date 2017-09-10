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

@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ServletContext sc = this.getServletContext();
			MemberDao memberDao = (MemberDao) sc.getAttribute("memberDao");

			Member member = memberDao.selectOne(Integer.parseInt(request.getParameter("m_no")));

			request.setAttribute("member", member);

			RequestDispatcher rd = request.getRequestDispatcher("/member/MemberUpdate.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ServletContext sc = this.getServletContext();
			MemberDao memberDao = (MemberDao) sc.getAttribute("memberDao");

			memberDao
					.update(new Member().setNo(Integer.parseInt(request.getParameter("m_no"))).setId(request.getParameter("m_id"))
							.setLevel(request.getParameter("l_name")).setName(request.getParameter("m_name"))
							.setEmail(request.getParameter("m_email")).setPhone(request.getParameter("m_phone")));

			response.sendRedirect("/member/info?m_no=" + Integer.parseInt(request.getParameter("m_no")));

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
	}
}
