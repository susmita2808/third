package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PassportApplyDAOImpl implements PassportApplyDAO{

	@Override
	public int create(PassportApply passportapply) throws SQLException {
		
		 Connection con = MyConnection.getConnection();
		 PreparedStatement ps = con.prepareStatement("INSERT INTO PASSPORTAPPLY VALUES(?,?,?,?,?,?,?,?,?,?,?)");
		   ps.setString(1, passportapply.getApplicationId());
		   ps.setString(2, passportapply.getFirstName());
		   ps.setString(3, passportapply.getLastName());
		   SimpleDateFormat sdf =  new SimpleDateFormat("dd-MMM-yy");// 09-aug-98
		   String dob = sdf.format(passportapply.getDateOfBirth()) ;
		   ps.setString(4, dob);
		   ps.setString(5, passportapply.getPlaceOfBirth());
		   ps.setLong(6, passportapply.getContactNumber());
		   ps.setLong(7, passportapply.getAadharNumber());
		   ps.setString(8, passportapply.getAddress());
		   ps.setString(9, passportapply.getNationality());
		   ps.setString(10, passportapply.getState());
		   ps.setString(11, passportapply.getCity());
		   
		 int i=  ps.executeUpdate();
           con.close();		 
		 return i;
		
	}

	@Override
	public List<PassportApply> read() throws SQLException, ParseException {
		Connection con=MyConnection.getConnection();
		PreparedStatement st = con.prepareStatement("SELECT * FROM PASSPORTAPPLY");
		ResultSet rs = st.executeQuery();
		SimpleDateFormat sdf1=new SimpleDateFormat("dd-MMM-yy");
		List<PassportApply> passportapplylist = new ArrayList<PassportApply>();
		while(rs.next()) {
			
			PassportApply passportapply = new PassportApply(rs.getString(1),rs.getString(2),rs.getString(3),sdf1.parse(rs.getString(4)), rs.getString(5),rs.getLong(6) , rs.getLong(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11));
			
			passportapplylist.add(passportapply);
		}
		con.close();
		return passportapplylist;
	}

	//read(100);
	@Override
	public PassportApply read(String id) throws SQLException, ParseException {
		Connection con=MyConnection.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM PASSPORTAPPLY WHERE APPLICATIONID=?");
		ps.setString(1,id);
		ResultSet rs = ps.executeQuery();
		PassportApply passportapply=null;
		
		SimpleDateFormat sdf1=new SimpleDateFormat("dd-MMM-yy");
		
		if(rs.next()) {
			
			passportapply= new PassportApply(rs.getString(1),rs.getString(2),rs.getString(3),sdf1.parse(rs.getString(4)), rs.getString(5),rs.getLong(6) , rs.getLong(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11));
		}
		
		con.close();
		return passportapply;
	}

	@Override
	public int update(PassportApply passportapply) throws SQLException {
		
		 Connection con = MyConnection.getConnection();
		 PreparedStatement ps = con.prepareStatement("UPDATE PassportApply SET FIRSTNAME=?, LASTNAME=?,DATEOFBIRTH=?,PLACEOFBIRTH=?,CONTACTNUMBER=?,AADHARNUMBER=?,ADDRESS=?,NATIONALITY=?,STATE=?,CITY=? WHERE APPLICATION_ID=?");
		  
		   ps.setString(1, passportapply.getFirstName());
		   ps.setString(2, passportapply.getLastName());
		   SimpleDateFormat sdf =  new SimpleDateFormat("dd-MMM-yy");// 09-aug-98
		   String dob = sdf.format(passportapply.getDateOfBirth()) ;
		   ps.setString(3, dob);
		   ps.setString(4, passportapply.getPlaceOfBirth());
		   ps.setLong(5, passportapply.getContactNumber());
		   ps.setLong(6, passportapply.getAadharNumber());
		   ps.setString(7, passportapply.getAddress());
		   ps.setString(8, passportapply.getNationality());
		   ps.setString(9, passportapply.getState());
		   ps.setString(10, passportapply.getCity());
		   ps.setString(11, passportapply.getApplicationId());
		 int i=  ps.executeUpdate();
		
		con.close();
		return i;
	}

	@Override
	public int delete(String id) throws SQLException {
	   Connection con = MyConnection.getConnection();
	   
	  PreparedStatement ps = con.prepareStatement("DELETE FROM PASSPORTAPPLY WHERE APPLICATIONID = ?");
	  
	  ps.setString(1, id);
	  
	 int i = ps.executeUpdate();
	   
	  con.close();
		return i;
	}
	
	public static void main(String[] args) throws ParseException, SQLException {
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yy");
		PassportApplyDAOImpl pdao = new PassportApplyDAOImpl();
		
		
		PassportApply passportclass = new PassportApply("A012345679", "Venkat", "Sai",sdf.parse("18-JUN-98") , "Guntur", 7896272982l,  123456789098l , "G1 Venkatramnagar", "Indian", "Telangana", "Hyderabad");
			
	int i = pdao.create(passportclass);

	         System.out.println(i+" row inserted");
	}

}
