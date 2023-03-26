package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.LiteOnlineFormat;

public class LiteOnlineFormatMapper implements RowMapper<LiteOnlineFormat> {

	@Override
	public LiteOnlineFormat mapRow(ResultSet rs, int rowNum) throws SQLException {
		LiteOnlineFormat liteFormat = new LiteOnlineFormat();
		liteFormat.setId(rs.getInt("id")); 
		liteFormat.setName(rs.getString("name"));  
		liteFormat.setsTatic(rs.getInt("static"));
		liteFormat.setsCredits(rs.getFloat("s_credits"));
		liteFormat.setAnimated(rs.getInt("animated"));
		liteFormat.setaCredits(rs.getFloat("a_credits"));
		return liteFormat;  
	}

}
