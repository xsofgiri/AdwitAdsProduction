package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.DpError;

public class DpErrorMapper implements RowMapper<DpError> {

	@Override
	public DpError mapRow(ResultSet rs, int rowNum) throws SQLException {
		DpError dpError = new DpError();  
		dpError.setDpErrorId(rs.getInt("dp_error_id"));
		dpError.setName(rs.getString("name"));
		dpError.setGroupId(rs.getInt("group_id"));
		dpError.setDpErrorTypeId(rs.getInt("dp_error_type_id"));
		dpError.setDpErrorDegreeId(rs.getInt("dp_error_degree_id"));
		dpError.setIsStatus(rs.getInt("is_status"));
		return dpError;
	}

}
