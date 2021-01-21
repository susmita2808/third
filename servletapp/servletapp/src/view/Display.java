package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PassportApply;
import model.PassportApplyDAO;
import model.PassportApplyDAOImpl;

/**
 * Servlet implementation class Display
 */
@WebServlet({ "/Display", "/display" })
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Display() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		PassportApplyDAO pdao = new PassportApplyDAOImpl(); 
		 
		   try {
			List<PassportApply> passportlist = pdao.read();
			out.println("   <head>\r\n" + 
					"    \r\n" + 
					"    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\r\n" + 
					"    <link rel=\"stylesheet\" href=\"NewFile.css\" >"+
					"</head> <body> <div class=\"row\" style=\"display: flex;\">  "       );
			for(PassportApply p:passportlist)
			{
				out.println("<div class=\"card m-5 col-md-4\" style=\"width: 28rem;\">" + 
						"        <ul class=\"list-group list-group-flush\">\r\n" + 
						"          <li class=\"list-group-item\">ApplicationNo        :"+p.getApplicationId() +" </li>\r\n" + 
						"          <li class=\"list-group-item\">FirstName            :"+ p.getFirstName() +"    </li>\r\n" + 
						"          <li class=\"list-group-item\">LastName             :"+p.getLastName()+"       </li>\r\n" + 
						"          <li class=\"list-group-item\">City                 :"+p.getCity()+"           </li>\r\n" + 
						"          <li class=\"list-group-item\">Nationality          :"+p.getNationality()+"    </li>\r\n" + 
						"        </ul>\r\n" + 
						"		<a href='DeleteServlet?id="+p.getApplicationId()+"'> Delete </a>" +
						"    <a href='EditServlet1?id="+p.getApplicationId()+"'> edit </a>" +

						"      </div>");
				
			}
			out.println("</div> </body>");
			
		} catch (SQLException e) {
			
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
