package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PassportApply;
import model.PassportApplyDAOImpl;

/**
 * Servlet implementation class PassportApplyServelet
 */
@WebServlet({ "/PassportApplyServelet", "/add" })
public class PassportApplyServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassportApplyServelet() {
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
		// TODO Auto-generated method stub
//		doGet(request, response);
		response.setContentType("text/html");
		ServletConfig config = getServletConfig();
		String applicationId=request.getParameter("applicationId");
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String dob=request.getParameter("dateOfBirth");
		String placeOfBirth=request.getParameter("placeOfBirth");
		Long contactNumber=Long.parseLong(request.getParameter("contactNumber"));
		Long aadharNumber=Long.parseLong(request.getParameter("aadharNumber")); 
		String address=request.getParameter("address");
		String nationality=request.getParameter("nationality");
		String state=request.getParameter("state");
		String city=request.getParameter("city");
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
		Date dateOfBirth=new Date();
		try {
			dateOfBirth=sdf1.parse(dob);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PassportApply passportapply = new PassportApply();
		
		if(request.getParameter("applicationId")!=null) {
			passportapply.setApplicationId(request.getParameter("applicationId"));
		}
		passportapply.setFirstName(firstName);
		passportapply.setLastName(lastName);
		passportapply.setDateOfBirth(dateOfBirth);
		passportapply.setPlaceOfBirth(placeOfBirth);
		passportapply.setContactNumber(contactNumber);
		passportapply.setAadharNumber(aadharNumber);
		passportapply.setAddress(address);
		passportapply.setNationality(nationality);
		passportapply.setState(state);
		passportapply.setCity(city);
		
		PassportApplyDAOImpl pdao = new PassportApplyDAOImpl();
		 
			try {
				if(passportapply.getApplicationId()!=null) {
				pdao.create(passportapply);
				System.out.println("Adding New Applicant");
			}
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getWriter().print("Added Applicant to DB");
			response.sendRedirect("display");
		}
	
	 
}
