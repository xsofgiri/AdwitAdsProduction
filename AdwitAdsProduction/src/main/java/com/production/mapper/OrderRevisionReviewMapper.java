package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.OrderRevisionReview;

public class OrderRevisionReviewMapper implements RowMapper<OrderRevisionReview> {

	@Override
	public OrderRevisionReview mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderRevisionReview orderRevisionReview = new OrderRevisionReview();
		orderRevisionReview.setOrderRevisionReviewId(rs.getInt("order_revision_review_id"));
		orderRevisionReview.setOrderId(rs.getInt("order_id"));
		orderRevisionReview.setRevSoldJobId(rs.getInt("rev_sold_job_id"));
		orderRevisionReview.setVersion(rs.getString("version"));
		orderRevisionReview.setDesignerId(rs.getInt("designer_id"));
		orderRevisionReview.setDesignerMistake(rs.getString("designer_mistake"));
		orderRevisionReview.setTimestamp(rs.getString("timestamp"));
		return orderRevisionReview;
	}

}
