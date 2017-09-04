package listeners;

import dao.MemberDao;
import dao.ProductDao;
import dao.ReceiptDao;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

@WebListener
public class ContextLoaderListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		try {
			ServletContext sc = event.getServletContext();

			InitialContext initialContext = new InitialContext();
			DataSource ds = (DataSource) initialContext.lookup("java:comp/env/jdbc/lotte");

			MemberDao memberDao = new MemberDao();
			memberDao.setDataSource(ds);

			ProductDao productDao = new ProductDao();
			productDao.setDataSource(ds);

			ReceiptDao receiptDao = new ReceiptDao();
			receiptDao.setDataSource(ds);

			sc.setAttribute("memberDao", memberDao);
			sc.setAttribute("productDao", productDao);
			sc.setAttribute("receiptDao", receiptDao);

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
	}
}
