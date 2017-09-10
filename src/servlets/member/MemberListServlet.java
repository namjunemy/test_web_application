package servlets.member;

import dao.MemberDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      ServletContext servletContext = this.getServletContext();

      MemberDao memberDao = (MemberDao) servletContext.getAttribute("memberDao");

      request.setAttribute("member", memberDao.selectList());
      response.setContentType("text/html; charset=UTF-8;");
      RequestDispatcher requestDispatcher = request.getRequestDispatcher("/member/MemberList.jsp");
      requestDispatcher.forward(request, response);
    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);
      RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
      rd.forward(request, response);
    }
  }
}
