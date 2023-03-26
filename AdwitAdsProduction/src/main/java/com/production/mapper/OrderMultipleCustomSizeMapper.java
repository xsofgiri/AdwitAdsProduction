package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.OrderMultipleCustomSize;

public class OrderMultipleCustomSizeMapper implements RowMapper<OrderMultipleCustomSize> {

	@Override
	public OrderMultipleCustomSize mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderMultipleCustomSize orderMultiplCustomSize = new OrderMultipleCustomSize();
		orderMultiplCustomSize.setOrderMultipleCustomSizeId(rs.getInt("order_multiple_custom_size_id"));
		orderMultiplCustomSize.setOrderId(rs.getInt("order_id"));
		orderMultiplCustomSize.setCustomWidth(rs.getInt("custom_width"));
		orderMultiplCustomSize.setCustomHeight(rs.getInt("custom_height"));
		return orderMultiplCustomSize;
	}

}
