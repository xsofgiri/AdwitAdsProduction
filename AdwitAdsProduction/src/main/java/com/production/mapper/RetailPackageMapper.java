package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.RetailPackage;

public class RetailPackageMapper implements RowMapper<RetailPackage> {

	@Override
	public RetailPackage mapRow(ResultSet rs, int rowNum) throws SQLException {
		RetailPackage retailPackage = new RetailPackage();
		retailPackage.setId(rs.getInt("id"));
		retailPackage.setuId(rs.getInt("uid"));
		retailPackage.setCredits(rs.getInt("credits"));
		retailPackage.setCreditsPrice(rs.getFloat("credits_price"));
		retailPackage.setDiscount(rs.getFloat("discount"));
		retailPackage.setPerDiscount(rs.getFloat("per_discount"));
		retailPackage.setTotalPrice(rs.getInt("total_price"));
		retailPackage.setTimestamp(rs.getString("time_stamp"));
		return retailPackage;  
	}

}
