package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.PaymentTransaction;
import com.production.util.CalendarUtil;

public class PaymentTransactionMapper implements RowMapper<PaymentTransaction> {

	@Override
	public PaymentTransaction mapRow(ResultSet rs, int rowNum) throws SQLException {
		PaymentTransaction paymentTransaction = new PaymentTransaction();
		CalendarUtil calendarUtil = new CalendarUtil();

		paymentTransaction.setId(rs.getInt("id"));
		paymentTransaction.setCustomerId(rs.getInt("customer_id"));
		paymentTransaction.setTrackingId(rs.getLong("tracking_id"));
		paymentTransaction.setBankRefNo(rs.getInt("bank_ref_no"));
		paymentTransaction.setOrderStatus(rs.getString("order_status"));
		paymentTransaction.setFailureMessage(rs.getString("failure_message"));
		paymentTransaction.setPaymentMode(rs.getString("payment_mode"));
		paymentTransaction.setCardName(rs.getString("card_name"));
		paymentTransaction.setStatusCode(rs.getString("status_code"));
		paymentTransaction.setStatusMessage(rs.getString("status_message"));
		paymentTransaction.setCurrency(rs.getString("currency"));
		paymentTransaction.setAmount(rs.getFloat("amount"));
		paymentTransaction.setTimestamp(rs.getString("timestamp"));

		return paymentTransaction;
	}

}
