package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.OrderMultipleSize;

public class OrderMultipleSizeMapper implements RowMapper<OrderMultipleSize> {

	@Override
	public OrderMultipleSize mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderMultipleSize orderMultipleSize = new OrderMultipleSize();
		orderMultipleSize.setOrderMultipleSizeId(rs.getInt("order_multiple_size_id"));
		orderMultipleSize.setOrderId(rs.getInt("order_id"));
		orderMultipleSize.setSizeID(rs.getInt("size_id"));
		return orderMultipleSize;
	}

}
