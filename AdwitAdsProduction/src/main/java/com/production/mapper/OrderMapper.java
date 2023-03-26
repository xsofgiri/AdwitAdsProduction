package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.Orders;
import com.production.util.CalendarUtil;

public class OrderMapper implements RowMapper<Orders> {

	@Override
	public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
		CalendarUtil calendarUtil = new CalendarUtil();

		// TODO Auto-generated method stub
		Orders order = new Orders();

		order.setOrderId(rs.getInt("order_id"));
		order.setAdRepId(rs.getInt("adrep_id"));
		order.setMapOrderId(rs.getInt("map_order_id"));
		order.setCsrId(rs.getInt("csr_id"));
		order.setPublicationId(rs.getInt("publication_id"));
		order.setOrderTypeId(rs.getInt("order_type_id"));
		order.setAdvertiserName(rs.getString("advertiser_name"));
		order.setPublishDate(
				calendarUtil.formatDate(calendarUtil.convertDateSqlToJava(rs.getDate("publish_date")), "yyyy-MM-dd"));
		order.setPublicationName(rs.getString("publication_name"));

		order.setDateNeeded(
				calendarUtil.formatDate(calendarUtil.convertDateSqlToJava(rs.getDate("date_needed")), "yyyy-MM-dd"));
		order.setCopyContent(rs.getString("copy_content"));
		order.setJobInstruction(rs.getString("job_instruction"));
		order.setArtWork(rs.getString("art_work"));
		order.setJobNo(rs.getString("job_no"));
		order.setSection(rs.getString("section"));
		order.setColorPreferences(rs.getString("color_preferences"));
		order.setFontPreferences(rs.getString("font_preferences"));
		order.setCopyContentDescription(rs.getString("copy_content_description"));
		order.setNotes(rs.getString("notes"));
		order.setWidth(rs.getDouble("width"));
		order.setHeight(rs.getDouble("height"));
		order.setPrintAdType(rs.getInt("print_ad_type_id"));
		try {
			order.setPixelSizeId(rs.getInt("pixel_size"));
		}catch(Exception e) {
			order.setPixelSizeId(0);
		}
		
		try {
			order.setFlexitiveSizeId(rs.getInt("flexitive_size_id"));
		}catch(Exception e) {
			order.setFlexitiveSizeId(0);
		}
		
		order.setWebAdType(rs.getString("web_ad_type"));
		order.setWebAdFormatId(rs.getInt("web_ad_format_id"));
		order.setMaxFileSize(rs.getString("maxium_file_size"));
		order.setCustomWidth(rs.getString("custom_width"));
		order.setCustomHeight(rs.getString("custom_height"));
		order.setPickupAdNo(rs.getString("pickup_adno"));
		order.setFilePath(rs.getString("file_path"));
		order.setCreatedOn(calendarUtil.getFormattedDateTime(rs.getDate("created_on"), rs.getTime("created_on")));

		order.setApproved(rs.getBoolean("is_approve"));
		order.setCancel(rs.getBoolean("is_cancel"));
		order.setRush(rs.getBoolean("is_rush"));
		order.setOldAdRepId(rs.getInt("old_adrep_id"));
		order.setQuestion(rs.getInt("question"));
		order.setIsCrequest(rs.getInt("is_crequest"));
		order.setPriority(calendarUtil.formatDate(calendarUtil.convertDateSqlToJava(rs.getDate("priority")),
				"yyyy-MM-dd hh:mm:ss"));
		order.setPdfPath(rs.getString("pdf"));
		order.setPdfCreatedOn(
				calendarUtil.getFormattedDateTime(rs.getDate("pdf_timestamp"), rs.getTime("pdf_timestamp")));
		order.setCredits(rs.getDouble("credits"));
		order.setRevCount(rs.getInt("rev_count"));
		order.setRevSoldJobId(rs.getInt("rev_sold_job_id"));
		order.setOrderStatusId(rs.getInt("order_status_id"));
		order.setIsDownloadDelete(rs.getInt("is_down_del"));
		order.setIsSourceDelete(rs.getInt("is_source_del"));
		order.setInvoiceId(rs.getInt("invoice_id"));
		order.setPubProjectId(rs.getInt("pub_project_id"));
		order.setClubId(rs.getInt("club_id"));
		order.setApprovedOn(
				calendarUtil.getFormattedDateTime(rs.getDate("approved_time"), rs.getTime("approved_time")));

		order.setActivityTime(
				calendarUtil.getFormattedDateTime(rs.getDate("activity_time"), rs.getTime("activity_time")));
		order.setPageDesignID(rs.getInt("page_design_id"));
		order.setRevOrderStatus(rs.getInt("rev_order_status"));

		return order;
	}

}
