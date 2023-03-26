package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.LiteFreeOrder;
import com.production.entity.LiteOrders;

public class LiteFreeOrderMapper implements RowMapper<LiteFreeOrder> {

	@Override
	public LiteFreeOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
		LiteFreeOrder liteFreeOrder = new LiteFreeOrder();
		liteFreeOrder.setId(rs.getInt("id"));
		liteFreeOrder.setFirstName(rs.getString("first_name"));
		liteFreeOrder.setLastName(rs.getString("last_name"));
		liteFreeOrder.setEmailId(rs.getString("email_id"));
		liteFreeOrder.setAdvertiserName(rs.getString("advertiser_name"));
		liteFreeOrder.setJobName(rs.getString("job_name"));
		liteFreeOrder.setWidth(rs.getFloat("width"));
		liteFreeOrder.setHeight(rs.getFloat("height"));
		liteFreeOrder.setPrintAdType(rs.getInt("print_ad_type"));
		liteFreeOrder.setCopyContentDescription(rs.getString("copy_content_description"));
		liteFreeOrder.setFilePath(rs.getString("file_path"));
		liteFreeOrder.setCreatedOn(rs.getString("created_on"));
		return liteFreeOrder;
	}

}
