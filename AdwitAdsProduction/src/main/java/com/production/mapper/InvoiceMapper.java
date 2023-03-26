package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.Invoice;

public class InvoiceMapper implements RowMapper<Invoice> {

	@Override
	public Invoice mapRow(ResultSet rs, int rowNum) throws SQLException {
		Invoice invoice = new Invoice(); 
		invoice.setInvoiceId(rs.getInt("invoice_id"));
		invoice.setPublicationId(rs.getInt("publication_id"));
		invoice.setCustomerId(rs.getInt("customer_id"));
		invoice.setBillingStatusId(rs.getInt("billing_status_id"));
		invoice.setTime(rs.getString("time"));
		invoice.setAccountId(rs.getInt("account_id"));
		invoice.setInvoiceNo(rs.getString("invoice_no"));
		invoice.setInvoiceNo1(rs.getInt("invoice_no1"));
		invoice.setQuantity(rs.getInt("quantity"));
		invoice.setTotalSqInches(rs.getFloat("total_sq_inches"));
		invoice.setTotalUsd(rs.getFloat("total_usd"));
		invoice.setDate(rs.getString("date"));
		invoice.setSpecialDiscount(rs.getFloat("special_discount"));
		invoice.setSubtotal(rs.getFloat("sub_total"));
		invoice.setDesc(rs.getFloat("desc"));
		invoice.setTotalDue(rs.getFloat("total_due"));

		return invoice;
	}

}
