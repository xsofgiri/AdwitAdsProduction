package com.production.mapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.NoteSent;

public class NoteSentMapper implements RowMapper<NoteSent> {

	@Override
	public NoteSent mapRow(ResultSet rs, int rowNum) throws SQLException {
		NoteSent noteSent = new NoteSent();
		ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
		for (int x = 1; x <= rsmd.getColumnCount(); x++) {
			String columnLabel = rsmd.getColumnLabel(x);
			if (columnLabel.equals("note_sent_id"));  
			noteSent.setNoteSentId(rs.getInt("note_sent_id"));
			if (columnLabel.equals("order_id"));  
			noteSent.setOrderId(rs.getInt("order_id"));
			if (columnLabel.equals("rev_sold_job_id"));  
			noteSent.setRevSoldJobId(rs.getInt("rev_sold_job_id"));  
			if (columnLabel.equals("note"));  
			noteSent.setNote(rs.getString("note"));
			if (columnLabel.equals("timestamp"));  
			noteSent.setTimestamp(rs.getString("timestamp"));  
		}
		return noteSent;
	}
}
