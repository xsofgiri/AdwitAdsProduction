package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.LiteMyCreditsHistory;

public class LiteMyCreditsHistoryMapper implements RowMapper<LiteMyCreditsHistory> {

	@Override
	public LiteMyCreditsHistory mapRow(ResultSet rs, int rowNum) throws SQLException {
		LiteMyCreditsHistory liteHistory = new LiteMyCreditsHistory();
		liteHistory.setId(rs.getInt("id"));
		liteHistory.setuId(rs.getInt("uid"));
		liteHistory.setCreditsAddedId(rs.getInt("credits_added_id"));
		liteHistory.setCreditsDebited(rs.getFloat("credits_debited"));
		liteHistory.setOrderId(rs.getInt("order_id"));
		liteHistory.setCreditsCredited(rs.getFloat("credits_credited"));
		liteHistory.setPurpose(rs.getInt("purpose"));
		liteHistory.setTimestamp(rs.getString("timestamp"));
		return liteHistory;  
	}

}
