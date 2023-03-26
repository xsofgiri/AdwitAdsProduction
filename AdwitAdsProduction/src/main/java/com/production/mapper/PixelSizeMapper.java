package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.PixelSize;

public class PixelSizeMapper implements RowMapper<PixelSize> {

	@Override
	public PixelSize mapRow(ResultSet rs, int rowNum) throws SQLException {
		PixelSize pixelSize = new PixelSize();
		pixelSize.setPixelSizeId(rs.getInt("pixel_size_id"));
		pixelSize.setName(rs.getString("name"));
		pixelSize.setWidth(rs.getInt("width"));
		pixelSize.setHeight(rs.getInt("height"));
		pixelSize.setIsActive(rs.getInt("is_active"));
		pixelSize.setIsDeleted(rs.getInt("is_deleted"));
		return pixelSize;  
	}

}
