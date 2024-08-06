package bank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.dao.register.RegisterDaoImpl;
import bank.model.Register;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 int accNumber = Integer.parseInt(request.getParameter("accNumber"));
		 RegisterDaoImpl rdao = new RegisterDaoImpl();
		 
		 List<Register> lstrecord = rdao.retriveRecord(accNumber);
		 PrintWriter pw =response.getWriter();
		 if (lstrecord != null) {
			    Register robj = lstrecord.get(0);
			    pw.println("<html>");
			    pw.println("<head>");
			    pw.println("<style>");
			    pw.println("table { width: 100%; border-collapse: collapse; border: 1px solid #ddd; margin: 20px 0; font-family: Arial, sans-serif; }");
			    pw.println("th, td { padding: 12px; text-align: left; border-bottom: 1px solid #ddd; }");
			    pw.println("th { background-color: #4CAF50; color: white; }");
			    pw.println("tr:hover { background-color: #f5f5f5; }");
			    pw.println("tr td { transition: background-color 0.3s; }");
			    pw.println("</style>");
			    pw.println("</head>");
			    pw.println("<body>");
			    pw.println("<table>");
			    pw.println("<tr><th>Account Number</th><th>First Name</th><th>Username</th><th>Password</th><th>Balance</th></tr>");
			    pw.println("<tr><td>" + robj.getAccNumber() + "</td><td>" + robj.getAccFname() + "</td><td>" + robj.getAccUname() + "</td><td>" + robj.getAccPassword() + "</td><td>" + robj.getAccBal() + "</td></tr>");
			    pw.println("</table>");
			    pw.println("</body>");
			    pw.println("</html>");
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
