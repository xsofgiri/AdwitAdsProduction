package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.LitePackageOld;

public class LitePackageOldMapper implements RowMapper<LitePackageOld> {

	@Override
	public LitePackageOld mapRow(ResultSet rs, int rowNum) throws SQLException {
		LitePackageOld litePackageOld = new LitePackageOld();
		litePackageOld.setId(rs.getInt("id"));
		litePackageOld.setuId(rs.getInt("uid"));
		litePackageOld.setCredits(rs.getInt("credits"));
		litePackageOld.setCreditsPrice(rs.getFloat("credits_price"));
		litePackageOld.setDiscount(rs.getFloat("discount"));
		litePackageOld.setPerDiscount(rs.getFloat("per_discount"));
		litePackageOld.setTotalPrice(rs.getInt("total_price"));
		litePackageOld.setTimestamp(rs.getString("time_stamp"));
		return litePackageOld;  
	}
  
}
