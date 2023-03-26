package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.LiteOrders;
import com.production.util.CalendarUtil;

public class LiteOrdersMapper implements RowMapper<LiteOrders> {

	@Override
	public LiteOrders mapRow(ResultSet rs, int rowNum) throws SQLException {
		CalendarUtil calendarUtil = new CalendarUtil();
		LiteOrders liteOrder = new LiteOrders();
		liteOrder.setId(rs.getInt("id"));
		liteOrder.setUid(rs.getInt("uid"));
		liteOrder.setJobName(rs.getString("job_name"));
		liteOrder.setWidth(rs.getFloat("width"));
		liteOrder.setHeight(rs.getFloat("height"));
		liteOrder.setColorPreference(rs.getInt("color_preference"));
		liteOrder.setDateNeeded(
				calendarUtil.formatDate(calendarUtil.convertDateSqlToJava(rs.getDate("date_needed")), "yyyy-MM-dd"));
		liteOrder.setCredits(rs.getFloat("credits"));
		liteOrder.setCopyContent(rs.getString("copy_content"));
		liteOrder.setInstruction(rs.getString("instruction"));
		liteOrder.setStatus(rs.getInt("status"));
		liteOrder.setTimestamp(rs.getString("time_stamp"));
		liteOrder.setDocImage(rs.getString("doc_image"));
		return liteOrder;

	}

}
