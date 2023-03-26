package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.CatNewspaper;

public class CatNewspaperMapper implements RowMapper<CatNewspaper> {

	@Override
	public CatNewspaper mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CatNewspaper catNewspaper = new CatNewspaper();
		catNewspaper.setId(rs.getInt("id"));
		catNewspaper.setClient(rs.getInt("client")); 
		catNewspaper.setPublication(rs.getInt("publication"));
		catNewspaper.setName(rs.getString("name"));
		catNewspaper.setInitials(rs.getString("initials"));
		catNewspaper.setSlugType(rs.getString("slug_type"));
		catNewspaper.setHelpDesk(rs.getInt("help_desk"));
		catNewspaper.setTeam(rs.getInt("team"));
		catNewspaper.setBusinessGroupId(rs.getInt("business_group_id"));
		catNewspaper.setChannel(rs.getInt("channel"));
		catNewspaper.setStatus(rs.getInt("status"));
		return catNewspaper;
	}

}
