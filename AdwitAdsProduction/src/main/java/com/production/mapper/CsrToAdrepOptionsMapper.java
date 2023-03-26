package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.CsrToAdrepOptions;
import com.mysql.jdbc.ResultSetMetaData;

public class CsrToAdrepOptionsMapper implements RowMapper<CsrToAdrepOptions> {

	@Override
	public CsrToAdrepOptions mapRow(ResultSet rs, int rowNum) throws SQLException {
		CsrToAdrepOptions csrOptions = new CsrToAdrepOptions();
		ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
		for (int i = 1; i <= rsmd.getColumnCount(); i++) {
			String columnLabel = rsmd.getColumnLabel(i);
			if (columnLabel.equals("id"))
				csrOptions.setId(rs.getInt("id"));
			if (columnLabel.equals("name"))
				csrOptions.setName(rs.getString("name"));
			if (columnLabel.equals("is_active"))
				csrOptions.setIsActive(rs.getString("is_active"));
		}
		return csrOptions;  
	}

}
