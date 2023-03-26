package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.MapOrders;

public class MapOrdersMapper implements RowMapper<MapOrders> {

	@Override
	public MapOrders mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		MapOrders mapOrders = new MapOrders();
		mapOrders.setId(rs.getInt("id"));
		mapOrders.setMapId(rs.getInt("map_id"));
		mapOrders.setMainOrdersId(rs.getInt("main_orders_id"));
		mapOrders.setUserId(rs.getInt("user_id"));
		mapOrders.setOrderTypeId(rs.getInt("order_type_id"));
		mapOrders.setAdvId(rs.getString("adv_id"));
		mapOrders.setPubId(rs.getInt("pub_id"));
		mapOrders.setJobName(rs.getString("job_name"));
		mapOrders.setNumAds(rs.getInt("num_ads"));
		mapOrders.setStatus(rs.getInt("status"));
		mapOrders.setFilePath(rs.getString("file_path"));
		mapOrders.setCreatedOn(rs.getString("created_on"));
		mapOrders.setOdId(rs.getInt("od_id"));
		mapOrders.setOrderId(rs.getInt("order_id"));
		mapOrders.setSizeId(rs.getString("size_id"));
		mapOrders.setWidth(rs.getFloat("width"));
		mapOrders.setHeight(rs.getFloat("height"));
		mapOrders.setJobInstruction(rs.getString("job_instruction"));
		mapOrders.setArtWork(rs.getString("art_work"));
		mapOrders.setColorPreferences(rs.getString("color_preferences"));
		mapOrders.setFontPreferences(rs.getString("font_preferences"));
		mapOrders.setCopyContentDescription(rs.getString("copy_content_description"));
		mapOrders.setNotes(rs.getString("notes"));
		mapOrders.setPublishDate(rs.getString("publish_date"));
		mapOrders.setDateNeeded(rs.getString("date_needed"));
		mapOrders.setPrintAdType(rs.getString("print_ad_type"));
		mapOrders.setWebAdType(rs.getString("web_ad_type"));
		mapOrders.setPixelSize(rs.getString("pixel_size"));
		mapOrders.setCustomWidth(rs.getString("custom_width"));
		mapOrders.setCustomHeight(rs.getString("custom_height"));
		mapOrders.setAdFormat(rs.getInt("ad_format"));
		mapOrders.setMaximumFileSize(rs.getString("maximum_file_size"));
		mapOrders.setApprove(rs.getInt("approve"));
		mapOrders.setAdwitadsPickupId(rs.getInt("adwitads_pickup_id"));
		mapOrders.setTimestamp(rs.getString("timestamp"));

		return mapOrders;
	}

}
