package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.OrderCancel;
import com.production.util.CalendarUtil;

public class OrderCancelMapper implements RowMapper<OrderCancel> {

	@Override
	public OrderCancel mapRow(ResultSet rs, int rowNum) throws SQLException {
		CalendarUtil calendarUtil = new CalendarUtil();
		OrderCancel orderCancel = new OrderCancel();
		orderCancel.setOrderCancelId(rs.getInt("order_cancel_id"));
		orderCancel.setOrderId(rs.getInt("order_id"));
		orderCancel.setCsrId(rs.getInt("csr_id"));
		orderCancel.setAdrepId(rs.getInt("adrep_id"));
		orderCancel.setcReason(rs.getString("Creason"));
		orderCancel.setRetainReason(rs.getString("retain_reason"));
		orderCancel.setrReason(rs.getString("Rreason"));
		orderCancel.setcTimestamp(rs.getString("Ctimestamp"));
		orderCancel.setAtimestamp(rs.getString("Atimestamp"));
		return orderCancel;    
	}

}
