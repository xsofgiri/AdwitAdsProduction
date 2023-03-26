package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.SourceTracker;
import com.production.util.CalendarUtil;

public class SourceTrackerMapper implements RowMapper<SourceTracker> {

	@Override
	public SourceTracker mapRow(ResultSet rs, int rowNum) throws SQLException {
		CalendarUtil calendarUtil = new CalendarUtil();

		SourceTracker sourceTracker = new SourceTracker();
		sourceTracker.setSourceTrackerId(rs.getInt("source_tracker_id"));
		sourceTracker.setOrderId(rs.getInt("order_id"));
		sourceTracker.setStart(
				calendarUtil.formatDate(calendarUtil.convertTimeSqlToJava(rs.getTime("start")), "hh:mm:ss"));
		sourceTracker.setCheck(
				calendarUtil.formatDate(calendarUtil.convertTimeSqlToJava(rs.getTime("check")), "hh:mm:ss"));
		sourceTracker.setZip(
				calendarUtil.formatDate(calendarUtil.convertTimeSqlToJava(rs.getTime("zip")), "hh:mm:ss"));
		sourceTracker.setFtp(
				calendarUtil.formatDate(calendarUtil.convertTimeSqlToJava(rs.getTime("ftp")), "hh:mm:ss"));
		sourceTracker.setDelete(calendarUtil.formatDate(calendarUtil.convertTimeSqlToJava(rs.getTime("delete")),
				"hh:mm:ss"));
		sourceTracker.setMonth(rs.getString("month"));
		sourceTracker.setZipFilePath(rs.getString("zip_file_path"));
		sourceTracker.setIsActive(rs.getInt("is_active"));

		return sourceTracker;      
	}

}
