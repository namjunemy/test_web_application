package servlets.receipt;

import dao.ReceiptDao;
import vo.Receipt;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/receipt/add")
public class ReceiptAddServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      ServletContext sc = this.getServletContext();
      ReceiptDao receiptDao = (ReceiptDao) sc.getAttribute("receiptDao");

      receiptDao.insert(new Receipt().setmNo(Integer.parseInt(request.getParameter("m_no")))
          .setpNo(Integer.parseInt(request.getParameter("p_no"))));

      response.sendRedirect("/receipt/list?m_no=" + request.getParameter("m_no"));

    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);
      RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
      rd.forward(request, response);
    }
  }
}
