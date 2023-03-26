package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.RevOrderReason;

public class RevOrderReasonMapper implements RowMapper<RevOrderReason> {

	@Override
	public RevOrderReason mapRow(ResultSet rs, int rowNum) throws SQLException {
		RevOrderReason revOrderReason = new RevOrderReason();
		revOrderReason.setRevOrderReasonId(rs.getInt("rev_order_reason_id"));
		revOrderReason.setRevSoldJobId(rs.getInt("rev_sold_job_id"));
		revOrderReason.setOrderId(rs.getInt("order_id"));
		revOrderReason.setRevReasonId(rs.getString("rev_reason_id"));
		revOrderReason.setCsrId(rs.getInt("csr_id"));
		revOrderReason.setDesignerId(rs.getInt("designer_id"));
		revOrderReason.setRevErrorTypeId(rs.getInt("rev_error_type_id"));
		revOrderReason.setTimestamp(rs.getString("timestamp")); 
		return revOrderReason;      
	}  

}
