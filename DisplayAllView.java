package bank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bank.dao.register.RegisterDao;
import bank.model.Register;
import bank.dao.register.RegisterDaoImpl;
/**
 * Servlet implementation class DisplayAllView
 */
@WebServlet("/DisplayAllView")
public class DisplayAllView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RegisterDao rdao = new RegisterDaoImpl();
		List<Register> lstallrecord = rdao.displayAll();
		
		PrintWriter pw = response.getWriter();
		

		pw.println("<table border='3' style='width: 80%; margin: 50px auto; background-color: #fff; border: 1px solid #ccc; border-radius: 5px; padding: 20px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);'>");
		for(Register robj:lstallrecord) {
		    pw.println("<tr><td style='padding: 8px; border-bottom: 1px solid #ccc;'>" + robj.getAccNumber() + "</td><td style='padding: 8px; border-bottom: 1px solid #ccc;'>" + robj.getAccFname() + "</td><td style='padding: 8px; border-bottom: 1px solid #ccc;'>" + robj.getAccBal() + "</td></tr>");
		}
		pw.println("</table>");

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
