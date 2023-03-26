package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.Payment;
import com.production.util.CalendarUtil;

public class PaymentMapper implements RowMapper<Payment> {

	@Override
	public Payment mapRow(ResultSet rs, int rowNum) throws SQLException {
		CalendarUtil calendarUtil = new CalendarUtil();
		Payment payment = new Payment();
		payment.setId(rs.getInt("id"));
		payment.setPaymentId(rs.getString("paymentId"));
		payment.setPaymentStatus(rs.getString("payment_status"));
		payment.setTotal(rs.getString("total"));
		payment.setDescription(rs.getString("description"));
		payment.setFirstName(rs.getString("first_name"));
		payment.setLastName(rs.getString("last_name"));
		payment.setAddress(rs.getString("address"));
		payment.setZip(rs.getString("zip"));
		payment.setCity(rs.getString("city"));
		payment.setCreatedOn(calendarUtil.formatDate(calendarUtil.convertDateSqlToJava(rs.getDate("created_on")),
				"yyyy-MM-dd hh:mm:ss"));
		payment.setUpdatedOn(calendarUtil.formatDate(calendarUtil.convertDateSqlToJava(rs.getDate("updated_on")),
				"yyyy-MM-dd hh:mm:ss"));
		return null;
	}

}
