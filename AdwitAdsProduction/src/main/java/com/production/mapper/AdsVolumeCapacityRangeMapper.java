package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.AdsVolumeCapacityRange;

public class AdsVolumeCapacityRangeMapper implements RowMapper<AdsVolumeCapacityRange> {

	@Override
	public AdsVolumeCapacityRange mapRow(ResultSet rs, int rowNum) throws SQLException {
		AdsVolumeCapacityRange adRange = new AdsVolumeCapacityRange();
		adRange.setId(rs.getInt("id"));
		adRange.setChannel(rs.getString("channel"));
		adRange.setTeam(rs.getInt("team"));
		adRange.setLowestMin(rs.getInt("lowest_min"));
		adRange.setLowestMax(rs.getInt("lowest_max"));
		adRange.setLowMin(rs.getInt("low_min"));
		adRange.setLowMax(rs.getInt("low_max"));
		adRange.setOptimalMin(rs.getInt("optimal_min"));
		adRange.setOptimalMax(rs.getInt("optimal_max"));
		adRange.setPeakMin(rs.getInt("peak_min"));
		adRange.setPeakMax(rs.getInt("peak_max"));
		adRange.setStretch(rs.getInt("stretch"));
		return adRange;
	}  

}
