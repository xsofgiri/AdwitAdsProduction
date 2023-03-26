package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.FlexitiveSize;

public class FlexitiveSizeMapper implements RowMapper<FlexitiveSize> {

	@Override
	public FlexitiveSize mapRow(ResultSet rs, int rowNum) throws SQLException {
		FlexitiveSize flexitiveSize = new FlexitiveSize();
		flexitiveSize.setFlexitiveSizeId(rs.getInt("flexitive_size_id"));
		flexitiveSize.setRatio(rs.getString("ratio"));
		flexitiveSize.setMinimum(rs.getInt("min"));
		flexitiveSize.setMaximum(rs.getInt("max"));
		flexitiveSize.setText(rs.getString("text"));
		return flexitiveSize;
	}

}
