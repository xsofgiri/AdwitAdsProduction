package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.TimeZone;

public class TimeZoneMapper implements RowMapper<TimeZone> {

	@Override
	public TimeZone mapRow(ResultSet rs, int rowNum) throws SQLException {
		TimeZone timeZone = new TimeZone();
		timeZone.setTimeZoneID(rs.getInt("time_zone_id"));
		timeZone.setTimeZoneName(rs.getString("time_zone_name"));
		timeZone.setPriority(rs.getInt("priority"));
		return timeZone;
	}
}
