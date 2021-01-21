package model;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface PassportApplyDAO {
	

	int create(PassportApply passportapply) throws SQLException;

	List<PassportApply> read() throws SQLException, ParseException;

	PassportApply read(String id) throws SQLException, ParseException;

	int update(PassportApply passportapply) throws SQLException;

	

	int delete(String id) throws SQLException;



}
