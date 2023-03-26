package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.LitePackage;

public class LitePackageMapper implements RowMapper<LitePackage> {

	@Override
	public LitePackage mapRow(ResultSet rs, int rowNum) throws SQLException {
		LitePackage litePackage = new LitePackage();
		litePackage.setId(rs.getInt("id"));
		litePackage.setName(rs.getString("name"));
		litePackage.setMinPrice(rs.getFloat("min_price"));
		litePackage.setMaxPrice(rs.getFloat("max_price"));
		litePackage.setNumDays(rs.getInt("num_days"));   
		litePackage.setDiscount(rs.getFloat("discount"));
		litePackage.setTimestamp(rs.getString("timestamp"));
		return litePackage;
	}

}
