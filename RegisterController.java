package bank.controller;
import bank.dao.register.RegisterDao;

import bank.dao.register.RegisterDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.model.Register;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int accNumber = Integer.parseInt(request.getParameter("accNumber"));
		String accFname =request.getParameter("accFname");
		String accUname =request.getParameter("accUname");
		String accPassword =request.getParameter("accPassword");
		float accBal =Integer.parseInt(request.getParameter("accBal"));
		
		Register regmodel = new Register(accNumber, accFname, accUname, accPassword, accBal);
		
		List<Register>lstregister = new ArrayList<Register>();
		lstregister.add(regmodel);
		
		RegisterDao rdao = new RegisterDaoImpl();
		int i = rdao.createRecord(lstregister);
		if(i>0) {
			response.sendRedirect("loginView.html");
			
		}
		else {
			response.sendRedirect("Error.html");
		}
		
		PrintWriter pw = response.getWriter();
		pw.println("<table>");
		pw.println("<tr><td>"+regmodel.getAccNumber()+"</td><td>"+regmodel.getAccFname()+"</td><td>"+regmodel.getAccUname()+"</td><td>"+regmodel.getAccPassword()+"</td><td>"+regmodel.getAccBal()+"</td></tr>");
		pw.println("</table>");
		
		pw.println("<a href='home.html'>home page</a>");
	}

}
