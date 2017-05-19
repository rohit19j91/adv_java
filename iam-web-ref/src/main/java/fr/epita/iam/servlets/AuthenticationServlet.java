/**
 * 
 */
package fr.epita.iam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.services.Dao;
import fr.epita.iam.services.HibernateDAO;

/**
 * @author tbrou
 *
 */

@WebServlet(name="AuthenticationServlet", urlPatterns={"/authenticate"})
public class AuthenticationServlet extends HttpServlet{

	
	@Autowired
	Dao<Identity> dao;
	HibernateDAO hbdao;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private static final Logger LOGGER = LogManager.getLogger(AuthenticationServlet.class);
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		PrintWriter writer = resp.getWriter();
		LOGGER.info("dao instance is : {}", dao);
		String login = req.getParameter("login");
		String password = req.getParameter("pwd");
		
		LOGGER.info("tried to authenticate with this login {}", login);
//		if (login == null || password == null)
//		{
//			  req.setAttribute("msg", "Please type in password and username (Attribute)");
//			  writer.println("Please type in something atleaset");
//			  String results= "Invalid User Name/Password";
//			  req.getSession().setAttribute("results", results);
//			  RequestDispatcher rd = req.getRequestDispatcher("result.jsp");
//	            rd.forward(req, resp);
//		}
//		
//		else
//		{
			Identity identity= new Identity();
			identity.setEmail(login);
			identity.setPassword(password);
			 List<Identity> ids = hbdao.check(identity);
			 if (ids !=null && !ids.isEmpty())
			 {
				 writer.println("Please type in something atleaset");
			 String[] array={login,password};
			 List<String> results=Arrays.asList(array);
			 req.getSession().setAttribute("results",results);
				resp.sendRedirect("results.jsp");
			 
//			 req.getSession().setAttribute("flag", "login_success");
//             req.getSession().setAttribute("email", ids.get(0).getEmail());
//             req.getSession().setAttribute("username", ids.get(0).getDisplayName());
             
//             req.getSession().setAttribute("address", ids.get(0).
           //  RequestDispatcher rd=req.getRequestDispatcher("Search.html");
//		}
//			 
//			 else
//			 {
//				 req.setAttribute("flag","Invalid login/password");
//				 RequestDispatcher rd=req.getRequestDispatcher("index.html");
//			 }
//		}
//		String[] array = {login,password};
//		List<String> results = Arrays.asList(array);
//		req.getSession().setAttribute("results",results);
//		resp.sendRedirect("results.jsp");
	}
	}
}
		
