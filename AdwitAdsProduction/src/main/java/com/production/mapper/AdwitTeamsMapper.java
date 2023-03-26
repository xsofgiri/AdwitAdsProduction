package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.AdwitTeams;

public class AdwitTeamsMapper implements RowMapper<AdwitTeams> {

	@Override
	public AdwitTeams mapRow(ResultSet rs, int rowNum) throws SQLException {
		AdwitTeams adwitTeams = new AdwitTeams();
		adwitTeams.setAdwitTeamsId(rs.getInt("adwit_teams_id"));
		adwitTeams.setName(rs.getString("name"));
		adwitTeams.setIsActive(rs.getInt("is_active"));
		adwitTeams.setCategory(rs.getString("category"));  
		return adwitTeams;  
	}
  
}
