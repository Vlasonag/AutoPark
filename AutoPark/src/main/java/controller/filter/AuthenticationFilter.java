package controller.filter;

import java.io.IOException; 

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static java.util.Objects.nonNull;
import model.ENUM.ROLE;
import model.dao.DaoFactory;
import model.dao.DriverDao;


public class AuthenticationFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		        final HttpServletRequest req = (HttpServletRequest) request;
		        final HttpServletResponse res = (HttpServletResponse) response;

		        final String login = req.getParameter("login");
		        final String password = req.getParameter("password");
		        
		        DaoFactory factory = DaoFactory.getInstance();		
		        DriverDao dao = factory.createDriverDao();
		        
		        final HttpSession session = req.getSession();

		        //Logged user.
		        if (nonNull(session) &&
		                nonNull(session.getAttribute("login")) &&
		                nonNull(session.getAttribute("password"))) {

		            final ROLE role = (ROLE) session.getAttribute("role");

		            moveToMenu(req, res, role);


		        } else if (dao.isDriverConfirmed(login, password)) {

		            final ROLE role = ROLE.DRIVER;

		            req.getSession().setAttribute("password", password);
		            req.getSession().setAttribute("login", login);
		            req.getSession().setAttribute("role", role);

		            moveToMenu(req, res, role);

		        } else {
		        	 final ROLE role = ROLE.DRIVER;
			            req.getSession().setAttribute("password", password);
			            req.getSession().setAttribute("login", login);
			            req.getSession().setAttribute("role", role);
		            moveToMenu(req, res, ROLE.UNKNOWN);
		           
		        }
		        
	}
		    

		    
		    private void moveToMenu(final HttpServletRequest req,
		                            final HttpServletResponse res,
		                            final ROLE role)
		            throws ServletException, IOException {


		         if (role.equals(ROLE.DRIVER)) {

		            req.getRequestDispatcher("/driver_appointment").forward(req, res);

		        } else if (role.equals(ROLE.ADMIN)) {

			            req.getRequestDispatcher("/wrong_role").forward(req, res);

			        }
		        else {
		        	req.getRequestDispatcher("/driver_appointment").forward(req, res);
		        }
		        
		    }   

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}