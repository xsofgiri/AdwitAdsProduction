package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.OrderRevisionReviewCsr;

public class OrderRevisionReviewCsrMapper implements RowMapper<OrderRevisionReviewCsr> {

	@Override
	public OrderRevisionReviewCsr mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderRevisionReviewCsr orRevisionRevCsr = new OrderRevisionReviewCsr();
		orRevisionRevCsr.setOrderRevisionReviewCsrId(rs.getInt("order_revision_review_csr_id"));
		orRevisionRevCsr.setOrderId(rs.getInt("order_id"));
		orRevisionRevCsr.setRevSoldJobId(rs.getInt("rev_sold_job_id"));
		orRevisionRevCsr.setVersion(rs.getString("version"));
		orRevisionRevCsr.setCsrId(rs.getInt("csr_id"));
		orRevisionRevCsr.setCsrMistake(rs.getString("csr_mistake"));
		orRevisionRevCsr.setTimestamp(rs.getString("timestamp"));
		return orRevisionRevCsr;  
	}

}
