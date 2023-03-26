package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.DesignerAdsTime;
import com.production.util.CalendarUtil;

public class DesignerAdsTimeMapper implements RowMapper<DesignerAdsTime> {

	@Override
	public DesignerAdsTime mapRow(ResultSet rs, int rowNum) throws SQLException {
		DesignerAdsTime designerAdsTime = new DesignerAdsTime();
		CalendarUtil calendarUtil = new CalendarUtil();
		designerAdsTime.setDesignerAdsTimeId(rs.getInt("designer_ads_time_id"));
		designerAdsTime.setOrderId(rs.getInt("order_id"));
		designerAdsTime.setStartTime(rs.getString("start_time"));
		designerAdsTime.setEndDate(
				calendarUtil.formatDate(calendarUtil.convertDateSqlToJava(rs.getDate("end_date")), "yyyy-MM-dd"));
		designerAdsTime.setEndTime(
				calendarUtil.formatDate(calendarUtil.convertTimeSqlToJava(rs.getTime("end_time")), "hh:mm:ss"));
		designerAdsTime.setTimeTaken(rs.getString("time_taken"));
		designerAdsTime.setDesignerId(rs.getInt("designer_id"));
		return designerAdsTime;
	}

}
