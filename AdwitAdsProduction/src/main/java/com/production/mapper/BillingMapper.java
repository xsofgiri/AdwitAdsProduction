package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.Billing;

public class BillingMapper implements RowMapper<Billing> {

	@Override
	public Billing mapRow(ResultSet rs, int rowNum) throws SQLException {
		Billing billing = new Billing();
		billing.setBillingId(rs.getInt("billing_id"));
		billing.setPublicationId(rs.getInt("publication_id"));  
		billing.setGroupId(rs.getInt("group_id"));
		billing.setMonth(rs.getString("month"));
		billing.setBillingStatusId(rs.getInt("billing_status_id"));
		billing.setInvoiceId(rs.getInt("invoice_id"));
		return billing;  
	}  

}
