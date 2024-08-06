package bank.controller;
import bank.dao.register.RegisterDaoImpl;
import bank.model.*;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accUname = request.getParameter("accUname");
		String accPassword = request.getParameter("accPassword");
		
		Login lobj = new Login(accUname,accPassword);
		List<Login>lstlogin = new ArrayList<Login>();
		lstlogin.add(lobj);
		
		RegisterDaoImpl rdao= new RegisterDaoImpl();
		boolean b = rdao.validateUser(lstlogin);
		if(b) {
			response.sendRedirect("Dashboard.html");
		}
		else {
			response.sendRedirect("Error.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
