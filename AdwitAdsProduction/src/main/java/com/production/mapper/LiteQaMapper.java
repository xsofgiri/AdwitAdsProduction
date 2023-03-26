package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.LiteQa;

public class LiteQaMapper implements RowMapper<LiteQa> {

	@Override
	public LiteQa mapRow(ResultSet rs, int rowNum) throws SQLException {  
		LiteQa liteQa = new LiteQa();
		liteQa.setId(rs.getInt("id"));
		liteQa.setuId(rs.getInt("uId"));
		liteQa.setQuestion(rs.getString("question"));
		liteQa.setAnswer(rs.getString("answer"));
		liteQa.setQueTimestamp(rs.getString("que_timestamp"));
		liteQa.setAnsTimestamp(rs.getString("ans_timestamp"));
		return liteQa;  
	}

}
