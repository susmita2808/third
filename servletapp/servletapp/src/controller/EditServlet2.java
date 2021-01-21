package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PassportApply;
import model.PassportApplyDAOImpl;

/**
 * Servlet implementation class EditServlet2
 */
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		 SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
		String sid=request.getParameter("id");
		String fname= request.getParameter("firstName");
		String lname = request.getParameter("lastName");
		String dob = request.getParameter("dateOfBirth");
		
		
		
		String pob = request.getParameter("placeOfBirth");
		String cono = request.getParameter("contactNumber");
		long conol = Long.parseLong(cono); 
		String adno = request.getParameter("aadharNumber");
		long adnol= Long.parseLong(adno);
		String address= request.getParameter("address");
		String nat = request.getParameter("nationality");
		String sat = request.getParameter("state");
		String city = request.getParameter("city");
		
		PassportApplyDAOImpl pdao = new PassportApplyDAOImpl();
		
		PassportApply passup = new PassportApply();
		
		passup.setApplicationId(sid);
		passup.setFirstName(fname);
		passup.setLastName(lname);
		try {
			passup.setDateOfBirth(sdf.parse(dob));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		passup.setPlaceOfBirth(pob);
		passup.setContactNumber(conol);
		passup.setAadharNumber(adnol);
		passup.setAddress(address);
		passup.setNationality(nat);
		passup.setState(sat);
		passup.setCity(city);
		
		try {
			int status=pdao.update(passup);
			if(status>0){
				response.sendRedirect("Display");
			}else{
				out.println("Sorry! unable to update record");
			}
			
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
