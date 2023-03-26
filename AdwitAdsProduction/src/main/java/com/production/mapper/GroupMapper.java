package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.Group;
import com.production.util.CalendarUtil;

public class GroupMapper implements RowMapper<Group> {

	@Override
	public Group mapRow(ResultSet rs, int rowNum) throws SQLException {
		CalendarUtil calendarUtil = new CalendarUtil();
		Group group = new Group();
		group.setGroupId(rs.getInt("group_id"));
		group.setName(rs.getString("name"));
		group.setHelpDeskId(rs.getInt("help_desk_id"));
		group.setChannelId(rs.getInt("channel_id"));
		group.setCatSlugTypeId(rs.getInt("cat_slug_type_id"));
		group.setIsBillingSystem(rs.getInt("is_billing_system"));
		group.setBillingEffectiveDate(calendarUtil.formatDate(
				calendarUtil.convertDateSqlToJava(rs.getDate("billing_effective_date")), "yyyy-MM-dd hh:mm:ss"));
		group.setInitial(rs.getString("initial"));
		group.setIsDisplayPub(rs.getInt("is_display_pub"));
		group.setPriority(rs.getInt("priority"));
		group.setIsActive(rs.getInt("is_active"));

		return group;
	}

}
