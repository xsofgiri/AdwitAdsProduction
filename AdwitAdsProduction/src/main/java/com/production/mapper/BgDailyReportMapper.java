package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.BgDailyReport;
import com.production.util.CalendarUtil;

public class BgDailyReportMapper implements RowMapper<BgDailyReport> {

	@Override
	public BgDailyReport mapRow(ResultSet rs, int rowNum) throws SQLException {

		BgDailyReport bgDailyReport = new BgDailyReport();
		CalendarUtil calendarUtil = new CalendarUtil();

		bgDailyReport.setDay(rs.getString("day"));
		bgDailyReport.setMetroCount(rs.getInt("metro_count"));
		bgDailyReport.setMetroColor(rs.getString("metro_color"));
		bgDailyReport.setTsCount(rs.getInt("ts_count"));
		bgDailyReport.setTsColor(rs.getString("ts_color"));
		bgDailyReport.setSoftwriteCount(rs.getInt("softwrite_count"));
		bgDailyReport.setSoftWriteColor(rs.getString("softwrite_color"));
		bgDailyReport.setCanadaCount(rs.getInt("canada_count"));
		bgDailyReport.setCanadaColor(rs.getString("canada_color"));
		bgDailyReport.setAgCount(rs.getInt("ag_count"));
		bgDailyReport.setAgColor(rs.getString("ag_color"));
		bgDailyReport
				.setDate(calendarUtil.formatDate(calendarUtil.convertDateSqlToJava(rs.getDate("date")), "yyyy-MM-dd"));
		bgDailyReport
				.setTime(calendarUtil.formatDate(calendarUtil.convertTimeSqlToJava(rs.getTime("time")), "hh:mm:ss"));
		return bgDailyReport;
	}

}
