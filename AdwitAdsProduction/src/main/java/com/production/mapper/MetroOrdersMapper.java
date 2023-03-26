package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.MetroOrders;

public class MetroOrdersMapper implements RowMapper<MetroOrders> {

	@Override
	public MetroOrders mapRow(ResultSet rs, int rowNum) throws SQLException {
		MetroOrders metroOrders = new MetroOrders();
		metroOrders.setOrderType(rs.getString("order_type"));
		metroOrders.setMetroRef(rs.getString("metro_ref"));
		metroOrders.setJobNum(rs.getString("job_num"));
		metroOrders.setPrevJobNum(rs.getString("prev_job_num"));
		metroOrders.setReqBy(rs.getString("req_by"));
		metroOrders.setStage(rs.getString("stage"));
		metroOrders.setSubmittedDate(rs.getString("submitted_date"));
		metroOrders.setRequiredDate(rs.getString("required_date"));
		metroOrders.setPublishDate(rs.getString("publish_date"));
		metroOrders.setAccount(rs.getString("account"));
		metroOrders.setAdvertiser(rs.getString("advertiser"));
		metroOrders.setPublication(rs.getString("publication"));
		metroOrders.setAdType(rs.getString("ad_type"));
		metroOrders.setAdKind(rs.getString("ad_kind"));
		metroOrders.setAdformat(rs.getString("ad_format"));
		metroOrders.setAdSize(rs.getString("ad_size"));
		metroOrders.setAdColor(rs.getString("ad_color"));
		metroOrders.setWidth(rs.getFloat("width"));
		metroOrders.setHeight(rs.getFloat("height"));
		metroOrders.setColumns(rs.getInt("columns"));
		metroOrders.setSqInches(rs.getFloat("sq_inches"));
		metroOrders.setMaxFileSize(rs.getString("max_filesize"));
		metroOrders.setAudio(rs.getString("audio"));
		metroOrders.setSplash(rs.getString("splash"));
		metroOrders.setMetroSpecAds(rs.getString("metro_spec_ads"));
		metroOrders.setMetroArtWork(rs.getString("metro_artwork"));
		metroOrders.setColorPreference(rs.getString("color_preference"));
		metroOrders.setFontPreference(rs.getString("font_preference"));
		metroOrders.setAdDesign(rs.getString("ad_design"));
		metroOrders.setTimeZone(rs.getString("time_zone"));
		metroOrders.setProductionVersion(rs.getString("production_version"));
		metroOrders.setLastActionDate(rs.getString("last_action_date"));
		metroOrders.setLastCustomerMsg(rs.getString("last_customer_msg"));
		metroOrders.setFile(rs.getString("file"));
		metroOrders.setTimestamp(rs.getString("timestamp"));
		metroOrders.setApprove(rs.getInt("approve"));
		metroOrders.setId(rs.getInt("id"));  

		return metroOrders;
	}

}
