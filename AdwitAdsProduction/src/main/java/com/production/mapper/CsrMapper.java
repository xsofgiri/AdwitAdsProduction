package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.Csr;
import com.production.util.CalendarUtil;

public class CsrMapper implements RowMapper<Csr> {

	@Override
	public Csr mapRow(ResultSet rs, int rowNum) throws SQLException {
		CalendarUtil calendarUtil = new CalendarUtil();
		Csr csr = new Csr();
		csr.setCsrId(rs.getInt("csr_id"));
		csr.setName(rs.getString("name"));
		csr.setAlias(rs.getString("alias"));
		csr.setGender(rs.getInt("gender"));
		csr.setCsrRoleId(rs.getInt("csr_role_id"));
		csr.setBusinessGroupId(rs.getInt("business_group_id"));
		csr.setIsTeam(rs.getInt("is_team"));  
		csr.setEmailId(rs.getString("email_id"));
		csr.setUsername(rs.getString("username"));
		csr.setPassword(rs.getString("password"));
		csr.setPwdDate(
				calendarUtil.formatDate(calendarUtil.convertDateSqlToJava(rs.getDate("pwd_date")), "yyyy-MM-dd"));
		csr.setSaralId(rs.getInt("saral_id"));
		csr.setMobileNo(rs.getString("mobile_no"));
		csr.setJoinLocationId(rs.getInt("join_location_id"));
		csr.setWorkLocationId(rs.getInt("work_location_id"));
		csr.setExtNo(rs.getString("ext_no"));
		csr.setShiftFactor(rs.getInt("shift_factor"));
		csr.setIsNewCsr(rs.getInt("is_new_csr"));
		csr.setIsWebAd(rs.getInt("is_web_ad"));
		csr.setIsRequests(rs.getInt("is_requests"));
		csr.setImagePath(rs.getString("image_path"));
		csr.setPwdDate(calendarUtil.formatDate(calendarUtil.convertDateSqlToJava(rs.getDate("pwd_expiry_date")),
				"yyyy-MM-dd"));
		csr.setEncryptedKey(rs.getString("encrypted_key"));
		csr.setCreatedOn(rs.getString("created_on"));
		csr.setIsActive(rs.getInt("is_active"));
		csr.setIsDeleted(rs.getInt("is_deleted"));
		csr.setPublicationId(rs.getString("publication_id"));
		csr.setCategoryLevel(rs.getString("category_level"));
		csr.setClubId(rs.getString("club_id"));
		csr.setIsPdfReviewTool(rs.getString("is_pdf_review_tool")); 

		return csr;
	}

}
