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
 * Servlet implementation class EditServlet1
 */
@WebServlet("/EditServlet1")
public class EditServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>Update Application</h1>");
		String sid = request.getParameter("id");
		out.println(sid);
		
		PassportApplyDAOImpl pdao = new PassportApplyDAOImpl();
		
		try {
			PassportApply pa = pdao.read(sid);
			out.printf("%s,%s",pa.getContactNumber(),pa.getCity());
			
			SimpleDateFormat sdf = new SimpleDateFormat();
			
			out.println("<head>\r\n" + 
					"   \r\n" + 
					"    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"    \r\n" + 
					"<div class=\"container \"> \r\n" + 
					"    <form action=\"EditServlet2\" method=\"post\">\r\n" + 
					"    \r\n" + 
					"         <input type='hidden' name='id' value='"+pa.getApplicationId()+"' />\r\n" + 
					"    First Name       : <input class=\"form-control\"  type=text name=firstName value='"+pa.getFirstName()+"'><br>\r\n" + 
					"    Last Name        :<input class=\"form-control\" type=text name=lastName value='"+pa.getLastName()+"'><br>\r\n" + 
					"    Date Of Birth    :<input class=\"form-control\" type=date name=dateOfBirth value='"+sdf.format(pa.getDateOfBirth())+"' ><br>\r\n" + 
					"    Place Of Birth   :<input class=\"form-control\"  type=text name=placeOfBirth value='"+pa.getPlaceOfBirth()+"'><br>\r\n" + 
					"    Contact Number   :<input class=\"form-control\" type=text name=contactNumber value= '"+pa.getContactNumber()+"'><br>\r\n" + 
					"    Aadhar Number    : <input class=\"form-control\"  type=number name=aadharNumber value= '"+pa.getAadharNumber()+"'><br>\r\n" + 
					"    Address          : <input class=\"form-control\" type=text name=address value='"+pa.getAddress()+"'><br>\r\n" + 
					"    Nationality      :<input class=\"form-control\"  type=text name=nationality value='"+pa.getNationality()+"'><br>\r\n" + 
					"    State            :<input class=\"form-control\" type=text name=state value='"+pa.getState()+"'><br>\r\n" + 
					"    City             :<input class=\"form-control\" type=text name=city value= '"+pa.getCity()+"'><br>\r\n" + 
					"             <input type=submit>\r\n" + 
					"    \r\n" + 
					"    </form>\r\n" + 
					"    </div> \r\n" + 
					"</body>");
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
