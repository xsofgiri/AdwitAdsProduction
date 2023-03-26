package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.DpErrorResult;

public class DpErrorResultMapper implements RowMapper<DpErrorResult> {

	@Override
	public DpErrorResult mapRow(ResultSet rs, int rowNum) throws SQLException {
		DpErrorResult dpErrorResult = new DpErrorResult();  
		dpErrorResult.setDpErrorResultId(rs.getInt("dp_error_result_id"));
		dpErrorResult.setDpResultId(rs.getInt("dp_result_id"));
		dpErrorResult.setJobName(rs.getString("job_name"));
		dpErrorResult.setDpErrorId(rs.getInt("dp_error_id"));
		dpErrorResult.setDpErrorTypeId(rs.getInt("dp_error_type_id"));
		dpErrorResult.setDpErrorDegreeId(rs.getInt("dp_error_degree_id"));
		return dpErrorResult;    
	}

}
