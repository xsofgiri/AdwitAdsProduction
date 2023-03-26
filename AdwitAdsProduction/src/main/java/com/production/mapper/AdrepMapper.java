package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.Adrep;

public class AdrepMapper implements RowMapper<Adrep> {

	@Override
	public Adrep mapRow(ResultSet rs, int rowNum) throws SQLException {
		Adrep adrep = new Adrep();
		adrep.setAdrepId(rs.getInt("adrep_id"));
		adrep.setFirstName(rs.getString("first_name"));
		adrep.setLastName(rs.getString("last_name"));
		adrep.setGender(rs.getInt("gender"));
		adrep.setEmailId(rs.getString("email_id"));
		adrep.setPublicationId(rs.getInt("publication_id"));
		adrep.setUserName(rs.getString("username"));
		adrep.setPassword(rs.getString("password"));
		adrep.setEmailCC(rs.getString("email_cc"));
		adrep.setPhone1(rs.getString("phone_1"));
		adrep.setPhone2(rs.getString("phone_2"));
		adrep.setMobileNo(rs.getString("mobile_no"));
		adrep.setAddress(rs.getString("address"));
		adrep.setFax(rs.getString("fax"));
		adrep.setImage(rs.getString("image"));
		adrep.setIsAdSearch(rs.getInt("is_ad_search"));
		adrep.setDisplayOrders(rs.getInt("display_orders"));
		adrep.setNewUI(rs.getString("new_ui"));
		adrep.setIsPage(rs.getInt("is_page"));
		adrep.setIsTeamOrders(rs.getString("is_team_orders"));
		adrep.setIsRush(rs.getInt("is_rush"));
		adrep.setIsTemplate(rs.getInt("is_template"));
		adrep.setCouponSpec(rs.getInt("coupon_spec")); 
		adrep.setBilling(rs.getInt("billing"));
		adrep.setIsPrintAd(rs.getString("is_print_ad"));
		adrep.setIsOnlineAd(rs.getString("is_online_ad"));
		adrep.setIsPageDesignAd(rs.getString("is_pagedesign_ad"));
		adrep.setEncryptedKey(rs.getString("encrypted_key"));
		adrep.setIsPremium(rs.getString("is_premium"));
		adrep.setColorCode(rs.getString("color_code"));
		adrep.setCreatedOn(rs.getString("created_on"));
		adrep.setIsActive(rs.getInt("is_active"));
		adrep.setIsDeleted(rs.getInt("is_deleted"));

		return adrep;
	}

}
