package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.LiteCreditsAdded;
import com.production.util.CalendarUtil;

public class LiteCreditsAddedMapper implements RowMapper<LiteCreditsAdded> {

	@Override
	public LiteCreditsAdded mapRow(ResultSet rs, int rowNum) throws SQLException {
		LiteCreditsAdded liteCreditsAdded = new LiteCreditsAdded();
		CalendarUtil calendarUtil = new CalendarUtil();
		liteCreditsAdded.setId(rs.getInt("id"));
		liteCreditsAdded.setuId(rs.getInt("uid"));
		liteCreditsAdded.setCredits(rs.getFloat("credits"));
		liteCreditsAdded.setPrice(rs.getFloat("price"));
		liteCreditsAdded.setCreditsType(rs.getInt("credits_type"));
		liteCreditsAdded.setExpiry(
				calendarUtil.formatDate(calendarUtil.convertDateSqlToJava(rs.getDate("expiry")), "yyyy-MM-dd"));
		liteCreditsAdded.setIsActive(rs.getInt("is_active"));
		return liteCreditsAdded;
	}

}  
