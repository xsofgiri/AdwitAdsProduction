package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.Designer;
import com.production.util.CalendarUtil;

public class DesignerMapper implements RowMapper<Designer> {

	@Override
	public Designer mapRow(ResultSet rs, int rowNum) throws SQLException {
		CalendarUtil calendarUtil = new CalendarUtil();
		Designer designer = new Designer();
		designer.setDesignerId(rs.getInt("designer_id"));
		designer.setName(rs.getString("name"));
		designer.setGender(rs.getInt("gender"));
		designer.setEmail(rs.getString("email_id"));
		designer.setMobileNo(rs.getString("mobile_no"));
		designer.setUsername(rs.getString("username"));
		designer.setPassword(rs.getString("password"));
		designer.setPwdDate(calendarUtil.formatDate(calendarUtil.convertDateSqlToJava(rs.getDate("pwd_date")),
				"yyyy-MM-dd hh:mm:ss"));
		designer.setSaralId(rs.getInt("saral_id"));
		designer.setDesignerLevelId(rs.getInt("designer_level_id"));
		designer.setJoinLocationId(rs.getInt("join_location_id"));
		designer.setWorkLocationId(rs.getInt("work_location_id"));
		designer.setIsOnlineAd(rs.getInt("is_online_ad"));
		designer.setDesignerRoleId(rs.getInt("designer_role_id"));
		designer.setEncryptedKey(rs.getString("encrypted_key"));
		designer.setImage(rs.getString("image"));
		designer.setShiftFactor(rs.getFloat("shift_factor"));
		designer.setShiftFactorStatus(rs.getInt("shift_factor_status"));
		designer.setIsNewD(rs.getInt("is_new_d"));
		designer.setPwdDate(calendarUtil.formatDate(calendarUtil.convertDateSqlToJava(rs.getDate("pwd_expiry_date")),
				"yyyy-MM-dd hh:mm:ss"));
		designer.setCreatedOn(rs.getString("created_on"));
		designer.setActive(rs.getBoolean("is_active"));
		designer.setDeleted(rs.getBoolean("is_deleted"));
		designer.setPublicationIds(rs.getString("publication_id"));
		designer.setCategoryLevel(rs.getString("category_level"));
		designer.setClubIds(rs.getString("club_id"));
		designer.setAlias(rs.getString("alias"));
		return designer;
	}

}
