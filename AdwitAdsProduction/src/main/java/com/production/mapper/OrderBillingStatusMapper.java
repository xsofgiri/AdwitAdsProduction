package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.OrderBillingStatus;

public class OrderBillingStatusMapper implements RowMapper<OrderBillingStatus> {

	@Override
	public OrderBillingStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderBillingStatus orderBillingStatus = new OrderBillingStatus();
		orderBillingStatus.setOrderBillingStatusId(rs.getInt("order_billing_status_id"));
		orderBillingStatus.setOrderId(rs.getString("order_id"));
		orderBillingStatus.setCatResultId(rs.getInt("cat_result_id"));
		orderBillingStatus.setReason(rs.getString("reason"));
		orderBillingStatus.setStatus(rs.getInt("status"));
		orderBillingStatus.setDate(rs.getString("date"));
		return orderBillingStatus;
	}

}
