package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.AdwitProductionStaff;
import com.production.util.CalendarUtil;

public class AdwitProductionStaffMapper implements RowMapper<AdwitProductionStaff> {

	@Override
	public AdwitProductionStaff mapRow(ResultSet rs, int rowNum) throws SQLException {
		CalendarUtil calendarUtil = new CalendarUtil();
		AdwitProductionStaff adwitProductionStaff = new AdwitProductionStaff();
		adwitProductionStaff.setDesignerId(rs.getInt("designer_id"));
		adwitProductionStaff.setName(rs.getString("name"));
		adwitProductionStaff.setGender(rs.getInt("gender"));
		adwitProductionStaff.setEmailId(rs.getString("email_id"));
		adwitProductionStaff.setMobileNo(rs.getString("mobile_no"));
		adwitProductionStaff.setUsername(rs.getString("username"));
		adwitProductionStaff.setPassword(rs.getString("password"));
		adwitProductionStaff.setPwdDate(calendarUtil
				.formatDate(calendarUtil.convertDateSqlToJava(rs.getDate("pwd_date")), "yyyy-MM-dd hh:mm:ss"));
		adwitProductionStaff.setSaralID(rs.getInt("saral_id"));
		adwitProductionStaff.setDesignerLevelId(rs.getInt("designer_level_id"));
		adwitProductionStaff.setJoinLocationId(rs.getInt("join_location_id"));
		adwitProductionStaff.setWorkLocationId(rs.getInt("work_location_id"));
		adwitProductionStaff.setIsOnlineAd(rs.getInt("is_online_ad"));
		adwitProductionStaff.setDesignerRoleId(rs.getInt("designer_role_id"));
		adwitProductionStaff.setEncryptedKey(rs.getString("encrypted_key"));
		adwitProductionStaff.setImage(rs.getString("image"));
		adwitProductionStaff.setShiftFactor(rs.getFloat("shift_factor"));
		adwitProductionStaff.setShiftFactorStatus(rs.getInt("shift_factor_status"));
		adwitProductionStaff.setIsNewD(rs.getInt("is_new_d"));
		adwitProductionStaff.setPwdExpiryDate(calendarUtil
				.formatDate(calendarUtil.convertDateSqlToJava(rs.getDate("pwd_expiry_date")), "yyyy-MM-dd hh:mm:ss"));
		adwitProductionStaff.setCreatedOn(rs.getString("created_on"));
		adwitProductionStaff.setIsActive(rs.getInt("is_active"));
		adwitProductionStaff.setIsDeleted(rs.getInt("is_deleted"));
		adwitProductionStaff.setPublicationId(rs.getString("publication_id"));
		adwitProductionStaff.setCategoryLevel(rs.getString("category_level"));
		adwitProductionStaff.setClubId(rs.getString("club_id"));
		adwitProductionStaff.setAlias(rs.getString("alias"));
		adwitProductionStaff.setBusinessGroupId(rs.getInt("business_group_id"));
		adwitProductionStaff.setIsPdfReviewTool(rs.getString("is_pdf_review_tool"));

		return adwitProductionStaff;
	}

}
