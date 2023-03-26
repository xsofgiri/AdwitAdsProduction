package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.CancelReason;

public class CancelReasonMapper implements RowMapper<CancelReason> {

	@Override
	public CancelReason mapRow(ResultSet rs, int rowNum) throws SQLException {
		CancelReason cancelReason = new CancelReason();
		cancelReason.setId(rs.getInt("id"));
		cancelReason.setName(rs.getString("name")); 
		return cancelReason;  
	}

}
