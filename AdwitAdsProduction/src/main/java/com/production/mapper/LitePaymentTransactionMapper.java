package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.LitePaymentTransaction;
import com.production.util.CalendarUtil;

public class LitePaymentTransactionMapper implements RowMapper<LitePaymentTransaction> {

	@Override
	public LitePaymentTransaction mapRow(ResultSet rs, int rowNum) throws SQLException {
		CalendarUtil calendarUtil = new CalendarUtil();
		LitePaymentTransaction liTransaction = new LitePaymentTransaction();

		liTransaction.setId(rs.getInt("id"));
		liTransaction.setCustomerId(rs.getInt("customer_id"));
		liTransaction.setTrackingId(rs.getLong("tracking_id"));
		liTransaction.setBankRefNo(rs.getInt("bank_ref_no"));
		liTransaction.setOrderStatus(rs.getString("order_status"));
		liTransaction.setFailureMessage(rs.getString("failure_message"));
		liTransaction.setPaymentMode(rs.getString("payment_mode"));
		liTransaction.setCardName(rs.getString("card_name"));
		liTransaction.setStatusCode(rs.getString("status_code"));
		liTransaction.setStatusMessage(rs.getString("status_message"));
		liTransaction.setCurrency(rs.getString("currency"));
		liTransaction.setAmount(rs.getFloat("amount"));
		liTransaction.setCredits(rs.getFloat("credits"));
		liTransaction.setTimestamp(rs.getString("timestamp"));
		liTransaction.setMd5Id(rs.getString("md5_id"));
		return liTransaction;
	}

}
