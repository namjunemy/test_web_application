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
import java.util.List;

@WebServlet("/receipt/list")
public class ReceiptListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ServletContext servletContext = this.getServletContext();

			ReceiptDao receiptDao = (ReceiptDao) servletContext.getAttribute("receiptDao");
			List<Receipt> receipts = receiptDao.selectList(Integer.parseInt(request.getParameter("m_no")));

			request.setAttribute("receipts", receipts);
			response.setContentType("text/html; charset=UTF-8;");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/receipt/ReceiptList.jsp");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
	}
}
