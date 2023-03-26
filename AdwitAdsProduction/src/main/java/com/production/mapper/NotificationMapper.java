package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.Notification;
import com.production.util.CalendarUtil;

public class NotificationMapper implements RowMapper<Notification> {

	@Override
	public Notification mapRow(ResultSet rs, int rowNum) throws SQLException {

		CalendarUtil calendarUtil = new CalendarUtil();
		Notification notification = new Notification();
		notification.setNotificationId(rs.getInt("notification_id"));
		notification.setHeadline(rs.getString("headline"));
		notification.setMessage(rs.getString("message"));
		notification.setAdwitUserId(rs.getInt("adwit_user_id"));
		notification.setAdrepId(rs.getInt("adrep_id"));
		notification.setPublicationId(rs.getInt("publication_id"));
		notification.setImage(rs.getString("image"));
		notification.setStartDate(calendarUtil.formatDate(calendarUtil.convertDateSqlToJava(rs.getDate("start_date")),
				"yyyy-MM-dd"));
		notification.setEndDate(calendarUtil.formatDate(calendarUtil.convertDateSqlToJava(rs.getDate("end_date")),
				"yyyy-MM-dd"));
		notification.setTime(rs.getString("time"));
		notification.setJobStatus(rs.getInt("job_status"));

		return notification;
	}

}
