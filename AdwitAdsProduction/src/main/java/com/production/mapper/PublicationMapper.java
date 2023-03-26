package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.Publication;

public class PublicationMapper implements RowMapper<Publication> {

	@Override
	public Publication mapRow(ResultSet rs, int rowNum) throws SQLException {
		Publication publication = new Publication();
		publication.setPublicationId(rs.getInt("publication_id"));
		publication.setBusinessGroupId(rs.getInt("business_group_id"));
		publication.setGroupId(rs.getInt("group_id"));
		publication.setName(rs.getString("name"));
		publication.setAdvertisingDirectorEmail(rs.getString("advertising_director_email_id"));
		publication.setDesignTeamId(rs.getInt("design_team_id"));
		publication.setTeamLeadId(rs.getInt("team_lead_id"));
		publication.setSpecAds(rs.getInt("spec_ads"));
		publication.setSoldAds(rs.getInt("sold_ads"));
		publication.setCatSlugTypeId(rs.getInt("cat_slug_type_id"));
		publication.setCsrIdQA(rs.getInt("csr_id_QA"));
		publication.setTagCsrId(rs.getInt("tag_csr_id"));
		publication.setCatNewspaperId(rs.getInt("cat_newspaper_id"));
		publication.setInitial(rs.getString("initial"));
		publication.setCustomSize(rs.getBoolean("is_custom_sizes"));
		publication.setEnableProject(rs.getBoolean("is_enable_project"));
		publication.setClubId(rs.getInt("club_id"));
		publication.setHelpDeskId(rs.getInt("help_desk_id"));
		publication.setIsEnableSource(rs.getInt("is_enable_source"));
		publication.setIsEnableRequest(rs.getInt("is_enable_request"));
		publication.setRevDays(rs.getInt("rev_days"));
		publication.setCustomer(rs.getInt("customer"));
		publication.setInvoiceAmount(rs.getFloat("invoice_amount"));
		publication.setCustomerId(rs.getInt("customer_id"));
		publication.setOrderingSystemId(rs.getInt("ordering_system_id"));
		publication.setChannelId(rs.getInt("channel_id"));
		publication.setTimeZoneId(rs.getInt("time_zone_id"));
		publication.setCity(rs.getString("city"));
		publication.setApprove(rs.getInt("approve"));
		publication.setIsTheme(rs.getInt("is_theme"));
		publication.setEmail(rs.getString("email"));
		publication.setIsIdml(rs.getInt("is_idml"));
		publication.setActive(rs.getBoolean("is_active"));
		publication.setDeleted(rs.getBoolean("is_deleted"));
		publication.setLiveTracker(rs.getBoolean("is_live_tracker"));
		publication.setPDFReview(rs.getBoolean("is_pdf_review"));

		return publication;
	}

}
