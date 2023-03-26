package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.PreOrder;

public class PreOrderMapper implements RowMapper<PreOrder> {

	@Override
	public PreOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
		PreOrder preOrder = new PreOrder();
		preOrder.setStatus(rs.getString("status"));
		preOrder.setJobName(rs.getString("job_name"));  
		preOrder.setCustomerId(rs.getString("customer_id"));
		preOrder.setAdvertiser(rs.getString("advertiser"));
		preOrder.setPublication(rs.getString("publication"));
		preOrder.setPublishDate(rs.getString("publish_date"));
		preOrder.setSection(rs.getString("section"));
		preOrder.setAdrepId(rs.getString("adrep_id"));
		preOrder.setDateNeeded(rs.getString("date_needed"));
		preOrder.setTime(rs.getString("time"));
		preOrder.setUnit(rs.getString("unit"));
		preOrder.setWidth1(rs.getFloat("width1"));
		preOrder.setWidth2(rs.getFloat("width2"));
		preOrder.setHeight(rs.getFloat("height"));
		preOrder.setColor(rs.getString("color"));
		preOrder.setFile(rs.getString("file"));
		preOrder.setTimestamp(rs.getString("time_stamp"));
		preOrder.setAccept(rs.getInt("accept"));
		preOrder.setId(rs.getInt("id"));
		return preOrder;
	}

}
